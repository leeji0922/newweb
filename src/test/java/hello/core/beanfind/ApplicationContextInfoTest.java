package hello.core.beanfind;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class ApplicationContextInfoTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력하기")
    void findAllBean(){
        String[] BeanDefinitionNames = ac.getBeanDefinitionNames();
        for (String BeanDefinitionName : BeanDefinitionNames) {
            Object bean = ac.getBean(BeanDefinitionName);
            System.out.println("name = " + BeanDefinitionName + " object = " + bean);
        }
    }
    @Test
    @DisplayName("애플리케이션 빈 출력하기")
    void findApplicationBean(){
        String[] BeanDefinitionNames = ac.getBeanDefinitionNames();
        for (String BeanDefinitionName : BeanDefinitionNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(BeanDefinitionName);

            if(beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION){
                Object bean = ac.getBean(BeanDefinitionName);
                System.out.println("name = " + BeanDefinitionName + " object = " + bean);
            }
        }
    }
}
