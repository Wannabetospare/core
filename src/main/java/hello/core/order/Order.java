package hello.core.order;

// 주문 구현체 클래스
public class Order {
    private Long memberId;
    private String itemName;
    private int itemPrice;
    private int discountPrice;

    // 오더 클래스의 생성자
    public Order(Long memberId, String itemName, int itemPrice, int
            discountPrice) {
        this.memberId = memberId;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.discountPrice = discountPrice;
    }

    // 아이템 가격에서 할인을 해주는 메서드 구현
    public int calculatePrice() {

        return itemPrice - discountPrice;
    }

    // 게터들 모음
    public Long getMemberId() {

        return memberId;
    }

    public String getItemName() {
        return itemName;
    }

    public int getItemPrice() {
        return itemPrice;
    }

    public int getDiscountPrice() {

        return discountPrice;
    }

    @Override
    public String toString() {
        return "Order{" + "memberId=" + memberId +
                ", itemName='" + itemName + '\'' +
                ", itemPrice=" + itemPrice +
                ", discountPrice=" + discountPrice +
                '}';
    }
}