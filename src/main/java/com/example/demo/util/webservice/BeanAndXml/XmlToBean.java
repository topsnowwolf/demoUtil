package com.example.demo.util.webservice.BeanAndXml;

import com.example.demo.util.webservice.BeanAndXml.bean.XstreamUtil;

/**
 * @author: topsnowwolf
 * @description: xml解析成bean
 * @date: Create in 2018/8/18 12:20
 * @modified by:
 * @versions：0.1.0
 */
public class XmlToBean {

    public static Object getBeanByNode(String xml,String rootName,String[] nodes){
        return null;
    }

    /**
     * 将xml文件解析成bean
     * @param xml
     * @param clazz
     * @return
     * @throws Exception
     */
    public static Object getBeanByXstream(String xml,Class clazz) throws Exception{
        return XstreamUtil.xmlStr2Object(xml,clazz);
    }
}
