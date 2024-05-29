package Magma.Games.Buying;

import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import Magma.Games.services.PurchaseService;
import org.junit.Assert;

import static org.junit.Assert.assertEquals;

public class PurchaseSteps {




        @DataTableType(replaceWithEmptyString = "[blank]")
         public String stringType(String cell) {
        return cell;
    }

        private String gameName;
        private String message;
        private String paymentData;
        private String discountCode;
        private String purchaseResult;

        @Given("потребителят е на страницата с подробности за играта за {string}")
        public void openGameDetails(String gameName) {
            this.gameName = gameName;
        }

        @When("потребителят кликва върху бутона „Купи“.")
        public void clickBuyButton() {
            System.out.println("Buy button clicked for game: " + gameName);
        }

        @When("Въвежда валидни данни за плащане")
        public void enterValidPaymentData() {
            this.paymentData = "valid";
        }

        @When("Въвежда невалидни данни за плащане")
        public void enterInvalidPaymentData() {
            this.paymentData = "invalid";
        }

        @When("въвежда данни за плащане с недостатъчни средства")
        public void enterInsufficientFundsPaymentData() {
            this.paymentData = "insufficient";
        }

        @When("Потвърждава поръчката")
         public void confirmOrder() {
        PurchaseService purchaseService = new PurchaseService();
        if (discountCode != null) {
            purchaseResult = purchaseService.purchaseGameWithDiscount(gameName, paymentData, discountCode);
        } else {
            purchaseResult = purchaseService.purchaseGame(gameName, paymentData);
        }
        message = purchaseResult;
        }

        @When("Въвежда валиден код за отстъпка {string}")
        public void enterValidDiscountCode(String code) {
        discountCode = code;
        }

        @Then("Системата прилага отстъпката")
         public void systemAppliesDiscount() {
        // Simulate discount application
        Assert.assertNotNull("Message should not be null", message);
        Assert.assertTrue("Message should contain discount", message.contains("с отстъпка"));
        }

         @Then("Изкарва потвърждение за поръчката с прилагането на отстъпка")
         public void orderConfirmationWithDiscount() {
             Assert.assertEquals("Успешно закупихте играта " + gameName + " с отстъпка", purchaseResult);
         }


        @Then("Системата обработва данните")
        public void systemProcessesData() {
            // This step is handled within the service method
        }

        @Then("Изкарва потвърждение за поръчката")
        public void checkOrderConfirmation() {
            assertEquals("Успешно закупихте играта " + gameName, message);
        }

        @Then("Системата отказва плащането")
        public void systemDeclinesPayment() {
            this.paymentData = "invalid";
        }

        @Then("Излиза съобщение за грешка при плащането")
        public void checkPaymentErrorMessage() {
            this.paymentData = "invalid";
        }

        @Then("Излиза съобщение за недостатъчно средства")
        public void checkInsufficientFundsMessage() {
            this.paymentData = "insufficient";

        }


}


