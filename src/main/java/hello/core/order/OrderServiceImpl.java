package hello.core.order;
import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

// 오더 서비스를 상속받아 만든 서비스 구현체
public class OrderServiceImpl implements OrderService {


    // 저장소를 선언, new 를 사용한 구현체에 의존하지 않고, 인터페이스만 사용하여 인터페이스에만 의존
    private final MemberRepository memberRepository;

    // 할인 정책을 선언, new 를 사용한 구현체에 의존하지 않고, 인터페이스에만 의존 (추상화만 사용)
    private final DiscountPolicy discountPolicy;

    // 구현체에 위에서 선언한 인터페이스 필드를 사용하여 생성자(객체) 선언
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    // 할인정책을 선언 , 생성자 구현은 구현체로 // 이건 추상화 클래스뿐만 아니라 구현체까지 사용해서 의존하였으므로 DIP 를 위반한 설계이다.
    // private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    //private final DiscountPolicy discountPolicy = new RateDiscountPolicy();

    // 메서드 오버라이드로 creatOrder 재정의
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