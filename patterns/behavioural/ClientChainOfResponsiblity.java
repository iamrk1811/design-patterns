package patterns.behavioural;

/*
 * Chain of Responsiblity: lets you pass requests along a chain of handlers
 */

// 1. Handler interface
interface SupportHandler {
    void setNextHandler(SupportHandler handler);
    void handleRequest(String difficulty);
}

// 2. Concrete Handlers
class BasicSupportHandler implements SupportHandler {
    private SupportHandler nextHandler;

    @Override
    public void setNextHandler(SupportHandler handler) {
        this.nextHandler = handler;
    }

    @Override
    public void handleRequest(String difficulty) {
        if (difficulty.equals("easy")) {
            System.out.println("Basic Support: Handling easy request.");
        } else if (nextHandler != null) {
            nextHandler.handleRequest(difficulty);
        }
    }
}

class AdvancedSupportHandler implements SupportHandler {
    private SupportHandler nextHandler;

    @Override
    public void setNextHandler(SupportHandler handler) {
        this.nextHandler = handler;
    }

    @Override
    public void handleRequest(String difficulty) {
        if (difficulty.equals("medium")) {
            System.out.println("Advanced Support: Handling medium request.");
        } else if (nextHandler != null) {
            nextHandler.handleRequest(difficulty);
        }
    }
}

class ExpertSupportHandler implements SupportHandler {
    private SupportHandler nextHandler;

    @Override
    public void setNextHandler(SupportHandler handler) {
        this.nextHandler = handler;
    }

    @Override
    public void handleRequest(String difficulty) {
        if (difficulty.equals("hard")) {
            System.out.println("Expert Support: Handling hard request.");
        } else if (nextHandler != null) {
            nextHandler.handleRequest(difficulty);
        } else {
            System.out.println("Support: Difficulty level out of scope.");
        }
    }
}

public class ClientChainOfResponsiblity {
    public static void main(String[] args) {
        // Setting up the chain
        SupportHandler basic = new BasicSupportHandler();
        SupportHandler advanced = new AdvancedSupportHandler();
        SupportHandler expert = new ExpertSupportHandler();

        basic.setNextHandler(advanced);
        advanced.setNextHandler(expert);

        // Sending requests
        basic.handleRequest("easy");    // Handled by Basic Support
        basic.handleRequest("medium");  // Handled by Advanced Support
        basic.handleRequest("hard");    // Handled by Expert Support
        basic.handleRequest("unknown"); // Out of scope
    }
}
