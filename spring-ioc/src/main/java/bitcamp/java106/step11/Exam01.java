// 객체 자동 생성 - @Component 애노테이션
package bitcamp.java106.step11;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import bitcamp.java106.BeanUtils;

public class Exam01 {

    public static void main(String[] args) {
        ApplicationContext iocContainer = 
                new AnnotationConfigApplicationContext(AppConfig01.class);
        
        BeanUtils.printBeanNames(iocContainer);
        
    }
}





