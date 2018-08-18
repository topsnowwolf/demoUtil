package com.example.demo.util.webservice.beanxml.xml;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.io.xml.StaxDriver;

/**
 * @author: topsnowwolf
 * @description:
 * @date: Create in 2018/8/18 9:20
 * @modified by:
 * @versions：0.1.0
 */
public class BuilderXml implements XstreamToXml{
    @Override
    public String getXmlByXstream(Object object, Converter converter) {
        XStream xStream = new XStream(new StaxDriver());
        String result = xStream.toXML(object);
        if(converter != null){
            xStream.registerConverter(converter);
        }
        return result;
    }
}
