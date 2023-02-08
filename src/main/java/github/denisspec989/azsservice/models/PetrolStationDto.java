package github.denisspec989.azsservice.models;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import lombok.*;

import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PetrolStationDto {
    private String      azsId;
    private Double      latitude;
    private Double      longitude;
    private String      telephone;
    private String      azsName;
    private String      azsAddress;
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<PriceModelDto> priceModelList;
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<ServiceModelDto> serviceModelList;
}
