import java.net.*;

public class firstcode {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://9ai.in/saas-colaboration");
            System.out.println("Protocol:" + url.getProtocol());
            System.out.println("Hostname:" + url.getHost());
            System.out.println("Port No.:" + url.getPort());
            System.out.println("Default Pno.:" + url.getDefaultPort());
            System.out.println("Query String:" + url.getQuery());
            System.out.println("File:" + url.getFile());
            System.out.println("Path:" + url.getPath());
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
