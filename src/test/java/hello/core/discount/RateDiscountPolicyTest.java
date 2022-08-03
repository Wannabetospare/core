package hello.core.discount;

import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;


class RateDiscountPolicyTest {

    // 인터페이스를 상속받지 않고, 구현체로만 객체를 생성
    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test // 테스트 메서드
    @DisplayName("VIP는 10% 할인이 적용되어야 한다.") // 실행창에 메서드 이름 대신 이 어노테이션을 지정한 글자가 대신 띄워짐
    void vip_o() { // 등급이 vip 일때 할인금액이 1000이 맞게 나오는지 확인하는 메서드
        //given
        Member member = new Member(1L, "memberVIP", Grade.VIP);
        //when
        int discount = discountPolicy.discount(member, 10000);
        //then
        assertThat(discount).isEqualTo(1000);
    }
    @Test // 테스트 메서드
    @DisplayName("VIP가 아니면 할인이 적용되지 않아야 한다.")
    void vip_x() { // 등급이 vip 가 아닐때 할인 적용이 되지않아야 되는지 확인하는 메서드
        //given 조건 받기
        Member member = new Member(2L, "memberBASIC", Grade.BASIC);
        //when 어디서 작동하는지
        int discount = discountPolicy.discount(member, 10000);
        //then
        assertThat(discount).isEqualTo(0);
    }
}