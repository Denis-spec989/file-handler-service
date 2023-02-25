package github.denisspec989.azsservice.config;

import github.denisspec989.azsservice.models.JSON;
import github.denisspec989.azsservice.models.PetrolStationDto;
import github.denisspec989.azsservice.models.XML;
import github.denisspec989.azsservice.service.Converter;
import github.denisspec989.azsservice.service.impl.JSONConverter;
import github.denisspec989.azsservice.service.impl.XMLConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
@Lazy(value = false)
public class BeanConfig {
    @Bean
    public Converter<JSON, Iterable<PetrolStationDto>> getJSONConverter(){
        return new JSONConverter();
    }
    @Bean
    public Converter<XML, Iterable<PetrolStationDto>> getXMLConverter(){
        return new XMLConverter();
    }
}
