package hello.core.member;

// 멤버 클래스 구헌체
public class Member {

    private Long id; // 정수형으로 id 값 선언
    private String name; // String 형으로 name 값 선언
    private Grade grade; // 내가 선언한 열거 클래스타입으로 grade 값 선언



    // 멤버 클래스의 생성자
    public Member(Long id, String name, Grade grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }


    // 게터, 세터 부분
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }






}
