package hello.core.order;
import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

// 오더 서비스를 상속받아 만든 서비스 구현체
public class OrderServiceImpl implements OrderService {

    // 저장소를 선언,  생성자 구현은 구현체로
    private final MemberRepository memberRepository = new MemoryMemberRepository();
    // 할인정책을 선언 , 생성자 구현은 구현체로
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();


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