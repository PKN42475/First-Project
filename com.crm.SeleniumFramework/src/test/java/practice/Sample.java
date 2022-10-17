package practice;

import org.testng.annotations.Test;

public class Sample {
	@Test
	public void createCustomerTest() {
		System.out.println("Customer details created");
	}
	
	@Test
	public void modifyCustomerTest() {
		System.out.println("Customer details modified");
	}
	
	@Test
	public void deleteCustomerTest() {
		System.out.println("Customer details deleted");
	}
}

