import java.util.Objects;

public class Contacto {
    private String name;
    private String phoneNumber;


    public Contacto(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }


    public static Contacto CreateContact (String name, String PhoneNumber){

        Contacto contacto = new Contacto(name, PhoneNumber);

        return contacto;
    }


    @Override
    public String toString() {
        return "Contacto{" +
                "name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contacto contacto = (Contacto) o;
        return Objects.equals(name, contacto.name) && Objects.equals(phoneNumber, contacto.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, phoneNumber);
    }

}