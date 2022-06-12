package com.blog.payload;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDto {
	
	private int id;
	@NotNull
	@Size(min = 4,message="User must be min of 4 characters")
	private String name;
	@NotEmpty
	@Email(message="Email address is  not valid")
	private String email;
	
	@NotEmpty
	@Size(min=3,max=10,message="Password must be min of 3 and max of 10 chars!!")
	//@Pattern(regxp)
	private String password;
	
	@NotEmpty
	private String about;
	
	
	
	

}
