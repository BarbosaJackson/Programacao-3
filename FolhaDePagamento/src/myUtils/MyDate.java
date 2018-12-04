package myUtils;

import java.util.Scanner;

public class MyDate {
	private Integer day, month, year, week;
	
	public MyDate(Integer day, Integer month, Integer year) {
		this.day = day;
		this.month = month;
		this.year = year;
		this.week = (this.day / 7) + 1;
	}

	public MyDate () {
		this.day = 0;
		this.month = 0;
		this.year = 0;
		this.week = (day % 7);
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

	public void incrementDay() {
		this.day++;
		week = (this.day / 7) + 1;
		if(this.month == 2) {
			if(this.day == 29) {
				this.day = 1;
				this.week = 1;
				this.month++;
			}
		} else {
			if(this.day == 32) {
				if(this.month == 1 || this.month == 3 || this.month == 5 || this.month == 7 || this.month == 8 || this.month == 10 || this.month == 12) {
					this.day = 1;
					this.week = 1;
					this.month = (this.month < 12 ? this.month + 1 : 1);
				}
			} else  if(this.day == 31) {
				if(this.month == 4 || this.month == 6 || this.month == 9 || this.month == 11) {
					this.day = 1;
					this.week = 1;
					this.month++;	
				}
			}
		}
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
	public Integer getWeek() {
		return this.week;
	}

	public String toString() {
		return (getDay() < 10 ? "0" + getDay() : getDay()) + "/" + (getMonth() < 10 ? "0" + getMonth() : getMonth()) + "/" + getYear() + "\nWEEK = " + getWeek();
	}
}