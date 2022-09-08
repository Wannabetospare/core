package hello.core.member;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
// 서비스를 상속받아 만든 서비스 구현체
public class MemberServiceImpl implements  MemberService{

    // 저장소가 필요하니 저장소를 선언한다.
    private final MemberRepository memberRepository;

    @Autowired
    // 생성자를 통해서 주입
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    // 메서드 오버라이드로 join 재정의
    // 이름 - join
    // 매개변수 - member
    // 동작 - 매개변수로 받은 멤버를 리퍼지토리에 저장한다.
    // 반환값 - x
    @Override
    public void join(Member member) {
        memberRepository.save(member);

    }

    // 메서드 오버라이드로 findMember 재정의
    // 이름 - findMember
    // 매개변수 - memberId
    // 동작 - 매개변수를 이용해서 리퍼지토리에서 멤버를 찾고
    // 반환값 - 동작값으로 찾은 멤버를 반환한다.
    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }



}
