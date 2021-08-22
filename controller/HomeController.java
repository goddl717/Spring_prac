package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home()
    {
        return "home"; // home.html 를 호출한다.
        // controller의 우선 순위.
        // 컨트롤러 단이 더 우선 순위가 높다
        // 그다음에 templates의 파일을 찾는다. 이름 index.html
    }
}
