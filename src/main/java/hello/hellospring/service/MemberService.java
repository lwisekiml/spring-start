package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

//@Service // 스프링이 올라올때 스프링이 스프링 컨테이너에 (멤버 서비스) 등록하면서 생성자 호출
@Transactional // JPA를 사용하려면 있어야함(데이터 저장, 변경할 때 있어야함)
public class MemberService {
//    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final MemberRepository memberRepository;

//    @Autowired // 스프링 컨테이너에 있는 MemberRepository 를 넣어줌(현재 MemoryMemberRepository가 구현채로 있으므로 이것을 넣어줌)
    public MemberService(MemberRepository memberRepository) {
         this.memberRepository = memberRepository; // Dependency Injection(외부에서 memberRepository를 넣어준다.)
    }

    /**
     * 회원 가입
     */
    public Long join(Member member) {
//        Optional<Member> result = memberRepository.findByName(member.getName());
//        memberRepository.findByName(member.getName())
//                .ifPresent(m -> {
//                    throw new IllegalStateException("이미 존재하는 회원입니다.");
//                });

            validateDuplicateMember(member);
            memberRepository.save(member);
            return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    /**
     * 전체 회원 조회
     */
    public List<Member> findMember(){
            return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
