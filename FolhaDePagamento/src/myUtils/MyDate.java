package myUtils;

import java.util.Scanner;

public class MyDate {
	private Integer day, month, year;
	
	public MyDate(Integer day, Integer month, Integer year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}

	public MyDate () {
		this.day = 0;
		this.month = 0;
		this.year = 0;
	}

	public void setDay(Integer day) {
		while(day > 31 || day < 1) {
			System.out.println("Dia inválido!");
			Scanner sc = new Scanner(System.in);
			System.out.print("Digite um novo valor para o dia: ");
			day = sc.nextInt();
		}
		this.day = day;
	}
	public void setMonth(Integer month) {
		while(month < 1 || month > 12) {
			System.out.println("Mês inválido!");
			Scanner sc = new Scanner(System.in);
			System.out.print("Digite um novo valor para o mês: ");
			month = sc.nextInt();
		}
		this.month = month;
	}
	public void setYear(Integer year) { 
		while(year < 0) {
			System.out.println("Ano inválido!");
			Scanner sc = new Scanner(System.in);
			System.out.print("Digite o novo valor para o ano: ");
			year = sc.nextInt();
		}
		this.year = year;
	}

	public Integer getDay(){
		return this.day;
	}
	public Integer getMonth() {
		return this.month;
	}
	public Integer getYear() {
		return this.year;
	}

	public String toString() {
		return (getDay() < 10 ? "0" + getDay() : getDay()) + "/" + (getMonth() < 10 ? "0" + getMonth() : getMonth()) + "/" + getYear();
	}
}