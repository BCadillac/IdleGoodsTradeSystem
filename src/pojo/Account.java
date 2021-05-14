package pojo;

public class Account {
	private String id;
	private String password;
	private String contactInfo;
	
	public void setId(String id){
		this.id=id;
	}
	public String getId(){
		return id;
	}
	public void setPassword(String pw){
		this.password=pw;
	}
	public String getPassword(){
		return password;
	}
	public void setContactInfo(String cIf){
		this.contactInfo=cIf;
	}
	public String getContactInfo(){
		return contactInfo;
	}	
}
