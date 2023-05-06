package org.cluo.framework.jpa.search.annotation;

import javax.persistence.criteria.JoinType;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author: thone
 * type: JoinType 表连接方式
 * name: 对应实体类中的外键关联名称
 * 		如实体类 [ Article (1 - n) ArticleGroup ]
 * 		ArticleGroup 中  @JoinColumn 下 的属性名称：articleByArticleId
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface JoinBy {
	JoinType type() default JoinType.LEFT;
	int value() default 1;
	String name();
}
