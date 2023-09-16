package com.brandon.resttemplate.mapper;

import com.brandon.resttemplate.dto.DataDTO;
import com.brandon.resttemplate.model.Data;
import lombok.experimental.UtilityClass;

@UtilityClass
public class DataMapper {

    public DataDTO buildDataDTO(Data data) {
        return new DataDTO(data.getId(), data.getValue());
    }

}
