package freecell.model;

import java.util.LinkedList;
import java.util.List;

/**
 *
 */
public interface CardPiles {

  /**
   *
   * @return
   */
  PileType getType();

  /**
   *
   * @return
   */
  List<LinkedList<Cards>> getPiles();
}
