package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;

public class TaxDiscountPolicy implements DiscountPolicy{

    private int sendTax = 2500;

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.BASIC) {
            return price + sendTax;
        } else {
            return price;
        }
    }
}
