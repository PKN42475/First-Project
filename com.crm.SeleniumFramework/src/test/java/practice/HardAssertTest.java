package practice;

import org.junit.Assert;
import org.testng.annotations.Test;
public class HardAssertTest {
	@Test
	public void createCustomerTest() {
		System.out.println("Step1");
		System.out.println("Step2");
		Assert.assertEquals("A", "A");
		System.out.println("Step3");
		System.out.println("Step4");
	}

	@Test
	public void modifyCustomerTest() {
		System.out.println("StepA");
		System.out.println("StepB");
		System.out.println("StepC");
		System.out.println("--------------------------");
	}
}
