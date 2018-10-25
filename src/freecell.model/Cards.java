package freecell.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 */
public class Cards implements CardDeck{
  private String suite;
  private CardColor color;
  private String value;

  /**
   *
   */
  Cards(){
  }

  /**
   *
   * @param value
   * @param color
   * @param suite
   */
  private Cards(String value, CardColor color, String suite){
    this.suite = suite;
    this.value = value;
    this.color = color;
  }

  /**
   *
   * @return
   */
  @Override
  public String getSuite() {
    return this.suite;
  }

  /**
   *
   * @return
   */
  @Override
  public String getValue() {
    return this.value;
  }

  /**
   *
   * @return
   */
  @Override
  public CardColor getColor() {
    return this.color;
  }

  /**
   *
   * @return
   */
  @Override
  public List<Cards> createDeck() {
    List<String> card_values = Arrays.asList("A", "2", "3", "4", "5",
            "6", "7", "8", "9", "10", "J", "Q", "K");
    List<Cards> deck = new ArrayList<>();
    for(int i = 0; i < card_values.size(); i++) {
      deck.add(new Cards(card_values.get(i), CardColor.RED,"♥"));
      deck.add(new Cards(card_values.get(i), CardColor.RED,"♦"));
      deck.add(new Cards(card_values.get(i), CardColor.BLACK, "♠"));
      deck.add(new Cards(card_values.get(i), CardColor.BLACK, "♣"));
    }
    return deck;
  }
}
