package hello.core.order;

// 인터페이스로 주문서비스 생성 = 구현체를 위해 역할을 정해줄뿐 구현체가 아님
public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice);
    // 추상메서드 반환타입 Order 클래스, {} 구현부 없음
}