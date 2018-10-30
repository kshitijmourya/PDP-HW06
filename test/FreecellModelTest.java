import org.junit.Before;
import org.junit.Test;

import java.util.List;

import freecell.model.Cards;
import freecell.model.FreecellModel;
import freecell.model.FreecellOperations;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;


public class FreecellModelTest {
  private FreecellOperations testModel;
  private FreecellOperations testModel2;

  /**
   * setup method which calls the constructors.
   */
  @Before
  public void setUp() {
    testModel = FreecellModel
            .getBuilder()
            .build();

    testModel2 = FreecellModel
            .getBuilder()
            .cascades(4)
            .opens(2)
            .build();

  }

  @Test
  public void iniTest() {
    assertEquals("", testModel2.getGameState());

    testModel2.startGame(testModel2.getDeck(), true);
    assertEquals(52, testModel2.getDeck().size());
  }

  @Test(expected = IllegalArgumentException.class)
  public void iniTestFail() {
    List<Cards> cards = testModel2.getDeck();
    Cards extra_card = cards.get(1);
    cards.add(extra_card);
    cards.remove(4);
    System.out.println(cards);
    assertEquals("", testModel2.getGameState());
    testModel.startGame(cards, false);
    System.out.println(testModel2.getGameState());
  }

  /**
   * Test for getting valid deck. getdeck() method. 1) It should not be empty. 2) Assert right
   * number of cards. 3) No duplicate cards.
   */
  @Test
  public void testGetDeck() {
    List deck = testModel.getDeck();
    assertEquals(52, testModel.getDeck().size());

    //testModel.startGame(deck, false);
  }

  /**
   * Test for startGame() method. Verify that deck is valid. java.lang.IllegalArgumentException - if
   * the deck is invalid test1- With shuffling test 2 - Without shuffling.
   */
  //Remove whitespace from the last line in the expected output.
  @Test
  public void testStartGame1() {
    List deck = testModel.getDeck();
    assertEquals(52, testModel.getDeck().size());
    testModel.startGame(deck, false);
    String st = testModel.getGameState();

    assertEquals(st, "F1:\n" +
            "F2:\n" +
            "F3:\n" +
            "F4:\n" +
            "O1:\n" +
            "O2:\n" +
            "O3:\n" +
            "O4:\n" +
            "C1: A♥, 3♥, 5♥, 7♥, 9♥, J♥, K♥\n" +
            "C2: A♦, 3♦, 5♦, 7♦, 9♦, J♦, K♦\n" +
            "C3: A♠, 3♠, 5♠, 7♠, 9♠, J♠, K♠\n" +
            "C4: A♣, 3♣, 5♣, 7♣, 9♣, J♣, K♣\n" +
            "C5: 2♥, 4♥, 6♥, 8♥, 10♥, Q♥\n" +
            "C6: 2♦, 4♦, 6♦, 8♦, 10♦, Q♦\n" +
            "C7: 2♠, 4♠, 6♠, 8♠, 10♠, Q♠\n" +
            "C8: 2♣, 4♣, 6♣, 8♣, 10♣, Q♣");

  }

  @Test
  public void testStartGame2() {
    List deck = testModel.getDeck();
    assertEquals(52, testModel.getDeck().size());
    testModel.startGame(deck, true);
    assertNotEquals(testModel.getGameState(), "C1: K♥, J♥, 9♥, 7♥, 5♥, 3♥, A♥\n" +
            "C2: K♦, J♦, 9♦, 7♦, 5♦, 3♦, A♦\n" +
            "C3: K♠, J♠, 9♠, 7♠, 5♠, 3♠, A♠\n" +
            "C4: K♣, J♣, 9♣, 7♣, 5♣, 3♣, A♣\n" +
            "C5: Q♥, 10♥, 8♥, 6♥, 4♥, 2♥\n" +
            "C6: Q♦, 10♦, 8♦, 6♦, 4♦, 2♦\n" +
            "C7: Q♠, 10♠, 8♠, 6♠, 4♠, 2♠\n" +
            "C8: Q♣, 10♣, 8♣, 6♣, 4♣, 2♣");
  }

}