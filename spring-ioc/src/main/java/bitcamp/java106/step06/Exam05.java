// 팩토레 메서드 호출 - 팩토리 빈 구현체 
package bitcamp.java106.step06;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Exam05 {

    public static void main(String[] args) {
        ApplicationContext iocContainer = new ClassPathXmlApplicationContext(
                "bitcamp/java106/step06/application-context-04.xml");

        // 이 예제는 Exam04 예제외 같다.
        // 다만 Factory 클래스의 이름을 CarFactory3에서 CarFactoryBean으로 바꾼 것이다.
        System.out.println(iocContainer.getBean("c1"));
    }

}




