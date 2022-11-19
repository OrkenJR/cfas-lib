package kz.iitu.cfaslib.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;


/**
 * DTO для аггрегации склада с материалом
 *
 * @author Orken
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MatWarAggregationDto {

    /**
     * Материал
     **/
    private MaterialDto material;

    /**
     * Доступное кол-во
     **/
    private Double amount;

    /**
     * Департмент:процент материала
     **/
    private Map<String, Double> departmentShare;

}
