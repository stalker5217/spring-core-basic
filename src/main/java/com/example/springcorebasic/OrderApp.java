package com.example.springcorebasic;

import com.example.springcorebasic.member.Grade;
import com.example.springcorebasic.member.Member;
import com.example.springcorebasic.member.MemberService;
import com.example.springcorebasic.member.MemberServiceImpl;
import com.example.springcorebasic.order.Order;
import com.example.springcorebasic.order.OrderService;
import com.example.springcorebasic.order.OrderServiceImpl;

public class OrderApp {
	public static void main(String[] args) {
		MemberService memberService = new MemberServiceImpl();
		OrderService orderService = new OrderServiceImpl();

		Long memberId = 1L;
		Member member = new Member(memberId, "memberA", Grade.VIP);
		memberService.join(member);

		Order order = orderService.createOrder(memberId, "itemA", 10000);

		System.out.println("order = " + order);
	}
}
