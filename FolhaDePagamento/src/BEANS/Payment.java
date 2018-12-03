package BEANS;

import java.util.List;
import java.util.Scanner;

public class Payment {
	private String typePayment;
	private Integer paymentDay;

	public Payment() {
		this.typePayment = "";
		this.paymentDay = 0;
	}

	public Payment(String typePayment, Integer paymentDay) {
		this.typePayment = typePayment;
		this.paymentDay = paymentDay;
	}

	public void setTypePayment(String typePayment, List<Payment> payments) {
		for(Payment p : payments) {
			if(p.getTypePayment().equals(typePayment)) {
				System.out.println("este tipo de pamento já está cadastrado!");
				return;
			}
		}
		this.typePayment = payments;
	}

	public void setPaymentDay(Integer paymentDay) {
		while(paymentDay > 31 || paymentDay < 1) {
			System.out.println("Dia inválido, registre um dia válido!!");
			System.out.print("Digite o novo dia: ");
			paymentDay = new Scanner(System.in).nextInt();
		}
		this.paymentDay = paymentDay;
	}

	public String getTypePayment() {
		return this.typePayment;
	}
	public Integer getPaymentDay() {
		return this.paymentDay;
	}

	public String toString() {
		return typePayment + "\n Dia de pagamento: " + getPaymentDay();
	}
}