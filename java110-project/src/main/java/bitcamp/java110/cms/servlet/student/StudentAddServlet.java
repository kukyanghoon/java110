package bitcamp.java110.cms.servlet.student;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.java110.cms.dao.StudentDao;
import bitcamp.java110.cms.domain.Student;

@WebServlet("/student/add")
public class StudentAddServlet extends HttpServlet{

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException,IOException{
        request.setCharacterEncoding("UTF-8");
        Student s = new Student();
        s.setName(request.getParameter("name"));
        s.setEmail(request.getParameter("email"));
        s.setPassword(request.getParameter("password"));
        s.setTel(request.getParameter("tel"));
        s.setSchool(request.getParameter("school"));
        s.setWorking(Boolean.parseBoolean(request.getParameter("working")));


        //등록 결과를 출력하고 1초가 경과한 후에 목록 페이지를 요청하도록
        //"리프레시"명령을 설정한다.
        //=> 응답할 때 응답 헤더로 웹 브라우저에게 알린다.
        StudentDao studentDao = 
                (StudentDao)this.getServletContext().getAttribute("studentDao");

        try{
            studentDao.insert(s);  
            response.sendRedirect("list");            
        } catch (Exception e) {
            request.setAttribute("error", e);
            request.setAttribute("message", "학생 등록 오류!");
            request.setAttribute("refresh", "3;url=list");
            request.getRequestDispatcher("/error").forward(request, response);
        }

    }


}
