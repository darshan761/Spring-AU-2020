package com.akash.maharana.wsdlFirst;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.cxf.feature.Features;

import com.akash.ws.trainings.CreateOrdersRequest;
import com.akash.ws.trainings.CreateOrdersResponse;
import com.akash.ws.trainings.CustomerOrdersPortType;
import com.akash.ws.trainings.DeleteOrdersRequest;
import com.akash.ws.trainings.DeleteOrdersResponse;
import com.akash.ws.trainings.GetOrdersRequest;
import com.akash.ws.trainings.GetOrdersResponse;
import com.akash.ws.trainings.Order;
import com.akash.ws.trainings.Product;
import com.akash.ws.trainings.UpdateOrdersRequest;
import com.akash.ws.trainings.UpdateOrdersResponse;

@Features(features="org.apache.cxf.feature.LoggingFeature")
public class CustomerOrdersWSImpl implements CustomerOrdersPortType{

	Map<BigInteger,List<Order>> customerOrders=new HashMap<>();
	int currenntId;
	
	public CustomerOrdersWSImpl() {
		init();
	}
	
	public void init() {
		List<Order> orders=new ArrayList<>();
		Order order = new Order();
		order.setId(BigInteger.valueOf(1));
		
		Product product=new Product();
		product.setId("1");
		product.setDescription("Amul");
		product.setQuantity(BigInteger.valueOf(3));
		order.getProduct().add(product);
		orders.add(order);
		
		customerOrders.put(BigInteger.valueOf(++currenntId), orders);
	}
	
	@Override
	public GetOrdersResponse getOrders(GetOrdersRequest request) {
		BigInteger customerId=request.getCustomerId();
		List<Order> orders = customerOrders.get(customerId);
		GetOrdersResponse response=new GetOrdersResponse();
		response.getOrder().addAll(orders);
		return response;
	}
	@Override
	public CreateOrdersResponse createOrders(CreateOrdersRequest request) {
		BigInteger customerId=request.getCustomerId();
		Order order=request.getOrder();
		List<Order> orders=customerOrders.get(customerId);
		orders.add(order);
		CreateOrdersResponse response=new CreateOrdersResponse();
		response.setResult(true);
 		return response;
	}
	
	// added method for updating order
	@SuppressWarnings("unlikely-arg-type") // to supress warning for BigInteger
	@Override
	public UpdateOrdersResponse updateOrders(UpdateOrdersRequest request) {
		
		UpdateOrdersResponse response = new UpdateOrdersResponse();

		try {
			BigInteger customerId=request.getCustomerId();
			Order order=request.getOrder();
			List<Order> orders=customerOrders.get(customerId);
			orders.remove(request.getOrderId());
			orders.add(order);
			customerOrders.remove(customerId);
			customerOrders.put(customerId, orders);

			response.setResult(true);
		}
		catch (Exception e) {
			response.setResult(false);
			System.out.println("Update Failed");
		}
		
		return response;
	}
	
	
	
	// added method for deleting order
	@SuppressWarnings("unlikely-arg-type") // to supress warning for BigInteger
	@Override
	public DeleteOrdersResponse deleteOrders(DeleteOrdersRequest request) {
		DeleteOrdersResponse response = new DeleteOrdersResponse();
		
		try {
			BigInteger customerId = request.getCustomerId();
			List<Order> orders=customerOrders.get(customerId);
			orders.remove(request.getOrderId());
			customerOrders.remove(customerId);
			customerOrders.put(customerId, orders);
			
			response.setResult(true);
		}
		catch (Exception e) {
			response.setResult(false);
			System.out.println("Delete Failed");
		}
		
		return response;
	}

	

}