/**
 * Author: yao jiqian
 * 
 * Description: this service is for payment.
 * 
 * 
 */

package com.bitcode.personalcourses.services;

public interface PaymentService {
	
	/**
	 * pay method, add the payment to payment_records table,
	 * and update the balance of the institution
	 * @param ins_id
	 * @param amount
	 * @param realAmount
	 */
	void pay(Long ins_id, double amount, double realAmount);
}
