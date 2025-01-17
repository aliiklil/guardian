package models;

import java.util.ArrayList;

public class Quest {

	private String questTitle;
	
	private boolean inactive = true;
	private boolean active = false;
	private boolean finished = false;
	private boolean failed = false;
	
	private int experienceReward;
	private int goldReward;
	private Item itemReward;
	
	private ArrayList<String> notes = new ArrayList<String>();
	
	//Timestamps when the quest became active, finished or failed. Relevant for the ordering in the questlog
	private long timestamp;
	
	public Quest(String questTitle, int experienceReward) {
		this.questTitle = questTitle;
		this.experienceReward = experienceReward;
	}

	public String getQuestTitle() {
		return questTitle;
	}

	public boolean isInactive() {
		return inactive;
	}
	
	public boolean isActive() {
		return active;
	}

	public void setActive() {
		inactive = false;
		active = true;
		finished = false;
		failed = false;
		
		timestamp = System.currentTimeMillis();
	}
	
	public boolean isFinished() {
		return finished;
	}

	public void setFinished() {
		inactive = false;
		active = false;
		finished = true;
		failed = false;
		
		timestamp = System.currentTimeMillis();
	}

	public boolean isFailed() {
		return failed;
	}

	public void setFailed() {
		inactive = false;
		active = false;
		finished = false;
		failed = true;
		
		timestamp = System.currentTimeMillis();
	}

	public int getExperienceReward() {
		return experienceReward;
	}
	
	public int getGoldReward() {
		return goldReward;
	}

	public void setGoldReward(int goldReward) {
		this.goldReward = goldReward;
	}

	public Item getItemReward() {
		return itemReward;
	}

	public void setItemReward(Item itemReward) {
		this.itemReward = itemReward;
	}

	public ArrayList<String> getNotes() {
		return notes;
	}

	public void setNotes(ArrayList<String> notes) {
		this.notes = notes;
	}

	public long getTimestamp() {
		return timestamp;
	}
		
}
