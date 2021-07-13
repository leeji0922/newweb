package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepositiort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService{

    /***
     * OrderServiceImpl 입장에서는 어떤 구현객체가 들어올지 알 수 없다.
     * OrderServiceImpl의 생성자를 통해 어떤 구현객체를 주입할지는 외부(AppConfig)를 통해 결정 된다
     * OrderServiceImpl은 이제부터 실행에만 집중 하면 된다
     */

    //  new로 구현체를 선언 안하여 DIP원칙을 준수
    private final MemberRepository memberRepository;  // 유저 정보 담긴 메모리
    private final DiscountPolicy discountPolicy;

    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member,itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
