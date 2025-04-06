//package yash.example.WatherAPI.CentralSchedular;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//import yash.example.WatherAPI.Services.WeatherServices;
//
//@Component
//public class WeatherAPIScheduling {
//
//
//    @Autowired
//    private WeatherServices weatherServices;
//
//
//    @Scheduled(cron = "0 0 * ? * *")
//    public void schedule(){
//
//        weatherServices.getWeatherAPI("Mumbai");
//    }
//}
