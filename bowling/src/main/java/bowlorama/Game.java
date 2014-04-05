package bowlorama;

import org.apache.commons.lang.NotImplementedException;


public class Game {

	private int score = 0;
	private int[] rolls = new int[21];
	private int roll = 0;
	private int currentRoll = 0;
	private int currentFrame = 0;
	private boolean firstRoll = true;

	public void roll(int pinsKnockedDown) {
		score += pinsKnockedDown;
		rolls[currentRoll ++] = pinsKnockedDown;
		
		if (firstRoll ) {
			currentFrame++;
			firstRoll = false;
		} else {
			firstRoll = true;
		}
	}

	public int getScore() {
		return getScoreForFrame(currentFrame);
	}

	public int getScoreForFrame(int frame) {
		int frameScore = 0;
		for (int currentFrame = 0; currentFrame < frame; currentFrame++) {
			frameScore += rolls[roll];
			frameScore += rolls[roll+1];
			if (rolls[roll] + rolls[roll+1] == 10) {
				frameScore += rolls[roll+2];
			}
			roll += 2;
		}
		return frameScore;
	}

}
