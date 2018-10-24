package freecell.model;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public abstract class AbstractCard implements CardDeck{
  private String value;

  public AbstractCard(String value){
    this.value = value;
  }

  @Override
  public String getValue() {
    return this.value;
  }

  @Override
  public List createDeck() {
    List<CardDeck> deck_of_cards = new LinkedList<>();
    List<String> card_values = Arrays.asList("A", "2", "3", "4", "5",
            "6", "7", "8", "9", "10", "J", "Q", "K");

    while (!card_values.isEmpty()) {
      deck_of_cards.add(new Hearts(card_values.get(0)));
      deck_of_cards.add(new Diamonds(card_values.get(0)));
      deck_of_cards.add(new Spades(card_values.get(0)));
      deck_of_cards.add(new Clubs(card_values.get(0)));

      card_values.remove(0);
    }

    return deck_of_cards;
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