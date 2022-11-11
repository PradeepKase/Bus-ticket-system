package beans;

public class Customer {
 private int cusId;
 
 private String email;
 
 private String password;
 
 private String firstname;
 
 private String lastname;
 
 private String address;
 
 private String mobile;

 
 
	public Customer() {
		super();
	}
	
public Customer(int cusId, String email, String password, String firstname, String lastname, String address,
		String mobile) {
	super();
	this.cusId = cusId;
	this.email = email;
	this.password = password;
	this.firstname = firstname;
	this.lastname = lastname;
	this.address = address;
	this.mobile = mobile;
}






public int getCusId() {
	return cusId;
}






public void setCusId(int cusId) {
	this.cusId = cusId;
}


public String getEmail() {
	return email;
}


public void setEmail(String email) {
	this.email = email;
}

public String getPassword() {
	return password;
}


public void setPassword(String password) {
	this.password = password;
}


public String getFirstname() {
	return firstname;
}


public void setFirstname(String firstname) {
	this.firstname = firstname;
}

public String getLastname() {
	return lastname;
}

public void setLastname(String lastname) {
	this.lastname = lastname;
}


public String getAddress() {
	return address;
}


public void setAddress(String address) {
	this.address = address;
}

public String getMobile() {
	return mobile;
}

public void setMobile(String mobile) {
	this.mobile = mobile;
}






@Override
public String toString() {
	return "Customer [cusId=" + cusId + ", email=" + email + ", password=" + password + ", firstname=" + firstname
			+ ", lastname=" + lastname + ", address=" + address + ", mobile=" + mobile + "]";
}
 
 
 
 
}
