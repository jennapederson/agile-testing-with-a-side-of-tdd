package bowlorama;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Copyright 2014 612 Software Foundry
 */

/**
 * @author jennapederson
 */
public class GameTest {

	private Game game;

	// one roll
	// two rolls
	// 4 rolls
	// spare and 2 rolls
	// strike and 2 rolls
	// perfect game
	// refactor
	
	@Before
	public void before() {
		game = new Game();
	}
	
	@Test
	public void testOneRoll() {
		game.roll(5);

		// verify
		// write asserts first
		assertThat(game.getScore(), is(5));
		assertThat(game.getScoreForFrame(1), is(5));
	}

	@Test
	public void testTwoRolls() {
		// setup
		game.roll(5);
		game.roll(2);
		// verify
		assertThat(game.getScore(), is(7));
		assertThat(game.getScoreForFrame(1), is(7));
		
	}

	@Test
	public void testFourRolls() {
		game.roll(5);
		game.roll(2); // 7
		game.roll(1);
		game.roll(4); // 12
		
		// verify
		assertThat(game.getScore(), is(12));
		assertThat(game.getScoreForFrame(1), is(7));
		assertThat(game.getScoreForFrame(2), is(12));
	}
	
	@Test
	public void testSpareAndTwoRolls() {
		// setup
		game.roll(4);
		game.roll(6); // spare; 12
		game.roll(2);
		game.roll(4); // 18
		
		// verify
		assertThat(game.getScoreForFrame(1), is(12));
		assertThat(game.getScoreForFrame(2), is(18));
		assertThat(game.getScore(), is(18));
	}

}
