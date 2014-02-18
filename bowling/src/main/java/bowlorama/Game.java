package bowlorama;


public class Game {

	private int roll = 0; 
	private int[] rolls = new int[21];
	private int currentFrame;
	private boolean firstRoll = true;

	public void roll(int pinsKnockedDown) {
		rolls[roll++] = pinsKnockedDown;
		
		if (firstRoll) {
			currentFrame++;
			firstRoll = false;
		} else {
			firstRoll = true;
		}
	}

	public int getScore() {
		return getScoreForFrame(getCurrentFrame());
	}

	private int getCurrentFrame() {
		return currentFrame;
	}

	public int getScoreForFrame(int frame) {
 		int scoreForFrame = 0;
 		int ball = 0;
		for (int currentFrame = 0; currentFrame < frame; currentFrame++) {
			scoreForFrame += rolls[ball];
			scoreForFrame += rolls[ball + 1];
			if ((rolls[ball] + rolls[ball+1]) == 10) {
				scoreForFrame += rolls[ball+2];
			}
			ball += 2;
		}
		return scoreForFrame;
	}

}
