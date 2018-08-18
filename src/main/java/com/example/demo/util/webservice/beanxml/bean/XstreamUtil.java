package com.example.demo.util.webservice.beanxml.bean;

import com.thoughtworks.xstream.XStream;

/**
 * @author: topsnowwolf
 * @description:
 * @date: Create in 2018/8/18 12:24
 * @modified by:
 * @versions：0.1.0
 */
public class XstreamUtil {
    /**
     * 将xml字符串转为对象
     * */
    public static Object xmlStr2Object(String xml,Class clazz) throws Exception{
        if( clazz == null || xml == null || "".equals(xml.replace(" ", "")) ){
            return null;
        }
        Object object = clazz.newInstance();
        XStream xStream = new XStream();
        String className = object.getClass().getName();
        xStream.alias(className, clazz);
//        xStream.a(new Class[]{clazz});
        xStream.setMode(XStream.NO_REFERENCES);
        //转为对象
        object = xStream.fromXML(xml);
        return object;

    }

    /**
     * 将对象转为xml格式字符串
     * */
    public static String object2XmlStr(Object obj) throws Exception{
        if(obj==null) {
            return null;
        }
        XStream xStream = new XStream();
        String xml = xStream.toXML(obj);
        return xml;
    }

}
