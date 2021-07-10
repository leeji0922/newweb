package hello.core.beanfind;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class ApplicationContextInfoTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class); //스프링 컨테이너 생성

    @Test
    @DisplayName("모든 빈 출력하기")
    void findAllBean(){
        String[] BeanDefinitionNames = ac.getBeanDefinitionNames(); // 스프링에 등록된 모든 빈 이름을 조회
        for (String BeanDefinitionName : BeanDefinitionNames) {
            Object bean = ac.getBean(BeanDefinitionName); //BeanDefinitionName에 등록된 빈(ac 컨테이너 안의 빈)으로 객체를 조회한다
            System.out.println("name = " + BeanDefinitionName + " object = " + bean);
        }
    }
    @Test
    @DisplayName("애플리케이션 빈 출력하기")
    void findApplicationBean(){
        String[] BeanDefinitionNames = ac.getBeanDefinitionNames();
        for (String BeanDefinitionName : BeanDefinitionNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(BeanDefinitionName);

            //Role ROLE.APPLICATION : 직접 등록한 애플리케이션 빈
            //Role ROLE.INFRASTRUCTURE : 스프링이 내부에서 사용하는 빈
            if(beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION){
                Object bean = ac.getBean(BeanDefinitionName);
                System.out.println("name = " + BeanDefinitionName + " object = " + bean);
            }
        }
    }
}
