package world;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import phone.Connection;
import phone.Phone;
import ref.Reference;

public class WorldMap {

	//All Phones in existance
	private Random rand = new Random();
	private List<Phone> phones = new ArrayList();
	private char[][] world = new char[Reference.WORLDWIDTH][Reference.WORLDLENGTH];
	
	public void drawWorld(){
		for(Phone current1: phones){
			for(Phone current2: phones){
				if(!current1.equals(current2)){
					int xdis = current1.getXLocation() - current2.getXLocation();
					int ydis = current1.getYLocation() - current2.getYLocation();
					int combofsq = (int) (Math.pow(xdis, 2) + (Math.pow(ydis, 2)));
					int totaldis = (int) Math.sqrt(combofsq);
					if(totaldis <= Reference.SIGNALSTRENGTH){
						current1.addConnection(new Connection(current2));
						current2.addConnection(new Connection(current1));
						System.out.println(current1.getName() + " is Connected to " + current2.getName());
					}else{
						current1.removeConnection(current2);
						current2.removeConnection(current1);
					}
				}
			}
		}
		for(int x = 0; x < Reference.WORLDLENGTH; x++){
			for(int y = 0; y < Reference.WORLDWIDTH; y++){
				world[y][x] = ' ';
			}
		}
		for(Phone current: phones){
			if(Reference.names){
				world[current.getXLocation()][current.getYLocation()] = current.getName().charAt(0);
			}else{
				world[current.getXLocation()][current.getYLocation()] = 'P';
			}
			
		}
		
					
		for(int i = 0; i < Reference.WORLDLENGTH; i++){
				System.out.print('_');
			}
			System.out.println();
		for(char[] current: world){
			System.out.print('|');
			for(char current2: current){
				
				System.out.print(current2);
				
			}System.out.print('|');
			System.out.println("");
		}
		for(int i = 0; i < Reference.WORLDLENGTH; i++){
			System.out.print('_');
		}
		System.out.println();
	}
	public void addPhone(String name, int x, int y){
		phones.add(new Phone(name, x, y));
	}
	private boolean arePhonesConnected(Phone phone1, Phone phone2){
		if(phone1.isConnected(phone2) && phone2.isConnected(phone1)){
			return true;
		}else{
			return false;
		}
	}
	public Phone getPhoneFromName(String name){
		for(Phone current: phones){
			if(current.getName().equals(name)){
				return current;
			}
		}
		return null;
	}
	public Phone getRandomPhone(){
		return phones.get(rand.nextInt(phones.size()));
	}
	public boolean isPhoneHere(int x, int y){
		for(Phone current: phones){
			if(current.getXLocation() == x && current.getYLocation() == y){
				return true;
			}
		}
		return false;
	}
	public boolean movePhone(Phone phone, int x, int y){
		int newx = phone.getXLocation() + x;
		int newy = phone.getYLocation() + y;
		if(newx >= 0 && newx < Reference.WORLDLENGTH && newy >= 0 && newy < Reference.WORLDWIDTH){
			if(!isPhoneHere(newx, newy)){
				phone.setLocation(newx, newy);
				return true;
			}
		}
		return false;
	}
	public Phone deletePhone(Phone phone){
		int current = 0;
		while(current < phones.size()){
			if(phones.get(current).equals(phone)){
				return phones.remove(current);
			}
			current++;
		}
		return null;
	}
}
