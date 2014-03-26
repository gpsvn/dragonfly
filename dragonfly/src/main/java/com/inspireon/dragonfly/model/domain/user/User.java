package com.inspireon.dragonfly.model.domain.user;

import java.util.Date;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.inspireon.dragonfly.exception.InvalidPasswordException;
import com.inspireon.dragonfly.model.domain.shared.Entity;

@Document(collection="users")
public class User extends Entity<User>{
    
	@Indexed
    private String username;
    
    private String password;
    
    private String email;
    
    private Date joinedDate;
    
    private Role role;

    
    // ---------------------------------- Constructors --------------------------------- //
    public User(String username, String password, String email) {
		this.username = username;
		this.password = password;
		this.email = email;
		
		this.joinedDate = new Date();
		
		this.role = Role.USER;
	}
    
    public User(){
    	
    }
    
    // ---------------------------------- Business logic --------------------------------- //
	public String username() {
		return username;
	}

	public String password() {
		return password;
	}
	
	public String email() {
		return email;
	}

	public Date joinedDate() {
		return joinedDate;
	}

	public Role role() {
		return role;
	}

	
	public void resetPassword(String newPassword) {
		this.password = encodePassword(newPassword);
	}

	/**
	 * @author Phuong
	 * 
	 *  using bcrypt encoding alorithm to encode
	 *  
	 * @param password
	 * @return 
	 */
	private String encodePassword(String password){
		PasswordEncoder pe = new BCryptPasswordEncoder();
		return pe.encode(password);
	}
	
	/**
	 * When user change his password, he need input old password.
	 * If input old password don't match old password in storage, he can't change password.
	 * 
	 * @param old password
	 * 		old password 
	 * @param newRawPwd
	 * 		new raw password
	 * 
	 * @throws IllegalArgumentException - if input old password don't match stored old password. 
	 * @author Tung 
	 * @throws InvalidPasswordException 
	 */
	public void changePassword (String oldPassword, String newPassword) throws InvalidPasswordException {
		//logical check matching old password stored in the system with old password input by user
		PasswordEncoder pe = new BCryptPasswordEncoder();
		
		if(pe.matches(oldPassword, this.password))
		
			this.password = encodePassword(newPassword);
		else throw new InvalidPasswordException();
	}
	
	// -------------------------------- Common method ---------------------------------//
	@Override
	public boolean sameIdentityAs(User other) {
		return other != null && this.username.equals(other.username);
	}
	
	@Override
	public boolean equals(final Object object) {
		if (this == object)
			return true;
		if (object == null || getClass() != object.getClass())
			return false;

		final User other = (User) object;
		return sameIdentityAs(other);
	}

	/**
	 * @return Hash code of username
	 */
	@Override
	public int hashCode() {
		return username.hashCode();
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", email=" + email + ", joinedDate=" + joinedDate + "]";
	}
}

