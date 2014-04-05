package bowlorama;



public class Game {

	private int[] rolls = new int[21];
	private int roll = 0;
	private int currentRoll = 0;
	private int currentFrame = 0;
	private boolean firstRoll = true;

	public void roll(int pinsKnockedDown) {
		rolls[currentRoll ++] = pinsKnockedDown;
		
		incrementCurrentFrame();
	}

	private void incrementCurrentFrame() {
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
			int roll1 = rolls[roll];
			int roll2 = rolls[roll+1];
			int roll3 = rolls[roll+2];

			frameScore += roll1;
			frameScore += roll2;
			
			if (isSpare(roll1, roll2)) {
				frameScore += roll3;
			}
			
			roll += 2;
		}
		return frameScore;
	}

	private boolean isSpare(int roll1, int roll2) {
		return roll1 + roll2 == 10;
	}

}
