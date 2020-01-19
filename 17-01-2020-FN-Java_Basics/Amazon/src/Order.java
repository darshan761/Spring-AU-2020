import java.util.ArrayList;
import java.util.List;

public class Order {
	int order_id=0;
	String username;
	double total_bill = 0;
	List<Product> Products = new ArrayList<Product>();
	@Override
	public String toString() {
		return "order_id:" + order_id + "  username:" + username + "  Products:" + Products +"\nTOTAL:"+total_bill;
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public List<Product> getProducts() {
		return Products;
	}
	public void setProducts(List<Product> products) {
		Products = products;
	}

}
