// 쿠키 값 받기
package ex02;

import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/ex02/test19")
public class Test19 {

    @RequestMapping(value="m1", produces="text/plain;charset=UTF-8")
    @ResponseBody
    public String m1(HttpServletResponse response) throws Exception{
        
        response.addCookie(new Cookie("name", URLEncoder.encode("hong,홍길동","UTF-8")));
        response.addCookie(new Cookie("age","20"));
        return "쿠키 보냈음!";
    }
    
    
    @RequestMapping(value="m2", produces="text/plain;charset=UTF-8")
    @ResponseBody
    public String m2(@CookieValue("name") String name,
            @CookieValue("age") int age) {
        return String.format("name=%s, age=%s\n", name,age);
    }
    
    
    @RequestMapping(value="m3", produces="text/plain;charset=UTF-8")
    @ResponseBody
    public String m3(@CookieValue(value="name", defaultValue="") String name,
            @CookieValue(value="age", defaultValue="0") int age) {
        return String.format("name=%s, age=%s\n", name,age);
    }
}

