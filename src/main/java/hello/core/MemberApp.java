package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;

public class MemberApp {

    public static void main(String[] args) {

        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        //MemberService memberService = new MemberServiceImpl(); 서비스로 선언, 서비스 구현체 생성, join 메서드를 사용하기 위해서
        Member member = new Member(1L, "memberA", Grade.VIP); // 멤버 클래스 생성자 선언
        memberService.join(member); // 위에서 선언한 멤버 클래스 생성자 등록

        Member findmember = memberService.findMember(1L); //  멤버 클래스로 선언, 서비스에서 findMember 메서드 사용

        System.out.println("new member = " + member.getName()); // 위에서 생성한 멤버 클래스의 이름을 가져온다.
        System.out.println("findMember = " + findmember.getName()); // 위에서 선언한 클래스의 이름을 가져온다.



    }
}
