package bowlorama;

public class Game {

	private int roll = 0;
	private int[] rolls = new int[21];
	private int currentFrame = 0;
	private boolean firstRoll = true;

	public void roll(int pinsKnockedDown) {
		rolls[roll++] = pinsKnockedDown;
		
		// increment the current frame
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

	public int getScoreForFrame(int frameNumber) {
		int frameScore = 0;
		int rollNum = 0;
		for (int currentFrame = 0; currentFrame < frameNumber; currentFrame++) {
			if ((rolls[rollNum] + rolls[rollNum + 1]) < 10) {
				frameScore += rolls[rollNum];
				frameScore += rolls[rollNum + 1];
			} else {
				frameScore += rolls[rollNum]; // roll 1 of frame
				frameScore += rolls[rollNum + 1]; // roll 2 of frame
				frameScore += rolls[rollNum + 2]; // next roll
			}
			rollNum += 2;
		}
		return frameScore;
	}

}
