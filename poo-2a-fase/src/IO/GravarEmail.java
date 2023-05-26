package IO;

import java.util.ArrayList;
import java.util.List;

public class GravarEmail {
    private static final String HOME_DIR = System.getProperty("user.home");
    private static final String FILE_NAME = "emails.txt";

    public static String getHOME_DIR() {
        return HOME_DIR;
    }

    public static String getFILE_NAME() {
        return FILE_NAME;
    }
    
    public static List<String> getPessoas(){
        List<String> emails = new ArrayList();
        emails.add("Teste@hotmail.com");
        emails.add("Teste01@gmail.com");
        emails.add("Testes02@yahoo.com");
        return emails;
    }
}
