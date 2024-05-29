package Magma.Games.services;
import Magma.Games.db.MainRepo;
import Magma.Games.models.Game;
import Magma.Games.models.Purchase;


public class PurchaseService {


    public String purchaseGame(String gameName, String paymentData) {
        Game game = MainRepo.getGames().stream()
                .filter(g -> g.getName().equals(gameName))
                .findFirst()
                .orElse(null);

        if (game == null) {
            return "Играта не е налична";
        }

        if ("invalid".equals(paymentData)) {
            return "Грешка при плащането";
        }

        if ("insufficient".equals(paymentData)) {
            return "Недостатъчно средства";
        }

        Purchase purchase = new Purchase(game.getId(), paymentData);
        MainRepo.getPurchases().add(purchase);
        return "Успешно закупихте играта " + gameName;
    }

    public String purchaseUnavailableGame() {

        return "Играта не е налична";
    }

    public String purchaseGameWithDiscount(String gameName, String paymentData, String discountCode) {
        Game game = MainRepo.getGames().stream()
                .filter(g -> g.getName().equals(gameName))
                .findFirst()
                .orElse(null);


        if (!"DISCOUNT10".equals(discountCode)) {
            return "Невалиден код за отстъпка";
        }

        Purchase purchase = new Purchase(game.getId(), paymentData);
        MainRepo.getPurchases().add(purchase);
        return "Успешно закупихте играта " + gameName + " с отстъпка";
    }

}



