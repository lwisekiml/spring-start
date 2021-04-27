package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
// SpringDataJpaMemberRepository가 구현체를 자동으로 만들어 줌
// 스프링 빈에 자동으로 등록 해주어 가져다 쓰기만 하면 됨
public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {

    @Override
    Optional<Member> findByName(String name);
}
