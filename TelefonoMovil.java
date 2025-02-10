import java.util.ArrayList;

public class TelefonoMovil {


    private String myNumber;
    private ArrayList<Contacto> myContacts;


    public TelefonoMovil(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<>();
    }


    public boolean addNewContact(Contacto contact) {
        if (findContact(contact.getName()) == -1) {
            myContacts.add(contact);
            return true;
        }

        return false;
    }


    public boolean updateContact(Contacto oldContact, Contacto newContact) {
        boolean booleano;

        if ( findContact(oldContact) != -1 && findContact() ) {
            return true;
        }

        return false;
    }


    public boolean removeContact(Contacto contact) {
        boolean booleano;

        if (findContact(myContacts = findContact(()){
            return true;

        }

        return false;
    }




    private int findContact(Contacto contact) {
        for (int i = 0; i < myContacts.size(); i++) {
            if (myContacts.get(i).getName().equals(contact.getName())) {
                return i;
            }
        }
        return -1;
    }


    private int findContact(String name) {
        for (int i = 0; i < myContacts.size(); i++) {
            if (myContacts.get(i).getName().equals(name)) {
                return i;

            }

        }
        return -1;
    }

    public int ordenarNombre(){



        return findContact("hola");
    }


    private int queryContact (String contact){

        return 0;
    }


    public void printContacts () {
        System.out.println();
        System.out.println();

    }


}