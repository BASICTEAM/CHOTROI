package edu.poly.spring.dtos;

import javax.validation.constraints.NotBlank;

public class ShopDto {

	@NotBlank(message = "Không để trống tài khoản!")
	private String username;
	
	@NotBlank(message = "Không để trống mật khẩu cũ!")
	private String oldPassword;
	
	@NotBlank(message = "Không để trống mật khẩu mới!")
	private String newPassword;
	
	@NotBlank(message = "Không để trống xác nhận mật khẩu!")
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
