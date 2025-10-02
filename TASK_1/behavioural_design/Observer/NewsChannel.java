package TASK_1.behavioural_design.Observer;

public class NewsChannel implements Observer{
    private String channelName;

    public NewsChannel(String name) {
        this.channelName = name;
    }

    @Override
    public void update(String news) {
        System.out.println(channelName + " received news: " + news);
    }
}
