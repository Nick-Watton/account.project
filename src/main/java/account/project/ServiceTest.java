package account.project;

import static org.junit.Assert.*;
import org.junit.Test;

public class ServiceTest
{
	@Test
	public void test() throws Exception
	{
		Service service = new Service();
		String jsonconvert = "{\"0\":{\"accountNumber\":0,\"lastName\":\"Moore\",\"firstName\":\"Matt\"},\"1\":{\"accountNumber\":1,\"lastName\":\"Watton\",\"firstName\":\"Nick\"},\"2\":{\"accountNumber\":2,\"lastName\":\"Biswas\",\"firstName\":\"Anirban\"},\"3\":{\"accountNumber\":3,\"lastName\":\"McGill\",\"firstName\":\"Andrew\"}}";
		String jsonmap;
		
		service.addAccount("Matt", "Moore", 0);
		assertTrue(service.retrieveAccount(0).getAccountNumber() == 0);
		service.addAccount("Nick", "Watton", 1);
		assertTrue(service.retrieveAccount(1).getAccountNumber() == 1);
		service.addAccount("Anirban", "Biswas", 2);
		assertTrue(service.retrieveAccount(2).getAccountNumber() == 2);
		service.addAccount("Andrew", "McGill", 3);
		assertTrue(service.retrieveAccount(3).getAccountNumber() == 3);
		
		jsonmap = service.translateAccount();
		assertEquals(jsonmap, jsonconvert);
		service.removeAccount(3);
		service.removeAccount(2);
		service.removeAccount(1);
		service.removeAccount(0);
	}
}