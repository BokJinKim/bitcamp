// AOP(Aspect-Oriented Programming) - AOP 필터 적용 후
package bitcamp.java106.step13.ex6;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Exam01 {
    
    public static void main(String[] args) {
        AnnotationConfigApplicationContext iocContainer =   
                new AnnotationConfigApplicationContext(AppConfig.class);
        
        String[] names = iocContainer.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(iocContainer.getBean(name).getClass().getName());
        }
        System.out.println("-------------------------------------------------");
        
        try {
            Caller caller = (Caller) iocContainer.getBean(Caller.class);
            caller.test();
        } catch (Exception e) {
            System.err.println("오류발생");
        }
    }

}
