package Model;

public class product {
	private String image_link;
	private String link;
	private String price;
	private String title;
	public String getImage_link() {
		return image_link;
	}
	public void setImage_link(String image_link) {
		this.image_link = image_link;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public product(String image_link, String link, String price, String title) {
		super();
		this.image_link = image_link;
		this.link = link;
		this.price = price;
		this.title = title;
	}
	public product() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "product [image_link=" + image_link + ", link=" + link + ", price=" + price + ", title=" + title + "]";
	}
	
}
