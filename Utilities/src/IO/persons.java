package IO;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class persons implements Serializable {
	private String name;
	private int age;
	private String genders;
	private String occupations;
	private String mydate = new SimpleDateFormat("MM/dd/YYYY")
			.format(new Date());

	public persons() {
		name = "";
		age = 0;
		genders = "";
		occupations = "";
		mydate = "00/00/0000";
	}

	public persons(String name, int age, String genders, String occupations) {
		this.name = name;
		this.age = age;
		this.genders = genders;
		this.occupations = occupations;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age
	 *            the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * @return the genders
	 */
	public String getGenders() {
		return genders;
	}

	/**
	 * @param genders
	 *            the genders to set
	 */
	public void setGenders(String genders) {
		this.genders = genders;
	}

	/**
	 * @return the occupations
	 */
	public String getOccupations() {
		return occupations;
	}

	/**
	 * @param occupations
	 *            the occupations to set
	 */
	public void setOccupations(String occupations) {
		this.occupations = occupations;
	}

	/**
	 * @return the mydate
	 */
	public String getMydate() {
		return mydate;
	}

	/**
	 * @param mydate
	 *            the mydate to set
	 */
	public void setMydate(String mydate) {
		this.mydate = mydate;
	}

	public String toString() {
		return "Name : " + this.name + "\n" + "Gender : " + this.genders + "\n"
				+ "Age : " + this.genders + "\n" + "Occaption : "
				+ this.occupations + "\n" + "Date/Time : " + this.mydate;
	}
}
