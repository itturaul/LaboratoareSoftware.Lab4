package ro.ulbs.proiectaresoftware.lab7.util;

public class PasswordMaker {
    private static final int MAGIC_NUMBER = 3;
    private static final String MAGIC_STRING;

    private static final PasswordMaker instance;
    private static int accessCounter = 0;

    private String name;

    static {
        StringRandomizer srand = new StringRandomizer();
        MAGIC_STRING = srand.randomString(20);
    }
    static {
        try {
            instance = new PasswordMaker("pazzwd");
        } catch (Exception e) {
            throw new RuntimeException("Eroare la inițializarea Singleton-ului");
        }
    }

    private PasswordMaker(String name) {
        this.name = name;
    }

    public static PasswordMaker getInstance() {
        accessCounter++;
        return instance;
    }

    public static int getCallingCounts() {
        return accessCounter;
    }

    public String getPassword() {
        java.util.Random r = new java.util.Random();
        String ln = ""+name.length();
        ln += r.nextInt(101);
        StringRandomizer srand = new StringRandomizer();
        return srand.randomString(MAGIC_NUMBER) + srand.randomString(10, MAGIC_STRING) + ln;
    }

    public String generatePassword() {
        return "ParolaExemplu123";
    }
}

