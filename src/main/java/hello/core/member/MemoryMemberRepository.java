package hello.core.member;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import javax.print.DocFlavor;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

@Component
// 리퍼지토리 인터페이스를 상속받아 만든 저장소구현체
public class MemoryMemberRepository implements MemberRepository{


    // 상수(private,static)로 저장소 생성자 구현
    private static Map<Long, Member> store = new HashMap<>();

    // 메서드 오버라이드로 save 재정의
    @Override
    public void savs(Member member) {
        store.put(member.getId(), member);

    }

    // 메서드 오버라이드로 findById 재정의,
    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }



}
