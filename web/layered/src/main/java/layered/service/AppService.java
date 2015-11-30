package layered.service;

import layered.model.City;
import layered.repositories.CityRepository;
import layered.repositories.CountryRepository;
import layered.repositories.LanguageRepository;
import layered.web.CityData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class AppService {
    private final CityRepository cityRepository;
    private final CountryRepository countryRepository;
    private final LanguageRepository languageRepository;

    @Autowired
    public AppService(
            CityRepository cityRepository,
            CountryRepository countryRepository,
            LanguageRepository languageRepository) {
        this.cityRepository = cityRepository;
        this.countryRepository = countryRepository;
        this.languageRepository = languageRepository;
    }

    public List<CityData> getCities(Pageable pageable) {
        return cityRepository.findAll(pageable).getContent().stream()
                .map(this::toData)
                .collect(Collectors.toList());
    }


    public CityData getCityById(Long id) {
        City city = cityRepository.getOne(id);
        CityData cityData = toData(city);
        return cityData;
    }

    public void updateCity(Long id, CityData cityData) {
        City city = cityRepository.getOne(id);
        city.setName(cityData.getName());
        cityRepository.save(city);
    }

    private CityData toData(City city) {
        CityData cityData = new CityData();
        cityData.setId(city.getId());
        cityData.setName(city.getName());
        cityData.setCountry(city.getCountry().getName());
        cityData.setDistrict(city.getDistrict());
        cityData.setPopulation(city.getPopulation());
        return cityData;
    }
}
