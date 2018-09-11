package bitcamp.java110.cms.control.teacher;

import java.util.Scanner;

import bitcamp.java110.cms.annotation.Autowired;
import bitcamp.java110.cms.annotation.Component;
import bitcamp.java110.cms.annotation.RequestMapping;
import bitcamp.java110.cms.dao.TeacherDao;

@Component
public class TeacherDeleteController {

    TeacherDao teacherDao;

    @Autowired
    public void setTeacherDao(TeacherDao teacherDao) {
        this.teacherDao = teacherDao;
    }

    @RequestMapping("teacher/delete")
    public void delete(Scanner keyIn) {
        System.out.print("삭제할 강사 이메일? ");
        String email = keyIn.nextLine();

        if (teacherDao.delete(email)>0) {
            System.out.println("삭제하였습니다.");
            return;
        }
        else
        {
            System.out.println("이메일에 해당하는 강사를 찾을 수 없습니다.");
        }
    }
}
