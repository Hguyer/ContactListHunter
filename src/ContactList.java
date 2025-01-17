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
        for (int i = 0; i < contacts.size() - 1; i++) {
            for (int j = 0; j < contacts.size() - i - 1; j++) {
                boolean swapped = false;
                if (sortBy == 0 && contacts.get(j).getFirstName().compareTo(contacts.get(j + 1).getFirstName()) > 0) {
                    swapped = true;
                }
                else if (sortBy == 1 && contacts.get(j).getLastName().compareTo(contacts.get(j + 1).getLastName()) > 0) {
                    swapped = true;
                }
                else if (sortBy == 2 && contacts.get(j).getPhoneNumber().compareTo(contacts.get(j + 1).getPhoneNumber()) > 0) {
                    swapped = true;
                }
                if(swapped){
                    Person temp = contacts.get(j);
                    contacts.set(j, contacts.get(j + 1));
                    contacts.set(j + 1, temp);
                }
            }
        }

    }
    public Person searchByFirstName(String firstName) {
        for (Person contact : contacts) {
            if (contact.getFirstName().equals(firstName.toLowerCase())) {
                return contact;
            }
        }
        return null;
    }
    public Person searchByLastName(String lastName) {
        for (Person contact : contacts) {
            if (contact.getLastName().equals(lastName.toLowerCase())) {
                return contact;
            }
        }
        return null;
    }
    public Person searchByPhoneNumber(String phoneNumber) {
        for (Person contact : contacts) {
            if (contact.getPhoneNumber().equals(phoneNumber)) {
                return contact;
            }
        }
        return null;
    }

    public void listStudents() {
        for (Person contact : contacts) {
            if (contact instanceof Student) {
                System.out.println(contact);
            }
        }
    }

    public void run(){
        java.util.Scanner menu = new java.util.Scanner(System.in);
        int option;


    }
}
