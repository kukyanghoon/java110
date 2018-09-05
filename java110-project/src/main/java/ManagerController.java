import java.util.Scanner;

public class ManagerController {

        static Scanner keyIn;
        
        static Manager[] managers = new Manager[100];
        
        static int managerIndex = 0;
        
        static class Manager extends Member{
           protected String tel;
           protected String position;
        public String getTel() {
            return tel;
        }
        public void setTel(String tel) {
            this.tel = tel;
        }
        public String getPosition() {
            return position;
        }
        public void setPosition(String position) {
            this.position = position;
        }
        }
        
        static void printManagers()
        {
            int count =0;
            for(Manager s : managers) {
                if(count++ == managerIndex)
                {
                    break;
                }
                System.out.printf("%s, %s, %s, %s, %s\n"
                        , s.getName()
                        , s.getEmail()
                        , s.getPassword()
                        , s.getTel()
                        , s.getPosition());
            }

        }

        static void inputManagers()
        {
            while(true) {
                Manager m =new Manager();

                System.out.println("이름?");
                m.setName(keyIn.nextLine());

                System.out.println("이메일?");
                m.setEmail(keyIn.nextLine());

                System.out.println("비밀번호?");
                m.setPassword(keyIn.nextLine());

                System.out.println("전화번호?");
                m.setTel(keyIn.nextLine());

                System.out.println("직위?");
                m.setPosition(keyIn.nextLine());

              
                managers[managerIndex++]=m;


                System.out.println("계속입력?(Y/n)");
                String yn=keyIn.nextLine();
                if(yn.equalsIgnoreCase("n"))
                {
                    break;
                }

            }
        }

        static void serviceManagerMenu() {
            while(true) 
            {
                System.out.println("매니저 관리 : (목록 : list, 추가 : add, 종료 : quit)");
                String command = keyIn.nextLine();
                if(command.equals("list"))
                {
                    printManagers();
                }
                else if(command.equals("add"))
                {
                    inputManagers();
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
