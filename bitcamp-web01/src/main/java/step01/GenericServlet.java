// 서블릿 클래스가 구현해야 할 메서드를 미리 이 클래스에서 구현해 둔다.
package step01;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

// Servlet 인터페이스에서 선언된 메서드 중에서
// 개발자가 관심없는 메서드는 이 클래스에서 미리 구현해 둔다.
// 그러면 개발자는 Servlet 인터페이스를 직접 구현하기 보다는
// 이 클래스를 상속 받음으로써 개발이 간결해 질 것이다.

// 어차피 서브클래스에서 재정의할 메서드라면 추상메서드로 만들고
// 반드시 서브클래스에서 재정의하게 만들꺼라면 추상메서드를 만든다.
// 인스턴스를 못만드는 추상클래스가 추상메서드를 가질수 있다.
public abstract class GenericServlet implements Servlet {
    ServletConfig config;
    
    @Override
    public void init(ServletConfig config) throws ServletException {
        this.config = config;
    }
    @Override
    public void destroy() {
    }
    @Override
    public String getServletInfo() {
        return this.getClass().getName();
        
    }
    @Override
    public ServletConfig getServletConfig() {
        return null;
    }
    
}
