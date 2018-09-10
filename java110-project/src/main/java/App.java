import java.lang.reflect.Method;
import java.util.Scanner;

import bitcamp.java110.cms.annotation.RequestMapping;
import bitcamp.java110.cms.context.ApplicationContext;
import bitcamp.java110.cms.context.RequestMappingHandlerMapping;
import bitcamp.java110.cms.context.RequestMappingHandlerMapping.RequestMappingHandler;

public class App {

    static Scanner keyIn = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        ApplicationContext iocContainer = 
                new ApplicationContext("bitcamp.java110.cms.control");

        RequestMappingHandlerMapping requestHandlerMap = new RequestMappingHandlerMapping();
        //=>iocContainer에 보관된 객체의 이름 목록을 가져온다.
        String[] names = iocContainer.getBeanDefinitionNames();
        for(String name : names)
        {
            //=>이름으로 객체를 꺼낸다.
            Object obj = iocContainer.getBean(name);
            requestHandlerMap.addMapping(obj);

        }
        while (true) {
            String menu = prompt();
            if (menu.equals("0")){
                System.out.println("안녕히 가세요!");
                break;
            } 

            RequestMappingHandler mapping = requestHandlerMap.getMapping(menu);

            if(mapping==null)
            {
                System.out.println("해당 메뉴가 없습니다.");
                continue;
            }
            //Method method = mapping.getMethod();
            mapping.getMethod().invoke(mapping.getInstance(),keyIn);
        }
        keyIn.close();
    }

    private static String prompt() {
        System.out.print("메뉴 > ");
        return keyIn.nextLine();
    }
}






















