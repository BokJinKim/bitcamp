// 스프링 IoC 컨테이너 사용
package bitcamp.java106.step02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import bitcamp.java106.BeanUtils;

public class Exam01 {

    public static void main(String[] args) {
        // 스프링 IoC 컨테이너는 ApplicationContext를 구현한다.
        ApplicationContext iocContainer = new ClassPathXmlApplicationContext(
                "bitcamp/java106/step02/application-context-01.xml");
        BeanUtils.printBeanList(iocContainer);
    }

}
