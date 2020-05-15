package com.nusacamp.app.web.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import com.nusacamp.app.constraints.FieldMatch;

@FieldMatch.List({
	@FieldMatch(first = "password", second = "confirmPassword", message = "The password field must match"),
	@FieldMatch(first = "mail", second = "confirmEmail", message = "The email field must match")
})
public class UserRegistrationDto {

	@NotEmpty
	private String fullName;
	
	@Email
	@NotEmpty
	private String mail;
	
	@Email
	@NotEmpty
	private String confirmEmail;
	
	@NotEmpty
	private String password;
	
	@NotEmpty
	private String confirmPassword;
	
	
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getConfirmEmail() {
		return confirmEmail;
	}
	public void setConfirmEmail(String confirmEmail) {
		this.confirmEmail = confirmEmail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

}
