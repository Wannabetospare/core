package hello.core;


import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // 빈 설정을 담당하는 클래스라고 선언
// 어플리케이션에 대한 전반적인 구현 객체를 생성하고(메서드내용), 연결하는 책임(생성자를 통해 주입)(메서드내용과 반환타입 연결)을 갖는 공연 기획자의 역할을 하는 클래스
public class AppConfig {

    // 멤버 서비스를 반환타입으로 지정하고, new 멤버 서비스 구현체를 생성하고 멤버 리포지토리(구현체)를 매개로 받아 반환하는 메서드
    @Bean // 스프링 컨테이너에 등록하는 어노테이션
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }


    @Bean
    public MemberRepository memberRepository() {

        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService(){

        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy(){

        return new RateDiscountPolicy();
        // return new FixDiscountPolicy();
    }







}
