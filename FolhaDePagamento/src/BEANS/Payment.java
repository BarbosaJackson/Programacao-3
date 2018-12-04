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
		this.typePayment = typePayment;
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

	public static Payment registerPayment(List<Payment> payments) {
		Payment p = new Payment();
		System.out.print("Digite o dia de pagamento: ");
		p.setPaymentDay(new Scanner(System.in).nextInt());
		System.out.print("Digite o tipo de pagamento: ");
		p.setTypePayment(new Scanner(System.in).nextLine(), payments);
		return p;
	}

	public String toString() {
		return typePayment + "\n Dia de pagamento: " + getPaymentDay();
	}
}