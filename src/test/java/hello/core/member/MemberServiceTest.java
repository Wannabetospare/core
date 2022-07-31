package hello.core.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;


// 테스트 파일에 서비스테스트 클래스
public class MemberServiceTest {

    // 똑같이 서비스 선언, new 구현체 선언
    MemberService memberService = new MemberServiceImpl();

    @Test //  테스트임을 명시
    void join(){
        //given 가져오는 값
        // 멤버 클래스로 멤버 생성자 생성
        Member member = new Member(1L, "memberA", Grade.VIP);

        // when 어디서,어떻게 실행할지
        // 서비스 구현체로 선언한 클래스의 join 메서드로 위에서 선언한 멤버 생성자 가입, findMember 로 findMember 함수를 이용해 참조값 찾기
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        //then 그러므로 확인 값
        // 참조값이 같은지 확인하는 메서드
        Assertions.assertThat(member).isEqualTo(findMember);

    }
}
