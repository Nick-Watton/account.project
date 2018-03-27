package account.project;

public class Account
{
	//ATTRIBUTES
	private String m_firstname;
	private String m_lastname;
	private int m_accountnumber;
	
	
	//METHODS
	
	//Constructor
	public Account(String firstname, String lastname, int accountnumber)
	{
		m_firstname = firstname;
		m_lastname = lastname;
		m_accountnumber = accountnumber;
	}
	
	
	//Get methods
	public String getFirstName()
	{
		return m_firstname;
	}
	
	public String getLastName()
	{
		return m_lastname;
	}
	
	public int getAccountNumber()
	{
		return m_accountnumber;
	}
}