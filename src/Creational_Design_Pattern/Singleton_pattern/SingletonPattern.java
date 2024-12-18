package Creational_Design_Pattern.Singleton_pattern;

class AppSetting {

    private String databaseUrl;
    private String apiKey;

    // Volatile ensures visibility and prevents instruction reordering issues
    // When one thread updates the volatile variable, all other threads immediately see the updated value.
    // A variable as volatile, it ensures that the variable is always read and written directly from the main memory instead of being cached in a thread's local memory.
    private static volatile AppSetting appSetting = null;

    //to prevent direct object creation
    private AppSetting() {
        databaseUrl = "jdbc:mysql://localhost:3306/myDB";
        apiKey = "myKey12345";
    }

    public static AppSetting getInstance() {
        if (appSetting == null) { // First check (without locking)
            synchronized (AppSetting.class) {// Synchronize on the class
                if (appSetting == null) { // Second check (with locking)
                    appSetting = new AppSetting();
                }
            }
        }
        return appSetting;
    }

    public String getDatabaseUrl() {
        return databaseUrl;
    }
    public String getApiKey() {
        return apiKey;
    }
}

public class SingletonPattern {
    public static void main(String[] args) {
        AppSetting appSetting = AppSetting.getInstance();
        System.out.println(appSetting.getDatabaseUrl());
        System.out.println(appSetting.getApiKey());

        AppSetting appSetting1 = AppSetting.getInstance();
        System.out.println(appSetting+"  "+appSetting1);//both are same
    }
}
