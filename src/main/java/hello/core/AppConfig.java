package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.discount.TaxDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepositiort;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

/***
 * 관심사의 분리 예제 ex) 배우는 연기만 기획자는 섭외만
 * AppConfig 는 공현 기획자이다. 그리고 구체 클래스를 선택 후 배역에 맞는 담당 배우를 선택 하고 애플리케이션이 어떤 방식으로 동작할지 전체 구성을 책임
 * 클라이언트인 memberServiceImpl,orderServiceImpl 입장에서는 외부에서 주입해준거 같다고 한다 = DI 의존성 주입
 *
 * 역할과 구현클래스가 한눈에 들어와 구성이 어떻게 되는지 빠르게 파악 가능 그리고 수정도 용이함
 */

//생성한 객체 인스턴스의 참조(레퍼런스)를 "생성자를 통해서 주입" 해준다
public class AppConfig { // 생성자 주입

    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository()); // MemberServiceImpl을 선언하면서 MemoryMemberRespositiory를 사용할 것이다.
    }

    private MemberRepository memberRepository() { //리턴타입은 구체클래스가 아닌 인터페이스를 선택
        return new MemoryMemberRepositiort();
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
//      return new FixDiscountPolicy();
    }

}