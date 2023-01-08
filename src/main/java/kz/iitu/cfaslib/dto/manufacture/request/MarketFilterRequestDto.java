package kz.iitu.cfaslib.dto.manufacture.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO для фильтра market
 *
 * @author Orken
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MarketFilterRequestDto {
    private String name;

    private Double min;

    private Double max;

    private String icon;

    private String country;
}
