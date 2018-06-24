import java.time.LocalDate;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Hospital {
    private Set<Patient> patients = new HashSet<>( );

    public void add(Patient patient) {
        patients.remove(patient);
        patients.add(patient);
    }

    public Set<Patient> getPatient() {
        return patients;

    }

    public void addAll(Set<Patient> patients) {
        this.patients.removeAll(patients);
        this.patients.addAll(patients);
    }

    @Override
    public String toString() {
        return "Hospital{" +
                "patients=" + patients +
                '}';
    }
}
