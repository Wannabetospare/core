package hello.core.discount;
import hello.core.member.Grade;
import hello.core.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

// 할인정책을 상속받아 만든 할인정책 구현체 클래스
@Component
public class FixDiscountPolicy implements DiscountPolicy {
    private int discountFixAmount = 1000; //1000원 할인

    // 메서드 오버라이드로 discount 메서드를 재정의
    // 이름 - discount
    // 매개변수 - member, price
    // 동작 - 멤버의 등급이 VIP 이면 1000을 반환하고, 아니면 0을 반환한다.
    // 반환값 - 동작 정수 값
    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return discountFixAmount;
        } else {
            return 0;
        }
    }
}
