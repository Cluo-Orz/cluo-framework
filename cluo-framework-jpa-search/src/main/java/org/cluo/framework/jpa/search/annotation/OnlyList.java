package org.cluo.framework.jpa.search.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * In services-xin.dayukeji.common.annotation
 * Create in 13:56 2018/12/26
 *
 * @author canfuu
 * @version v1.0
 * descriotion 描述
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface  OnlyList {
	// 如果ignore，在列表里的一定会onlyList，如果不ignore，不在列表里的一定不会onlyList
	String[] value() default {};
	// 一定会onlyList
	boolean must() default false;
	// 如果ignore，程序默认不会onlyList，如果不ignore，程序默认会onlyList
	boolean ignore() default false;

}
