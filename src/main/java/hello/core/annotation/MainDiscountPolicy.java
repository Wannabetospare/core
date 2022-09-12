package hello.core.annotation;

import org.springframework.beans.factory.annotation.Qualifier;
import java.lang.annotation.*;
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER,
        ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Qualifier("mainDiscountPolicy") // 같은 타입의 빈이 2개이상일때 충돌이 발생 -> 이름을 따로 지정해줘서 충돌을 방지한다.
// 어노테이션, 클래스x
public @interface MainDiscountPolicy {
}