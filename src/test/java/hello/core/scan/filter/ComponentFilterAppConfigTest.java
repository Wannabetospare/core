package hello.core.scan.filter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.context.annotation.ComponentScan.Filter;


public class ComponentFilterAppConfigTest {

        @Test
        void filterScan() {
            ApplicationContext ac = new AnnotationConfigApplicationContext(ComponentFilterAppConfig.class);
            BeanA beanA = ac.getBean("beanA", BeanA.class);
            assertThat(beanA).isNotNull();
            Assertions.assertThrows(
                    NoSuchBeanDefinitionException.class, () -> ac.getBean("beanB", BeanB.class));
        }
        @Configuration
        @ComponentScan(
                // 포함 시키는 컴포넌트는 잘 사용하지 않는다. -> 컴포넌트스캔이 있어서 굳이 포함을 따로 표기할 이유가 없음
                includeFilters = @Filter(type = FilterType.ANNOTATION, classes = MyIncludeComponent.class),
                // 미포함 시키는 컴포넌트는 가끔 사용한다.
                excludeFilters = @Filter(type = FilterType.ANNOTATION, classes = MyExcludeComponent.class)
        )

        static class ComponentFilterAppConfig {
        }

}
