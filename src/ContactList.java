import java.util.ArrayList;

public class ContactList {
    private ArrayList<Person> contacts;

    public ContactList(){
        contacts = new ArrayList<>();
    }

    public ArrayList<Person> getContacts() {
        return contacts;
    }

    public void addContact(Person contact){
        contacts.add(contact);
    }

    public void printContacts() {
        for (Person contact : contacts) {
            System.out.println(contact);
        }
    }

    public void sort(int sortBy) {

    }
}
