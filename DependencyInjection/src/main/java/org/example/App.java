package org.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //we did manually using spring core it can manage automatically we have manage pom.xml file do bean configuration in that file and IOc container managed it life cyle and manage dependency also.
        //constructor injection--
        Student student = new Student(new DSA());
        //Field Injection--
        student.course=new DSA();
        //setter Injection--
        student.setCourse(new JAVA());


        student.study();
    }
}
