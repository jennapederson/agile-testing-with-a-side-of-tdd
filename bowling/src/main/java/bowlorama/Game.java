package bowlorama;

public class Game {

	private static final int MAX_ROLLS_PER_GAME = 21;
	private int[] rolls = new int[MAX_ROLLS_PER_GAME];
	private int roll = 0;
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
		return getScoreForFrame(currentFrame);
	}

	public int getScoreForFrame(int frame) {
		int ball = 0;
		int scoreForFrame = 0;

		for (int currentFrame = 0; currentFrame < frame; currentFrame++) {
			int roll1 = rolls[ball];
			int roll2 = rolls[ball + 1];
			int roll3 = rolls[ball + 2];

			scoreForFrame += roll1; // roll 1
			scoreForFrame += roll2; // roll 2
			if ((roll1 + roll2) == 10) {
				scoreForFrame += roll3; // roll 3
			}
			ball += 2;
		}
		return scoreForFrame;
	}

}
