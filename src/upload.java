import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashSet;
import java.util.Set;

public class upload {
    private URL link;

    public upload(String link) throws MalformedURLException {
        this.link = new URL(link);
    }

    public Set<Patient> execute() throws IOException {
        Set<Patient> patients = new HashSet<>( );
        URLConnection connection = link.openConnection( );
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream( )))) {
            String line;
            while ((line = reader.readLine( )) != null) {
                patients.add(new Patient(line));
            }
        }
        return patients;
    }
}