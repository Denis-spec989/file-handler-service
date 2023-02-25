package github.denisspec989.azsservice.service.impl;



import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import github.denisspec989.azsservice.models.JSON;
import github.denisspec989.azsservice.models.PetrolStationDto;
import github.denisspec989.azsservice.service.Converter;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;


public class JSONConverter implements Converter<JSON, Iterable<PetrolStationDto>> {
    @Override
    public Iterable<PetrolStationDto> convert(JSON input) throws IOException {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        stream.write(input.getMultipartFile().getBytes());
        String finalString = new String(stream.toByteArray());
        ArrayList<PetrolStationDto> stations = new ObjectMapper().readValue(finalString, new TypeReference<ArrayList<PetrolStationDto>>() {});
        return stations;
    }

    @Override
    public String getInputType() {
        return JSON.class.getName();
    }

    @Override
    public String getOutputType() {
        return Iterable.class.getName();
    }
}
