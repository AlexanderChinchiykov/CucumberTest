package Magma.Games.Library;

import Magma.Games.models.Game;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GameLibraryHelper {
    private Game selectedGame;
    private List<String> searchResult;
}
