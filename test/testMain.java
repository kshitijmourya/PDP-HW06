import java.util.List;

import freecell.model.FreecellModel;
import freecell.model.PileType;

public class testMain {

  public static void main(String[] args) {

    helper(FreecellModel
            .getBuilder()
            .cascades(8)
            .opens(4)
            .build());

  }
  private static <T> void helper(freecell.model.FreecellOperations<T> model) {
    List<T> deck = model.getDeck();
    model.startGame(deck, false);
    //model.getGameState();
    model.move(PileType.CASCADE, 0, 6, PileType.CASCADE, 2);

  }
}
