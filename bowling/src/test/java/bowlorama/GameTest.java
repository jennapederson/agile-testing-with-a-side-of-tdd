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
	// spare and 2 rolls
	// strike and 2 rolls
	// perfect game
	// refactor
	
	@Before
	public void before() {
		game = new Game();
	}
	
	@Test
	public void testOneRoll() throws Exception {
		game.roll(5);
		assertThat(game.getScore(), is(5));
	}
	
	@Test
	public void testTwoRolls() throws Exception {
		game.roll(5);
		game.roll(2);
		assertThat(game.getScore(), is(7));
	}
	
	@Test
	public void testGetScoreForFrameOne() throws Exception {
		game.roll(5);
		game.roll(2);
		assertThat(game.getScoreForFrame(1), is(7));
	}
	
	@Test
	public void testGetScoreForFrameTwo() throws Exception {
		game.roll(5);
		game.roll(2);
		game.roll(3);
		game.roll(1);
		assertThat(game.getScoreForFrame(2), is(11));
	}
	
	@Test
	public void testGetScoreForSpareAndTwoRolls() throws Exception {
		game.roll(3);
		game.roll(7);  // 13
		game.roll(3);
		game.roll(1);  // 17
		assertThat(game.getScoreForFrame(1), is(13));
	}
	
	@Test
	public void testSpareAndTwoRolls() throws Exception {
		game.roll(3);
		game.roll(7);  // 13
		game.roll(3);
		game.roll(1);  // 17
		assertThat(game.getScore(), is(17));
	}
}
