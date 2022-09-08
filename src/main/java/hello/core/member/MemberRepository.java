package hello.core.member;

// 인터페이스로 리퍼지토리 생성 = 구현체를 위해 역할을 정해줄뿐 구현체가 아님
public interface MemberRepository {

    void save(Member member); //  추상메서드 반환타입 void, {} 구현부 없음

    Member findById(Long memberId); // 추상메서드 반환타입 Member 클래스, {} 구현부 없음

}
