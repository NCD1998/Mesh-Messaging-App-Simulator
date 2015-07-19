package phone;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import message.Message;
import ref.Reference;
import ref.TransModes;
import util.Logger;
import Main.MeshSimMain;

public class Phone {

	/*
	 * Object that represents a phone in the world 
	 *
	 */
	//FINALS
		//Name
	private String name = "";
		//Used to store the phones public UUID
	private final UUID PUBLICUUID;
		//Stores phones private UUID
	private final UUID PRIVATEUUID;
		//Max number of connections a phone can have
	private final int MAXCONNECTS = Reference.MAXCONNECT;
	//Private Variables
		//UUIDs of all messages the phone has recieved in the past [timeframe]
	private List<UUID> recievedUUID = new ArrayList();
		//Phones Current transmission mode
	private TransModes mode;
		//Phones Current position
	private int XPos;
	private int YPos;
		//Phones Current connections
	private List<Connection> connections = new ArrayList();
		//Is Phones text currently being read by Simulation?
	private boolean showText = Reference.DEFAULTVIEW;
	//The persons personality
	private final Personality personality;
	//Public Variables
	
	//pos Params Constructer
	public Phone(int x, int y){
		//Placeholder
		PUBLICUUID = UUID.randomUUID();
		PRIVATEUUID = UUID.randomUUID();
		mode = TransModes.PUBLIC;
		personality = new Personality();
		this.setLocation(x, y);
	}
	//Name Params
	public Phone(String Pname,int x, int y){
		//Placeholder
		PUBLICUUID = UUID.randomUUID();
		PRIVATEUUID = UUID.randomUUID();
		mode = TransModes.PUBLIC;
		personality = new Personality();
		name= Pname;
		this.setLocation(x, y);
	}
	//Getters/setters
	public UUID getPublicID(){
		return PUBLICUUID;
	}
	
	public void addToRecievedUUID(UUID toStore){
		recievedUUID.add(toStore);
	}
	
	public void changeMode(TransModes tomode){
		mode = tomode;
	}
	
	public TransModes getMode(){
		return mode;
	}
	
	public void setLocation(int x, int y){
		XPos = x;
		YPos = y;
	}
	public int getXLocation(){
		return XPos;
	}
	public int getYLocation(){
		return YPos;
	}
	//Adds a connection if phone has connection capabilities
	public boolean addConnection(Connection newC){
		if(connections.size() < MAXCONNECTS){
			connections.add(newC);
			return true;
		}else{
			return false;
		}
		
		
	}
	//Recieves a message
	public void recieve(Message mess){
		if(hasMessageRecieved(mess.getUUID())){
			//No further action
		}else{
			recievedUUID.add(mess.getUUID());
			if(mess.getType().equals(TransModes.PUBLIC)){
				if(mode.equals(TransModes.PUBLIC) && showText){
					System.out.println("(" + name + ") " + mess.getSenderName() + ": " +  mess.getText());
					mess.FSend(connections);
				}
			}
		}
		
		
	}
	public void toggleText(){
		showText = !showText;
		Logger.Log("Toggled Text for phone: " + PRIVATEUUID);
	}
	//Checks if a phone is connected
	public boolean isConnected(Phone checkthis){
		for(Connection current: connections){
			if(current.getPhone().equals(checkthis)){
				return true;
			}
		}
		return false;
	}
	//Removes a connection
	public void removeConnection(Phone removethis){
		for(int i = 0; i < connections.size(); i++){
			if(connections.get(i).equals(removethis)){
				connections.remove(i);
				break;
			}
		}
	}
	public String getName(){
		return name;
	}
	public void sendGlobalChat(String message){
		Message mess = new Message(name, PUBLICUUID, mode, connections, message, null);
	}
	public Personality getPersonality(){
		return personality;
		
	}
	//Private methods
	//Checks if a UUID is stored in recievedUUID
	private boolean hasMessageRecieved(UUID toCheck){
		for(UUID current: recievedUUID){
			if(current.equals(toCheck)){
				return true;
			}
		}
		return false;
	}
	//Clears recivedUUID
	private void clearUUIDLog(){
		recievedUUID = new ArrayList();
	}
	//Creates and sends a global chat message
	
}
