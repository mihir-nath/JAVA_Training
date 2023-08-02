package entities;

public class RenewInsurance {
      private String policyNumber;
      private String mobileNumber;
      private String emailAddress;
	
      public RenewInsurance() {
    	  
      }
      
      public String getPolicyNumber() {
		return policyNumber;
	  }
	  public void setPolicyNumber(String policyNumber) {
		this.policyNumber = policyNumber;
	  }
	  public String getMobileNumber() {
		return mobileNumber;
	  }
	  public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	  }
	  public String getEmailAddress() {
		return emailAddress;
	  }
	  public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	  }
      
      
}
