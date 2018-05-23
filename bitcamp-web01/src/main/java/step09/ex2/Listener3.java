// 리스너 = 이벤트 핸들러 : 특정 상태가 되었을 때 실행되는 객체
//
package step09.ex2;


import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.annotation.WebListener;

// 리스너
// => 특정 상태가 되었을 때 특정 작업을 수행하는 객체
//
// 서블릿 컨테이너에서 발생하는 이벤트 
//
@WebListener
public class Listener3 implements ServletRequestAttributeListener {
    @Override
    public void attributeAdded(ServletRequestAttributeEvent srae) {
        System.out.println("Listener3.attributeAdded()");
        System.out.printf("%s=%s 저장\n", srae.getName(), srae.getValue());
    }
    
    @Override
    public void attributeReplaced(ServletRequestAttributeEvent srae) {
        System.out.println("Listener3.attributeReplaced()");
        System.out.printf("%s=%s(%s) 변경\n", srae.getName(),
                srae.getServletRequest().getAttribute(srae.getName()),
                srae.getValue());
    }
}
