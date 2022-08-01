package hello.core;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.order.Order;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
public class OrderApp {

    public static void main(String[] args) {

        // 멤버 서비스를 선언하고, 구현체로 멤버 서비스구현체 생성
        MemberService memberService = new MemberServiceImpl();
        // 오더 서비스를 선언하고, 구현체로 오더 서비스구현체 생성
        OrderService orderService = new OrderServiceImpl();

        Long memberId = 1L;
        // 멤버 클래스의 생성자를 생성
        Member member = new Member(memberId, "memberA", Grade.VIP);
        // 서비스의 메서드를 사용해 가입시킴
        memberService.join(member);

        // 오더 클래스로 선언하여 오더서비스 구현체의 메서드를 사용하여 주문정보를 저장
        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);
    }


    }

