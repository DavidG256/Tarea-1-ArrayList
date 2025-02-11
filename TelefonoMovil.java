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
        int position = findContact(oldContact);
        if (position < 0 || findContact(newContact.getName()) >= 0) {
            return false;
        }
        myContacts.set(position, newContact);
        return true;
    }

    public boolean removeContact(Contacto contact) {
        int position = findContact(contact);
        if (position < 0) {
            return false;
        }
        myContacts.remove(position);
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

    public Contacto searchByPhone(String phoneNumber) {
        for (Contacto c : myContacts) {
            if (c.getPhoneNumber().equals(phoneNumber)) {
                return c;
            }
        }
        return null;
    }

    public void sortContacts() {
        myContacts.sort(Comparator.comparing(Contacto::getName, String.CASE_INSENSITIVE_ORDER));
    }

    public void removeAllContacts() {
        myContacts.clear();
    }

    public int getNumberOfContacts() {
        return myContacts.size();
    }

    public void printContacts() {
        System.out.println("Lista contactos:");
        for (int i = 0; i < myContacts.size(); i++) {
            System.out.println((i + 1) + ". " + myContacts.get(i).getName() + " -> " + myContacts.get(i).getPhoneNumber());
        }
    }
}