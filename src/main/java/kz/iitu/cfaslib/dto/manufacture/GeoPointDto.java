package kz.iitu.cfaslib.dto.manufacture;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO для координатов
 *
 * @author Orken
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GeoPointDto {
    private Double longitude;
    private Double latitude;
}
