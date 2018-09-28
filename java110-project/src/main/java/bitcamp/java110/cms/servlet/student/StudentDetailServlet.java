package bitcamp.java110.cms.servlet.student;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.java110.cms.dao.StudentDao;
import bitcamp.java110.cms.domain.Student;

@WebServlet("/student/detail")
public class StudentDetailServlet extends HttpServlet{
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException,IOException{
        int no =Integer.parseInt(request.getParameter("no"));
        response.setContentType("text/html;charset=UTF-8");

        StudentDao studentDao = 
                (StudentDao)this.getServletContext().getAttribute("studentDao");
        Student s = studentDao.findByNo(no);
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>학생 관리</title>");
        out.println("<style>");
        out.println("table, th, td{");
        out.println("border:1px solid silver;");
        out.println("}");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>학생 상세보기<h1>");
        if (s == null) {
            out.println("<p>해당 번호의 매니저가 없습니다!</p>");

        }else {
            out.println("<table>");
            out.println("<tbody>");
            out.printf("<tr><th>이름</th> <td>%s</td></tr>\n",s.getName());
            out.printf("<tr><th>이메일</th> <td>%s</td></tr>\n", s.getEmail());
            out.printf("<tr><th>암호</th> <td>%s</td></tr>\n", s.getPassword());
            out.printf("<tr><th>전화번호</th> <td>%s</td></tr>\n", s.getTel());
            out.printf("<tr><th>학위</th> <td>%s</td></tr>\n", s.getSchool());
            out.printf("<tr><th>재직여부</th> <td>%b</td></tr>\n", s.isWorking());
            out.println("</tbody>");
            out.println("</table>");
            out.println("<button type='button' onclick='remove()'>삭제</button>\n");
        }
        out.println("<script>");
        out.println("function remove() {");
        out.printf("location.href='delete?no=%d'\n",s.getNo());
        out.println("}");
        out.println("</script>");

        out.println("</body>");
        out.println("</html>");
    }
}
