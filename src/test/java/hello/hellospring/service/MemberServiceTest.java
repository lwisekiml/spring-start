package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {
//    MemberService memberService = new MemberService();
//    MemoryMemberRepository memberRepository = new MemoryMemberRepository();

    // MemberService에서 MemoryMemberRepository()를 생성하면 MemberServiceTest에 있는 MemoryMemberRepository()와 관계가 애매함
    // static은 인스턴스와 상과 없이 클래스레벨에 붙는 것이기 때문데 지금은 크게 상관없지만 new로 다른 객체 리파지토리가 생성되면 다른 인스터스이기 때문에 내용이 달라지거나 그럴 수 있다.
    // MemberService에서 만든 MemoryMemberRepository()는 MemberServiceTest에서 만든 MemoryMemberRepository()는 다른 리파지토리고 다른 인스턴스이다.
    // 지금이야 private static Map<Long, Member> store처럼 static으로 되어 있기에 문제 없지만 static이 아니면 바로 문제 생김
    // 디비가 다른 디비가 되면서 문제 될 수 있다.
    // 같은것으로 테스트하는것이 맞는것인데 다른 리파지토리로 테스트 되고 있어 같은 인스턴스를 쓰도록 아래와 같이 수정

    MemberService memberService;
    MemoryMemberRepository memberRepository;

    @BeforeEach
    public void beforeEach(){
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @AfterEach // 각 Test 메소드가 끝날때 마다 실행
    public void afterEach() {
        memberRepository.clearStore(); // 메모리 clear
    }

    @Test
    void 회원가입() {
        // given 무언가 주어졌는데(이 데이터를 기반으로)
        Member member = new Member();
//        member.setName("hello");
        member.setName("spring"); // afterEach()로 메모리 clear 하여 정상 실행 확인

        // when 이것을 실행했을때
        Long saveId = memberService.join(member);

        // then 결과가 이게 나와야 됨(검증부)
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void 중복_회원_예외() {
        // given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        // when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));

        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");

//        assertThrows(NullPointerException.class, () -> memberService.join(member2));
//
//        try {
//            memberService.join(member2);
//            fail();
//        } catch (IllegalStateException e){
//            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
//        }
    }

    @Test
    void findMember() {

    }

    @Test
    void findOne() {

    }
}