package com.example.springcorebasic.order;

import com.example.springcorebasic.discount.DiscountPolicy;
import com.example.springcorebasic.discount.FixDiscountPolicy;
import com.example.springcorebasic.member.Member;
import com.example.springcorebasic.member.MemberRepository;
import com.example.springcorebasic.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

	private final MemberRepository memberRepository = new MemoryMemberRepository();
	private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

	@Override
	public Order createOrder(Long memberId, String itemName, int itemPrice) {
		Member member = memberRepository.findById(memberId);
		int discountPrice = discountPolicy.discount(member, itemPrice);

		return new Order(
			memberId,
			itemName,
			itemPrice,
			discountPrice
		);
	}
}
