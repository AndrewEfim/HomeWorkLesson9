import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashSet;
import java.util.Set;

public class Registratura {
    private Hospital hospital;
    private String fileName;
    private upload upload = new upload("https://raw.githubusercontent.com/AndrewEfim/ForHomeWork9/master/Patient.txt");

    public Registratura(Hospital hospital, String fileName) throws MalformedURLException {
        this.hospital = hospital;
        this.fileName = fileName;
    }

    public void remoteAdd() throws IOException {
        hospital.addAll(upload.execute( ));
    }

    public void write() {
        Set<Patient> patients = hospital.getPatient( );
        try (DataOutputStream out = new DataOutputStream(new FileOutputStream(new File("Patient.txt")))) {
            for (Patient patient : patients) {
                out.writeUTF(patient.getName( ));
                out.writeUTF(patient.getLastName( ));
                out.writeUTF(patient.getBirth( ));
                out.writeBoolean(patient.isSick( ));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace( );
        } catch (IOException e) {
            e.printStackTrace( );
        }
    }

    public void read() {
        Set<Patient> patients = hospital.getPatient( );
        try (DataInputStream dos = new DataInputStream(new FileInputStream("Patient.txt"))) {
            for (Patient patient : patients) {
                String name = dos.readUTF( );
                String lastName = dos.readUTF( );
                String birth = dos.readUTF( );
                boolean isSick = dos.readBoolean( );
                System.out.printf("name: %s  lastName: %s  birth: %s  is Sick: %b\n",
                        name, lastName, birth, isSick);
            }
        } catch (IOException ex) {

            System.out.println(ex.getMessage( ));
        }
    }
}