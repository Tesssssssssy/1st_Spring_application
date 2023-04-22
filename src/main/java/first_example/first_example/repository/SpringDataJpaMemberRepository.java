package first_example.first_example.repository;

import first_example.first_example.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {

    //JPQL select m from Member m where m.name = ?
    @Override
    Optional<Member> findByName(String name);
    //인터페이스를 통한 기본적인 crud 기능을 제공하기 때문에
    //method 이름만 findBy 형식에 맞게 해도 조회 기능 제공
}
