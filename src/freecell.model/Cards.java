package freecell.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cards implements CardDeck{
  //private
  private CardColor color;
  private String value;
  private List<CardDeck> deck;

  public Cards(){
    this.deck = new ArrayList<>();
  }

  public Cards(String value, CardColor color){
    this.value = value;
    this.deck = new ArrayList<>();
    this.color = color;
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
    System.out.println("here2");

    List<String> card_values = Arrays.asList("A", "2", "3", "4", "5",
            "6", "7", "8", "9", "10", "J", "Q", "K");

    //while (!card_values.isEmpty()) {
    //  this.deck.add(new Hearts(card_values.get(0)));
    //  this.deck.add(new Diamonds(card_values.get(0)));
    // this.deck.add(new Spades(card_values.get(0)));
    // this.deck.add(new Clubs(card_values.get(0)));

//      card_values.remove(0);
    //  }

    for(int i=0; i<card_values.size()-1;i++){
      this.deck.add(new Cards(card_values.get(i), CardColor.RED));
      this.deck.add(new Cards(card_values.get(i), CardColor.RED));
      this.deck.add(new Cards(card_values.get(i), CardColor.BLACK));
      this.deck.add(new Cards(card_values.get(i), CardColor.BLACK));

    }


    return this.deck;
  }
}
