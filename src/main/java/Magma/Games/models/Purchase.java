package Magma.Games.models;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Purchase {
    private Long gameId;
    private String paymentData;
}