package Structural_Design_Pattern.Proxy_Pattern;

import java.util.ArrayList;
import java.util.List;

interface Internet{
    public void connectToInternet(String serverHost) throws Exception;
}

class RealInternet implements Internet{

    @Override
    public void connectToInternet(String serverHost) {
        System.out.println("Connecting to " + serverHost);
    }
}

class ProxyInternet implements Internet{

    private RealInternet realInternet;

    private static List<String> bannedSites = new ArrayList<>();

    static {
        bannedSites.add("bannedsite.com");
        bannedSites.add("malicious.com");
        bannedSites.add("socialmedia.com");
    }

    @Override
    public void connectToInternet(String serverHost) throws Exception {
        if(bannedSites.contains(serverHost)) {
            throw new Exception("Access Denied to "+serverHost);
        }
        realInternet.connectToInternet(serverHost);
    }
}


public class ProxyPatternExample {
    public static void main(String[] args) {
        Internet internet = new ProxyInternet();

        try {
            internet.connectToInternet("example.com");
            internet.connectToInternet("bannedsite.com");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
