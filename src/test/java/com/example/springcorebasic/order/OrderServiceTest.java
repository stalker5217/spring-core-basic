package com.example.springcorebasic.order;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.example.springcorebasic.member.Grade;
import com.example.springcorebasic.member.Member;
import com.example.springcorebasic.member.MemberService;
import com.example.springcorebasic.member.MemberServiceImpl;

class OrderServiceTest {
	MemberService memberService = new MemberServiceImpl();
	OrderService orderService = new OrderServiceImpl();

	@Test
	void createOrder() {
		Long memberId = 1L;
		Member member = new Member(memberId, "memberA", Grade.VIP);
		memberService.join(member);

		Order order = orderService.createOrder(memberId, "itemA", 10000);

		assertThat(order.getDiscountPrice()).isEqualTo(1000);
	}
}