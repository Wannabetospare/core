package hello.core.order;
import hello.core.annotation.MainDiscountPolicy;
import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


@Component
// 오더 서비스를 상속받아 만든 서비스 구현체
public class OrderServiceImpl implements OrderService {


    // 저장소를 선언, new 를 사용한 구현체에 의존하지 않고, 인터페이스만 사용하여 인터페이스에만 의존
    private final MemberRepository memberRepository;

    // 할인 정책을 선언, new 를 사용한 구현체에 의존하지 않고, 인터페이스에만 의존 (추상화만 사용)
    private final DiscountPolicy discountPolicy;

    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, @Qualifier("mainDiscountPolicy") DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }




    // 할인정책을 선언 , 생성자 구현은 구현체로 // 이건 추상화 클래스뿐만 아니라 구현체까지 사용해서 의존하였으므로 DIP 를 위반한 설계이다.
    // private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    //private final DiscountPolicy discountPolicy = new RateDiscountPolicy();

    // 메서드 오버라이드로 creatOrder 재정의
    // 이름 - createOrder
    // 매개변수 - memberId, itemName, itemPrice
    // 동작 - 멤버 리퍼지토리에서 매개변수로 찾은 멤버아이디로 멤버를 생성하고, 할인정책이 얼마인지 할인정책메서드로 저장한다.
    // 반환값 - 동작 값으로 주문을 생성한후 반환한다.
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {

        // 멤버 클래스로 저장소에서 매개변수로 찾은 아이디를 찾아서 멤버에 저장
        Member member = memberRepository.findById(memberId);
        // 할인정책에서 위에서 선언된 멤버와 매개변수로 찾은 아이템가격을 받아와서 값을 저장한다.
        int discountPrice = discountPolicy.discount(member, itemPrice);

        // 결과값으로 클래스 생성자 타입으로 반환
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }


}