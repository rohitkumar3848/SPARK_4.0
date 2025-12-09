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

        //car1.drive();


        //This is the second case and if our scope is  singleton so it should return true bcz sue to this scope it create only 1 object on every request--
        System.out.println("--------------second call-----------------");
        Car car2=context.getBean(Car.class);
        System.out.println("same car object ? "+(car1==car2));


        //This is the second case when scope is prototype so on every request it create new object and we have to manage destruction of object manually.
        System.out.println("--------------first call-----------------");
        PetrolEngine p1=context.getBean(PetrolEngine.class);

        System.out.println("--------------second call-----------------");
        PetrolEngine p2=context.getBean(PetrolEngine.class);

        System.out.println("same petrol engine object ? "+(p1==p2));
    }
}
