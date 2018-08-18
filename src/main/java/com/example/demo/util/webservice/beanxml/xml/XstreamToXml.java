package com.example.demo.util.webservice.beanxml.xml;

import com.thoughtworks.xstream.converters.Converter;

/**
 * @author: topsnowwolf
 * @description:
 * @date: Create in 2018/8/18 9:37
 * @modified by:
 * @versions：0.1.0
 */
public interface XstreamToXml {
    public String getXmlByXstream(Object object, Converter converter);
}
