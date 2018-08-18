package com.example.demo.util.webservice.BeanAndXml;

import com.example.demo.util.webservice.BeanAndXml.xml.BuilderXml;
import com.example.demo.util.webservice.BeanAndXml.xml.CostomToXml;
import com.thoughtworks.xstream.converters.Converter;

/**
 * @author: topsnowwolf
 * @description: 创建XML的适配器
 * @date: Create in 2018/8/18 9:47
 * @modified by:
 * @versions：0.1.0
 */
public class AdapterXml extends BuilderXml implements CostomToXml {
    private static String costom = "COSTOM";
    private static String defualt = "DEFUALT";

    /**
     * 使用自定义的适配器时，必须实现这个方法
     * @return
     */
    @Override
    public String getCostomXml() {
        return null;
    }
    public static String getXml(String type,Object object, Converter converter){
        if(costom.equals(type)){
            return new AdapterXml().getCostomXml();
        }else if(defualt.equals(type)){
            return new BuilderXml().getXmlByXstream(object,converter);
        }else {
            return null;
        }
    }
}
