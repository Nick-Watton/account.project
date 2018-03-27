package account.project;

public class Account
{
	private String firstName;
	private String lastName;
	private int accountNumber;
	
	public Account(String firstname, String lastname, int accountnumber)
	{
		firstName = firstname;
		lastName = lastname;
		accountNumber = accountnumber;
	}
	
	public String getFirstName()
	{
		return firstName;
	}
	
	public String getLastName()
	{
		return lastName;
	}
	
	public int getAccountNumber()
	{
		return accountNumber;
	}
}