package TASK_1.structural_design.Adapter;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- Adapter Pattern Demo ---");
        NewWeatherService newApi = new NewWeatherService();
        // The client expects an object of type OldWeatherService
        OldWeatherService adapter = new WeatherAdapter(newApi);

        System.out.println("Client is requesting temperature...");
        // The client uses the old interface, unaware of the new service
        String temperature = adapter.getTemperature();
        System.out.println("Received: " + temperature);
    }
}
