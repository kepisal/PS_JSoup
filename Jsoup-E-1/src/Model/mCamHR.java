package Model;

public class mCamHR {
	private String username;
	private String lastname;
	private String firstname;
	private String gender;
	private String dateofbirth;
	private String address;
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}
	public mCamHR(){};
	public mCamHR(String username, String lastname, String firstname,
			String gender, String dateofbirth, String address) {
		super();
		this.username = username;
		this.lastname = lastname;
		this.firstname = firstname;
		this.gender = gender;
		this.dateofbirth = dateofbirth;
		this.address = address;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "mCamHR [username=" + username + ", lastname=" + lastname
				+ ", firstname=" + firstname + ", gender=" + gender
				+ ", dateofbirth=" + dateofbirth + ", address=" + address + "]";
	}
	/**
	 * @param lastname the lastname to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	/**
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}
	/**
	 * @param firstname the firstname to set
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}
	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	/**
	 * @return the dateofbirth
	 */
	public String getDateofbirth() {
		return dateofbirth;
	}
	/**
	 * @param dateofbirth the dateofbirth to set
	 */
	public void setDateofbirth(String dateofbirth) {
		this.dateofbirth = dateofbirth;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
}
