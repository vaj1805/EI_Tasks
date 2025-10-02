package TASK_1.structural_design.Adapter;

public class WeatherAdapter implements OldWeatherService {
    private NewWeatherService newService;

    public WeatherAdapter(NewWeatherService newService) {
        this.newService = newService;
    }

       @Override
    public String getTemperature() {
        // 1. Call the new service to get the temperature.
        double tempF = newService.fetchTemperatureFahrenheit();

        // 2. Convert the double to a String (and add units for clarity).
        double tempC = (tempF-32)*5/9;

        // 3. Return the adapted string result.
        return String.format("%.1f C", tempC);
    }


}
