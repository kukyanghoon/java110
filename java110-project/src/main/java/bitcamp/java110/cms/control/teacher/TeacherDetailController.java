package bitcamp.java110.cms.control.teacher;

import java.util.Scanner;

import bitcamp.java110.cms.App;
import bitcamp.java110.cms.annotation.Component;
import bitcamp.java110.cms.annotation.RequestMapping;
import bitcamp.java110.cms.domain.Teacher;

@Component
public class TeacherDetailController {
    
    @RequestMapping("teacher/detail")
    public void detailTeacher(Scanner keyIn) {
        System.out.print("조회할 강사 이메일? ");
        String email = keyIn.nextLine();
        
        Teacher teacher = App.teachersDao.findByEmail(email);
        if (teacher ==null) {
            System.out.println("해당 이메일의 강사 정보가 존재하지 않습니다.");
            return;
        }
        
        
        
        System.out.printf("이름: %s\n", teacher.getName());
        System.out.printf("이메일: %s\n", teacher.getEmail());
        System.out.printf("암호: %s\n", teacher.getPassword());
        System.out.printf("전화: %s\n", teacher.getTel());
        System.out.printf("시급: %d\n", teacher.getPay());
        System.out.printf("강의과목: %s\n", teacher.getSubjects());
    }
}
