package bitcamp.java110.cms.control;
import java.util.Scanner;

import bitcamp.java110.cms.domain.Teacher;
import bitcamp.java110.cms.util.ArrayList;

public class TeacherController {
    
    private ArrayList teachers = new ArrayList();
    public Scanner keyIn;
    
    public TeacherController(Scanner keyIn)
    {
        this.keyIn = keyIn;
    }


    private void printTeachers()
    {
     
        for(int i=0; i<teachers.size();i++) {
            Teacher s = (Teacher) teachers.get(i);
            System.out.printf("%s: %s, %s, %s, %s, %d, [%s]\n"
                    , i
                    , s.getName()
                    , s.getEmail()
                    , s.getPassword()
                    , s.getTel()
                    , s.getPay()
                    , s.getSubjects());
        }

    }

    private void inputTeachers()
    {
        while(true) {
            Teacher m =new Teacher();

            System.out.println("이름?");
            m.setName(keyIn.nextLine());

            System.out.println("이메일?");
            m.setEmail(keyIn.nextLine());

            System.out.println("비밀번호?");
            m.setPassword(keyIn.nextLine());

            System.out.println("전화번호?");
            m.setTel(keyIn.nextLine());

            System.out.println("급여?");
            m.setPay(Integer.parseInt(keyIn.nextLine()));

            System.out.println("과목?(예: 자바, C, C++ ...)");
            m.setSubjects(keyIn.nextLine());;

            teachers.add(m);


            System.out.println("계속입력?(Y/n)");
            String yn=keyIn.nextLine();
            if(yn.equalsIgnoreCase("n"))
            {
                break;
            }

        }
    }

    public void serviceTeacherMenu() {
        while(true) //학생관리 명령처리
        {
            System.out.println("강사 관리 : (목록 : list, 추가 : add, 종료 : quit)");
            String command = keyIn.nextLine();
            if(command.equals("list"))
            {
                printTeachers();
            }
            else if(command.equals("add"))
            {
                inputTeachers();
            }
            else if(command.equals("delete"))
            {
                deleteTeacher();
            }
            else if(command.equals("detail"))
            {
                detailTeacher();
            }
            else if(command.equals("quit"))
            {
                break;
            }
            else
            {
                System.out.println("유효하지 않는 명령입니다.");
            }
        }
    }
    
    private void deleteTeacher()
    {
        System.out.print("삭제할 번호 : ");
        int no = Integer.parseInt(keyIn.nextLine());

        if(no<0 || no>teachers.size())
        {
            System.out.println("유효하지않은 번호입니다.");
            return;
        }
       
        teachers.remove(no);
        System.out.println("삭제하였습니다.");

    }

    private void detailTeacher() 
    {
        System.out.print("조회할 번호 : ");
        int no = Integer.parseInt(keyIn.nextLine());
        Teacher teacher = new Teacher();
        if(no<0 && no>=teachers.size())
        {
            System.out.println("유효하지않은 번호입니다.");
            return;
        }
        System.out.printf("이름 :%s\n", teacher.getName());
        System.out.printf("이메일 :%s\n", teacher.getEmail());
        System.out.printf("암호 :%s\n", teacher.getPassword());
        System.out.printf("전화번호 :%s\n", teacher.getTel());
        System.out.printf("급여 :%d\n", teacher.getPay());
        System.out.printf("과목 :%s\n", teacher.getSubjects());
    }

}
