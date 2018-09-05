package bitcamp.java110.cms.control;
import java.util.Scanner;

import bitcamp.java110.cms.dao.StudentList;
import bitcamp.java110.cms.domain.Student;


public class StudentController {

    public static Scanner keyIn;

    public static void serviceStudentMenu() {
        while(true) //학생관리 명령처리
        {
            System.out.println("학생 관리 : (목록 : list, 추가 : add, 삭제 : delete, 상세보기 : detail, 종료 : quit)");
            String command = keyIn.nextLine();
            if(command.equals("list"))
            {
                printStudents();
            }
            else if(command.equals("add"))
            {
                inputStudents();
            }
            else if(command.equals("delete"))
            {
                deleteStudent();
            }
            else if(command.equals("detail"))
            {
                detailStudent();
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

    private static void printStudents()
    {
        for(int i=0; i<StudentList.size();i++) {
            Student s = StudentList.get(i);
            System.out.printf("%s: %s, %s, %s, %s, %b, %s\n"
                    , i
                    , s.getName()
                    , s.getEmail()
                    , s.getPassword()
                    , s.getSchool()
                    , s.isWorking()
                    , s.getTel());
        }

    }

    private static void inputStudents()
    {
        
        while(true) {
            Student m =new Student();

            System.out.println("이름?");
            m.setName(keyIn.nextLine());

            System.out.println("이메일?");
            m.setEmail(keyIn.nextLine());

            System.out.println("비밀번호?");
            m.setPassword(keyIn.nextLine());

            System.out.println("최종학력?");
            m.setSchool(keyIn.nextLine());

            System.out.println("재직여부?(true/false)");
            m.setWorking(Boolean.parseBoolean(keyIn.nextLine()));

            System.out.println("전화?");
            m.setTel(keyIn.nextLine());
            
            StudentList.add(m);
            
            System.out.println("계속입력?(Y/n)");
            String yn=keyIn.nextLine();
            if(yn.equalsIgnoreCase("n"))
            {
                break;
            }
            
        }
    }




    private static void deleteStudent()
    {
        System.out.print("삭제할 번호 : ");
        int no = Integer.parseInt(keyIn.nextLine());

        if(no<0 || no>StudentList.size())
        {
            System.out.println("유효하지않은 번호입니다.");
            return;
        }
        StudentList.remove(no);
        System.out.println("삭제하였습니다.");

    }

    private static void detailStudent() 
    {
        System.out.print("조회할 번호 : ");
        int no = Integer.parseInt(keyIn.nextLine());

        if(no<0 && no>=StudentList.size())
        {
            System.out.println("유효하지않은 번호입니다.");
            return;
        }
        Student student = StudentList.get(no);
        System.out.printf("이름 :%s\n", student.getName());
        System.out.printf("이메일 :%s\n", student.getEmail());
        System.out.printf("암호 :%s\n", student.getPassword());
        System.out.printf("최종학력 :%s\n", student.getSchool());
        System.out.printf("전화번호 :%s\n", student.getTel());
        System.out.printf("재직여부 :%b\n", student.isWorking());
    }
    
    static {
        Student s = new Student();
        s.setName("a");
        StudentList.add(s);
        
        s = new Student();
        s.setName("b");
        StudentList.add(s);
        
        s = new Student();
        s.setName("c");
        StudentList.add(s);
        
        s = new Student();
        s.setName("d");
        StudentList.add(s);
        
        s = new Student();
        s.setName("e");
        StudentList.add(s);
        
    }
    

}
