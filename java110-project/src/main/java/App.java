import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        String[] names = new String[100];
        String[] emails = new String[100];
        String[] passwords = new String[100];
        int index = 0;
        while(true) {
            Scanner keyIn = new Scanner(System.in);
            System.out.println("이름?");
            names[index] = keyIn.nextLine();

            System.out.println("이메일?");
            emails[index] = keyIn.nextLine();

            System.out.println("비밀번호?");
            passwords[index] = keyIn.nextLine();
            
            index++;

            System.out.println("계속입력?(Y/n)");
            String yn=keyIn.nextLine();
            if(yn.equalsIgnoreCase("n"))
            {
                break;
            }
            for(int i=0; i<index; i++) {
                System.out.printf("%s, %s, %s\n", names[i], emails[i], passwords[i]);
            }
            keyIn.close();
        }
    }
}
