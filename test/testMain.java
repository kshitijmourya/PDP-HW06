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
    //System.out.print(model.getGameState());
    //System.out.println("**********************************************************");

    model.move(PileType.CASCADE, 0, 1, PileType.FOUNDATION, 0);
    model.move(PileType.CASCADE, 1, 1, PileType.FOUNDATION, 1);
    model.move(PileType.CASCADE, 2, 1, PileType.FOUNDATION, 2);
    model.move(PileType.CASCADE, 3, 1, PileType.FOUNDATION, 3);
    //System.out.println(model.getGameState());
    model.move(PileType.CASCADE, 4, 2, PileType.FOUNDATION, 0);
    model.move(PileType.CASCADE, 5, 2, PileType.FOUNDATION, 1);
    model.move(PileType.CASCADE, 6, 2, PileType.FOUNDATION, 2);
    model.move(PileType.CASCADE, 7, 2, PileType.FOUNDATION, 3);

    model.move(PileType.CASCADE, 0, 3, PileType.FOUNDATION, 0);
    model.move(PileType.CASCADE, 1, 3, PileType.FOUNDATION, 1);
    model.move(PileType.CASCADE, 2, 3, PileType.FOUNDATION, 2);
    model.move(PileType.CASCADE, 3, 3, PileType.FOUNDATION, 3);

    model.move(PileType.CASCADE, 4, 4, PileType.FOUNDATION, 0);
    model.move(PileType.CASCADE, 5, 4, PileType.FOUNDATION, 1);
    model.move(PileType.CASCADE, 6, 4, PileType.FOUNDATION, 2);
    model.move(PileType.CASCADE, 7, 4, PileType.FOUNDATION, 3);

    model.move(PileType.CASCADE, 0, 5, PileType.FOUNDATION, 0);
    model.move(PileType.CASCADE, 1, 5, PileType.FOUNDATION, 1);
    model.move(PileType.CASCADE, 2, 5, PileType.FOUNDATION, 2);
    model.move(PileType.CASCADE, 3, 5, PileType.FOUNDATION, 3);

    model.move(PileType.CASCADE, 4, 6, PileType.FOUNDATION, 0);
    model.move(PileType.CASCADE, 5, 6, PileType.FOUNDATION, 1);
    model.move(PileType.CASCADE, 6, 6, PileType.FOUNDATION, 2);
    model.move(PileType.CASCADE, 7, 6, PileType.FOUNDATION, 3);

    model.move(PileType.CASCADE, 0, 7, PileType.FOUNDATION, 0);
    model.move(PileType.CASCADE, 1, 7, PileType.FOUNDATION, 1);
    model.move(PileType.CASCADE, 2, 7, PileType.FOUNDATION, 2);
    model.move(PileType.CASCADE, 3, 7, PileType.FOUNDATION, 3);

    model.move(PileType.CASCADE, 4, 8, PileType.FOUNDATION, 0);
    model.move(PileType.CASCADE, 5, 8, PileType.FOUNDATION, 1);
    model.move(PileType.CASCADE, 6, 8, PileType.FOUNDATION, 2);
    model.move(PileType.CASCADE, 7, 8, PileType.FOUNDATION, 3);

    model.move(PileType.CASCADE, 0, 9, PileType.FOUNDATION, 0);
    model.move(PileType.CASCADE, 1, 9, PileType.FOUNDATION, 1);
    model.move(PileType.CASCADE, 2, 9, PileType.FOUNDATION, 2);
    model.move(PileType.CASCADE, 3, 9, PileType.FOUNDATION, 3);

    model.move(PileType.CASCADE, 4, 10, PileType.FOUNDATION, 0);
    model.move(PileType.CASCADE, 5, 10, PileType.FOUNDATION, 1);
    model.move(PileType.CASCADE, 6, 10, PileType.FOUNDATION, 2);
    model.move(PileType.CASCADE, 7, 10, PileType.FOUNDATION, 3);

    model.move(PileType.CASCADE, 0, 11, PileType.FOUNDATION, 0);
    model.move(PileType.CASCADE, 1, 11, PileType.FOUNDATION, 1);
    model.move(PileType.CASCADE, 2, 11, PileType.FOUNDATION, 2);
    model.move(PileType.CASCADE, 3, 11, PileType.FOUNDATION, 3);

    model.move(PileType.CASCADE, 4, 12, PileType.FOUNDATION, 0);
    model.move(PileType.CASCADE, 5, 12, PileType.FOUNDATION, 1);
    model.move(PileType.CASCADE, 6, 12, PileType.FOUNDATION, 2);
    model.move(PileType.CASCADE, 7, 12, PileType.FOUNDATION, 3);

    model.move(PileType.CASCADE, 0, 13, PileType.FOUNDATION, 0);
    model.move(PileType.CASCADE, 1, 13, PileType.FOUNDATION, 1);
    model.move(PileType.CASCADE, 2, 13, PileType.FOUNDATION, 2);
    model.move(PileType.CASCADE, 3, 13, PileType.FOUNDATION, 3);


/*
    model.move(PileType.CASCADE, 4, 2, PileType.FOUNDATION, 0);
    model.move(PileType.CASCADE, 5, 2, PileType.FOUNDATION, 1);
    model.move(PileType.CASCADE, 6, 2, PileType.FOUNDATION, 2);
    model.move(PileType.CASCADE, 7, 2, PileType.FOUNDATION, 3);
*/



/*
    for (int i = 0; i < 8; i++) {
      for (int j = 0; j < 4; j++) {
        for (int k = 3; k < 14;k=k+3) {
          model.move(PileType.CASCADE, i,k, PileType.FOUNDATION, j);
          model.move(PileType.CASCADE, i, k-1, PileType.FOUNDATION, j);
        }
      }
    }
*/
    System.out.print(model.getGameState());

  }
}
