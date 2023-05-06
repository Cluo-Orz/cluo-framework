package org.cluo.framework.jpa.search.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * In services-xin.dayukeji.common.annotation
 * Create in 16:42 2018/8/19
 * todo OR 的多字段匹配的功能
 * @author canfuu
 * @version v1.0
 * descriotion
 * name: 对应pojo类的字段名 值为数组，连接关系为或
 * value: 对应sql匹配方法
 * group: 1. 对所有条件进行分组，默认0表示此字段单独一组与其他标识为0的字段互相独立。
 *  	  2. 若为其他值，组内可以有多个成员。
 *  	  3. 组与组匹配关系为且，组内成员匹配关系为或。
 * relation: 组内成员连接方式，默认为OR
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface SearchBy {
	Ops value() default Ops.EQUAL;
	String[] name() default {};
	int group() default 0;
	SearchRelation relation() default SearchRelation.OR;
}
