package org.cluo.framework.jpa.search;

import org.cluo.framework.jpa.search.annotation.JoinBy;
import org.cluo.framework.jpa.search.annotation.Ops;
import org.cluo.framework.jpa.search.annotation.SearchBy;
import org.cluo.framework.jpa.search.annotation.SearchRelation;
import org.cluo.framework.reflection.ReflectUtil;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Join;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

/**
 * @author canfuu.cts
 * @class JpaSpecificationBuilder
 * @date 2023/5/6 20:14
 */
public class JpaSpecificationBuilder {

    public static <T> Specification<T> search(Object queryEntity) {
        Map<String, Join<Object, Object>> joinNames = new HashMap<>();
        Map<Integer, Predicate> predicateMap = new HashMap<>();
        Map<Integer, Predicate> predicateMapAndRelation = new HashMap<>();
        List<Order> orders = new ArrayList<>();
        return (root, query, cb) -> {
            Map<String, String> kFieldVMethod = ReflectUtil.getKFieldVGetMethod(queryEntity);
            List<Predicate> l = new ArrayList<>();
            for (Class aClass = queryEntity.getClass(); aClass != Object.class; aClass = aClass.getSuperclass()) {
                // 判断属性内容是否有效
                Field[] fields = aClass.getDeclaredFields();
                for (int i = 0; i < fields.length; i++) {
                    try {
                        Field field = fields[i];
                        field.setAccessible(true);
                        if (field.isAnnotationPresent(SearchBy.class) && field.isAnnotationPresent(SearchBy.class)) {
                            Method method = ReflectUtil.getMethod(aClass, kFieldVMethod.get(field.getName()), 0);
                            if (method != null) {
                                Object filedValue = method.invoke(queryEntity);
                                boolean isEmpty = true;
                                if (filedValue instanceof String) {
                                    if (((String) filedValue).length() > 0) {
                                        isEmpty = false;
                                    }
                                }
                                if (filedValue != null || !isEmpty) {
                                    SearchBy searchType = field.getAnnotation(SearchBy.class);
                                    // 通过注解判断使用方法
                                    String[] name = {field.getName()};
                                    if (searchType.name() != null && searchType.name().length > 0) {
                                        name = searchType.name();
                                    }
                                    Predicate predicate = null;
                                    if (searchType.group() == 0){
                                        predicate = null;
                                    }else {
                                        if (searchType.relation().equals(SearchRelation.AND)){
                                            predicate = predicateMapAndRelation.get(searchType.group());
                                        }else {
                                            predicate = predicateMap.get(searchType.group());
                                        }
                                    }
                                    Join<Object, Object> join = null;
                                    String joinName = null;
                                    Integer joinValue = 0;
                                    if (field.isAnnotationPresent(JoinBy.class) && field.isAnnotationPresent(JoinBy.class)){
                                        JoinBy joinBy = field.getAnnotation(JoinBy.class);
                                        joinValue = joinBy.value();
                                        joinName = joinBy.name();
                                        if (0 == joinValue){
                                            if (joinNames.get(joinName) != null){//全连
                                                join = joinNames.get(joinName);
                                            }else {//左联
                                                join = root.join(joinName, joinBy.type());
                                                joinNames.put(joinName, join);
                                            }
                                        }
                                    }

                                    for (int j = 0; j < name.length; j++) {
                                        if (Objects.equals(searchType.value(), Ops.EQUAL)) {
                                            if (predicate == null) {
                                                if (join == null && joinValue == 1){
                                                    predicate = cb.equal(root.get(joinName).get(name[j]).as(filedValue.getClass()), filedValue);
                                                }else {
                                                    predicate = cb.equal((join==null?root:join).get(name[j]).as(filedValue.getClass()), filedValue);
                                                }
                                            }else {
                                                if (join == null && joinValue == 1){
                                                    predicate = (searchType.relation().equals(SearchRelation.OR))
                                                            ? cb.or(predicate, cb.equal(root.get(joinName).get(name[j]).as(filedValue.getClass()), filedValue))
                                                            : cb.and(predicate, cb.equal(root.get(joinName).get(name[j]).as(filedValue.getClass()), filedValue));
                                                }else {
                                                    predicate = (searchType.relation().equals(SearchRelation.OR))
                                                            ? cb.or(predicate, cb.equal((join == null ? root : join).get(name[j]).as(filedValue.getClass()), filedValue))
                                                            : cb.and(predicate, cb.equal((join == null ? root : join).get(name[j]).as(filedValue.getClass()), filedValue));
                                                }
                                            }
                                        } else if (Objects.equals(searchType.value(), Ops.LIKE)) {
                                            if (predicate == null) {
                                                if (join == null && joinValue == 1){
                                                    predicate = cb.like(root.get(joinName).get(name[j]).as(String.class), filedValue + "%");
                                                }else {
                                                    predicate = cb.like((join == null ? root : join).get(name[j]).as(String.class), filedValue + "%");
                                                }
                                            }else {
                                                if (join == null && joinValue == 1){
                                                    predicate = (searchType.relation().equals(SearchRelation.OR))
                                                            ? cb.or(predicate, cb.like(root.get(joinName).get(name[j]).as(String.class), filedValue + "%"))
                                                            : cb.and(predicate, cb.like(root.get(joinName).get(name[j]).as(String.class), filedValue + "%"));
                                                }else {
                                                    predicate = (searchType.relation().equals(SearchRelation.OR))
                                                            ? cb.or(predicate, cb.like((join == null ? root : join).get(name[j]).as(String.class), filedValue + "%"))
                                                            : cb.and(predicate, cb.like((join == null ? root : join).get(name[j]).as(String.class), filedValue + "%"));
                                                }
                                            }
                                        } else if (Objects.equals(searchType.value(), Ops.NOT)) {
                                            if (predicate == null) {
                                                if (join == null && joinValue == 1){
                                                    predicate = cb.notEqual(root.get(joinName).get(name[j]).as(filedValue.getClass()), filedValue);
                                                }else {
                                                    predicate = cb.notEqual((join == null ? root : join).get(name[j]).as(filedValue.getClass()), filedValue);
                                                }
                                            }else {
                                                if (join == null && joinValue == 1){
                                                    predicate = (searchType.relation().equals(SearchRelation.OR))
                                                            ? cb.or(predicate, cb.notEqual(root.get(joinName).get(name[j]).as(filedValue.getClass()), filedValue))
                                                            : cb.and(predicate, cb.notEqual(root.get(joinName).get(name[j]).as(filedValue.getClass()), filedValue));
                                                }else {
                                                    predicate = (searchType.relation().equals(SearchRelation.OR))
                                                            ? cb.or(predicate, cb.notEqual((join == null ? root : join).get(name[j]).as(filedValue.getClass()), filedValue))
                                                            : cb.and(predicate, cb.notEqual((join == null ? root : join).get(name[j]).as(filedValue.getClass()), filedValue));
                                                }
                                            }
                                        } else if (Objects.equals(searchType.value(), Ops.ALL_LIKE)) {
                                            if (predicate == null) {
                                                if (join == null && joinValue == 1){
                                                    predicate = cb.like(root.get(joinName).get(name[j]).as(String.class), "%" + filedValue + "%");
                                                }else {
                                                    predicate = cb.like((join == null ? root : join).get(name[j]).as(String.class), "%" + filedValue + "%");
                                                }
                                            }else {
                                                if (join == null && joinValue == 1){
                                                    predicate = (searchType.relation().equals(SearchRelation.OR))
                                                            ? cb.or(predicate, cb.like(root.get(joinName).get(name[j]).as(String.class), "%" + filedValue + "%"))
                                                            : cb.and(predicate, cb.like(root.get(joinName).get(name[j]).as(String.class), "%" + filedValue + "%"));
                                                }else {
                                                    predicate = (searchType.relation().equals(SearchRelation.OR))
                                                            ? cb.or(predicate, cb.like((join == null ? root : join).get(name[j]).as(String.class), "%" + filedValue + "%"))
                                                            : cb.and(predicate, cb.like((join == null ? root : join).get(name[j]).as(String.class), "%" + filedValue + "%"));
                                                }
                                            }
                                        } else if (Objects.equals(searchType.value(), Ops.DESC)) {
                                            if (join == null && joinValue == 1){
                                                orders.add(cb.desc(root.get(joinName).get(name[j])));
                                            }else {
                                                orders.add(cb.desc((join==null?root:join).get(name[j])));
                                            }
                                        } else if (Objects.equals(searchType.value(), Ops.ASC)) {
                                            if (join == null && joinValue == 1){
                                                orders.add(cb.asc(root.get(joinName).get(name[j])));
                                            }else {
                                                orders.add(cb.asc((join==null?root:join).get(name[j])));
                                            }
                                        } else if (Objects.equals(searchType.value(), Ops.IN)) {
                                            Object[] searchValue = null;
                                            if(filedValue instanceof Collection) {
                                                searchValue = ((Collection) filedValue).toArray();
                                            }
                                            if(filedValue instanceof Object[]){
                                                searchValue = (Object[]) filedValue;
                                            }
                                            if(searchValue!=null && searchValue.length>0) {
                                                if (predicate == null) {
                                                    if (join == null && joinValue == 1){
                                                        predicate = root.get(joinName).get(name[j]).in(searchValue);
                                                    }else {
                                                        predicate = (join == null ? root : join).get(name[j]).in(searchValue);
                                                    }
                                                } else {
                                                    if (join == null && joinValue == 1){
                                                        predicate = (searchType.relation().equals(SearchRelation.OR))
                                                                ? cb.or(predicate, root.get(joinName).get(name[j]).as(searchValue[0].getClass()).in(searchValue))
                                                                : cb.and(predicate, root.get(joinName).get(name[j]).as(searchValue[0].getClass()).in(searchValue));
                                                    }else {
                                                        predicate = (searchType.relation().equals(SearchRelation.OR))
                                                                ? cb.or(predicate, (join==null?root:join).get(name[j]).as(searchValue[0].getClass()).in(searchValue))
                                                                : cb.and(predicate, (join==null?root:join).get(name[j]).as(searchValue[0].getClass()).in(searchValue));
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    if (searchType.group() == 0){
                                        if (predicate != null) {
                                            l.add(predicate);
                                        }
                                    }else {
                                        if (searchType.relation().equals(SearchRelation.OR)) {
                                            predicateMap.remove(searchType.group());
                                            predicateMap.put(searchType.group(), predicate);
                                        } else {
                                            predicateMapAndRelation.remove(searchType.group());
                                            predicateMapAndRelation.put(searchType.group(), predicate);
                                        }
                                    }
                                }
                            }
                        }
                    } catch (Exception ignore) {
                        ignore.printStackTrace();
                    }
                }
            }
            if (orders.size() > 0) {
                Order[] o = new Order[orders.size()];
                query.orderBy(orders.toArray(o));
            }
            predicateMap.keySet().forEach(group -> {
                Predicate predicate = predicateMap.get(group);
                if (predicateMapAndRelation.keySet().contains(group)){
                    Predicate predicate2 = cb.or(predicate, predicateMapAndRelation.get(group));
                    l.add(predicate2);
                }else {
                    l.add(predicate);
                }
            });
            if (l.size() > 0) {
                Predicate[] predicates = new Predicate[l.size()];
//                query.where(cb.and(l.toArray(predicates)));
                query.where(cb.and(l.toArray(predicates)));
                return query.getRestriction();
            }
            return null;
        };
    }
}
