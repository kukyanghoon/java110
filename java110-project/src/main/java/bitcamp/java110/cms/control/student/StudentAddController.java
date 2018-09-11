package bitcamp.java110.cms.control.student;

import java.util.Scanner;

import bitcamp.java110.cms.annotation.Autowired;
import bitcamp.java110.cms.annotation.Component;
import bitcamp.java110.cms.annotation.RequestMapping;
import bitcamp.java110.cms.dao.StudentDao;
import bitcamp.java110.cms.domain.Student;

@Component
public class StudentAddController {

    StudentDao studentDao;
    
    @Autowired
    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @RequestMapping("student/add")
    public void add(Scanner KeyIn) {
        while(true) {

            Student s = new Student();

            System.out.print("이름 : ");
            s.setName(KeyIn.nextLine());

            System.out.print("이메일 : ");
            s.setEmail(KeyIn.nextLine());

            System.out.print("암호 : ");
            s.setPassword(KeyIn.nextLine());

            System.out.print("최종학력  : ");
            s.setSchool(KeyIn.nextLine());

            System.out.print("재직여부 : (true/false)");
            s.setWorking(Boolean.parseBoolean(KeyIn.nextLine()));

            System.out.print("전화번호 : ");
            s.setTel(KeyIn.nextLine());

            if(studentDao.insert(s)>0)
            {
                System.out.println("저장하였습니다.");
            }
            else
            {
                System.out.println("같은 이메일의 학생이 존재합니다.");
            }

            System.out.print("continue? (Y/n) ");
            String answer = KeyIn.nextLine();
            if(answer.toLowerCase().equals("n")) break;
        }
    }
/*
    {
        Student s = new Student();
        s.setName("a");
        s.setEmail("a@test.com");
        studentDao.insert(s);
        
        s = new Student();
        s.setName("b");
        s.setEmail("b@test.com");
        studentDao.insert(s);
        
        s = new Student();
        s.setName("c");
        s.setEmail("c@test.com");
        studentDao.insert(s);
        
        s = new Student();
        s.setName("d");
        s.setEmail("d@test.com");
        studentDao.insert(s);
        
        s = new Student();
        s.setName("e");
        s.setEmail("e@test.com");
        studentDao.insert(s);
    }*/
}