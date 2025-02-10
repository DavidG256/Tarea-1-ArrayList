import java.util.ArrayList;
import java.util.Comparator;

class TelefonoMovil {
    private String myNumber;
    private ArrayList<Contacto> myContacts;

    public TelefonoMovil(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<>();
    }

    public boolean addNewContact(Contacto contact) {
        if (findContact(contact.getName()) >= 0) {
            return false;
        }
        myContacts.add(contact);
        return true;
    }

    public boolean updateContact(Contacto oldContact, Contacto newContact) {
        int foundPosition = findContact(oldContact);
        if (foundPosition < 0 || findContact(newContact.getName()) >= 0) {
            return false;
        }
        myContacts.set(foundPosition, newContact);
        return true;
    }

    public boolean removeContact(Contacto contact) {
        int foundPosition = findContact(contact);
        if (foundPosition < 0) {
            return false;
        }
        myContacts.remove(foundPosition);
        return true;
    }

    private int findContact(Contacto contact) {
        return myContacts.indexOf(contact);
    }

    private int findContact(String name) {
        for (int i = 0; i < myContacts.size(); i++) {
            if (myContacts.get(i).getName().equalsIgnoreCase(name)) {
                return i;
            }
        }
        return -1;
    }

    public Contacto queryContact(String name) {
        int position = findContact(name);
        return (position >= 0) ? myContacts.get(position) : null;
    }

    public void printContacts() {
        System.out.println("Lista de contactos:");
        for (int i = 0; i < myContacts.size(); i++) {
            System.out.println((i + 1) + ". " + myContacts.get(i).getName() + " -> " + myContacts.get(i).getPhoneNumber());
        }
    }

    public Contacto findContactByPhone(String phone) {
        for (Contacto contact : myContacts) {
            if (contact.getPhoneNumber().equals(phone)) {
                return contact;
            }
        }
        return null;
    }


    public void sortContactsByName() {
        myContacts.sort(Comparator.comparing(Contacto::getName, String.CASE_INSENSITIVE_ORDER));
    }


    public void clearContacts() {
        myContacts.clear();
    }


    public int getContactCount() {
        return myContacts.size();
    }
}