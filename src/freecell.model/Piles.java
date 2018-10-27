package freecell.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Piles implements CardPiles {
  private PileType type;
  private int pileCount;
  private List<LinkedList<Cards>> piles;

  /**
   *
   * @param pileCount
   * @param type
   */
  public Piles(int pileCount, PileType type){
    this.pileCount = pileCount;
    this.type = type;
    this.piles = new ArrayList<LinkedList<Cards>>();

    for (int i = 0; i < pileCount; i++) {
      this.piles.add(new LinkedList<Cards>());
    }
  }

  /**
   *
   * @return
   */
  public PileType getType(){
    return this.type;
  }

  /**
   *
   * @return
   */
  public List<LinkedList<Cards>> getPiles(){
    return this.piles;
  }
}
