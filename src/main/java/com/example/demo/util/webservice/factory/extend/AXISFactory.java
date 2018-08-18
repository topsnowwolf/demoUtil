package com.example.demo.util.webservice.factory.extend;

import com.example.demo.util.webservice.Data.ReqData;
import com.example.demo.util.webservice.factory.WebServiceFactory;
import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
/**
 * @author: topsnowwolf
 * @description: AXIS方式处理工厂
 * @date: Create in 2018/8/17 21:36
 * @modified by:
 * @versions：0.1.0
 */
public class AXISFactory extends WebServiceFactory {
    @Override
    public String sendWebService(ReqData reqData) {
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?><ROWS><INFO><SBM>*</SBM>" +
                "</INFO><ROW><GMSFHM>公民身份号码</GMSFHM><XM>姓名</XM></ROW><ROW><GMSFHM>110101******" +
                "</GMSFHM><XM>李闻</XM><FSD>100600</FSD><YWLX>个人贷款</YWLX></ROW>" +
                "<ROW><GMSFHM>3624221952123***</GMSFHM><XM>李一闻</XM><FSD>100600</FSD><YWLX>个人贷款" +
                "</YWLX></ROW><ROW><GMSFHM>1234********</GMSFHM><XM>王龙</XM><FSD>100600</FSD><YWLX>银行开户" +
                "</YWLX></ROW><ROW><GMSFHM>110101******</GMSFHM><XM></XM><FSD>100600</FSD><YWLX>个人车贷" +
                "</YWLX></ROW><ROW><GMSFHM>110101******</GMSFHM><XM></XM><FSD>100600</FSD><YWLX></YWLX>" +
                "</ROW><ROW><GMSFHM>230602***</GMSFHM><XM></XM><FSD>100600</FSD><YWLX>个人车贷</YWLX></ROW></ROWS>";
        String inLicense = "********";
        String repString = "";
        try{
            //调用webservice地址
            String url = reqData.getUrl();
            //调用方法名
            String method="nciicCheck";
            Service service = new Service();
            //通过service创建call对象
            Call call = (Call) service.createCall();
            //设置服务地址
            call.setTargetEndpointAddress(new java.net.URL(url));
            //设置调用方法
            call.setOperationName(method);
            call.setUseSOAPAction(true);
            //添加方法的参数，有几个添加几个
            //inLicense是参数名，XSD_STRING是参数类型，IN代表传入
            call.addParameter("inLicense", org.apache.axis.encoding.XMLType.XSD_STRING,
                    javax.xml.rpc.ParameterMode.IN);
            call.addParameter("inConditions",
                    org.apache.axis.encoding.XMLType.XSD_STRING,javax.xml.rpc.ParameterMode.IN);
            //设置返回类型
            call.setReturnType(org.apache.axis.encoding.XMLType.XSD_STRING);
            Object ret= null;
            try{
                //使用invoke调用方法，Object数据放传入的参数值
                ret = call.invoke(new Object[] {inLicense,reqData.getParam()});
            }catch(Exception e){
                e.printStackTrace();
            }
            //输出SOAP请求报文
            System.out.println("--SOAP Request: " + call.getMessageContext().getRequestMessage().getSOAPPartAsString());
            //输出SOAP返回报文
            System.out.println("--SOAP Response: " + call.getResponseMessage().getSOAPPartAsString());
            //输出返回信息
            System.out.println("result==="+ret.toString());
            repString = ret.toString();
        }catch(Exception e){
            e.printStackTrace();
        }
        return repString;
    }
}
