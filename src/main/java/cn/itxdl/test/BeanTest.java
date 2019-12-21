package cn.itxdl.test;

import cn.itxdl.bean.Emp;
import cn.itxdl.bean.Person;
import cn.itxdl.util.BeanFactory;

public class BeanTest {
    public static void main(String[] args) {
        Emp emp = (Emp)BeanFactory.getBean("emp");
        Person p = (Person)BeanFactory.getBean("person");
        System.out.println(p);
        System.out.println(emp);
    }
}
