package cn.itxdl.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

@SuppressWarnings("ALL")
public class BeanFactory {

    public static Map<String,Object> createBeans(String id) throws Exception {
        Map<String,Object> map = new HashMap<>();
        List<Bean> beans = XMLResolver.xmlResolver();
        for(Bean bean:beans){
            if(bean.getId().equals(id)){
                String objId  = bean.getId();
                String className = bean.getClassName();
                Class<?> cl = Class.forName(className);
                Object obj = cl.newInstance();
                Map<String, String> properties = bean.getProperties();
                Set<Map.Entry<String, String>> entrySet = properties.entrySet();
                Iterator<Map.Entry<String, String>> iterator = entrySet.iterator();
                while(iterator.hasNext()){
                    Map.Entry<String, String> entry = iterator.next();
                    String name = entry.getKey();
                    String value = entry.getValue();
                    String methodName = "set"+(name.substring(0,1).toUpperCase()+name.substring(1));
                    Field field = cl.getDeclaredField(name);
                    Class<?> type = field.getType();
                    Method method = null;
                    if(value.getClass().getName().equals(type.getName())){
                        method = cl.getMethod(methodName,type);
                        method.invoke(obj,value);
                    }else{
                        Integer integer = Integer.valueOf(value);
                        method = cl.getMethod(methodName,type);
                        method.invoke(obj,integer);
                    }
                }
                map.put(objId,obj);
            }
        }
        return map;
    }

    public static Object getBean(String id){
        try{
            Map<String, Object> objectMap = BeanFactory.createBeans(id);
            Object obj = objectMap.get(id);
            return obj;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
