package Magma.Games.db;
import Magma.Games.models.Game;
import Magma.Games.models.Purchase;

import java.util.ArrayList;
import java.util.List;

public class MainRepo {

    public static List<Game> games = new ArrayList<>();
    public static List<Purchase> purchases = new ArrayList<>();

    static {
        Game game1 = new Game(1L, "Adventure Quest", "Action", 59.99, true);
        Game game2 = new Game(2L, "Battle Royale", "Action", 59.99, true);
        Game game3 = new Game(3L, "Adventure Quest", "Action", 59.99, true);
        games.add(game1);
        games.add(game2);
        games.add(game3);
    }

    public static List<Game> getGames() {
        return games;
    }

    public static List<Purchase> getPurchases() {
        return purchases;
    }

}
