package entity;

public class Trail {

	private int id;
	private String name;
	private String mtCounty;
	private double miles;

	public Trail(int id, String name, String mtCounty, double miles) {
		this.id = id;
		this.name = name;
		this.mtCounty = mtCounty;
		this.miles = miles;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMtCounty() {
		return mtCounty;
	}

	public void setMtCounty(String mtCounty) {
		this.mtCounty = mtCounty;
	}

	public double getMiles() {
		return miles;
	}

	public void setMiles(double miles) {
		this.miles = miles;
	}

}
