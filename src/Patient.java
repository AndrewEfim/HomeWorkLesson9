import java.io.Serializable;
import java.time.LocalDate;

public class Patient implements Serializable {
    private String name;
    private String lastName;
    private boolean isSick;
    private String birth;

    public Patient(String name, String lastName, String birth, boolean isSick) {
        this.name = name;
        this.lastName = lastName;
        this.birth = birth;
        this.isSick = isSick;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass( ) != o.getClass( )) return false;

        Patient patient = (Patient) o;

        if (!name.equals(patient.name)) return false;
        if (!lastName.equals(patient.lastName)) return false;
        return birth.equals(patient.birth);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode( );
        result = 31 * result + lastName.hashCode( );
        result = 31 * result + birth.hashCode( );
        return result;
    }

    public String getName() {
        return this.name;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getBirth() {
        return this.birth.toString();
    }

    public boolean isSick() {
        return this.isSick;
    }

    //public String toString(LocalDate birth) {
     //   return this.birth.toString( );
    //}

    public Patient(String patient) {
        this(patient.split(";"));
    }

    public Patient(String[] properties) {
        this(properties[0], properties[1], properties[2], properties[3]);
    }

    public Patient(String name, String lastName, String birth, String isSick ){
        this(name, lastName, birth, Boolean.getBoolean(isSick));
    }

    @Override
    public String toString() {
        return "Patient{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birth=" + birth +
                ", isSick=" + isSick +
                '}';
    }
}

