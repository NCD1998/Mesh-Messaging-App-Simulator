package util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Nrand {
	private Random rand = new Random();
	private List<String> names = new ArrayList();
	
	public Nrand(){
		names.add("Kayle");
		names.add("Joe");
		names.add("Bill");
		names.add("Annie");
		names.add("Marx");
		names.add("Sherman");
		names.add("Kyle");
		names.add("Zander");
		names.add("Zack");
		names.add("Nathan");
		names.add("Nate");
		names.add("Patrick");
		names.add("Andy");
		names.add("Eze");
		names.add("Marius");
		names.add("Darniel");
		names.add("Kimmy");
		names.add("Jimmy");
		names.add("Fin");
		names.add("Max");
		names.add("Martin");
		names.add("Malcom");
		names.add("Xavier");
		names.add("Bobby");
		names.add("Steven");
		names.add("Sofie");
		names.add("Fred");
		names.add("Maximo");
		names.add("Leo");
		names.add("Ezekiel");
		names.add("Quincy");
		names.add("Dustin");
	}
	
	public String nextName(){
		
		if(names.isEmpty()){
			names.add("Kayle");
			names.add("Joe");
			names.add("Bill");
			names.add("Annie");
			names.add("Marx");
			names.add("Sherman");
			names.add("Kyle");
			names.add("Zander");
			names.add("Zack");
			names.add("Nathan");
			names.add("Nate");
			names.add("Patrick");
			names.add("Andy");
			names.add("Eze");
			names.add("Marius");
			names.add("Darniel");
			names.add("Kimmy");
			names.add("Jimmy");
			names.add("Fin");
			names.add("Max");
			names.add("Martin");
			names.add("Malcom");
			names.add("Xavier");
			names.add("Bobby");
			names.add("Steven");
			names.add("Sofie");
			names.add("Fred");
			names.add("Maximo");
			names.add("Leo");
			names.add("Ezekiel");
			names.add("Quincy");
			names.add("Dustin");
			int randint = rand.nextInt(names.size());
			return names.remove(randint);
		}else{
			int randint = rand.nextInt(names.size());
			return names.remove(randint);
		}
			
	}
	public String nextString(int Length){
		int length = rand.nextInt(Length);
		int count = 0;
		String result = "";
		while(count <= Length){
			count++;
			int nextrand = rand.nextInt(26);
			char nextchar = 'a';
			switch(nextrand){
			case 0: nextchar = 'a' ;
				break;
			case 1: nextchar = 'b' ;
				break;
			case 2: nextchar = 'c' ;
			break;
			case 3: nextchar = 'd' ;
			break;
			case 4: nextchar = 'e' ;
			break;
			case 5: nextchar = 'f' ;
			break;
			case 6: nextchar = 'g' ;
			break;
			case 7: nextchar = 'h' ;
			break;
			case 8: nextchar = 'i' ;
			break;
			case 9: nextchar = 'j' ;
			break;
			case 10: nextchar = 'k' ;
			break;
			case 11: nextchar = 'l' ;
			break;
			case 12: nextchar = 'm' ;
			break;
			case 13: nextchar = 'n' ;
			break;
			case 14: nextchar = 'o' ;
			break;
			case 15: nextchar = 'p' ;
			break;
			case 16: nextchar = 'q' ;
			break;
			case 17: nextchar = 'r' ;
			break;
			case 18: nextchar = 's' ;
			break;
			case 19: nextchar = 't' ;
			break;
			case 20: nextchar = 'u' ;
			break;
			case 21: nextchar = 'v' ;
			break;
			case 22: nextchar = 'w' ;
			break;
			case 23: nextchar = 'x' ;
			break;
			case 24: nextchar = 'y' ;
			break;
			case 25: nextchar = 'z' ;
			break;
			}
			result +=  "" + nextchar;
			
		}
		if(rand.nextInt(1001) == 42){
			return "YOU ARE TRAPPED IN THE MATRIX! THIS MESSAGE MAY SHOW UP ANYWHERE!";
		}
		return result;
	}
}
