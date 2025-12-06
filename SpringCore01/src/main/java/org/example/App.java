package org.example;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App
{
    public static void main( String[] args )
    {

        System.out.println("----------------BeanFactory Started------------------");
        //We are using Application context so it use eager loading so it create the object early when the Beans.xml file loaded.
        //BeanFactory factory = new XmlBeanFactory(new ClassPathResource("your-beans.xml"));
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        System.out.println("----------------Bean file loaded------------------");

        System.out.println("sending request.....");
        System.out.println("--------------first call-----------------");
        Car car1=context.getBean(Car.class);

        car1.drive();
    }
}
