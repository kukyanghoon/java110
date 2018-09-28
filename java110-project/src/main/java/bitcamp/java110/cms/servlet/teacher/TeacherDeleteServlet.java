package bitcamp.java110.cms.servlet.teacher;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.java110.cms.dao.TeacherDao;

@WebServlet("/teacher/delete")
public class TeacherDeleteServlet extends HttpServlet{
    
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException,IOException{
        int no = Integer.parseInt(request.getParameter("no"));
        //등록 결과를 출력하고 1초가 경과한 후에 목록 페이지를 요청하도록
        //"리프레시"명령을 설정한다.
        //=> 응답할 때 응답 헤더로 웹 브라우저에게 알린다.
        TeacherDao teacherDao = 
                (TeacherDao)this.getServletContext().getAttribute("teacherDao");
        
        try {
            teacherDao.deleteByNo(no);
            response.sendRedirect("list");
        }catch(Exception e) {
            e.printStackTrace();
            response.setHeader("Refresh", "1;url=list");
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta charset='UTF-8'>");
            out.println("<title>강사 관리</title>");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>강사 삭제 결과<h1>");
            out.println("<p>wait</p>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
   
}
