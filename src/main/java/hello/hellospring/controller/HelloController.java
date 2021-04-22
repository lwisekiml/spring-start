package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {
    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!!");
        return "hello"; // resource/template에 있는 hello.html이 실행
    }

    @GetMapping("hello-mvc") // http://localhost:8080/hello-mvc?name=spring!!!!!!  이런 형식으로 name값을 전달
    public String helloMvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name", name);
        return "hello-template"; // templates에 있는 hello-template.html 실행
    }
}
