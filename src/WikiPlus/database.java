package WikiPlus;

public class database {
    public native int createUser(String fName, String lName, String uName, String pWord);
    public native String searchUser(String uName, String pWord);

    static {
        System.loadLibrary("db");
    }
}