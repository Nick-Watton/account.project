package account.project;

import java.util.HashMap;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Service
{
	
	private HashMap<Integer, Account> accountMap;
	private int keyCounter;
	
	public Service()
	{
		accountMap = new HashMap<Integer, Account>();
		keyCounter = 0;

	}
	
	public void addAccount(String firstname, String lastname, int accountnumber)
	{
		accountMap.put(keyCounter, new Account(firstname, lastname, accountnumber));
		keyCounter++;
	}
	
	public void removeAccount(int key)
	{
		if(accountMap.containsKey(key)) accountMap.remove(key);
	}
	

	public Account retrieveAccount(int key)
	{
		return accountMap.get(key);
	}
	
	public String translateAccount() throws Exception {
		
		ObjectMapper mapper = new ObjectMapper();
		String jsonFromMap = mapper.writeValueAsString(accountMap);
		System.out.println(jsonFromMap);
		
		return jsonFromMap;
	}

	public  int countAccount(String firstName) {
		
		Account accountHolder;
		int acCount = 0;
		for (int c=0; c < accountMap.size(); c++)
		{
			accountHolder = accountMap.get(c);

			if (accountHolder.getFirstName() == firstName) {

				acCount++;

			}
		}
		return acCount;
	}
}