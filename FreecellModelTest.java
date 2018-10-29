import org.junit.Before;
import org.junit.Test;

import java.util.List;

import freecell.model.CardDeck;
import freecell.model.FreecellModel;

import static org.junit.Assert.*;

public class FreecellModelTest {
private FreecellModel testModel;
private CardDeck cards;

  /**
   *
   */
@Before
public void setUp() {
  testModel = new FreecellModel(4, 8);
}

/**
 * Test for getting valid deck.
 * getdeck() method.
 * 1) It should not be empty.
 * 2) Assert right number of cards.
 * 3) No duplicate cards.
 */
@Test
public void testGetDeck(){
  List deck = testModel.getDeck();
  assertEquals(52, testModel.getDeck().size());

  //testModel.startGame(deck, false);
}

/**
 *Test for startGame() method.
 * Verify that deck is valid. java.lang.IllegalArgumentException - if the deck is invalid
 * test1- With shuffling
 * test 2 - Without shuffling.
 */
//Remove whitespace from the last line in the expected output.
@Test
public void testStartGame1(){
  List deck = testModel.getDeck();
  assertEquals(52, testModel.getDeck().size());
  testModel.startGame(deck, false);
  String st= testModel.getGameState();
  assertEquals(st,"F1: \n" +
          "F2: \n" +
          "F3: \n" +
          "F4: \n" +
          "O1: \n" +
          "O2: \n" +
          "O3: \n" +
          "O4: \n" +
          "C1: K♥, J♥, 9♥, 7♥, 5♥, 3♥, A♥\n" +
          "C2: K♦, J♦, 9♦, 7♦, 5♦, 3♦, A♦\n" +
          "C3: K♠, J♠, 9♠, 7♠, 5♠, 3♠, A♠\n" +
          "C4: K♣, J♣, 9♣, 7♣, 5♣, 3♣, A♣\n" +
          "C5: Q♥, 10♥, 8♥, 6♥, 4♥, 2♥\n" +
          "C6: Q♦, 10♦, 8♦, 6♦, 4♦, 2♦\n" +
          "C7: Q♠, 10♠, 8♠, 6♠, 4♠, 2♠\n" +
          "C8: Q♣, 10♣, 8♣, 6♣, 4♣, 2♣");

}

  @Test
  public void testStartGame2(){
    List deck = testModel.getDeck();
    assertEquals(52, testModel.getDeck().size());
    testModel.startGame(deck, true);
    assertNotEquals(testModel.getGameState(),"F1: \n" +
            "F2: \n" +
            "F3: \n" +
            "F4: \n" +
            "O1: \n" +
            "O2: \n" +
            "O3: \n" +
            "O4: \n" +
            "C1: K♥, J♥, 9♥, 7♥, 5♥, 3♥, A♥\n" +
            "C2: K♦, J♦, 9♦, 7♦, 5♦, 3♦, A♦\n" +
            "C3: K♠, J♠, 9♠, 7♠, 5♠, 3♠, A♠\n" +
            "C4: K♣, J♣, 9♣, 7♣, 5♣, 3♣, A♣\n" +
            "C5: Q♥, 10♥, 8♥, 6♥, 4♥, 2♥\n" +
            "C6: Q♦, 10♦, 8♦, 6♦, 4♦, 2♦\n" +
            "C7: Q♠, 10♠, 8♠, 6♠, 4♠, 2♠\n" +
            "C8: Q♣, 10♣, 8♣, 6♣, 4♣, 2♣");
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

  assertEquals(testModel.getGameState(),"");
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


@Test
public void startInvalidGame(){

}
}
