package se.danero.examples.terrastore.model;


public class PaymentBean {
	
	private double amount;
	
	public PaymentBean() {
	   // Do nothing, java-bean contract		
	}
	
	public PaymentBean(double amount) {
		 this.amount = amount;			
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}	
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("PaymentBean {amount=" + amount + "}");
		return sb.toString();
	}

}
