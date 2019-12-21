package cn.itxdl.util;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class XMLResolver {
   public static  List<Bean>  xmlResolver(){
       List<Bean> list = new LinkedList<>();
       FileInputStream fis = null;
       try {
           fis = new FileInputStream("E:\\JetBrains Workspaces\\IdeaProjects\\CircleLinkedList\\Reflect_Container\\src\\main\\resources\\bean.xml");
           SAXReader sr = new SAXReader();
           Document doc = sr.read(fis);
           Element root = doc.getRootElement();
           List<Element> beans = root.elements("bean");
           List<Element> property = null;
           for(Element e:beans){
               Map<String,String> map = new HashMap<>();
               String id = e.attributeValue("id");
               String className = e.attributeValue("class");
               Bean  bean = new Bean(id,className);
               property = e.elements("property");
               for(Element p : property){
                   String name = p.attributeValue("name");
                   String value = p.attributeValue("value");
                   map.put(name,value);
               }
               bean.setProperties(map);
               list.add(bean);
           }
           return list;
       } catch (Exception e) {
           e.printStackTrace();
           return null;
       }
   }
}
