package practice;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertTest {
	
	public SoftAssert soft = new SoftAssert();
	
	@Test
	public void createCustomerTest() {
		System.out.println("Step1");
		System.out.println("Step2");
		soft.assertEquals("A", "B");
		System.out.println("Step3");
		System.out.println("Step4");
		soft.assertAll();
	}
	@Test
	public void modifyCustomerTest() {
		System.out.println("StepA");
		System.out.println("StepB");
		System.out.println("StepC");
		System.out.println("--------------------------");
	}
}
