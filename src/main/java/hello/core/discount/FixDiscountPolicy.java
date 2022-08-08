package hello.core.discount;
import hello.core.member.Grade;
import hello.core.member.Member;
import org.springframework.stereotype.Component;

// 할인정책을 상속받아 만든 할인정책 구현체 클래스
@Component
public class FixDiscountPolicy implements DiscountPolicy {
    private int discountFixAmount = 1000; //1000원 할인

    // 메서드 오버라이드로 discount 메서드를 재정의
    // 멤버 클래스와 가격을 매개변수로 받음, 등급을 확인하고 VIP 이면 위에서 선언한 1000원을 깍아줌
    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return discountFixAmount;
        } else {
            return 0;
        } }
}
