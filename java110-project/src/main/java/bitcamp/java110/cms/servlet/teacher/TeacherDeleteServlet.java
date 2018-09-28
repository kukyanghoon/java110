package bitcamp.java110.cms.servlet.teacher;

import java.io.IOException;

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
            request.setAttribute("error", e);
            request.setAttribute("message", "강사 삭제 오류!");
            request.setAttribute("refresh", "3;url=list");
            request.getRequestDispatcher("/error").forward(request, response);
        }
    }
    
   
}
