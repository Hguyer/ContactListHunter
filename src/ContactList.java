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
            if (contact.getFirstName().equals(firstName)) {
                return contact;
            }
        }
        return null;
    }
    public Person searchByLastName(String lastName) {
        for (Person contact : contacts) {
            if (contact.getLastName().equals(lastName)) {
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

    public void run() {
        java.util.Scanner menu = new java.util.Scanner(System.in);
        int option;
        do {
            System.out.println("Menu:\n1 Add Contact\n2 List All Contacts By First Name\n3 List All Contacts By Last Name" +
                    "\n4 List All Contacts By Phone Number\n5 List All Students\n6 Search By First Name" +
                    "\n7 Search By Last Name\n8 Search By Phone Number\n0 Exit");

            option = menu.nextInt();
            menu.nextLine();
            switch (option) {
                case 1:
                    System.out.print("Enter first name: ");
                    String firstName = menu.nextLine();
                    System.out.print("Enter last name: ");
                    String lastName = menu.nextLine();
                    System.out.print("Enter phone number: ");
                    String phoneNumber = menu.nextLine();
                    System.out.print("Enter type (1 for Student, 2 for Teacher): ");
                    int type = menu.nextInt();
                    menu.nextLine();
                    if (type == 1) {
                        System.out.print("Enter grade: ");
                        int grade = menu.nextInt();
                        menu.nextLine();
                        addContact(new Student(firstName, lastName, phoneNumber, grade));
                    } else if (type == 2) {
                        System.out.print("Enter subject: ");
                        String subject = menu.nextLine();
                        addContact(new Teacher(firstName, lastName, phoneNumber, subject));
                    }
                    break;
                case 2:
                    sort(0);
                    printContacts();
                    break;
                case 3:
                    sort(1);
                    printContacts();
                    break;
                case 4:
                    sort(2);
                    printContacts();
                    break;
                case 5:
                    listStudents();
                    break;
                case 6:
                    System.out.print("Enter first name to search: ");
                    String searchFirstName = menu.nextLine();
                    Person foundFirstName = searchByFirstName(searchFirstName);
                    if (foundFirstName != null) {
                        System.out.println(foundFirstName);
                    } else {
                        System.out.println(searchFirstName + " is not in the list");
                    }
                    break;
                case 7:
                    System.out.print("Enter last name to search: ");
                    String searchLastName = menu.nextLine();
                    Person foundLastName = searchByLastName(searchLastName);
                    if (foundLastName != null) {
                        System.out.println(foundLastName);
                    } else {
                        System.out.println(searchLastName + " is not in the list");
                    }
                case 8:
                    System.out.print("Enter phone number to search: ");
                    String searchPhoneNumber = menu.nextLine();
                    Person foundPhoneNumber = searchByPhoneNumber(searchPhoneNumber);
                    if (foundPhoneNumber != null) {
                        System.out.println(foundPhoneNumber);
                    } else {
                        System.out.println(searchPhoneNumber + " is not in the list");
                    }
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
            }
        } while (option != 0);
    }
    public static void main(String[] args) {
        ContactList contactList = new ContactList();
        contactList.run();
    }
}
