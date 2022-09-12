package hello.core.discount;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import org.springframework.stereotype.Component;

// 할인 정책 인터페이스를 상속받은 새로운 할인 정책 구현체 ( 구매한 만큼 10% 할인 )
@Component
@MainDiscountPolicy // 직접 만들어서 사용하는 어노테이션, 이 클래스를 메인할인정책으로 지정하겠다는 의미
public class RateDiscountPolicy implements DiscountPolicy{

    private int discountPercent = 10; // 할인할 %를 int 형으로 선언

    // 메서드 오버라이드로 인터페이스에서 만든 추상메서드를 구현체에서 구현
    // 이름 - discount
    // 매개변수 - member, price
    // 동작 - 만약 멤버의 등급을 확인하고, VIP 이면 가격에서 10%를 할인한 int값을 반환한다.
    // 반환값 - 동작값으로 반환한다.
    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP){
            return price * discountPercent / 100;
        }else {
            return 0;
        }
    }
}
