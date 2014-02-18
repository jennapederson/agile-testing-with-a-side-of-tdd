package bowlorama;

public class Game {

	private int roll = 0;
	private int[] rolls = new int[21];
	private int currentFrame = 0;
	private boolean firstRoll = true;

	public void roll(int pinsKnockedDown) {
		rolls[roll++] = pinsKnockedDown;
		incrementCurrentFrame();
	}

	private void incrementCurrentFrame() {
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
			int roll1 = rolls[rollNum];
			int roll2 = rolls[rollNum + 1];
			int roll3 = rolls[rollNum + 2];

			if ((roll1 + roll2) < 10) {
				frameScore += roll1;
				frameScore += roll2;
			} else {
				frameScore += roll1;
				frameScore += roll2;
				frameScore += roll3; // next roll
			}
			rollNum += 2;
		}
		return frameScore;
	}

}
