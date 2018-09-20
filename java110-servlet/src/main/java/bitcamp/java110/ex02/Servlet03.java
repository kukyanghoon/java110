/*서블릿 만들기
 *  -javax.servlet.GenericServlet 상속받기
 * 
 * 
 */
package bitcamp.java110.ex02;

import java.io.IOException;
import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;


@WebServlet("/ex02/servlet03")
public class Servlet03 extends HttpServlet{
    

    private static final long serialVersionUID = 1L;

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("Servlet03.service()호출됨.");
        
    }


}



