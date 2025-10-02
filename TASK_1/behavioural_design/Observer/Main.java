package TASK_1.behavioural_design.Observer;


    public class Main {
    public static void main(String[] args) {
        System.out.println("--- Observer Pattern Demo ---");
        NewsAgency agency = new NewsAgency();

        NewsChannel channel1 = new NewsChannel("DD national");
        NewsChannel channel2 = new NewsChannel("Aaj Tak");

        // Register observers
        agency.registerObserver(channel1);
        agency.registerObserver(channel2);

        // Subject changes state, notifying observers
        agency.setNews("New AI breakthrough announced");
        
        // Unregister an observer
        agency.removeObserver(channel1);
        
        agency.setNews("Market hits an all-time high");
    }
}

