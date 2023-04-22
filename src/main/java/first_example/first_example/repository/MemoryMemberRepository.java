package first_example.first_example.repository;

import first_example.first_example.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

//@Repository
public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        //store에서 (람다 사용) 루프로 돌리면서 필터로 멤버에서 멤버.겟네임이 파라미터로 넘어온 네임과 같은지 비교
        return store.values().stream()
                    .filter(member -> member.getName().equals(name))
                    .findAny(); //하나로도 찾는 것
        //끝까지 없으면 optional로 null 반환
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values()); //store에 있는 values가 멤버들
    }


    public void clearStore(){
        store.clear();
    }
}
