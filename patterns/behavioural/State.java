package patterns.behavioural;

/*
 * State: allows an object to alter its behaviour based on its internal state changes
 */

interface State {
    void play();
    void pause();
    void stop();
}

class PlayingState implements State {
    @Override
    public void play() {
        System.out.println("Already playing.");
    }

    @Override
    public void pause() {
        System.out.println("Pausing the media.");
    }

    @Override
    public void stop() {
        System.out.println("Stopping the media.");
    }
}

class PausedState implements State {
    @Override
    public void play() {
        System.out.println("Resuming play.");
    }

    @Override
    public void pause() {
        System.out.println("Already paused.");
    }

    @Override
    public void stop() {
        System.out.println("Stopping from paused state.");
    }
}

class StoppedState implements State {
    @Override
    public void play() {
        System.out.println("Starting play.");
    }

    @Override
    public void pause() {
        System.out.println("Can't pause. Media is stopped.");
    }

    @Override
    public void stop() {
        System.out.println("Already stopped.");
    }
}

class MediaPlayer {
    private State currentState;

    MediaPlayer() {
        this.currentState = new StoppedState();
    }

    private void setState(State state) {
        this.currentState = state;
    }

    public void play() {
        this.currentState.play();
        this.setState(new PlayingState());
    }

    public void pause() {
        this.currentState.pause();
        this.setState(new PausedState());
    }

    public void stop() {
        this.currentState.stop();
        this.setState(new StoppedState());
    }
}


class ClientState {
    public static void main(String[] args) {
        MediaPlayer player = new MediaPlayer();

        player.play();
        player.pause();
        player.play();
        player.stop();
    }
}
