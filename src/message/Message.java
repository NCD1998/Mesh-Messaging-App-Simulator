package message;
import java.util.List;
import java.util.UUID;

import phone.Connection;
import ref.Reference;
import ref.TransModes;
public class Message {

	/*
	 * Represents a message 
	 */
	private final UUID mesUUID;
	private final List<Connection> recipients;
	private final TransModes Mtype;
	private final String text;
	private final boolean relay;
	private int relayStrength;
	private final List<UUID> additionalPhones;
	private final boolean displayAll;
	private final String senderName;
	private final UUID senderUUID;
	
	public Message(String PsenderName, UUID PsenderUUID, TransModes type, List<Connection> toList, String textM, List<UUID> additional){
		mesUUID = UUID.randomUUID();
		senderName = PsenderName;
		senderUUID = PsenderUUID;
		recipients = toList;
		Mtype = type;
		text = textM;
		additionalPhones = additional;
		if(type.equals(TransModes.PUBLIC)){
			relay = true;
			relayStrength = Integer.MAX_VALUE;
			displayAll = true;
		}else if(type.equals(TransModes.LOCAL)){
			relay = true;
			relayStrength = Reference.LOCALSTRENGTH;
			displayAll = true;
		}else if(type.equals(TransModes.PRIVATE)){
			relay = false;
			relayStrength = 0;
			displayAll = false;
		}else if(type.equals(TransModes.RELAY)){
			relay = true;
			relayStrength = Integer.MAX_VALUE;
			displayAll = false;
		}else if(type.equals(TransModes.LOCATER)){
			relay = true;
			relayStrength = Integer.MAX_VALUE;
			displayAll = false;
		}else{
			relay = false;
			relayStrength = 0;
			displayAll = false;
		}
		this.Send();
	}

	private void Send() {
		if(Mtype.equals(TransModes.PUBLIC)){
			for(Connection current: recipients){
				current.getPhone().recieve(this);
			}
		}	
		
	}
	public void FSend(List<Connection> connects) {
		if(Mtype.equals(TransModes.PUBLIC)){
			for(Connection current: connects){
				current.getPhone().recieve(this);
			}
		}	
		
	}
	public UUID getUUID(){
		return mesUUID;
	}
	public TransModes getType(){
		return Mtype;
	}
	public String getText(){
		return text;
	}
	public String getSenderName(){
		return senderName;
	}
	public UUID getSenderUUID(){
		return senderUUID;
	}
	public List<UUID> getAdditional(){
		return additionalPhones;
	}
}
