package phone;

public class Connection {
	/*
	 * Represents a connection between a phone and the phone object that is pointed to in this object
	 * 
	 */
	private final Phone phone;
	
	public Connection(Phone withPhone){
		phone = withPhone;
	}
	
	public Phone getPhone(){
		return phone;
	}
}
