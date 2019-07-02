package customer_master;

public class Customer_Master_Pojo {
	
	String custid,fname,lname,gender,dob,address,mobileno,emailid,password;

	public String getCustid()
	  {
		return custid;
	  }

	public void setCustid(String custid) 
	  {
		this.custid = custid;
	  }

	public String getFname() 
	  {
		return fname;
	  }

	public void setFname(String fname)
	  {
		this.fname = fname;
	  }

	public String getLname() 
	  {
		return lname;
	  }

	public void setLname(String lname)
	  {
		this.lname = lname;
	  }

	public String getGender() 
	  {
		return gender;
	  }

	public void setGender(String gender) 
	  {
		this.gender = gender;
	  }

	public String getDob()
	  {
		return dob;
	  }

	public void setDob(String dob) 
	  {
		this.dob = dob;
	  }

	public String getAddress() 
	  {
		return address;
	  }

	public void setAddress(String address) 
	  {
		this.address = address;
	  }

	public String getMobileno() 
	  {
		return mobileno;
	  }

	public void setMobileno(String mobileno) 
	  {
		this.mobileno = mobileno;
	  }

	public String getEmailid() 
	  {
		return emailid;
	  }

	public void setEmailid(String emailid) 
	  {
		this.emailid = emailid;
	  }

	public String getPassword() 
	  {
		return password;
	  }

	public void setPassword(String password)
	  {
		this.password = password;
	  }	
	public String toString()
	{
		return "Customer Id:"+custid+"\nName:"+fname+" "+lname+"\nGender:"+gender+"\nAddress:"+address
				+"\nContact No:"+mobileno+"\nE-Mail:"+emailid;
	}

}
