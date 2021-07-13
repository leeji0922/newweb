package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import static org.springframework.context.annotation.ComponentScan.*;

@Configuration // 설정 정보 스프링 컨테이너에 넣기
@ComponentScan(
        excludeFilters = @Filter(type = FilterType.ANNOTATION, classes = Configuration.class) // 다른 AppConfig, TestConfig가 들어가는걸 방지 필터를 설정
) // Bean 자동 주입
public class AutoAppConfig {

}
