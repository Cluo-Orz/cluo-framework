package org.cluo.framework.xml;

import com.thoughtworks.xstream.XStream;

import java.io.Serializable;
import java.util.regex.Pattern;

/**
 * In services-xin.dayukeji.common.sdk.tencent.aggregation
 * Create in 22:54 2018/7/31
 *
 * @author canfuu
 * @version v1.0
 * descriotion 描述
 */
public class XmlUtil implements Serializable {
    public static <T> T newBean(String xmlData, T t) {
        XStream xStream = new XStream();
        xStream.ignoreUnknownElements();
        xStream.ignoreUnknownElements("TAG");
        xStream.ignoreUnknownElements("request");
        xStream.alias("xml", t.getClass());
        return (T) xStream.fromXML(xmlData, t);
    }
    public static <T> T newBean(String xmlData, Class t) {
        XStream xStream = new XStream();
        xStream.alias("xml", t);
        xStream.ignoreUnknownElements("TAG");
        xStream.ignoreUnknownElements("request");
        xStream.ignoreUnknownElements();
        return (T) xStream.fromXML(xmlData);
    }

    public static String toXml(Object o) {
        XStream xStream = new XStream();
        xStream.alias("xml", o.getClass());
        return Pattern.compile("(_{2})").matcher(xStream.toXML(o)).replaceAll("_");
    }
}
