package kz.iitu.cfaslib.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * DTO для запроса
 *
 * @author Orken
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MatWarRequestDto {

    private String name;

    private List<String> department;

    private Integer min;

    private Integer max;

}
