package com.example.demo.util.webservice.beanxml.bean;

import com.example.demo.util.webservice.Data.Out;
import org.springframework.util.StringUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringReader;

/**
 * @author: topsnowwolf
 * @description:
 * @date: Create in 2018/8/18 12:36
 * @modified by:
 * @versions：0.1.0
 */
public class NodeUtil {
    public static Out parseXMLSTRING(String xml, String NodeName){
        Out out = new Out();
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new InputSource(new StringReader(xml)));
            //根据标签名称获取该名称的所有节点对象
            NodeList nodelist = doc.getElementsByTagName(NodeName);
            //遍历
            for (int i = 0; i < nodelist.getLength(); i++) {
                //得到具体的某个节点对象
                Node node = nodelist.item(i);
                NodeList list = node.getChildNodes();
                for(int j = 0; j < list.getLength(); j++){
                    Node chNode = list.item(j);
                    if("data".equals(chNode.getNodeName())&&StringUtils.isEmpty(chNode.getTextContent())){
                        out.setData(chNode.getTextContent());
                    }
                    if("message".equals(chNode.getNodeName())&&StringUtils.isEmpty(chNode.getTextContent())){
                        out.setMessage(chNode.getTextContent());
                    }
                    if("status".equals(chNode.getNodeName())&&StringUtils.isEmpty(chNode.getTextContent())){
                        out.setStatus(chNode.getTextContent());
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return out;
    }
}
