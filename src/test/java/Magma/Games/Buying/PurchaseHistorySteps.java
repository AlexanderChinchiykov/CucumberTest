package Magma.Games.Buying;


import Magma.Games.services.PurchaseHistoryService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PurchaseHistorySteps {

        private boolean hasPurchases;

        @Given("потребителят е закупил игри")
        public void userHasPurchasedGames() {
            hasPurchases = true;
        }

        @When("потребителят навигира до страницата с история на покупките")
        public void navigateToPurchaseHistoryPage() {
            // Simulate navigation to purchase history page
        }

        @Then("системата показва списък със закупени игри")
        public void checkPurchaseHistory() {
            PurchaseHistoryService purchaseHistoryService = new PurchaseHistoryService();
            assertFalse(purchaseHistoryService.getPurchaseHistory().isEmpty());
        }
    }
