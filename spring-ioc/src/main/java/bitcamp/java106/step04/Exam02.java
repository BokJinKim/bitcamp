// 스프링 IoC 컨테이너 사용
package bitcamp.java106.step04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import bitcamp.java106.BeanUtils;

public class Exam02 {

    public static void main(String[] args) {
        // 스프링 IoC 컨테이너는 ApplicationContext를 구현한다.
        ApplicationContext iocContainer = new ClassPathXmlApplicationContext(
                "bitcamp/java106/step04/application-context-02.xml");
        
        System.out.println(iocContainer.getBean("c1"));
        System.out.println(iocContainer.getBean("c2"));
    }

}
