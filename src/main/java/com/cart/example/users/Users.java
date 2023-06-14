package com.cart.example.users;

import java.util.Collection;
import java.util.Arrays;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Users implements UserDetails {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Long id;
  private String username;
  private String password;
  private String fullname;
  private String street;
  private String city;
  private String state;
  private String zip;
  private String phoneNumber;
 
  public Users() {}

  public Users(Long id, String username, String password, String fullname, String street, String city, String state, String zip, String phoneNumber) {
	super();
	this.id = id;
	this.username = username;
	this.password = password;
	this.fullname = fullname;
	this.street = street;
	this.city = city;
	this.state = state;
	this.zip = zip;
	this.phoneNumber = phoneNumber;
  }

  public Long getId() {
	return id;
  }
	
  public void setId(Long id) {
	this.id = id;
  }
	
  public static long getSerialversionuid() {
	return serialVersionUID;
  }
	
  public String getUsername() {
	return username;
  }
	
  public String getPassword() {
	return password;
  }
	
  public String getFullname() {
	return fullname;
  }
	
  public String getStreet() {
	return street;
  }
	
  public String getCity() {
	return city;
  }
	
  public String getState() {
	return state;
  }
	
  public String getZip() {
	return zip;
  }
	
  public String getPhoneNumber() {
	return phoneNumber;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }

}
