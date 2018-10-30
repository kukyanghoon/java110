// @PathVariable 사용법

package ex03;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import ex02.Car;

@Controller
@RequestMapping("/ex03/test24")
public class Test24 {

    @RequestMapping("car/detail")
    public String m1(String no, Model model) throws Exception{

        // request handler가 호출될 때
        // DBMS에서 해당 번호의 차 정보를 가져온다고 가정하자!
        Car car = new Car();
        car.setNo(100);
        car.setModel("소나타");
        car.setMaker("현대자동차");
        car.setAuto(true);
        model.addAttribute("car",car);


        return "ex03/Test24";
    }
    
    
    @RequestMapping("car/{no}")
    public String m2(@PathVariable String no, Model model) throws Exception{

        // request handler가 호출될 때
        // DBMS에서 해당 번호의 차 정보를 가져온다고 가정하자!
        Car car = new Car();
        car.setNo(200);
        car.setModel("기아");
        car.setMaker("쏘렌토");
        car.setAuto(true);
        model.addAttribute("car",car);


        return "ex03/Test24";
    }

}

