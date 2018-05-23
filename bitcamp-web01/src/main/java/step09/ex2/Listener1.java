// 리스너 = 이벤트 핸들러 : 특정 상태가 되었을 때 실행되는 객체
//
package step09.ex2;


import java.util.Date;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

// 리스너
// => 특정 상태가 되었을 때 특정 작업을 수행하는 객체
//
// 서블릿 컨테이너에서 발생하는 이벤트 
//

public class Listener1 implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.printf("Listener1.contextInitialized() - %s\n", new Date());
        
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.printf("Listener1.contextDestroyed() - %s\n", new Date());
    }
}
