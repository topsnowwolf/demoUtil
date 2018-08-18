package com.example.demo.util.webservice.factory;

import com.example.demo.util.webservice.Data.ReqData;
import com.example.demo.util.webservice.factory.extend.AXISFactory;
import com.example.demo.util.webservice.factory.extend.CXFfactory;
import com.example.demo.util.webservice.factory.extend.HttpClientFactory;

/**
 * @author: topsnowwolf
 * @description: 代理工厂
 * @date: Create in 2018/8/17 21:18
 * @modified by:
 * @versions：0.1.0
 */
public abstract class WebServiceFactory {
    private static String type_default = "DEFAULT";
    private static String type_axis = "AXIS";
    private static String type_cxf = "CXF";
    public  abstract String sendWebService(ReqData reqData);
    public static String sendWebService(String name,ReqData reqData) {
        if (type_cxf.equalsIgnoreCase(name)) {
            return new CXFfactory().sendWebService(reqData);
        } else if (type_default.equalsIgnoreCase(name)) {
            return new HttpClientFactory().sendWebService(reqData);
        } else if (type_axis.equalsIgnoreCase(name)) {
            return new AXISFactory().sendWebService(reqData);
        } else {
            System.out.println("暂时不支持这类型的工厂");
            return null;
        }
    }
}
