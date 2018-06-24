import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        // Scanner in = new Scanner(System.in);
        Hospital hospital = new Hospital( );
        upload upload = new upload("https://raw.githubusercontent.com/AndrewEfim/ForHomeWork9/master/Patient.txt");

        hospital.add(new Patient("Mike", "Wagner", "12 12 1989", true));
        hospital.add(new Patient("Wendy", "Roads", "12 10 1984", false));
        hospital.add(new Patient("Chuk", "Roads", "12 09 1988", true));
        hospital.add(new Patient("Bobby", "Axelrod", "17 05 1985", true));
        Registratura registratura = new Registratura(hospital, "Patients.txt");

        registratura.write( ); //запись в файл
        registratura.read( ); //чтение из файла
        upload.execute( ); // чтение удаленного файла
        registratura.remoteAdd();
        System.out.println(upload.execute( )); //файл который прочитали
    }
}
