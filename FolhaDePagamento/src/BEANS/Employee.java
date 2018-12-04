package BEANS;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Employee {
	private String name;
	private Integer codeEmployee, workedDays;
	private Payment typeEmployee;
	private Double baseSalary, currentSalary;
	private Boolean syndicate;
	private Address address;
	private List<PointCard> pointCard;
	private List<Sale> sales;

	public Employee(Integer codeEmployee) {
		this.name = "";

		this.codeEmployee = codeEmployee;
		this.workedDays = 0;
		
		this.baseSalary = 0.0;
		this.currentSalary = 0.0;
		
		this.isSyndicate = false;

		this.address = null;
		this.typeEmployee = null;

		this.pointCard = null;
		this.sales = null;
	}

	// -------------------------------------------- sets ----------------------------------------------------------------

	public void setName(String name) {
		this.name = name;
	}

	public void setTypeEmployee(String typeEmployee, List<String> typesEmployees) {
		int i = 1;
		while(true) {
			for(String s : typesEmployees) {
				if(s.equals(typeEmployee)) {
					this.typeEmployee = i;
					if(i == 1) {
						setPaymentDay(5);
					} else if(i == 2) {

					}
					return;
				}
				i++;
			}
			System.out.println("Tipo de empregado inválido!");
			System.out.println("Digite o tipo de empregado que você pertence: ");
			for(String s : typesEmployees) {
				System.out.println("[ " + s + " ]");
			}
			System.out.print("=> ");
			Scanner sc = new Scanner(System.in);
			typeEmployee = sc.nextLine();
		}
	}
	
	public void incrementWorkedDays() {
		this.workedDays++;
	}

	public void setPaymentDay(Integer paymentDay)  {
		this.paymentDay = paymentDay;
	}

	public void setBaseSalary(Double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	// -------------------------------------------- gets ----------------------------------------------------------------
	public String getName() {
		return this.name;
	}

	public Payment getTypeEmployee() {
		return typeEmployee;
	}
	
	public Integer getCodeEmployee() {
		return this.codeEmployee;
	}
	
	public Integer getWorkedDays() {
		return this.workedDays;		
	}
	
	public Double getBaseSalary() {
		return this.baseSalary;
	}
	
	public Double getCurrentSalary() {
		return this.currentSalary;
	}
	
	public Address getAddress() {
		return this.getAddress;
	}
	
	public List<Sale> getSales() {
		return this.sales;
	}
	
	public List<PointCard> getPointCard() {
		return this.pointCard;
	}
	
	public Boolean isSyndicate(){
		return this.syndicate;
	}
	
	public Integer getQtdWorkedDays() {
		return this.workedDays;
	}
	
}