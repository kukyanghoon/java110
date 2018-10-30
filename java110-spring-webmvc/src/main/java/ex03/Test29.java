/* 인터셉터 다루기 - 프론트 컨트롤러와 페이지 컨트롤러/JSP 사이의 필터링 방법이다.
 */
package ex03;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("ex03/test29")

public class Test29 {

    // 인터셉터를 스프링에 등록하기
    // => XMl 설정파일
    //     - /WEB-INF/app-servlet.xml
    // => Java Config설정

    @GetMapping("m1")
    @ResponseBody
    public void m1(Model model, HttpSession session) throws Exception{
        System.out.println("Test29.m1().....");
    }
    
    @GetMapping("m2")
    @ResponseBody
    public void m2() {
        System.out.println("Test29.m2().....");
    }
    
    
    
    @GetMapping("ok/m3")
    @ResponseBody
    public void m3() throws Exception{
        System.out.println("Test29.m3().....");
    }
    
    @GetMapping("no/m4")
    @ResponseBody
    public void m4() throws Exception{
        System.out.println("Test29.m4().....");
    }
    
}

