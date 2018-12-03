package BEANS;

public class Address {

	private String street, district;
	private Integer numberHouse;

	public Address () {
		this.street = "";
		this.district = "";
		this.numberHouse = 0;
	}

	public Address (String street, String district, Integer numberHouse) {
		this.street = street;
		this.district = district;
		this.numberHouse = numberHouse;
	}

	public void setStreet(String street) {
		this.street = street;
	}
	public void setDistrict (String district) {
		this.district = district;
	}
	public void setNumberHouse(Integer numberHouse) {
		this.numberHouse = numberHouse;
	}

	public String getStreet() {
		return this.street;
	}
	public String getDistrict() {
		return this.district;
	}
	public Integer getNumberHouse() {
		return this.numberHouse;
	}

	public static Address registerAddress() {
		Address address;
		Scanner sc = new Scanner(System.in);
		System.out.print("Digite o nome da rua: ");
		address.setStreet(sc.nextLine());
		System.out.print("Digite o nome do bairro: ");
		address.setDistrict(sc.nextLine());
		System.out.print("Digite o número da casa: ");
		address.setNumberHouse(sc.nextInt());
		return address;
	}

	public String toString() {
		return "Rua: " + this.street + "\nBairro: " +  this.district + "\nNº da casa: " + this.numberHouse;
	}
	
}