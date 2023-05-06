package org.cluo.framework.jpa.search.annotation;

/**
 * In services-xin.dayukeji.common.annotation
 * Create in 16:45 2018/8/19
 *
 * @author canfuu
 * @version v1.0
 * descriotion 搜索分组时，组内成员连接方式
 *  example ：下列为成员字段的名称和他们的连接方式：
 *              name: OR , filter: OR , state: AND, age: AND
 *   对应的sql: (name = ?1 OR filter = ?2 OR (state = ?3 AND age = ?4))
 */
public enum SearchRelation {
	AND,
	OR;
}
