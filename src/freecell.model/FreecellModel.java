package freecell.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import javax.smartcardio.Card;

import javafx.util.Builder;

/**
 *
 */
public class FreecellModel implements FreecellOperations {
  private CardDeck deck_of_cards;
  private Piles openPiles;
  private Piles cascadePiles;
  private Piles foundationPiles;
  private int opens;
  private int cascades;
  private boolean hasGameBegun=false;

  private final HashMap<String, Integer> value_table = new HashMap<String, Integer>() {{
    put("A", 1); put("2", 2); put("3", 3); put("4", 4); put("5", 5); put("6", 6); put("7", 7);
    put("8", 8); put("9", 9); put("10", 10); put("J", 11); put("Q", 12); put("K", 13);
  }};

  /**
   *
   * @param opens
   * @param cascades
   */
  public FreecellModel(int opens, int cascades) {
    this.deck_of_cards = new Cards();
    this.opens = opens;
    this.cascades = cascades;

    this.openPiles = new Piles(opens, PileType.OPEN);
    this.cascadePiles = new Piles(cascades, PileType.CASCADE);
    this.foundationPiles = new Piles(4, PileType.FOUNDATION);
  }

  /**
   *
   * @return
   */
  public static FreecellModelBuilder getBuilder() {
    return new FreecellModelBuilder();
  }

  /**
   *
   */
  public static class FreecellModelBuilder implements FreecellOperationsBuilder{
    CardDeck deck_of_cards;
    int opens;
    int cascades;

    /**
     *
     */
    public FreecellModelBuilder() {
      this.deck_of_cards = new Cards();
      this.opens = 1;
      this.cascades = 4;
    }

    /**
     *
     * @param opens
     * @return
     */
    public FreecellModelBuilder opens(int opens) {
      this.opens = opens;
      return this;
    }

    /**
     *
     * @param cascades
     * @return
     */
    public FreecellModelBuilder cascades(int cascades) {
      this.cascades = cascades;
      return this;
    }

    /**
     *
     * @return
     */
    public FreecellModel build() {
      return new FreecellModel(opens, cascades);
    }
  }

  /**
   * Return a valid and complete deck of cards for a game of Freecell. There is no restriction
   * imposed on the ordering of these cards in the deck. An invalid deck is defined as a deck that
   * has one or more of these flaws:
   * <ul>
   * <li>It does not have 52 cards</li> <li>It has duplicate cards</li> <li>It
   * has at least one invalid card (invalid suit or invalid number) </li> </ul>
   *
   * @return the deck of cards as a list
   */
  @Override
  public List<Cards> getDeck() {
    return deck_of_cards.createDeck();
  }

  /**
   * Deal a new game of freecell with the given deck, with or without shuffling it first. This
   * method first verifies that the deck is valid. It deals the deck among the cascade piles in
   * roundrobin fashion. Thus if there are 4 cascade piles, the 1st pile will get cards 0, 4, 8,
   * ..., the 2nd pile will get cards 1, 5, 9, ..., the 3rd pile will get cards 2, 6, 10, ... and
   * the 4th pile will get cards 3, 7, 11, .... Depending on the number of cascade piles, they may
   * have a different number of cards
   *
   * @param deck    the deck to be dealt in the game.
   * @param shuffle if true, shuffle the deck else deal the deck as-is.
   * @throws IllegalArgumentException if the deck is invalid.
   */
  @Override
  public void
   startGame(List deck, boolean shuffle) throws IllegalArgumentException {
    // if shuffle input is true the shuffle the deck.
    if (shuffle) {
      // Collections.shuffle() method randomly shuffle a Collections object.
      Collections.shuffle(deck);
    }

    // got the number of cascade piles from cascade piles. Could have used this.cascades instead
    // for a simpler approach. However, using it through getPiles.getsize() we ensure that the
    // correct pile number was made when the object was instantiated.
    int number_of_piles = this.cascadePiles.getPiles().size();

    // in the while-loop below, as cards in the deck are being used, they are being removed
    // so the condition here is to keep looping until there are no more cards in the deck.
    while (!deck.isEmpty()) {
      // for each pile in the cascade section, get the top card in the deck and add it to the pile.
      for (int i = 0; i < number_of_piles; i++ ) {
        // if the deck becomes empty as it is distributing cards then the process of distribution
        // will stop and the loop will break.
        if (!deck.isEmpty()){
          // had to cast to get working, I don't know what K means in the interface but its
          // keeping me from making the deck as List<Cards>. Ask in office hours.
          this.cascadePiles.getPiles().get(i).addFirst((Cards) deck.get(0));
          deck.remove(0);
        } else {
          break;
        }
      }
    }
    hasGameBegun =true;
  }

  /**
   * Move a card from the given source pile to the given destination pile, if the move is valid.
   *
   * @param source         the type of the source pile see @link{PileType}
   * @param pileNumber     the pile number of the given type, starting at 0
   * @param cardIndex      the index of the card to be moved from the source pile, starting at 0
   * @param destination    the type of the destination pile (see
   * @param destPileNumber the pile number of the given type, starting at 0
   * @throws IllegalArgumentException if the move is not possible {@link PileType})
   * @throws IllegalStateException    if a move is attempted before the game has starts
   */
  @Override
  public void move(PileType source, int pileNumber, int cardIndex, PileType destination, int destPileNumber) throws IllegalArgumentException, IllegalStateException {
    Cards card_shifting = new Cards();

    // get card from foundation pile is impossible.
    if (source.equals(PileType.FOUNDATION)) {
      throw new IllegalArgumentException("Cards cannot be removed from the Foundation piles.");
    }

    // get card from open pile. first check pile type.
    if (source.equals(PileType.OPEN)) {
      // check if chosen pile is empty
      if (!this.openPiles.getPiles().get(pileNumber).isEmpty()) {
        // get value of first card in chosen pile
        int shifting_card_value = value_table.get(this.openPiles.getPiles().get(pileNumber).peek().getValue());
        // check if value of first card matches cardIndex given by user.
        // If yes get card, else reject.
        if(shifting_card_value == cardIndex) {
          card_shifting = this.openPiles.getPiles().get(pileNumber).poll();
        } else {
          throw new IllegalArgumentException();
        }
      }
    }

    if (source.equals(PileType.CASCADE)) {
      // check if chosen pile is empty
      if (!this.cascadePiles.getPiles().get(pileNumber).isEmpty()) {
        // get value of first card in chosen pile
        int shifting_card_value = value_table.get(this.cascadePiles.getPiles().get(pileNumber).peek().getValue());
        // check if value of first card matches cardIndex given by user.
        // If yes get card, else reject.
        if(shifting_card_value == cardIndex) {
          card_shifting = this.cascadePiles.getPiles().get(pileNumber).poll();
        } else {
          throw new IllegalArgumentException();
        }
      }
    }

    int shifting_card_value = value_table.get(card_shifting.getValue());
    if (destination.equals(PileType.FOUNDATION)) {
      // if pile is empty and the card being moved is an ACE, then add it to the pile.
      if (this.foundationPiles.getPiles().get(pileNumber).isEmpty() && shifting_card_value == 1) {
        this.foundationPiles.getPiles().get(pileNumber).addFirst(card_shifting);
      }
      // if pile is not empty, card value is 1 level higher than current card in pile,
      // and card to be added has the suite matching that of the cards in the pile the add the card.
      else if (!this.foundationPiles.getPiles().get(pileNumber).isEmpty()
              && shifting_card_value -
              value_table
                      .get(this.foundationPiles.getPiles()
                              .get(pileNumber)
                              .peek()
                              .getValue()) == 1
              && card_shifting.getSuite().equals(
                      this.foundationPiles
                              .getPiles()
                              .get(pileNumber)
                              .peek()
                              .getSuite())
      ) {
        this.foundationPiles.getPiles().get(pileNumber).addFirst(card_shifting);
      }
    }
    if (destination.equals(PileType.OPEN)) {

    }
    if (destination.equals(PileType.CASCADE)) {
    }
  }

  /**
   * Signal if the game is over or not.
   *
   * @return true if game is over, false otherwise
   */
  @Override
  public boolean isGameOver() {
    return false;
  }

  /**
   * Return the present state of the game as a string. The string is formatted as follows:
   * <pre>
   * F1:[b]f11,[b]f12,[b],...,[b]f1n1[n] (Cards in foundation pile 1 in order)
   * F2:[b]f21,[b]f22,[b],...,[b]f2n2[n] (Cards in foundation pile 2 in order)
   * ...
   * Fm:[b]fm1,[b]fm2,[b],...,[b]fmnm[n] (Cards in foundation pile m in
   * order)
   * O1:[b]o11[n] (Cards in open pile 1)
   * O2:[b]o21[n] (Cards in open pile 2)
   * ...
   * Ok:[b]ok1[n] (Cards in open pile k)
   * C1:[b]c11,[b]c12,[b]...,[b]c1p1[n] (Cards in cascade pile 1 in order)
   * C2:[b]c21,[b]c22,[b]...,[b]c2p2[n] (Cards in cascade pile 2 in order)
   * ...
   * Cs:[b]cs1,[b]cs2,[b]...,[b]csps (Cards in cascade pile s in order)
   *
   * where [b] is a single blankspace, [n] is newline. Note that there is no
   * newline on the last line
   * </pre>
   *
   * @return the formatted string as above
   */
  @Override
  public String getGameState() {
    String gameState="";
    if(hasGameBegun){
      gameState="F1: \n" +
              "F2: \n" +
              "F3: \n" +
              "F4:\n" +
              "O1:\n" +
              "O2:\n" +
              "O3:\n" +
              "O4: \n" +
              "C1: \n" +
              "C2: \n" +
              "C3: \n" +
              "C4: \n" +
              "C5: \n" +
              "C6: \n" +
              "C7: \n" +
              "C8: ";
    }
    else{
      gameState="";

    }
    System.out.print(gameState);
    return gameState;
  }

}
