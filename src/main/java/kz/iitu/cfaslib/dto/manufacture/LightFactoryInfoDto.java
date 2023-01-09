package kz.iitu.cfaslib.dto.manufacture;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO для заводов
 *
 * @author Orken
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LightFactoryInfoDto {
    private String id;

    private String name;

    private Integer number;

    private String director;
}
