package Model;

public class mBongthom {
	private String JobID;
	private String JobTitle;
	private String CompanyName;
	private String CloseDate;
	private String Category;
	public String getJobID() {
		return JobID;
	}
	public void setJobID(String jobID) {
		JobID = jobID;
	}
	public String getJobTitle() {
		return JobTitle;
	}
	public void setJobTitle(String jobTitle) {
		JobTitle = jobTitle;
	}
	public String getCompanyName() {
		return CompanyName;
	}
	public void setCompanyName(String companyName) {
		CompanyName = companyName;
	}
	public String getCloseDate() {
		return CloseDate;
	}
	public void setCloseDate(String closeDate) {
		CloseDate = closeDate;
	}
	public String getCategory() {
		return Category;
	}
	public void setCategory(String category) {
		Category = category;
	}
	public mBongthom(String jobID, String jobTitle, String companyName,
			String closeDate, String category) {
		JobID = jobID;
		JobTitle = jobTitle;
		CompanyName = companyName;
		CloseDate = closeDate;
		Category = category;
	}
	public mBongthom(){};
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "mBongthom [getJobID()=" + getJobID() + ", getJobTitle()="
				+ getJobTitle() + ", getCompanyName()=" + getCompanyName()
				+ ", getCloseDate()=" + getCloseDate() + ", getCategory()="
				+ getCategory() + "]";
	}
	
	
}
