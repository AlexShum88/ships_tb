package com.shum.ships_tb.gameObj.interfaces;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shum.ships_tb.gameObj.Cargo;

import java.io.IOException;

public interface CanWorkWightJson {

    default String serialize(Object toSerializate) throws JsonParseException, JsonMappingException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(toSerializate);
    }

    default Object deserializeToArray(String jsonString) throws JsonParseException, JsonMappingException, IOException {
            ObjectMapper mapper = new ObjectMapper();
            Cargo[] asArray = mapper.readValue(jsonString, Cargo[].class);
            return asArray;
    }
}
