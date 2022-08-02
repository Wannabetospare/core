package hello.core.member;


// 서비스를 상속받아 만든 서비스 구현체
public class MemberServiceImpl implements  MemberService{

    // 저장소가 필요하니 저장소를 선언하한다. 선언은 구현받는 인터페이스로하되, 생성부는 new 구현체 클래스로 선언한다.
    private final MemberRepository memberRepository;

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
