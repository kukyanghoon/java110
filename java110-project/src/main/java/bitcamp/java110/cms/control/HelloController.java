package bitcamp.java110.cms.control;

import java.util.Scanner;

import bitcamp.java110.cms.annotation.Component;
import bitcamp.java110.cms.annotation.RequestMapping;

//일반주석!
@Component//값을 지정하지 않으면 클래스 이름으로 자동 저장
public class HelloController{

    //public String name = "4";
    
    @RequestMapping("hello")
    public void hello(Scanner keyIn) {
        System.out.println("안녕하세요!!!");
        
    }


}
