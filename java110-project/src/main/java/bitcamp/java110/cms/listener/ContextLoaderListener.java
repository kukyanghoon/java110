package bitcamp.java110.cms.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import bitcamp.java110.cms.dao.impl.ManagerMysqlDao;
import bitcamp.java110.cms.dao.impl.StudentMysqlDao;
import bitcamp.java110.cms.dao.impl.TeacherMysqlDao;
import bitcamp.java110.cms.util.DataSource;



//@WebListener
public class ContextLoaderListener implements ServletContextListener{

    @Override
    public void contextInitialized(ServletContextEvent sce){
        System.out.println("contextloaderlistener");
        
        ServletContext sc = sce.getServletContext();
        try {
            DataSource dataSource = new DataSource(
                    sc.getInitParameter("jdbc.driver"),
                    sc.getInitParameter("jdbc.url"),
                    sc.getInitParameter("jdbc.username"),
                    sc.getInitParameter("jdbc.password"));
            
            //DAO객체 생성 및 DB커넥션풀 주입하기
            ManagerMysqlDao managerDao = new ManagerMysqlDao();
            managerDao.setDataSource(dataSource);
            
            StudentMysqlDao studentDao = new StudentMysqlDao();
            studentDao.setDataSource(dataSource);
            
            TeacherMysqlDao teacherDao = new TeacherMysqlDao();
            teacherDao.setDataSource(dataSource);
            
            //서블릿에서 DAO를 이용할 수 있도록 ServletContext보관소에 저장하기
            sc.setAttribute("managerDao", managerDao);
            sc.setAttribute("studentDao", studentDao);
            sc.setAttribute("teacherDao", teacherDao);}
            catch(Exception e)
            {
                e.printStackTrace();
            }
    }
}
