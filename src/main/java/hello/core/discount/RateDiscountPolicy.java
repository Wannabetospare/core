package hello.core.discount;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import org.springframework.stereotype.Component;

// 할인 정책 인터페이스를 상속받은 새로운 할인 정책 구현체 ( 구매한 만큼 10% 할인 )
@Component
@MainDiscountPolicy
public class RateDiscountPolicy implements DiscountPolicy{

    private int discountPercent = 10; // 할인할 %를 int 형으로 선언

    // 메서드 오버라이드로 인터페이스에서 만든 추상메서드를 구현체에서 구현, 구매비의 10% 할인 해주는 메서드
    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP){
            return price * discountPercent / 100;
        }else {
            return 0;
        }
    }
}
