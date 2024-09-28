package io.project.SpringDemoBot.service;

import com.google.gson.Gson;
import io.project.SpringDemoBot.model.WeatherResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    private static final String WEATHER_API_KEY = "05ce4365ac9bfed1dcdc3b2d8f579cd9";  // Ваш API-ключ
    private static final String WEATHER_API_URL = "http://api.openweathermap.org/data/2.5/weather?q={city}&appid={apikey}&units=metric";

    public String getWeather(String city) {
        RestTemplate restTemplate = new RestTemplate();

        // Формируем URL для запроса
        String url = WEATHER_API_URL.replace("{city}", city).replace("{apikey}", WEATHER_API_KEY);

        try {
            // Получаем JSON-ответ от API
            String response = restTemplate.getForObject(url, String.class);

            // Используем Gson для парсинга JSON
            Gson gson = new Gson();
            WeatherResponse weatherResponse = gson.fromJson(response, WeatherResponse.class);  // Парсим ответ

            // Извлекаем температуру и описание погоды
            double temperature = weatherResponse.getMain().getTemp();
            String description = weatherResponse.getWeather().get(0).getDescription();

            // Форматируем ответ
            return String.format("Текущая температура в %s: %.2f °C (%s)", weatherResponse.getName(), temperature, description);
        } catch (Exception e) {
            return "Не удалось получить данные о погоде: " + e.getMessage();  // Возвращаем сообщение об ошибке
        }
    }
}
