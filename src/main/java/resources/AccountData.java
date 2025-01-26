package resources;

import com.api.models.request.CreateAccountRequest;

public class AccountData {
	
	public CreateAccountRequest createAccount(String accountType,String branch)
	{
		CreateAccountRequest createAccount=new CreateAccountRequest();
		createAccount.setAccountType(accountType);
		createAccount.setBranch(branch);
		return createAccount;
	}

}
