package account.project;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

public class ServiceTest {

	Service service = new Service();

	@Before
	public void testSetUp() {
		service.addAccount("Matt", "Moore", 0);
		service.addAccount("Nick", "Watton", 1);
		service.addAccount("Anirban", "Biswas", 2);
		service.addAccount("Andrew", "McGill", 3);
		service.addAccount("Nick", "Watton", 4);
		
	}
	
	@After
	public void testCleanUp() {
		service.removeAccount(4);
		service.removeAccount(3);
		service.removeAccount(2);
		service.removeAccount(1);
		service.removeAccount(0);	
	}
	
	@Test
	public void checkElementsExist() {
		assertTrue(service.retrieveAccount(0).getAccountNumber() == 0);
		assertTrue(service.retrieveAccount(1).getAccountNumber() == 1);
		assertTrue(service.retrieveAccount(2).getAccountNumber() == 2);
		assertTrue(service.retrieveAccount(3).getAccountNumber() == 3);
		assertTrue(service.retrieveAccount(4).getAccountNumber() == 4);
	}
	
	@Test
	public void translateToJSONFromMap() throws Exception {
		String jsonConvert = "{\"0\":{\"firstName\":\"Matt\",\"lastName\":\"Moore\",\"accountNumber\":0},\"1\":{\"firstName\":\"Nick\",\"lastName\":\"Watton\",\"accountNumber\":1},\"2\":{\"firstName\":\"Anirban\",\"lastName\":\"Biswas\",\"accountNumber\":2},\"3\":{\"firstName\":\"Andrew\",\"lastName\":\"McGill\",\"accountNumber\":3},\"4\":{\"firstName\":\"Nick\",\"lastName\":\"Watton\",\"accountNumber\":4}}"; 
		String jsonMap;
		jsonMap = service.translateAccount();
		assertEquals(jsonMap, jsonConvert);
	
	}
	
	@Test
	public void countAccounts() {
		int acCount;
		acCount = service.countAccount("Nick");
		assertEquals(2, acCount);
	}
}