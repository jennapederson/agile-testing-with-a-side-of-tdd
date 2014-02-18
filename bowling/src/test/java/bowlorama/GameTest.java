package bowlorama;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

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
	public void testScoreOneRoll() throws Exception {
		game.roll(5);
		
		assertThat(game.getScoreForFrame(1), is(5));
		assertThat(game.getScore(), is(5));
	}
	
	@Test
	public void testFourRolls() throws Exception {
		game.roll(5);
		game.roll(2); // 7
		game.roll(2);
		game.roll(3); // 12
		
		assertThat(game.getScoreForFrame(1), is(7));
 	 	assertThat(game.getScoreForFrame(2), is(12));
		assertThat(game.getScore(), is(12));
		
	}
	
	@Test
	public void testSpareThenTwoRolls() throws Exception {
		game.roll(3);
		game.roll(7); // spare; 12
		game.roll(2);
		game.roll(3); // 17
		
		assertThat(game.getScoreForFrame(1), is(12));
 	 	assertThat(game.getScoreForFrame(2), is(17));
		assertThat(game.getScore(), is(17));
	}
	
	
	
}
