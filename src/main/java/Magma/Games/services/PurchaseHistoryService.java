package Magma.Games.services;

import Magma.Games.db.MainRepo;
import Magma.Games.models.Purchase;
import java.util.List;

public class PurchaseHistoryService {

        public List<Purchase> getPurchaseHistory() {
            return MainRepo.getPurchases();
        }
    }

