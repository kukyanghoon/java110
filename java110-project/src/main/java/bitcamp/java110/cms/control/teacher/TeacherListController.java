package bitcamp.java110.cms.control.teacher;

import java.io.PrintWriter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bitcamp.java110.cms.annotation.RequestMapping;
import bitcamp.java110.cms.dao.TeacherDao;
import bitcamp.java110.cms.domain.Teacher;
import bitcamp.java110.cms.server.Request;
import bitcamp.java110.cms.server.Response;

@Component
public class TeacherListController {
    
    TeacherDao teacherDao;
    
    @Autowired
    public void setTeacherDao(TeacherDao teacherDao) {
        this.teacherDao = teacherDao;
    }

    @RequestMapping("teacher/list")
    public void list(Request request, Response response) {
        List<Teacher> list = teacherDao.findAll();
        PrintWriter out = response.getWriter();
        for (Teacher t : list) {
            out.printf("%d, %s, %s, %s, %s, %d, [%s]\n",
                    t.getNo(),
                    t.getName(), 
                    t.getEmail(), 
                    t.getPassword(), 
                    t.getTel(),
                    t.getPay(),
                    t.getSubjects());
        }
    }
}
