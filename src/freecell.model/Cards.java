package freecell.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cards implements CardDeck{
  private String suite;
  private CardColor color;
  private String value;
  private List<CardDeck> deck;

  Cards(){
    this.deck = new ArrayList<>();
  }

  private Cards(String value, CardColor color, String suite){
    this.suite = suite;
    this.value = value;
    this.deck = new ArrayList<>();
    this.color = color;
  }

  @Override
  public String getSuite() {
    return this.suite;
  }

  @Override
  public String getValue() {
    return this.value;
  }

  @Override
  public CardColor getColor() {
    return this.color;
  }

  @Override
  public List createDeck() {
    List<String> card_values = Arrays.asList("A", "2", "3", "4", "5",
            "6", "7", "8", "9", "10", "J", "Q", "K");

    for(int i=0; i<card_values.size()-1;i++){
      this.deck.add(new Cards(card_values.get(i), CardColor.RED,"♥"));
      this.deck.add(new Cards(card_values.get(i), CardColor.RED,"♦"));
      this.deck.add(new Cards(card_values.get(i), CardColor.BLACK, "♠"));
      this.deck.add(new Cards(card_values.get(i), CardColor.BLACK, "♣"));
    }
    return this.deck;
  }
}
