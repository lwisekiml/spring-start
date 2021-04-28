package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/*
(1) 컴포넌트 스캔과 자동 의존관계 설정 - @controller @service @repository 사용한 방식(@Component가 안에 있다.)
controller를 통해 외부 요청을 받고
service에서 비지니스 로직을 만들고
repository에서 데이터 저장

스프링이 뜰때 위 3개를 가지고 올라옴
*/
@Controller // @Controller가 있으면 MemberController 객체를 생성하여 스프링 컨테이너에 등록하여 스프링이 관리
public class MemberController {

//    private final MemberService memberService = new MemberService();
    // 스프링이 관리를 하게 되면 다 스프링컨테이너에 등록을 하고 컨테이너에서 받아서 쓰도록 바꾸어야 한다.
    // 다른 곳에서도 MemberService를 가져다 쓸수 있다. new로 계속 객체를 생성함
    // 별 기능이 없고 여러개의 인스턴스를 생성할 필요가 없다.
    // 하나만 생성해서 쓰면 됨
    // 스프링 컨테이너에 하나만 등록
    private final MemberService memberService;

    @Autowired //스프링이 스프링 컨테이너에 있는 memberService를 가져다가 연결
    // 'hello.hellospring.service.MemberService' that could not be found. 라고 뜸
    // MemberService는 순수한 자바 클래스. 스프링이 알 수 있는 방법이 없다. 그래서 @Service, @Repository 로 등록하여 사용
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
        System.out.println("memberService = " + memberService.getClass());
        // 아래와 같이 MemberService 뒤에 다른 것이 있다. memberService를 가지고 복제를 하는 것
        // memberService = class hello.hellospring.service.MemberService$$EnhancerBySpringCGLIB$$be580b1e
    }

    @GetMapping("/members/new") // url창에 타이핑
    public String createForm() {
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());

//        System.out.println("member = " + member.getName());
        memberService.join(member);

        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model) {
        List<Member> members = memberService.findMember();
        model.addAttribute("members", members);
        return "members/memberList";
    }
}
