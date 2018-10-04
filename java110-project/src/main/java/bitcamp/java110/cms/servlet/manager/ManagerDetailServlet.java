package bitcamp.java110.cms.servlet.manager;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.java110.cms.dao.ManagerDao;
import bitcamp.java110.cms.domain.Manager;

@WebServlet("/manager/detail")
public class ManagerDetailServlet extends HttpServlet { 
    private static final long serialVersionUID = 1L;
    
    @Override
    protected void doGet(
            HttpServletRequest request, 
            HttpServletResponse response) 
            throws ServletException, IOException {
        
        
        int no = Integer.parseInt(request.getParameter("no"));

        ManagerDao managerDao = (ManagerDao)this.getServletContext()
                .getAttribute("managerDao");
        Manager m = managerDao.findByNo(no);
        
        request.setAttribute("manager", m);
        
        response.setContentType("text/html;charset=UTF-8");
        RequestDispatcher rd = request.getRequestDispatcher("/manager/detail.jsp");
        rd.include(request, response);
    }
    
}
    
    













    
    
    
    
    
    
    
