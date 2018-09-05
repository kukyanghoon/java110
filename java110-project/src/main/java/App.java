import java.util.Scanner;

public class App {
    // 여러 속성의 값을 관리하기 쉽도록 사용자 정의 데이터 타입을 만들어 사용한다.
    static class Member{
        protected String name;
        protected String email;
        protected String password;

        //인스턴스의 메모리를 다루는 연산자   operater=setter/getter=accesor=property=message
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public String getEmail() {
            return email;
        }
        public void setEmail(String email) {
            this.email = email;
        }
        public String getPassword() {
            return password;
        }
        public void setPassword(String password) {
            this.password = password;
        }
    }
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
    /*static String[] names = new String[100];
    static String[] emails = new String[100];
    static String[] passwords = new String[100];*/
    static Student []  students = new Student[100];
    static Teacher[] teachers = new Teacher[100];
    static int studentIndex = 0;
    static int teacherIndex = 0;
    static Scanner keyIn = new Scanner(System.in);
    public static void main(String[] args) {

        while(true)
        {
            String menu = promptMenu();
            if(menu.equals("1"))
            {
                serviceStudentMenu();
            }
            else if(menu.equals("2"))
            {
                serviceTeacherMenu();
            }
            else
            {
                break;
            }
        }
        keyIn.close();
    }
    private static void serviceStudentMenu() {
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
    private static String promptMenu() {

        System.out.println("***메뉴***");
        System.out.println("1. 학생관리");
        System.out.println("2. 강사관리");
        System.out.println("3. 매니저관리");
        System.out.println("0. 종료");
        while(true)
        {
            System.out.print("메뉴 번호 : ");

            String menu = keyIn.nextLine();
            if(menu.equals("0"))
            {
                System.out.println("ㅅㄱ");
            }
            else
            {
                System.out.println(menu+"번 메뉴를 선택하였습니다.");
            }



            switch(menu)
            {
            case "1":
            case "2":
            case "3":
            case "0":
                return menu;
            default:
                System.out.println("메뉴번호가 유효하지 않습니다.");
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

    static void printTeachers()
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

    static void inputTeachers()
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

    private static void serviceTeacherMenu() {
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
