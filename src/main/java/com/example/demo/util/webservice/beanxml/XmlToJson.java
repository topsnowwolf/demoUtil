package com.example.demo.util.webservice.beanxml;

import com.alibaba.fastjson.JSONObject;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: topsnowwolf
 * @description: xml转json
 * @date: Create in 2018/8/18 14:18
 * @modified by:
 * @versions：0.1.0
 */
public class XmlToJson {
    public static JSONObject xml2JSON(String xml) throws Exception {
        JSONObject json = new JSONObject();
        InputStream is = new ByteArrayInputStream(xml.getBytes());
        SAXBuilder sb = new SAXBuilder();
        Document doc = sb.build(is);
        Element root = doc.getRootElement();
        json.put(root.getName(), iterateElement(root));
        return json;
    }
    private static JSONObject iterateElement(Element element) {
        List node = element.getChildren();
        Element et = null;
        JSONObject obj = new JSONObject();
        List list = null;
        for (int i = 0; i < node.size(); i++) {
            list = new LinkedList();
            et = (Element) node.get(i);
            if (et.getTextTrim().equals("")) {
                if (et.getChildren().size() == 0){
                    continue;
                }
                if (obj.containsKey(et.getName())) {
                    list = (List) obj.get(et.getName());
                }
                list.add(iterateElement(et));
                obj.put(et.getName(), list);
            } else {
                if (obj.containsKey(et.getName())) {
                    list = (List) obj.get(et.getName());
                }
                list.add(et.getTextTrim());
                obj.put(et.getName(), list);
            }
        }
        return obj;
    }
}
