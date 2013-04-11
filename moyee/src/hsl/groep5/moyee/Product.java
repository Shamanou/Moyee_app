package hsl.groep5.moyee;

import org.json.JSONException;
import org.json.JSONObject;

public class Product {
	private int id = 0;
	private String title = "";
	private String image = "";
	private double price = 0 ;
	private double size = 0;
	private String description = "";
	
	public Product(JSONObject obj) {
		try {
			this.id = obj.getInt("id");
			this.title = obj.getString("title");
			//this.image = obj.getString("image");
			this.price = obj.getDouble("price");
			this.size = obj.getDouble("size");
			//this.description = obj.getString("description");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getTitle() {
		return this.title;
	}
	public String getImageUrl() {
		return this.image;
	}
	public double getPrice() {
		return this.price;
	}
	public double getSize() {
		return this.size;
	}
	public String getDescription() {
		return this.description;
	}
}