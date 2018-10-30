// 커스텀 프로퍼티 에디터 - 글로벌 커스텀 프로퍼티 에디터 장착하기
package ex02;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/ex02/test16")
public class Test16 {

    
    // 모든 페이지 컨트롤러가 사용할 커스텀 프로퍼티 에디터는
    // @ControllerAdvice 애노테이션이 붙은 클래스에
    // @InitBinder가 붙은 메서드를 등록하라!
    //
    // => 이 방법의 문제점은 커스텀 프로퍼티 에디터가 필요하지 않는 페이지 컨트롤러에 대해서도
    //    매번 @InitBinder메서드를 호출한다는 
    
    @RequestMapping("m1")
    public String m1(String name, Date day, Model model) {
        model.addAttribute("name",name);
        model.addAttribute("day",day);
        return "/ex02/Test15.jsp";
    }
    
    // => 프론트 컨트롤러는 request handler를 호출하기 전에
    //    클라이언트가 보낸 데이터를 request handler의 파라미터 타입으로 바꾼다.
    // => 프론트 컨트롤러가 데이터 타입을 바꿀 때 WebDataBinder를 통해 설정된
    //    도구를 사용한다.
    // => @InitBinder는 프론트 컨트롤러가 WebDataBinder를 사용하기 전에
    //    이 애노테이션이 지정된 메서드를 호출하여 먼저 초기화 시킨 다음에
    //    사용할 것을 요구하는 애노테이션이다.
    // => 클라이언트가 보낸 데이터를 request handler의 각 파라미터 값으로 바꾸기 전에
    //    이 메서드에서 호출할 것이다.
    //    즉 파라미터 개수만큼 호출한다.
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        System.out.println("...................??");
        
        
        // yyyy-MM-dd형식으로 클라이언트가 보낸 문자열을
        // java.util.Date객체로 바꿔주는 객체
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        format.setLenient(false); // null값을 허용하지않음
        binder.registerCustomEditor(Date.class, /*new DatePropertyEditor(format)*/  // 개발자가 만든것을 써도 되고
                new CustomDateEditor(format, true));// 스프링에서 제공하는 것을 써도 된다.
        
        binder.registerCustomEditor(Car.class, new CarPropertyEditor());
    }
    
    
    
    @RequestMapping("m2")
    public String m2(
            // primitive type, String, java.util.Date, java.sql.Date
            // 타입이 아닐 경우 파라미터 변수 앞에 @RequestParam을 붙여야 한다.
            @RequestParam("car")Car car, Model model) {
        model.addAttribute("car",car);
        return "/ex02/Test15_2.jsp";
    }
    
    
}

