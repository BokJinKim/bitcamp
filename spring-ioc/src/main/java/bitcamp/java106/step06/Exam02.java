// 프로퍼티 호출 
package bitcamp.java106.step06;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Exam02 {

    public static void main(String[] args) {
        ApplicationContext iocContainer = new ClassPathXmlApplicationContext(
                "bitcamp/java106/step06/application-context-02.xml");
        
        Date date = (Date) iocContainer.getBean("d1");
        System.out.println(date);
    }

}





