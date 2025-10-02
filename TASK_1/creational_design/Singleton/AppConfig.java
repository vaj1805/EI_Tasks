package Singleton;

public class AppConfig {
    private static AppConfig instance;
    private String serverUrl;

    private AppConfig() {
        this.serverUrl = "https://api.example.com";
        System.out.println("AppConfig initialized. Server URL : " + this.serverUrl);
    }

    public static synchronized AppConfig getInstance() {
        if(instance == null) {
            instance = new AppConfig();
        }
        return instance;
    }

    public String getServerUrl() {
        return this.serverUrl;
    }

}

