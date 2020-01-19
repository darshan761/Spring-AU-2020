import java.util.ArrayList;
import java.util.List;

public class Cart {
	List<Product>Cart_Products = new ArrayList<Product>();
	double cart_total = 0;

	public double getCart_total() {
		return cart_total;
	}

	public void setCart_total(double cart_total) {
		this.cart_total = cart_total;
	}

	public List<Product> getCart_Products() {
		return Cart_Products;
	}

	public void setCart_Products(List<Product> cart_Products) {
		Cart_Products = cart_Products;
	}

}
