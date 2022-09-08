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
    // 이름 - save
    // 매개변수 - Member
    // 동작 - store 애 멤버 식별자와 멤버를 키와 밸류로 넣어준다.
    // 반환값 - x
    @Override
    public void save(Member member) {
        store.put(member.getId(), member);

    }

    // 메서드 오버라이드로 findById 재정의
    // 이름 - findById
    // 매개변수 - memberId
    // 동작 - store 에서 매개변수 memberId 를 이용해서 멤버를 가져온다.
    // 반환값 - 동자으로 받은 멤버를 반환한다.
    @Override
    public Member findById(Long memberId) {

        return store.get(memberId);
    }



}
