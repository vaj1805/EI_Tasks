package Singleton;
public class Main {
    public static void main(String[] args) {
        System.out.println("-----Singleton Pattern demo------");

        AppConfig config1 = AppConfig.getInstance();
        AppConfig config2 = AppConfig.getInstance();

        if(config1 == config2) {
            System.out.println("Both config 1 and 2 have same instances");
            System.out.println("Server URL from config1: " + config1.getServerUrl());
            System.out.println("Server URL from config2: " + config2.getServerUrl());
        }
    }   
}
