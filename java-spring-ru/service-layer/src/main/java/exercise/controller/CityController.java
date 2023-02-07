package exercise.controller;
import com.fasterxml.jackson.core.JsonProcessingException;
import exercise.CityNotFoundException;
import exercise.model.City;
import exercise.repository.CityRepository;
import exercise.service.WeatherService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.slf4j.MDC.remove;

@RestController
public class CityController {

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private WeatherService weatherService;

    // BEGIN
    @GetMapping(path = "/cities/{id}")
        public Map<String, String> getCity(@PathVariable long id) throws JsonProcessingException {
            City city = cityRepository.findById(id)
                    .orElseThrow(() -> new CityNotFoundException("User not found"));
            return weatherService.getWeather(city);
    }

    @GetMapping(path = "/search")
    public List<Map<String, String>> getList(@RequestParam(defaultValue = "") String name) {
        List<City> cities = cityRepository.findByNameStartingWithIgnoreCaseOrderByName(name);
        List<Map<String, String>> mapList = cities.stream()
                .map(item -> weatherService.getWeather(item))
                .map(item -> {
                    item.remove("cloudy");
                    item.remove("wind");
                    item.remove("humidity");
                    return item;
                })
                .collect(Collectors.toList());
        return mapList;
    }
    // END
}

