// 리스너 = 이벤트 핸들러 : 특정 상태가 되었을 때 실행되는 객체
//
package step09.ex2;


import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

// 리스너
// => 특정 상태가 되었을 때 특정 작업을 수행하는 객체
//
// 서블릿 컨테이너에서 발생하는 이벤트 
//
@WebListener
public class Listener2 implements ServletRequestListener {
    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        HttpServletRequest request = (HttpServletRequest)sre.getServletRequest();
        System.out.println("Listener2.requestInitialized()");
        System.out.printf("[%s] %s\n", request.getRemoteAddr(), request.getPathInfo());
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("Listener2.requestDestroyed()");
    }
}
