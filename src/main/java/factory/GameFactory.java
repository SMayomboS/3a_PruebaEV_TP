
package factory;

import view.GamePanel;
import view.NQueensPanel;
import view.KnightTourPanel;
import view.HanoiTowerPanel;

public class GameFactory {

    public static GamePanel createGame(String gameType) {
        switch (gameType.toLowerCase()) {
            case "n-queens":
            case "n reinas":
                return new NQueensPanel();
            case "knight's tour":
            case "tour del caballo":
                return new KnightTourPanel();
            case "towers of hanoi":
            case "torres de hanoi":
                return new HanoiTowerPanel();
            default:
                throw new IllegalArgumentException("Unknown game type: " + gameType);
        }
    }
}
