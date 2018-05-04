// 스프링 IoC 컨테이너 사용
package bitcamp.java106.step03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import bitcamp.java106.BeanUtils;

public class Exam03 {

    public static void main(String[] args) {
        // 스프링 IoC 컨테이너는 ApplicationContext를 구현한다.
        ApplicationContext iocContainer = new ClassPathXmlApplicationContext(
                "bitcamp/java106/step03/application-context-03.xml");
        BeanUtils.printBeanNames(iocContainer);
    }

}
