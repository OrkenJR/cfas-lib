package kz.iitu.cfaslib.dto.manufacture;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO для market
 *
 * @author Orken
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MarketMaterialDto {
    private String id;

    private String name;

    private Double price;

    private String icon;

    private String country;
}
