package bitcamp.java110.cms.control.teacher;

import java.util.Scanner;

import bitcamp.java110.cms.App;
import bitcamp.java110.cms.annotation.Component;
import bitcamp.java110.cms.annotation.RequestMapping;

@Component
public class TeacherDeleteController {

    @RequestMapping("teacher/delete")
    public void delete(Scanner keyIn) {
        System.out.print("삭제할 강사 이메일? ");
        String email = keyIn.nextLine();

        if (App.teachersDao.delete(email)>0) {
            System.out.println("삭제하였습니다.");
            return;
        }
        else
        {
            System.out.println("이메일에 해당하는 강사를 찾을 수 없습니다.");
        }
    }
}
