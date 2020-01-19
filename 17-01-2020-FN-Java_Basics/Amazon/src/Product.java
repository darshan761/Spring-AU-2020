
public class Product {
	int product_id,qty;
	String product_name;
	double rate;
	public Product(int product_id, int qty, String product_name, double rate) {
		super();
		this.product_id = product_id;
		this.qty = qty;
		this.product_name = product_name;
		this.rate = rate;
	}
	
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	@Override
	public String toString() {
		return "product_id:" + product_id + "  qty:" + qty + "  product_name:" + product_name + "  rate="
				+ rate;
	}
	

}
