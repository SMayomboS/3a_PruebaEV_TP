package factory;

import view.GamePanel;
import view.NQueensPanel;
import view.KnightTourPanel;
import view.HanoiTowerPanel;

public class GameFactory {
    public static GamePanel createGame(String gameType) {
        switch (gameType) {
            case "NQueens":
                return new NQueensPanel();
            case "KnightTour":
                return new KnightTourPanel();
            case "HanoiTower":
                return new HanoiTowerPanel();
            default:
                throw new IllegalArgumentException("Unknown game type: " + gameType);
        }
    }
}
