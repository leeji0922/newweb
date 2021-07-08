package hello.core.member;

import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class MemberServiceTest {

    MemberService memberService;

    @BeforeEach
    public void beforEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }
//    MemberService memberService = new MemberServiceImpl();

    @Test
    void join() {
        //given 환경이 주어졌을때
        Member member = new Member(1L,"memberA",Grade.VIP);


        //when  언제
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        //then  이렇게 된다
        Assertions.assertThat(member).isEqualTo(findMember);
    }
}
