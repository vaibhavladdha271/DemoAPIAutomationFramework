package resources;

import com.api.models.request.UserProfileRequest;

public class UserProfileData {
	
	public UserProfileRequest updateUserProfile(String firstName,String lastName,String email,String mobileNumber)
	{
		UserProfileRequest userProfileRequest=new UserProfileRequest.Builder()
				.email(email)
				.firstName(firstName)
				.lastName(lastName)
				.mobileNumber(mobileNumber)
				.build();
		return userProfileRequest;
	}

}
