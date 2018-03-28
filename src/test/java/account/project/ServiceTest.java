package account.project;

import static org.junit.Assert.*;
import org.junit.Test;

public class ServiceTest
{
	@Test
	public void test() throws Exception
	{
		Service service = new Service();
		String jsonConvert = "{\"0\":{\"firstName\":\"Matt\",\"lastName\":\"Moore\",\"accountNumber\":0},\"1\":{\"firstName\":\"Nick\",\"lastName\":\"Watton\",\"accountNumber\":1},\"2\":{\"firstName\":\"Anirban\",\"lastName\":\"Biswas\",\"accountNumber\":2},\"3\":{\"firstName\":\"Andrew\",\"lastName\":\"McGill\",\"accountNumber\":3},\"4\":{\"firstName\":\"Nick\",\"lastName\":\"Watton\",\"accountNumber\":4}}"; 
		String jsonMap;
		int acCount;
		
		service.addAccount("Matt", "Moore", 0);
		assertTrue(service.retrieveAccount(0).getAccountNumber() == 0);
		service.addAccount("Nick", "Watton", 1);
		assertTrue(service.retrieveAccount(1).getAccountNumber() == 1);
		service.addAccount("Anirban", "Biswas", 2);
		assertTrue(service.retrieveAccount(2).getAccountNumber() == 2);
		service.addAccount("Andrew", "McGill", 3);
		assertTrue(service.retrieveAccount(3).getAccountNumber() == 3);
		service.addAccount("Nick", "Watton", 4);
		assertTrue(service.retrieveAccount(4).getAccountNumber() == 4);
		
		jsonMap = service.translateAccount();
		assertEquals(jsonMap, jsonConvert);
		
		acCount = service.countAccount("Nick");
		assertEquals(2, acCount);
		
		service.removeAccount(4);
		service.removeAccount(3);
		service.removeAccount(2);
		service.removeAccount(1);
		service.removeAccount(0);
		

		
		
	}
}