import org.junit.Before;
import org.junit.Test;

import freecell.model.CardDeck;
import freecell.model.FreecellModel;

import static org.junit.Assert.*;

public class FreecellModelTest {
private FreecellModel testModel;
private CardDeck cards;

@Before
public void setUp() {
  testModel = new FreecellModel();
}

/**
 * Test for getting valid deck.
 * getdeck() method.
 * 1) It should not be empty.
 * 2) Assert right number of cards.
 * 3) No duplicate cards.
 */
@Test
public void testgetDeck(){
  System.out.println(testModel.getDeck());
  //System.out.println(cards.createDeck());
}

/**
 *Test for startGame() method.
 * Verify that deck is valid. java.lang.IllegalArgumentException - if the deck is invalid
 * test1- With shuffling
 * test 2 - Without shuffling.
 */
@Test
public void testStartGame(){

}

/**
 * Tests for all decks are valid after startGame().
 */
@Test
public void testAllValidDecks(){

}


/**
 * Combination of move and getGamestate().
 */
@Test
public void testGameState1(){
  // Return empty string before game has begun.
}

  @Test
  public void testGameState2(){
    // Return initial gamestate after new game.
  }

  @Test
  public void testGameState3(){
  //various move() method calls.
    //Get game state and assert that.
  }
// A lot of similar test methods to check gameState.
// check for invalid moves.
// java.lang.IllegalArgumentException - if the move is not possible PileType)
// java.lang.IllegalStateException - if a move is attempted before the game has starts.


// check for invalid middle value of move method.
// card at index o of source pile should match the value passed here.

/**
 * Tests for isGameOver().
 * True: If users wins
 * True: If user cannot make any move(User loser).
 * False: User can move cards.
 */
@Test
public void testGameOver()
{}

}