package hello.core.member;


// 서비스를 상속받아 만든 서비스 구현체
public class MemberServiceImpl implements  MemberService{

    // 저장소가 필요하니 저장소를 선언한다.
    private final MemberRepository memberRepository;

    // 생성자를 통해서 주입
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    // 메서드 오버라이드로 join 재정의
    @Override
    public void join(Member member) {
        memberRepository.savs(member);

    }

    // 메서드 오버라이드로 findMember 재정의
    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }



}
