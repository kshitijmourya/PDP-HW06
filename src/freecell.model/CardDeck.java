package freecell.model;

import java.util.List;

/**
 *
 */
public interface CardDeck {

  /**
   *
   * @return
   */
  String getValue();

  /**
   *
   * @return
   */
  CardColor getColor();

  /**
   *
   * @return
   */
  String getSuite();

  /**
   *
   * @return
   */
  List<Cards> createDeck();
}
