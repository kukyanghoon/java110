import java.util.Scanner;


public class StudentController {
    
    static Scanner keyIn;
    
    static Student []  students = new Student[100];
    
    static int studentIndex = 0;
    
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
    
   
    
     static void serviceStudentMenu() {
        while(true) //학생관리 명령처리
        {
            System.out.println("학생 관리 : (목록 : list, 추가 : add, 종료 : quit)");
            String command = keyIn.nextLine();
            if(command.equals("list"))
            {
                printStudents();
            }
            else if(command.equals("add"))
            {
                inputStudents();
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
    
    static void printStudents()
    {
        int count =0;
        for(Student s : students) {
            if(count++ == studentIndex)
            {
                break;
            }
            System.out.printf("%s, %s, %s, %s, %b, %s\n", s.getName(), s.getEmail(), s.getPassword()
                    , s.getSchool(), s.isWorking(), s.getTel());
        }

    }

    static void inputStudents()
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

            students[studentIndex++]=m;


            System.out.println("계속입력?(Y/n)");
            String yn=keyIn.nextLine();
            if(yn.equalsIgnoreCase("n"))
            {
                break;
            }

        }
    }
    
    
    
    

}
