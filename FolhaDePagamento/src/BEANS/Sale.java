package BEANS;

import java.util.Scanner;
import myUtils.MyDate;

public class Sale {
	private Double valueSale;
	private MyDate date;
	
	public Sale(Double valueSale, MyDate date) {
		this.valueSale = valueSale;
		this.date = date;
	}

	public Sale() {
		this.valueSale = 0.0;
		this.date = null;
	}

	public Sale(MyDate date) {
		this.date = date;
		this.valueSale = 0.0;
	}

	public void setDate(MyDate date) {
		this.date = date;
	}
	public void setValueSale(Double valueSale) {
		while(valueSale < 0) {
			System.out.println("Valor digitado para a venda é negativo!");
			System.out.print("Digite um valor válido: ");
			valueSale = new Scanner(System.in).nextDouble();
		}
		this.valueSale = valueSale;
	}

	public Double getValueSale() {
		return this.valueSale;
	}
	public MyDate getDate() {
		return this.date;
	}

	public String toString() {
		return "Valor da venda: " + getValueSale() + "\nData: " + this.date + "\n";
	}

	public static Sale registerSale(MyDate date) {
		Sale sale = new Sale(date);
		System.out.print("Digite o valor da venda: ");
		sale.setValueSale(new Scanner(System.in).nextDouble());
		return sale;
	}
}