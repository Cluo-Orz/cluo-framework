package org.cluo.framework.reflection;

import org.cluo.framework.reflection.annotation.CluoField;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Create in 13:50 2018/4/12
 *
 * @author canfuu
 * @version v1.0
 * descriotion 描述
 */
public class ReflectUtil {

    private static Map<Class, Map<String, Method>> CLASS_STRUCTURE_CACHE = new ConcurrentHashMap<>();

    public static Map<String, String> getKFieldVGetMethod(Object o) {
        HashMap<String, String> getMethod = new HashMap<>(16);
        for (Class aClass = o.getClass(); aClass != Object.class; aClass = aClass.getSuperclass()) {
            Field[] fields = aClass.getDeclaredFields();
            for (Field f : fields) {
                String fName = f.getName();
                getMethod.put(fName, "get" + uppercaseFirstChar(fName));
            }
        }
        return getMethod;
    }

    public static Map<String, String> getKFieldVSetMethod(Object o) {
        HashMap<String, String> getMethod = new HashMap<>(16);
        for (Class aClass = o.getClass(); aClass != Object.class; aClass = aClass.getSuperclass()) {
            Field[] fields = aClass.getDeclaredFields();
            for (Field f : fields) {
                String fName = f.getName();
                getMethod.put(fName, "set" + uppercaseFirstChar(fName));
            }
        }
        return getMethod;
    }


    public static Object getValue(Object obj, String filedName) {
        if (obj == null) {
            return null;
        }
        Field field = getField(filedName, obj.getClass());
        return getValue(obj, field);
    }

    private static String uppercaseFirstChar(String str){
        char[] chars = str.toCharArray();
        if(chars[0]>='a' && chars[0]<='z'){
            chars[0] = (char)(chars[0]-32);
        }
        return new String(chars);
    }

    public static Method getMethod(Class clazz, String methodName, int paramCount) {
        return getMethodMapByClassName(clazz).get(methodName + "$" + paramCount);
    }

    public static Object getValue(Object obj, Field field) {
        if (field == null) {
            return null;
        }
        if (obj == null) {
            return null;
        }
        Class clazz = obj.getClass();
        field.setAccessible(true);
        Map<String, Method> methods = getMethodMapByClassName(clazz);
        Method getMethod = methods.get("get" + uppercaseFirstChar(field.getName()) + "$0");
        if (getMethod == null) {
            try {
                return field.get(obj);
            } catch (IllegalAccessException e) {
                return null;
            }
        } else {
            getMethod.setAccessible(true);
            try {
                return getMethod.invoke(obj);
            } catch (IllegalAccessException e) {
                return null;
            } catch (InvocationTargetException e) {
                return null;
            }
        }
    }

    public static void setFinalField(Class clazz, String fieldName, Object value) {
        try {
            Field field = clazz.getDeclaredField(fieldName);
            Field modifiersField = Field.class.getDeclaredField("modifiers");
            modifiersField.setAccessible(true);
            modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);
            field.setAccessible(true);
            field.set(null, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean hasChildrenClass(Class<?> parent, Class<?> children) {
        List<Field> fieldList = getFields(parent);
        for (int i = 0; i < fieldList.size(); i++) {
            Class<?> fieldClass = fieldList.get(i).getType();
            if (children.isAssignableFrom(fieldClass)) {
                return true;
            } else if (!isBasicType(fieldClass) && hasChildrenClass(fieldClass, children, 0)) {
                return true;
            }
        }
        return false;
    }

    public static int LAYER_MAX = 50;

    public static boolean hasChildrenClass(Class<?> parent, Class<?> children, int layer) {
        if (layer >= LAYER_MAX) {
            return false;
        }
        List<Field> fieldList = getFields(parent);
        for (int i = 0; i < fieldList.size(); i++) {
            Class<?> fieldClass = fieldList.get(i).getType();
            if (children.isAssignableFrom(fieldClass)) {
                return true;
            } else if (!isBasicType(fieldClass) && hasChildrenClass(fieldClass, children, layer + 1)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isBasicType(Class clazz) {
        return clazz.isPrimitive() ||
                String.class.equals(clazz) ||
                Integer.class.equals(clazz) ||
                Double.class.equals(clazz) ||
                Long.class.equals(clazz) ||
                Byte.class.equals(clazz) ||
                Float.class.equals(clazz) ||
                Character.class.equals(clazz) ||
                Short.class.equals(clazz) ||
                Boolean.class.equals(clazz) ||
                BigDecimal.class.equals(clazz) ||
                BigInteger.class.equals(clazz) ||
                byte[].class.equals(clazz) ||
                Date.class.equals(clazz);
    }

    public static void copyBean(Object source, Object target, String... ignoreProperty) {
        Class<?> sourceClass = source.getClass();
        Class<?> targetClass = target.getClass();
        Field[] sourceFields = sourceClass.getDeclaredFields();
        Map<String, Method> targetMethodMap = getMethodMapByClassName(targetClass);
        for (int i = 0; i < sourceFields.length; i++) {
            Field sourceField = sourceFields[i];

            try {
                Method setMethod = null;
                Method getMethod = sourceClass.getDeclaredMethod("get" + uppercaseFirstChar(sourceField.getName()));
                try {
                    CluoField bobField = sourceField.getAnnotation(CluoField.class);
                    if (bobField != null && bobField.value().length() > 0) {
                        setMethod = targetMethodMap.get("set" + uppercaseFirstChar(bobField.value()) + "$1");
                    } else {
                        setMethod = targetMethodMap.get("set" + uppercaseFirstChar(sourceField.getName()) + "$1");
                    }
                } catch (Exception ignore) {
                    ignore.printStackTrace();
                }
                if (setMethod == null) {
                    continue;
                }
                setMethod.setAccessible(true);
                getMethod.setAccessible(true);


                setMethod.invoke(target, getMethod.invoke(source));
            } catch (Exception ignore) {
            }
        }
    }

    /**
     * @param clazz
     * @return key: {Method Name}-{number of param} value:Method
     */
    public static Map<String, Method> getMethodMapByClassName(Class clazz) {
        if (clazz == null) {
            return new HashMap<>();
        }
        if (ReflectUtil.CLASS_STRUCTURE_CACHE.containsKey(clazz)) {
            return ReflectUtil.CLASS_STRUCTURE_CACHE.get(clazz);
        } else {
            Map<String, Method> methodMap = new HashMap<>();
            Class tempClass = clazz;
            while (tempClass != null) {
                Method[] methods = tempClass.getMethods();
                for (int i = 0; i < methods.length; i++) {
                    Method method = methods[i];
                    methodMap.put(method.getName() + "$" + method.getParameterTypes().length, method);
                }
                methods = tempClass.getDeclaredMethods();
                for (int i = 0; i < methods.length; i++) {
                    Method method = methods[i];
                    methodMap.put(method.getName() + "$" + method.getParameterTypes().length, method);
                }
                tempClass = tempClass.getSuperclass();
            }
            ReflectUtil.CLASS_STRUCTURE_CACHE.put(clazz, methodMap);
            return methodMap;
        }
    }

    public static List<Field> getFields(Class clazz) {
        List<Field> response = new ArrayList<>();
        List<String> fieldName = new ArrayList<>();

        while (clazz != null) {
            Field[] fields = clazz.getFields();
            for (int i = 0; i < fields.length; i++) {
                if (!fieldName.contains(fields[i].getName())) {
                    response.add(fields[i]);
                }
            }
            fields = clazz.getDeclaredFields();
            for (int i = 0; i < fields.length; i++) {
                if (!fieldName.contains(fields[i].getName())) {
                    response.add(fields[i]);
                }
            }
            clazz = clazz.getSuperclass();
        }

        return response;
    }

    public static Field getField(String name, Class clazz) {
        Field field = null;
        Field[] fields = clazz.getFields();
        for (int i = 0; i < fields.length; i++) {
            if (fields[i].getName().equals(name)) {
                field = fields[i];
            }
        }
        fields = clazz.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            if (fields[i].getName().equals(name)) {
                field = fields[i];
            }
        }
        return field;
    }


}