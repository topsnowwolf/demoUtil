package com.example.demo.util;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.util.webservice.BeanAndXml.XmlToJson;
import com.example.demo.util.webservice.Data.ReqData;
import com.example.demo.util.webservice.factory.WebServiceFactory;
import org.junit.Test;

/**
 * @author: topsnowwolf
 * @description:
 * @date: Create in 2018/8/17 21:18
 * @modified by:
 * @versions：0.1.0
 */
public class TestClass {
    private static String type_default = "DEFAULT";
    private static String type_axis = "AXIS";
    private static String type_cxf = "CXF";
    public static void main(String[] args) {
        ReqData reqData = new ReqData();
        reqData.setEncoding("utf-8");
        reqData.setParam("test");
        String rep = WebServiceFactory.sendWebService(type_default,reqData);
    }

    @Test
    public void test() throws Exception {
        String xml ="<?xml version=\"1.0\" ?><com.example.demo.util.Data.ReqData>" +
                "<encoding>utf-8</encoding><param>test</param></com.example.demo.util.Data.ReqData>\n";
        JSONObject json = XmlToJson.xml2JSON(xml);
        System.out.println(json.toJSONString());
    }
}
