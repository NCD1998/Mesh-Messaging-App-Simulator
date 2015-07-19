package Chat;

import java.util.Random;

public enum Traits {
	Cheerful,
	Sulky,
	Hottempered,
	Indifferent,
	Nhilistic,
	Wimpy,
	Sarcastic;
	
	public static Moods getPreferedMood(Traits trait){
		if(trait.equals(Traits.Cheerful)){
			return Moods.Happy;
		}else if(trait.equals(Traits.Hottempered)){
			return Moods.Angry;
		}else if(trait.equals(Traits.Indifferent)){
			return Moods.Indifferent;
		}else if(trait.equals(Traits.Nhilistic)){
			return Moods.Indifferent;
		}else if(trait.equals(Traits.Sarcastic)){
			return Moods.Annoyed;
		}else if(trait.equals(Traits.Sulky)){
			return Moods.Sad;
		}else if(trait.equals(Traits.Wimpy)){
			return Moods.Afraid;
		}else{
			return Moods.Indifferent;
		}
	}
	public static Traits nextTrait(){
		Random rand = new Random();
		int randnum = rand.nextInt(Traits.values().length);
		return Traits.values()[randnum];
	}
}
