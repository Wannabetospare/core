package hello.core.beanfind;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

    class ApplicationContextInfoTest {

    // 스프링 컨테이너 생성, AppConfig 클래스를 컨테이너로 설정 정보로 받음
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);


    @Test
    @DisplayName("모든 빈 출력") // 모든 빈을 출력해야 하기 때문에 형태는 자바의 모든 상위타입인 Object 로 한다.
    void findAllBean(){
        // 스프링 컨테이너에 등록된 빈정보들을 이름으로 가져와서 문자 리스트형으로 선언한다.
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();

        // 선언된 문자 리스트형 스프링 빈들을 반복문으로 받아서 하나씩 이름과 참조 값을 출력한다.
        for (String beanDefinitionName : beanDefinitionNames) {
            Object bean = ac.getBean(beanDefinitionName);
            System.out.println("name = " + beanDefinitionName + "object = " + bean);

        }

    }

    @Test
    @DisplayName("애플리케이션 빈 출력하기") void findApplicationBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);

            //Role ROLE_APPLICATION: 직접 등록한 애플리케이션 빈
            //Role ROLE_INFRASTRUCTURE: 스프링이 내부에서 사용하는 빈
            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                Object bean = ac.getBean(beanDefinitionName);
                System.out.println("name=" + beanDefinitionName + " object=" + bean);
            }

        }

    }






}
