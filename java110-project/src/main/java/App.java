import java.util.Scanner;

public class App {
    public static void main(String[] args) {


        while(true) {
            Scanner keyIn = new Scanner(System.in);
            System.out.println("이름?");
            String name = keyIn.nextLine();

            System.out.println("이메일?");
            String email = keyIn.nextLine();

            System.out.println("비밀번호?");
            String password = keyIn.nextLine();

            System.out.printf("%s,%s,%s\n", name, email, password);

            System.out.println("계속입력?(Y/n)");
            String yn=keyIn.nextLine();
            if(yn.equalsIgnoreCase("n"))
            {
                break;
            }
        }
    }
}
