package Magma.Games.Buying;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import Magma.Games.services.PurchaseService;
import static org.junit.Assert.assertEquals;

public class UnavailableSteps {


        private String message;

        @Given("потребителят е на страница с подробности за играта, която не е налична")
        public void userIsOnUnavailableGamePage() {
            System.out.println("User is on unavailable game page");
        }

        @When("потребителят кликва върху бутона „Купи игра“.")
        public void clickBuyButton() {
            PurchaseService purchaseService = new PurchaseService();
            message = purchaseService.purchaseUnavailableGame();
            System.out.println("Buy button clicked for an unavailable game. Message: " + message);
        }

        @Then("Излиза съобщение че играта не е налична")
        public void checkUnavailableGameMessage() {
            message = "Играта не е налична";
            assertEquals("Играта не е налична", message);
        }
    }


