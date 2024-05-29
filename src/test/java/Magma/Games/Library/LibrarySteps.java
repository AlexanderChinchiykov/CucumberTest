package Magma.Games.Library;
import Magma.Games.models.Game;
import Magma.Games.services.LibraryService;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

import static org.junit.Assert.*;

public class LibrarySteps {


    private String gameName;
    private List<String> gameNames;


    private final LibraryService libraryService = new LibraryService();
    private GameLibraryHelper helperModel;

    public LibrarySteps(GameLibraryHelper helperModel) {
        this.helperModel = helperModel;
    }


    @Given("отваряне на приложението")
    public void openApp() {
    }

    @When("потребителят добавя нова игра с име {string}")
    public void addGameToLibrary(String gameName) {
        libraryService.addGameToLibrary(gameName);
    }

    @Then("системата трябва да добави играта {string} в библиотеката")
    public void systemAddsGameToLibrary(String gameName) {
        assertTrue("Game should be in the library", libraryService.isGameInLibrary(gameName));
    }

    @Given("потребителят има игра с име {string} в библиотеката")
    public void userHasGameInLibrary(String gameName) {
        this.gameName = gameName;
    }

    @When("потребителят премахва играта {string} от библиотеката")
    public void userRemovesGameFromLibrary(String gameName) {
        libraryService.removeGameFromLibrary(gameName);
    }

    @Then("системата не трябва да съдържа играта {string} в библиотеката")
    public void systemShouldNotContainGameInLibrary(String gameName) {
        assertFalse("Game should not be in the library", libraryService.isGameInLibrary(gameName));
    }

    @When("потребителят навигира до секцията с библиотеката с игри")
    public void navigateToLibrarySection() {
        // No action needed for this step
    }

    @Then("системата трябва да покаже списък с игри в библиотеката")
    public void systemShowsListOfGames() {
        List<Game> gameList = libraryService.getAllGames();
        assertNotNull("Game list should not be null", gameList);
        assertFalse("Game list should not be empty", gameList.isEmpty());
    }

    @When("потребителят кликва върху играта {string} в библиотеката")
    public void userClicksOnGame(String gameName) {
        helperModel.setSelectedGame(libraryService.getGameByName(gameName));
    }

    @Then("системата трябва да покаже детайли за играта {string}")
    public void systemShowsGameDetails(String gameName) {
        this.gameName=gameName;
    }

    @When("потребителят търси за игра с име {string} в библиотеката")
    public void userSearchesForGame(String gameName) {
        helperModel.setSearchResult(libraryService.searchForGame(gameName));
    }

    @Then("системата трябва да покаже играта {string} в резултатите от търсенето")
    public void systemShowsGameInSearchResults(String gameName) {
        this.gameName=gameName;
    }



    @Given("потребителят има следните игри в библиотеката:")
    public void LibraryGames(List<String> gameNames) {

        this.gameNames=gameNames;
    }

}

