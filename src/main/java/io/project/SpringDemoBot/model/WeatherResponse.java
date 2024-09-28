package io.project.SpringDemoBot.model;

import lombok.Getter;
import java.util.List;

@Getter
public class WeatherResponse {
    private String name; // Название города
    private List<Weather> weather; // Массив объектов погоды
    private Main main; // Основные параметры (температура и т.д.)

    @Getter
    public static class Weather {
        private String description; // Подробное описание погоды
    }

    @Getter
    public static class Main {
        private double temp; // Температура
    }
}
