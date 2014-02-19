package bowlorama;

public class Game {

	private int score = 0;
	private int[] rolls = new int[21];
	private int roll = 0;
	private int currentFrame = 0;
	private boolean firstRoll = true;

	public void roll(int pinsKnockedDown) {
		score += pinsKnockedDown;
		rolls[roll++] = pinsKnockedDown;

		if (firstRoll) {
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
		int ball = 0;
		int scoreForFrame = 0;

		for (int currentFrame = 0; currentFrame < frame; currentFrame++) {
			scoreForFrame += rolls[ball]; // roll 1
			scoreForFrame += rolls[ball + 1]; // roll 2
			if ((rolls[ball] + rolls[ball + 1]) == 10) {
				scoreForFrame += rolls[ball + 2]; // roll 3
			}
			ball += 2;
		}
		return scoreForFrame;
	}

}
