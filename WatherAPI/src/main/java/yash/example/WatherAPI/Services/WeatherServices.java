package yash.example.WatherAPI.Services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import yash.example.WatherAPI.Entity.WeatherEntity;

@Component
public class WeatherServices {



    @Value("${weather.api.key}")

    private String APIKEY;                       // we can use this for hiding apikey

//    private static final String APIKEY="f0f3c10a125809061b329d023cd607cc";


    private static final String API="http://api.weatherstack.com/current?access_key=API_KEY&query=CITY";

    @Autowired
    private RestTemplate restTemplate;


    public WeatherEntity getWeatherAPI(String city){

        String finalAPI=API.replace("API_KEY",APIKEY).replace("CITY",city);

        ResponseEntity<WeatherEntity> response = restTemplate.exchange(finalAPI, HttpMethod.GET, null, WeatherEntity.class);

        WeatherEntity body=response.getBody();

        return body;

    }


}
