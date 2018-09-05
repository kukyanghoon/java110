package bitcamp.java110.cms.control;
import java.util.Scanner;

import bitcamp.java110.cms.domain.Member;


public class StudentController {

    public static Scanner keyIn;

    public static Student []  students = new Student[5];

    public static int studentIndex = 0;

    static class Student extends Member{
        protected String school;
        protected boolean working;
        protected String tel;
        public String getSchool() {
            return school;
        }
        public void setSchool(String school) {
            this.school = school;
        }
        public boolean isWorking() {
            return working;
        }
        public void setWorking(boolean working) {
            this.working = working;
        }
        public String getTel() {
            return tel;
        }
        public void setTel(String tel) {
            this.tel = tel;
        }
    }



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
        int count =0;
        for(Student s : students) {
            if(count++ == studentIndex)
            {
                break;
            }
            System.out.printf("%s: %s, %s, %s, %s, %b, %s\n"
                    , count-1
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

            System.out.println("비밀번호?");
            m.setTel(keyIn.nextLine());;

            //배열 크기 늘리기
            if(studentIndex==students.length)
            {
                increaseStorage();
            }
            students[studentIndex++]=m;


            System.out.println("계속입력?(Y/n)");
            String yn=keyIn.nextLine();
            if(yn.equalsIgnoreCase("n"))
            {
                break;
            }

        }
    }

    private static void increaseStorage() {
        Student[] newList = new Student[students.length+3];
        for(int i =0; i<students.length;i++)
        {
            newList[i]=students[i];
        }
        students = newList;
    }

    private static void deleteStudent()
    {
        System.out.print("삭제할 번호 : ");
        int no = Integer.parseInt(keyIn.nextLine());

        if(no<0 || no>studentIndex)
        {
            System.out.println("유효하지않은 번호입니다.");
            return;
        }
        for( int i = no; i<=studentIndex-2; i++)
        {
            students[i]=students[i+1];
        }
        studentIndex--;
        System.out.println("삭제하였습니다.");

    }

    private static void detailStudent() 
    {
        System.out.print("조회할 번호 : ");
        int no = Integer.parseInt(keyIn.nextLine());

        if(no<0 && no>=studentIndex)
        {
            System.out.println("유효하지않은 번호입니다.");
            return;
        }
        System.out.printf("이름 :%s\n", students[no].getName());
        System.out.printf("이메일 :%s\n", students[no].getEmail());
        System.out.printf("암호 :%s\n", students[no].getPassword());
        System.out.printf("최종학력 :%s\n", students[no].getSchool());
        System.out.printf("전화번호 :%s\n", students[no].getTel());
        System.out.printf("재직여부 :%b\n", students[no].isWorking());
    }

    static {
        
        Student s = new Student();
        s.setName("a");
        
    }


  
}
