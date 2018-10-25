package freecell.model;

import java.util.List;

public interface CardDeck {

  String getValue();

  CardColor getColor();

  String getSuite();

  List createDeck();
}
