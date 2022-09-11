package hello.core;


import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import static org.springframework.context.annotation.ComponentScan.*;

// 설정정보 라고 스프링에게 알려주는 어노테이션
@Configuration
// 컴포넌트 스캔 - 컴포넌트 스캔의 범위, 어떻게 컴포넌트를 할건지 설정하는 어노테이션
@ComponentScan(
        excludeFilters = @Filter(type = FilterType.ANNOTATION,classes = Configuration.class))



public class AutoAppConfig {

    // memoryMemberRepository 이름으로 등록된 빈이 이미 존재하기 때문에 충돌이 나서 CoreApplication 을 실행하면 런타임가 오류난다.
    /*@Bean(name = "memoryMemberRepository")
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }*/

}
