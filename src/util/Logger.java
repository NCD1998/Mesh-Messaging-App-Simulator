package util;

import ref.Reference;

public class Logger {
	public static void Log(String mess){
		if(Reference.LOG){
			System.out.println("LOG: " + mess);
		}
	}
}
