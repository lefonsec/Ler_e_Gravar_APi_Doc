package api.com.json;

public class Nasa {

	private String media_type;
	private String title;

	public String getType() {
		return media_type;
	}

	public void setType(String url) {
		this.media_type = url;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return  media_type + title;
	}

}
