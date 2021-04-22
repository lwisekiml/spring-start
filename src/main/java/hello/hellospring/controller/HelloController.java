package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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


    @GetMapping("hello-string")
    @ResponseBody // http body. 적용후 소스코드 보면 body만 있다.(쓸일이 별로 없음)
    public String helloString(@RequestParam("name") String name){
        return "hello" + name; // http를 전달
    }

    // JSON 방식
    @GetMapping("hllo-api")
    @ResponseBody // 객체가 오면 JSON방식으로 변환
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
