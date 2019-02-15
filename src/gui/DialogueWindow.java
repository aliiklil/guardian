package gui;

import java.awt.Font;
import java.util.ArrayList;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;

import dialogue.Dialogue;
import main.Main;
import manager.CharacterManager;

public class DialogueWindow {

	private Image image = new Image("resources/dialogue_window.png");
	private boolean windowOpen = false;
	private ArrayList<Dialogue> startingDialogues;
	private ArrayList<Dialogue> currentDialogues;
	
	private Font font = new Font(Font.MONOSPACED, Font.BOLD, 25);
	private TrueTypeFont ttf = new TrueTypeFont(font, true);
	
	private int selectedOption;
	private int selectedStartingOption;
	
	private Input input = Main.appGameContainer.getInput();
	
	private int sentenceCount = 0;
	
	private String currentSentence;
	private String currentSpeaker;
	
	private final int MAX_CHAR_AMOUNT_PER_LINE = 62;
	
	private String currentlyDisplayedText;
	private final int TIME_FOR_NEXT_CHARACTER = 20;
	private long timeLastCharacterWasAdded;
	private int addedCharactersCounter;
	
	public DialogueWindow() throws SlickException {
		
	}
	
	public void showWindow(ArrayList<Dialogue> startingDialogues) {
		
		windowOpen = true;
		this.startingDialogues = startingDialogues;
		currentDialogues = startingDialogues;
		
	}
	
	public void update() throws SlickException {
		
		if(windowOpen) {
			
			if(sentenceCount == 0) {
				if(input.isKeyPressed(Input.KEY_UP)) {
					if(selectedOption > 0) {
						selectedOption--;
					} else if(selectedOption == 0) {
						if(currentDialogues == startingDialogues) {
							selectedOption = currentDialogues.size();
						} else {
							selectedOption = currentDialogues.size() - 1;
						}
					}
				}
								
				if(input.isKeyPressed(Input.KEY_DOWN)) {
					if(currentDialogues == startingDialogues) {
						if(selectedOption < currentDialogues.size()) {
							selectedOption++;
						} else if(selectedOption == currentDialogues.size()) {
							selectedOption = 0;
						}
					} else {
						if (selectedOption < currentDialogues.size() - 1) {
							selectedOption++;
						} else if(selectedOption == currentDialogues.size() - 1) {
							selectedOption = 0;
						}
					}
				}
			}
			
			if(CharacterManager.getPlayer().isYPressed()) {
				
				if(sentenceCount > 0 && currentlyDisplayedText.length() != currentSentence.length()) {
					
					currentlyDisplayedText = currentSentence;
					addedCharactersCounter = currentSentence.length();
					timeLastCharacterWasAdded = System.currentTimeMillis();
					
				} else if(selectedOption != currentDialogues.size()) {
			
					if(sentenceCount < currentDialogues.get(selectedOption).getSentences().size() - 1) {
						
						sentenceCount++;
						
						currentSentence = currentDialogues.get(selectedOption).getSentences().get(sentenceCount).getText();
						currentSpeaker = currentDialogues.get(selectedOption).getSentences().get(sentenceCount).getSpeakerName();
		
						timeLastCharacterWasAdded = System.currentTimeMillis();
						addedCharactersCounter = 0;
						currentlyDisplayedText = "";
						
						if(currentDialogues == startingDialogues) {
							selectedStartingOption = selectedOption;
						}
						
					} else if(sentenceCount == currentDialogues.get(selectedOption).getSentences().size() - 1 && currentDialogues.get(selectedOption).hasChildDialogues()) {
						
						currentDialogues = currentDialogues.get(selectedOption).getChildDialogues();
						sentenceCount = 0;
						selectedOption = 0;
						
					} else if(sentenceCount == currentDialogues.get(selectedOption).getSentences().size() - 1 && !currentDialogues.get(selectedOption).hasChildDialogues()) {
						
						if(currentDialogues.get(selectedOption).hasNewStartingDialogues()) {

							for(Dialogue dialogue : currentDialogues.get(selectedOption).getNewStartingDialogues()) {
								startingDialogues.add(dialogue);
							}
							
						}
						
						if(!startingDialogues.isEmpty()) {
							startingDialogues.remove(selectedStartingOption);
						}
											
						currentDialogues = startingDialogues;
						selectedOption = 0;
						sentenceCount = 0;
						
					} 
					
				} else if(selectedOption == currentDialogues.size() && currentDialogues == startingDialogues) {
					windowOpen = false;
					selectedOption = 0;
					sentenceCount = 0;
				}
			
			}
			
		}		

		
	}
	
	public void render(Graphics g) {
		if(windowOpen) {
			g.drawImage(image, 0, 0);
			
			if(sentenceCount == 0) {
			
				for(int i = 0; i <= currentDialogues.size(); i++) {
					Color fontColor;
					if(i == selectedOption) {
						fontColor = Color.white;
					} else {
						fontColor = Color.gray;
					}
					
					if(i == currentDialogues.size() && currentDialogues == startingDialogues) {
						ttf.drawString(495, 763 + i * 30, "End", fontColor);
					} 
					
					if(i < currentDialogues.size())  {
						ttf.drawString(495, 763 + i * 30, currentDialogues.get(i).getSentences().get(0).getText(), fontColor);
					}
					
				}	
				
			} else {
				Color fontColor;
				if(!currentSpeaker.equals("Hero")) {
					fontColor = Color.yellow;
				} else {
					fontColor = Color.white;
				}
				ttf.drawString(Main.WIDTH/2 - ttf.getWidth(currentSpeaker)/2, 763, currentSpeaker, fontColor);
								
				
				
				if(System.currentTimeMillis() - timeLastCharacterWasAdded > TIME_FOR_NEXT_CHARACTER && addedCharactersCounter < currentSentence.length()) {
					currentlyDisplayedText = currentlyDisplayedText + currentSentence.substring(addedCharactersCounter, addedCharactersCounter + 1);
					timeLastCharacterWasAdded = System.currentTimeMillis();
					addedCharactersCounter++;
				}
				
				
				
				
				String[] wrappedLines = new String[(int) Math.ceil((double)currentlyDisplayedText.length()/MAX_CHAR_AMOUNT_PER_LINE)];
				
				for(int i = 0; i < wrappedLines.length; i++) {
					if((currentlyDisplayedText.length() >= (i+1)*62)) {
						wrappedLines[i] = currentlyDisplayedText.substring(i * 62, (i+1)*62);
					} else {
						wrappedLines[i] = currentlyDisplayedText.substring(i * 62, currentlyDisplayedText.length());
					}
				}
				
				for(int i = 0; i < wrappedLines.length; i++) {
					if(wrappedLines[i].substring(0, 1).equals(" ")) {
						wrappedLines[i] = wrappedLines[i].substring(1);
					}
				}

				for(int i = 0; i < wrappedLines.length; i++) {
					ttf.drawString(495, 808 + i * 30, wrappedLines[i], fontColor);
				}
				
			}
		}
	}

	public boolean isWindowOpen() {
		return windowOpen;
	}
}