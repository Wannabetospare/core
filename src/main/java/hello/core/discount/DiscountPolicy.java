package hello.core.discount;
import hello.core.member.Member;


// 인터페이스로 할인정책 생성 = 구현체를 위해 역할을 정해줄뿐 구현체가 아님

public interface DiscountPolicy {
    /**
     * @return 할인 대상 금액
     */
    //
    int discount(Member member, int price); // 추상메서드 반환타입 int, {} 구현부 없음
}