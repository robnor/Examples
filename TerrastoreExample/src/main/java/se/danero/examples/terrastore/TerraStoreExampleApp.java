package se.danero.examples.terrastore;

import se.danero.examples.terrastore.model.PaymentBean;
import terrastore.client.TerrastoreClient;
import terrastore.client.connection.resteasy.HTTPConnectionFactory;

public class TerraStoreExampleApp {
	
	public static void main(String[] args) {
		
		PaymentBean payment = new PaymentBean(125.00);
		
		TerrastoreClient client = new TerrastoreClient("http://localhost:8000", new HTTPConnectionFactory());
		
		System.out.println("Trying to store:  " + payment);
		client.bucket("payments").key("1").put(payment);
	
		System.out.println("\nPayment stored\n");
		
		System.out.println("Trying to retrive payment from storage");
		PaymentBean payment2 = (PaymentBean) client.bucket("payments").key("1").get(PaymentBean.class);
	
		System.out.println("Retrieved payment: " + payment2);
		
		System.out.println("\nDone!\n");
	}

}
