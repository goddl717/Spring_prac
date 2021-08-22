package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.stereotype.Repository;

import java.sql.Array;
import java.util.*;
@Repository
public class MemoryMemberRepositroy implements MemberRepository {

    private  static Map<Long,Member> store = new HashMap<>();   //동시성 문제 concent
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        // 들어올 때 이름이 들어오게 됨.

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
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }
    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStroe()
    {
        store.clear();
    }

}
