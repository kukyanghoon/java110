import java.util.Scanner;

public class App {

    static Scanner keyIn = new Scanner(System.in);

    public static void main(String[] args) {

        StudentController.keyIn=keyIn;
        TeacherController.keyIn=keyIn;
        ManagerController.keyIn=keyIn;
        while(true)
        {
            String menu = promptMenu();
            if(menu.equals("1"))
            {
                StudentController.serviceStudentMenu();
            }
            else if(menu.equals("2"))
            {
                TeacherController.serviceTeacherMenu();
            }
            else if(menu.equals("3"))
            {
                ManagerController.serviceManagerMenu();
            }
            else
            {
                break;
            }
        }
        keyIn.close();
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
}
