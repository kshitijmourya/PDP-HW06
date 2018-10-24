package freecell.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class AbstractCard implements CardDeck{
  private String value;
  private List<CardDeck> deck;

  public AbstractCard(){
    this.deck = new ArrayList<>();
  }

  public AbstractCard(String value){
    this.value = value;
    this.deck = new ArrayList<>();
  }

  @Override
  public String getValue() {
    return this.value;
  }

  @Override
  public CardColor getColor() {
    return null;
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
      this.deck.add(new Hearts(card_values.get(i)));
      this.deck.add(new Diamonds(card_values.get(i)));
      this.deck.add(new Spades(card_values.get(i)));
      this.deck.add(new Clubs(card_values.get(i)));

    }


    return this.deck;
  }
}

class Hearts extends AbstractCard {
  private CardColor color;

  public Hearts(String value) {
    super(value);
    this.color = CardColor.RED;
  }

  @Override
  public CardColor getColor() {
    return this.color;
  }
}

class Diamonds extends AbstractCard {
  private CardColor color;

  public Diamonds(String value) {
    super(value);
    this.color = CardColor.RED;
  }

  @Override
  public CardColor getColor() {
    return this.color;
  }
}

class Spades extends AbstractCard {
  private CardColor color;

  public Spades(String value) {
    super(value);
    this.color = CardColor.BLACK;
  }

  @Override
  public CardColor getColor() {
    return this.color;
  }
}

class Clubs extends AbstractCard {
  private CardColor color;

  public Clubs(String value) {
    super(value);
    this.color = CardColor.BLACK;
  }

  @Override
  public CardColor getColor() {
    return this.color;
  }
}