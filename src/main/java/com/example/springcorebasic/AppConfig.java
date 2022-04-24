package com.example.springcorebasic;

import com.example.springcorebasic.discount.DiscountPolicy;
import com.example.springcorebasic.discount.RateDiscountPolicy;
import com.example.springcorebasic.member.MemberService;
import com.example.springcorebasic.member.MemberServiceImpl;
import com.example.springcorebasic.member.MemoryMemberRepository;
import com.example.springcorebasic.order.OrderService;
import com.example.springcorebasic.order.OrderServiceImpl;

public class AppConfig {

	public MemberService memberService() {
		return new MemberServiceImpl(memberRepository());
	}

	public OrderService orderService() {
		return new OrderServiceImpl(
			memberRepository(),
			discountPolicy()
		);
	}

	public MemoryMemberRepository memberRepository() {
		return new MemoryMemberRepository();
	}

	public DiscountPolicy discountPolicy() {
		return new RateDiscountPolicy();
	}
}
