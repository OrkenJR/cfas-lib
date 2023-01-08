package kz.iitu.cfaslib.dto.manufacture;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO для материалов
 *
 * @author Orken
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MaterialDto {

    /**
     * Название материала
     **/
    private String materialName;

    /**
     * ID иконки, наверное сразу буду отправлять byte[] надо обсудить
     **/
    private String iconId;

    /**
     * Краткое описание
     **/
    private String description;
}
