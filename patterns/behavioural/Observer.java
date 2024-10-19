package patterns.behavioural;
import java.util.ArrayList;
import java.util.List;

/*
 * Observer: facilitates a subscription mechanism to allow multiple objects to listen
 * and react to events occuring in other objects
 */

interface Observer {
    public void update(String msg);
}

interface Subject {
    public void addObserver(Observer observer);
    public void removeObserver(int idx);
    public void updateAllObserver();
}

class YouTubeChannel implements Subject {
    List<Observer> list = new ArrayList<>();

    @Override
    public void addObserver(Observer observer) {
        list.add(observer);
    }

    @Override
    public void removeObserver(int idx) {
        list.remove(idx);
    }

    @Override
    public void updateAllObserver() {
        for (Observer observer: list) {
            observer.update("new video uploaded");
        }
    }

    public void uploadVideo() {
        System.out.println("upload successful");
        this.updateAllObserver();
    }
}

interface Viewer {
    public String getName();
}

class Rakib implements Observer, Viewer {
    @Override
    public void update(String msg) {
        System.out.printf("%s: watching new video", this.getName());
    }

    @Override
    public String getName() {
        return "Rakib";
    }
}

class Abhinav implements Observer, Viewer  {
    @Override
    public void update(String msg) {
        System.out.printf("%s: watching new video", this.getName());
    }

    @Override
    public String getName() {
        return "Abhinav";
    }
}

class Main {
    public static void main(String[] args) {
        YouTubeChannel channel = new YouTubeChannel();

        Observer rakib = new Rakib();
        Observer abhinav = new Abhinav();

        channel.addObserver(rakib);
        channel.addObserver(abhinav);

        channel.uploadVideo();
    }
}