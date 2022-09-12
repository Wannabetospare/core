package hello.core.autowired;

import hello.core.AutoAppConfig;
import hello.core.discount.DiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.util.List;
import java.util.Map;
import static org.assertj.core.api.Assertions.assertThat;

// 여러개의 비을 전부 찾아서 사용해야 할 때
public class AllBeanTest {

    @Test
    void findAllBean() {
        // 스프링 컨테이너 생성, AutoAppConfig 와 DiscountService 2가지를 스프링 컨테이너로 선언
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class, DiscountService.class);
        // 스프링 컨테이너에 등록된 DiscountService 빈을 꺼내서 선언
        DiscountService discountService = ac.getBean(DiscountService.class);
        // 멤버를 하나 생성
        Member member = new Member(1L, "userA", Grade.VIP);
        // 위에서 생성한 discountService 로 할인메서드를 가져와서 매개변수를 넣는데 마지막에 이름을 넣어서 이름으로 정책을 찾을 수 있게 한다.
        int discountPrice = discountService.discount(member, 10000, "fixDiscountPolicy");
        // 같은 인스턴스인지 확인
        assertThat(discountService).isInstanceOf(DiscountService.class);
        // 같은 할인가격인지 확인
        assertThat(discountPrice).isEqualTo(1000);
    }
    static class DiscountService {

        // 키와 밸류를 받아 여러개의 할인정책을 받음
        private final Map<String, DiscountPolicy> policyMap;
        // 리스트형으로 할인정책들을 받음
        private final List<DiscountPolicy> policies;
        // 생성자
        public DiscountService(Map<String, DiscountPolicy> policyMap, List<DiscountPolicy> policies) {
            this.policyMap = policyMap;
            this.policies = policies;
            System.out.println("policyMap = " + policyMap);
            System.out.println("policies = " + policies);
        }
        // 이름 - discount
        // 매개변수 - member, price, discountCode
        // 동작 - 맵으로 선언된 할인정책에 매개변수로 받은 discountCode 를 받아서 가져온다.
        // 반환값 - 선언된 정책에서 받은 매개변수로 할인값을 반환한다.

        public int discount(Member member, int price, String discountCode) {
            DiscountPolicy discountPolicy = policyMap.get(discountCode);
            System.out.println("discountCode = " + discountCode);
            System.out.println("discountPolicy = " + discountPolicy);
            return discountPolicy.discount(member, price);
        }
    }
}