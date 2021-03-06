package com.kirkk.mediator;

import java.math.*;
import java.util.*;
import com.kirkk.cust.*;
import com.kirkk.bill.*;

public class PaymentMediator {
	private Customer customer;

	public PaymentMediator(Customer customer) {
		this.customer = customer;
	}

	public BigDecimal pay(Bill bill) {
		BigDecimal discount = new BigDecimal(1).subtract(this.getDiscountAmount()).setScale(2, BigDecimal.ROUND_HALF_UP);
		BigDecimal paidAmount = bill.getChargeAmount().multiply(discount).setScale(2);
		//make the payment...
		return paidAmount;
	}
	
	private BigDecimal getDiscountAmount() {
		if (this.customer.getBills().size() > 5) {
			return new BigDecimal(0.1);
		} else {
			return new BigDecimal(0.03);
		}
	}
}