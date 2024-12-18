package Creational_Design_Pattern.Singleton_pattern;

class AppSettings{

    private String databaseUrl;

    private String apiKey;

    public AppSettings() {
        this.databaseUrl = "jdbc:mysql://127.0.0.1:3306/myDB";
        this.apiKey = "myKey123";
    }

    public String getDatabaseUrl() {
        return databaseUrl;
    }

    public void setDatabaseUrl(String databaseUrl) {
        this.databaseUrl = databaseUrl;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }
}


public class WithoutSingletonPattern {
    public static void main(String[] args) {
        //We are able to create multiple objects with the same kind of repetitive data
        AppSettings appSettings1 = new AppSettings();
        AppSettings appSettings2 = new AppSettings();

        //same data
        System.out.println(appSettings1.getDatabaseUrl());
        System.out.println(appSettings2.getDatabaseUrl());

    }
}
