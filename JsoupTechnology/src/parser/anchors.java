package parser;

public class anchors {
	private char charset;
	private char coords;
	private String downloads;
	private String href;
	private String hreflang;
	private char name;
	private String rel;
	private String rev;
	private char target;
	private char type;
	private String text;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public char getCharset() {
		return charset;
	}

	public void setCharset(char charset) {
		this.charset = charset;
	}

	public char getCoords() {
		return coords;
	}

	public void setCoords(char coords) {
		this.coords = coords;
	}

	public String getDownloads() {
		return downloads;
	}

	public void setDownloads(String downloads) {
		this.downloads = downloads;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public String getHreflang() {
		return hreflang;
	}

	public void setHreflang(String hreflang) {
		this.hreflang = hreflang;
	}

	public char getName() {
		return name;
	}

	public void setName(char name) {
		this.name = name;
	}

	public String getRel() {
		return rel;
	}

	public void setRel(String rel) {
		this.rel = rel;
	}

	public String getRev() {
		return rev;
	}

	public void setRev(String rev) {
		this.rev = rev;
	}

	public char getTarget() {
		return target;
	}

	public void setTarget(char target) {
		this.target = target;
	}

	public char getType() {
		return type;
	}

	public void setType(char type) {
		this.type = type;
	}

	/**
	 * @param charset
	 * @param coords
	 * @param downloads
	 * @param href
	 * @param hreflang
	 * @param name
	 * @param rel
	 * @param rev
	 * @param target
	 * @param type
	 * @param text
	 */
	public anchors(char charset, char coords, String downloads, String href, String hreflang, char name, String rel,
			String rev, char target, char type, String text) {
		this.charset = charset;
		this.coords = coords;
		this.downloads = downloads;
		this.href = href;
		this.hreflang = hreflang;
		this.name = name;
		this.rel = rel;
		this.rev = rev;
		this.target = target;
		this.type = type;
		this.text = text;
	}

	@Override
	public String toString() {
		return "anchors [charset=" + charset + ", coords=" + coords + ", downloads=" + downloads + ", href=" + href
				+ ", hreflang=" + hreflang + ", name=" + name + ", rel=" + rel + ", rev=" + rev + ", target=" + target
				+ ", type=" + type + ", text=" + text + "]";
	}

	

	
	
}
