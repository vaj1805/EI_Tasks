package TASK_1.behavioural_design.Observer;
import java.util.*;

public class NewsAgency implements Subject{
    private List<Observer> observers = new ArrayList<>();
    private String news;

    public void setNews(String news) {
        this.news = news;
        System.out.println("\nNews Agency : breaking news" + news + "!!");
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for(Observer observer : observers) {
            observer.update(news);
        }
    }


}
