package account.project;

import static org.junit.Assert.*;
import org.junit.Test;

public class ServiceTest
{
	@Test
	public void test() throws Exception
	{
		Service service = new Service();
		String jsonConvert = "{\"0\":{\"accountNumber\":0,\"lastName\":\"Moore\",\"firstName\":\"Matt\"},\"1\":{\"accountNumber\":1,\"lastName\":\"Watton\",\"firstName\":\"Nick\"},\"2\":{\"accountNumber\":2,\"lastName\":\"Biswas\",\"firstName\":\"Anirban\"},\"3\":{\"accountNumber\":3,\"lastName\":\"McGill\",\"firstName\":\"Andrew\"}}";
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
		service.removeAccount(4);
		service.removeAccount(3);
		service.removeAccount(2);
		service.removeAccount(1);
		service.removeAccount(0);
		
		acCount = Service.countAccount("Nick");
		assertEquals(acCount, 2);
		
		
	}
}