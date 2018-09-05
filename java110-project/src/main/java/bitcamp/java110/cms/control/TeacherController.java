package bitcamp.java110.cms.control;
import java.util.Scanner;

import bitcamp.java110.cms.domain.Member;

public class TeacherController {
    
    public static Scanner keyIn;
    
    public static Teacher[] teachers = new Teacher[100];
    
    public static int teacherIndex = 0;
    
    static class Teacher extends Member{
        protected String tel;
        protected int pay;
        public String getTel() {
            return tel;
        }
        public void setTel(String tel) {
            this.tel = tel;
        }
        public int getPay() {
            return pay;
        }
        public void setPay(int pay) {
            this.pay = pay;
        }
        public String getSubjects() {
            return subjects;
        }
        public void setSubjects(String subjects) {
            this.subjects = subjects;
        }
        protected String subjects;
    }
    
    private static void printTeachers()
    {
        int count =0;
        for(Teacher s : teachers) {
            if(count++ == teacherIndex)
            {
                break;
            }
            System.out.printf("%s, %s, %s, %s, %d, [%s]\n"
                    , s.getName()
                    , s.getEmail()
                    , s.getPassword()
                    , s.getTel()
                    , s.getPay()
                    , s.getSubjects());
        }

    }

    private static void inputTeachers()
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

            teachers[teacherIndex++]=m;


            System.out.println("계속입력?(Y/n)");
            String yn=keyIn.nextLine();
            if(yn.equalsIgnoreCase("n"))
            {
                break;
            }

        }
    }

    public static void serviceTeacherMenu() {
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

}
