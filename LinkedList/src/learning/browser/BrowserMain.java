package learning.browser;

public class BrowserMain {
    public static void main(String[] args) {
        BrowserHistory browserHistory = new BrowserHistory("www.google.com");
        System.out.println("Current URL: " + browserHistory.getCurrentUrl());
        browserHistory.visit("www.facebook.com");
        System.out.println("Visited: www.facebook.com");
        System.out.println("Current URL: " + browserHistory.getCurrentUrl());
        browserHistory.visit("www.twitter.com");
        System.out.println("Visited: www.twitter.com");
        System.out.println("Current URL: " + browserHistory.getCurrentUrl());
        System.out.println("Back 1 step: " + browserHistory.back(1));
        System.out.println("Current URL: " + browserHistory.getCurrentUrl());
        System.out.println("Forward 1 step: " + browserHistory.forward(1));
        System.out.println("Current URL: " + browserHistory.getCurrentUrl());
        System.out.println("Back 2 steps: " + browserHistory.back(2));
        System.out.println("Current URL: " + browserHistory.getCurrentUrl());
        System.out.println("Forward 2 steps: " + browserHistory.forward(2));
        System.out.println("Current URL: " + browserHistory.getCurrentUrl());
        browserHistory.visit("www.linkedin.com");
        System.out.println("Visited: www.linkedin.com");
        System.out.println("Current URL: " + browserHistory.getCurrentUrl());
    }
}
