// 스프링 IoC 컨테이너 사용
package bitcamp.java106.step05;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import bitcamp.java106.BeanUtils;

public class Exam04 {

    public static void main(String[] args) {
        // 스프링 IoC 컨테이너는 ApplicationContext를 구현한다.
        ApplicationContext iocContainer = new ClassPathXmlApplicationContext(
                "bitcamp/java106/step05/application-context-04.xml");
        
        System.out.println(iocContainer.getBean("c1"));
        
    }

}
