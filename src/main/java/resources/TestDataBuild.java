package resources;

import com.api.models.request.LoginRequest;
import com.api.models.request.ResetPasswordRequest;
import com.api.models.request.SignupRequest;

public class TestDataBuild {

	public LoginRequest validLoginPayload(String username, String password) {
		LoginRequest loginRequest = new LoginRequest.Builder()
				.username(username)
				.password(password)
				.build();
		return loginRequest;
	}

	public SignupRequest addUser(String username, String password, String email, String firstName, String lastName,
			String mobileNumber) {
		SignupRequest signupRequest=new SignupRequest.Builder()
				.username(username)
				.password(password)
				.email(email)
				.firstName(firstName)
				.lastName(lastName)
				.mobileNumber(mobileNumber).build();
		return signupRequest;
	}
	public ResetPasswordRequest resetPassword(String token,String newPassword,String confirmPassword)
	{
		ResetPasswordRequest resetPasswordRequest=new ResetPasswordRequest();
		resetPasswordRequest.setConfirmPassword(confirmPassword);
		resetPasswordRequest.setNewPassword(newPassword);
		resetPasswordRequest.setToken(token);
		return resetPasswordRequest;
	}
}
