package phone;

import java.util.Random;

import Chat.Moods;
import Chat.Traits;

public class Personality {

	/*
	 * Contains personality properties like randomness, indifference, mood, and normal mood, and influence...
	 */
	private final int randomness;
	private final int influence;
	private final int indifference;
	private  Moods mood;
	private  int moodlevel;
	private Moods influencingMood;
	private int influencingMoodlevel;
	private final Traits trait;
	private Random rand = new Random();
	private Phone[] friends;
	private Phone[] blocked;
	public Personality(){
		randomness = rand.nextInt(5);
		influence = rand.nextInt(10);
		indifference = rand.nextInt(10);
		trait = Traits.nextTrait();
		mood = trait.getPreferedMood(trait);
		influencingMood = trait.getPreferedMood(trait);
		influencingMoodlevel = 0;
		moodlevel = 5;
	}
	
	public void recieveInfluence(Moods Imood, Phone phone){
		Personality otherperson = phone.getPersonality();
		int effectiveness = otherperson.getInfluence() - indifference;
		if(effectiveness <= 0){
			//Nothing needs be done as the person was not influenced
		}else{
			if(Imood.equals(mood)){
				if(Imood.equals(Traits.getPreferedMood(trait))){
					addMoodLevel(2 + randomness);
				}else{
					addMoodLevel(1 + randomness);
				}
			}else if(Imood.equals(influencingMood)){
				if(Imood.equals(Traits.getPreferedMood(trait))){
					addInfluenceLevel(2 + randomness);
				}else{
					addInfluenceLevel(1 + randomness);
				}
			}else if(effectiveness > influencingMoodlevel){
				influencingMood = Imood;
				influencingMoodlevel = effectiveness - influencingMoodlevel;
				checkForChange();
			}else{
				addInfluenceLevel(-1 - randomness);
				addMoodLevel(-1 - randomness);
			}
		}
	}
	
	private void addInfluenceLevel(int i) {
		if(influencingMoodlevel + i > 10){
			influencingMoodlevel = 10;
		}else if(influencingMoodlevel + i < 0){
			influencingMoodlevel = 0;
		}else{
			influencingMoodlevel += i;
		}
		checkForChange();
		
	}

	private void addMoodLevel(int i) {
		if(moodlevel + i > 10){
			moodlevel = 10;
		}else if(moodlevel + i < 0){
			moodlevel = 0;
		}else{
			moodlevel += i;
		}
		checkForChange();
		
	}

	private void checkForChange() {
		if(influencingMoodlevel > moodlevel){
			mood = influencingMood;
			moodlevel = 5;
			influencingMoodlevel = 0;
		}
		
	}

	public int getInfluence(){
		return influence;
	}
}
