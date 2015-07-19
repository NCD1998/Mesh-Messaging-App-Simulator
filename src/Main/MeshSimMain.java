package Main;
import java.util.Random;
import java.util.Scanner;

import ref.Reference;
import util.Logger;
import util.Nrand;
import world.WorldMap;


public class MeshSimMain {

	public static void main(String[] args) throws InterruptedException {
		//Main Code for the Program
		Scanner reader = new Scanner(System.in);
		System.out.println("How many connections can 1 phone have? (Int)");
		Reference.MAXCONNECT = reader.nextInt();
		System.out.println("How strong are the phones signals? (Int)");
		Reference.SIGNALSTRENGTH = reader.nextInt();
		System.out.println("How long is the world? (int)");
		Reference.WORLDLENGTH= reader.nextInt();
		System.out.println("How wide is the world? (int)");
		Reference.WORLDWIDTH= reader.nextInt();
		System.out.println("How many people should be in the begining? (int)");
		int startphone = reader.nextInt();
		Random rand = new Random();
		Nrand nrand = new Nrand();
		WorldMap world = new WorldMap();
		String yourname = null;
		System.out.println("Want to be in the Sim? (1/0)");
		if(reader.nextInt() == 1){
			System.out.println("Enter your name: ");
			yourname = reader.next();
			world.addPhone(yourname, rand.nextInt(Reference.WORLDLENGTH), rand.nextInt(Reference.WORLDWIDTH));
		}
		
		
		world.drawWorld();
		int max = startphone;
		int count = 0;
		while(count < max){
			count++;
			int y = rand.nextInt(Reference.WORLDLENGTH);
			int x = rand.nextInt(Reference.WORLDWIDTH);
			if(!world.isPhoneHere(x, y)){
				world.addPhone(nrand.nextName(), x, y);
			}
		}
		world.drawWorld();
		while(true){
			Thread.sleep(1000 + rand.nextInt(1000));
			int donext = rand.nextInt(100);
			if(donext < 70){
				String sentence = nrand.nextString(1 + rand.nextInt(1 + rand.nextInt(1 + rand.nextInt(30))));
				for(int i = 0; i < rand.nextInt(13); i++){
					sentence += " " + nrand.nextString(1 + rand.nextInt(1 + rand.nextInt(30)));
				}
				sentence += ".";
				world.getRandomPhone().sendGlobalChat(sentence);
			}else if(donext > 70 && donext < 90){
				boolean xpos = rand.nextBoolean();
				boolean ypos = rand.nextBoolean();
				int xval = rand.nextInt(5);
				int yval = rand.nextInt(5);
				if(xpos){
					xval *= -1;
				}
				if(ypos){
					yval *= -1;
				}
				world.movePhone(world.getRandomPhone(), xval, yval);
				Logger.Log("Redraw!");
				world.drawWorld();
			}else if(donext > 90 && donext < 95){
				int y = rand.nextInt(Reference.WORLDLENGTH);
				int x = rand.nextInt(Reference.WORLDWIDTH);
				if(!world.isPhoneHere(x, y)){
					String nextName = nrand.nextName();
					world.addPhone(nextName, x, y);
					world.drawWorld();
					Logger.Log(nextName += " has been born!");
				}
				
			}else{
				world.deletePhone(world.getRandomPhone());
				world.drawWorld();
				Logger.Log(world.deletePhone(world.getRandomPhone()).getName() + " has left the world!");
			}
		}
		/*
		 * Start up for program.
		 * Ask for world size, number of staring phones, and other info
		 * 
		 * Create world object
		 * 
		 * Create and Add Initial Phone Objects
		 * 
		 * Establish Connections
		 * 
		 * Draw world
		 * 
		 * LOOP	
		 * Command Imput: Add Phone, Enter Phone Simulation, Move Phone, and other commands
		 * 
		 * 
		 * Redraw world
		 * 
		 * 
		 */

	}

}
