package models;

public class Image {

	// Quick note. Even though the name of the model is Image, this class is being used to store
	// all sorts of files. Because im lazy and i dont want to change it.
	
	private String image64b;
	private String name;
	private String type;
	
	public Image() {
		
	}
	
	public Image(String image64b, String name, String type) {
		this.image64b = image64b;
		this.name = name;
		this.type = type;
	}

	public String getImage64b() {
		return image64b;
	}

	public void setImage64b(String image64b) {
		this.image64b = image64b;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Image [image64b=" + image64b + ", name=" + name + ", type=" + type + "]";
	}

}
