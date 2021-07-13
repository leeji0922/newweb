package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepositiort;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/***
 * 관심사의 분리 예제 ex) 배우는 연기만 기획자는 섭외만
 * AppConfig 는 공현 기획자이다. 그리고 구체 클래스를 선택 후 배역에 맞는 담당 배우를 선택 하고 애플리케이션이 어떤 방식으로 동작할지 전체 구성을 책임
 * 클라이언트인 memberServiceImpl,orderServiceImpl 입장에서는 외부에서 주입해준거 같다고 한다 = DI 의존성 주입
 *
 * 역할과 구현클래스가 한눈에 들어와 구성이 어떻게 되는지 빠르게 파악 가능 그리고 수정도 용이함
 */

//생성한 객체 인스턴스의 참조(레퍼런스)를 "생성자를 통해서 주입" 해준다

@Configuration //설정 정보
public class AppConfig { // 생성자 주입


    //@Bean memberService -> new MemoryMemberRepositiory() 호출
    //@Bean orderService -> new MemoryMemberRepositiory(), new RateDiscountPolicy() 호출


    //호출 되는 로직순서(추정)
    //1.call AppConfig.memberService
    //2.call AppConfig.memberRepository
    //3.call AppConfig.memberRepository
    //4.call AppConfig.orderService
    //5.call AppConfig.memberRepository


    //호출되는 로직순서(결과)
    //1.call AppConfig.memberService
    //2.call AppConfig.memberRepository
    //3.call AppConfig.orderService

    @Bean //메서드가 스프링 컨테이너에 등록 된다.
    public MemberService memberService() {
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository()); // MemberServiceImpl을 선언하면서 MemoryMemberRespositiory를 사용할 것이다.
    }

    @Bean
    public OrderService orderService(){
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public MemberRepository memberRepository() { //리턴타입은 구체클래스가 아닌 인터페이스를 선택
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepositiort();
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
//      return new FixDiscountPolicy();
    }

}
