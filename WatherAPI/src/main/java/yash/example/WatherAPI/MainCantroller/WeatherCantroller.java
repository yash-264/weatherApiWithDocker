package yash.example.WatherAPI.MainCantroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import yash.example.WatherAPI.Entity.WeatherEntity;
import yash.example.WatherAPI.Services.WeatherServices;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/weather")
@CrossOrigin(origins = "*") // Enable CORS for frontend access
public class WeatherCantroller {

    @Autowired
    private WeatherServices weatherServices;

    @GetMapping
    public ResponseEntity<?> getWeather(@RequestParam String city) {
        WeatherEntity weatherResponse = weatherServices.getWeatherAPI(city);

        if (weatherResponse == null || weatherResponse.getCurrent() == null) {
            return ResponseEntity.status(404).body("Weather data not found for: " + city);
        }

        WeatherEntity.Current current = weatherResponse.getCurrent();

        
        Map<String, Object> response = new HashMap<>();
        response.put("city", city);
        response.put("temperature", current.getTemperature());
        response.put("feelsLike", current.getFeelslike());
        response.put("code", current.getWeatherCode());
        response.put("condition", current.getWeatherDescriptions() != null && !current.getWeatherDescriptions().isEmpty()
                ? current.getWeatherDescriptions().get(0)
                : "N/A");
        response.put("observationTime", current.getObservationTime());
        response.put("localTime", LocalDateTime.now().toString());

        return ResponseEntity.ok(response);
    }
}
