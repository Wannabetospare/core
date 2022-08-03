package hello.core;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.order.Order;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {

    public static void main(String[] args) {

//          AppConfig appConfig = new AppConfig();
//          MemberService memberService = appConfig.memberService();
//          OrderService orderService = appConfig.orderService();

        // 스프링 컨테이너를 사용해서 객체를 선언
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        // 스프링 컨테이너에서 객체를 사용하여 꺼내서 사용함
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

//        // 멤버 서비스를 선언하고, 구현체로 멤버 서비스구현체 생성
//        MemberService memberService = new MemberServiceImpl(null);
//        // 오더 서비스를 선언하고, 구현체로 오더 서비스구현체 생성
//        OrderService orderService = new OrderServiceImpl(null,null);

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

