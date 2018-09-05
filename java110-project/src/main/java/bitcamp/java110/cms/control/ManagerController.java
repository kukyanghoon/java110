package bitcamp.java110.cms.control;


import java.util.Scanner;

import bitcamp.java110.cms.dao.ManagerList;
import bitcamp.java110.cms.domain.Manager;

public class ManagerController {

    public static Scanner keyIn;

    private static void printManagers()
    {
      
        for(int i=0; i<ManagerList.size(); i++) {
            Manager s = ManagerList.get(i);
            System.out.printf("%s: %s, %s, %s, %s, %s\n"
                    , i
                    , s.getName()
                    , s.getEmail()
                    , s.getPassword()
                    , s.getTel()
                    , s.getPosition());
        }

    }

    private static void inputManagers()
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
            

            System.out.println("계속입력?(Y/n)");
            String yn=keyIn.nextLine();
            if(yn.equalsIgnoreCase("n"))
            {
                break;
            }

        }
    }

    public static void serviceManagerMenu() {
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
            else if(command.equals("delete"))
            {
                deleteManager();
            }
            else if(command.equals("detail"))
            {
                detailManager();
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
   

    private static void deleteManager()
    {
        System.out.print("삭제할 번호 : ");
        int no = Integer.parseInt(keyIn.nextLine());

        if(no<0 || no>ManagerList.size())
        {
            System.out.println("유효하지않은 번호입니다.");
            return;
        }
       
        System.out.println("삭제하였습니다.");

    }

    private static void detailManager() 
    {
        System.out.print("조회할 번호 : ");
        int no = Integer.parseInt(keyIn.nextLine());
        Manager manager = new Manager();
        if(no<0 && no>=ManagerList.size())
        {
            System.out.println("유효하지않은 번호입니다.");
            return;
        }
        System.out.printf("이름 :%s\n", manager.getName());
        System.out.printf("이메일 :%s\n", manager.getEmail());
        System.out.printf("암호 :%s\n", manager.getPassword());
        System.out.printf("전화번호 :%s\n", manager.getTel());
        System.out.printf("직위 :%s\n", manager.getPosition());
        
    }

}
