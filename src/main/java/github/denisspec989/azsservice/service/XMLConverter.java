package github.denisspec989.azsservice.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import github.denisspec989.azsservice.models.JSON;
import github.denisspec989.azsservice.models.PetrolStationDto;
import github.denisspec989.azsservice.models.XML;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;

@Service
public class XMLConverter implements Converter<XML, Iterable<PetrolStationDto>> {
    @Override
    public Iterable<PetrolStationDto> convert(XML input) throws IOException {
        XmlMapper xmlMapper = new XmlMapper();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        stream.write(input.getMultipartFile().getBytes());
        String finalString = new String(stream.toByteArray());
        ArrayList<PetrolStationDto> stations = xmlMapper.readValue(finalString,new TypeReference<ArrayList<PetrolStationDto>>() {});
        return stations;
    }


    @Override
    public String getInputType() {
        return XML.class.getName();
    }

    @Override
    public String getOutputType() {
        return Iterable.class.getName();
    }
}
