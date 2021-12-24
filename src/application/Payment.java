package application;

public  class Payment {
	private PaymentHandler paymentHandler;
       
	void SetPaymentHandler(PaymentHandler PHandler) {
		
		paymentHandler=PHandler;
	}
	PaymentHandler getPaymentHandler() {
		return paymentHandler;
		
	}
	public Payment() {
	
		//paymentHandler=factory.CreatePaymentHandler(type);
	}
	
	
	float  MakePayment(float Total,float paidCash) {
		
		return paymentHandler.MakePayment(Total,paidCash);
	}
}
