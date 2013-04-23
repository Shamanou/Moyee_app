package hsl.groep5.moyee;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * @title Product object
 * @author Maikel de Jong
 * @param s1041697
 * @since 04-04-2013
 * @version 1.0
 */

public class Product {
	private int id = 0;
	private String title = "";
	private String image = "";
	private double price = 0;
	private double size = 0;
	private String description = "";
	private int count = 0;

	public Product(JSONObject obj) {
		// Extract data from JSONObject to Product
		try {
			this.id = obj.getInt("id");
			this.title = obj.getString("title");
			this.image = obj.getString("image");
			this.price = obj.getDouble("price");
			this.size = obj.getDouble("size");
			this.description = obj.getString("description");
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	public int getId() {
		return this.id;
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

	public int getCount() {
		return this.count;
	}

	public void addCount() {
		this.count++;
	}

	public void subtractCount() {
		if (this.count > 0)
			this.count--;
	}
}