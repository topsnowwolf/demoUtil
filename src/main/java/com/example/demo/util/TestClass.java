package com.example.demo.util;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.util.webservice.beanxml.XmlToJson;
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

    public void test2() throws Exception{
        String url = "https://fcmedia.changanford.cn/Media2Ford/services/Media2FordData";
        String date = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\"\n" +
                "xmlns:agen=\"www.agenda.com\">\n" +
                "<soapenv:Header/>\n" +
                "<soapenv:Body>\n" +
                "<agen:saveData>\n" +
                "<in0>2017-12-05 10:25:00</in0>\n" +
                "<in1>尹文彬</in1>\n" +
                "<in2>男</in2>\n" +
                "<in3>15000254783</in3>\n" +
                "<in4></in4>\n" +
                "<in5>wenbin.yin@wunderman.com</in5>\n" +
                "<in6></in6>\n" +
                "<in7>福特锐界</in7>\n" +
                "<in8></in8>\n" +
                "<in9></in9>\n" +
                "<in10>0-3个月</in10>\n" +
                "<in11>上海</in11>\n" +
                "<in12>上海</in12>\n" +
                "<in13></in13>\n" +
                "<in14></in14>\n" +
                "<in15></in15>\n" +
                "<in16>上海福银</in16>\n" +
                "<in17>A08774</in17>\n" +
                "<in18></in18>\n" +
                "<in19></in19>\n" +
                "<in20></in20>\n" +
                "<in21></in21>\n" +
                "<in22></in22>\n" +
                "<in23>ifeng_PC</in23>\n" +
                "<in24></in24>\n" +
                "<in25></in25>\n" +
                "<in26></in26>\n" +
                "<in27></in27>\n" +
                "<in28>1481528315863</in28>\n" +
                "<in29></in29>\n" +
                "<in30></in30>\n" +
                "<in31></in31>\n" +
                "<in32></in32>\n" +
                "<in33></in33>\n" +
                "<in34></in34>\n" +
                "<in35>2017年福特SUV家族10-12月网络投放</in35>\n" +
                "<in36>http://api.3g.ifeng.com/ford20171012</in36>\n" +
                "<in37>否</in37>\n" +
                "<in38>2017-10-12</in38>\n" +
                "<in39>UNID12345678</in39>\n" +
                "<in40></in40>\n" +
                "<in41>联系上</in41>\n" +
                "<in42>2017-12-05</in42>\n" +
                "<in43>1710AllCarBrand_CAFImpossibleChallengeRetailPromotion_Oct2017</in43>\n" +
                "<in44>1次</in44>\n" +
                "</agen:saveData>\n" +
                "</soapenv:Body>\n" +
                "</soapenv:Envelope>";
    }
}
