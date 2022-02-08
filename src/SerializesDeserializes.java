import java.io.*;
import java.util.Scanner;

class Student implements Serializable {

    private final String firstName;
    private final String dateOfBirth;
    Address address;

    public Student(String firstName, String dateOfBirth, Address address) {

        this.firstName = firstName;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student :" +
                "\nfirstName = " + firstName +
                "\ndateOfBirth = " + dateOfBirth +
                "\n" + address;
    }
}

class Address implements Serializable {

    private final String city;
    private final String state;
    private final int pinCode;
    private final String country;

    public Address(String city, String state, int pinCode, String country) {

        this.city = city;
        this.state = state;
        this.pinCode = pinCode;
        this.country = country;
    }

    @Override
    public String toString() {
        System.out.println("------------------------------");
        return "Address :" +
                "\ncity = " + city +
                "\nstate = " + state +
                "\npinCode = " + pinCode +
                "\ncountry = " + country;

    }
}

class SerializationTest implements Serializable {

    String firstName;
    String city;
    String state;
    int pincode;
    String country;
    String dateOfBirth;
    int date;
    int month;
    int year;

    Scanner sc = new Scanner(System.in);
    Scanner st = new Scanner(System.in);        //for taking String input
    Address address;
    Student student;

    public SerializationTest() {

        try {

            System.out.println("Enter FirsName :");
            firstName = st.nextLine();

            System.out.println("Enter Date Of Birth :");
            System.out.println("Date :");
            date = sc.nextInt();
            System.out.println("Month :");
            month = sc.nextInt();
            System.out.println("Year :");
            year = sc.nextInt();
            dateOfBirth = (date + "/" + month + "/" + year);

            System.out.println("Enter city Name :");
            city = st.nextLine();

            System.out.println("Enter State Name :");
            state = st.nextLine();

            System.out.println("Enter Pincode :");
            pincode = sc.nextInt();

            System.out.println("Enter Country Name :");
            country = st.nextLine();

            address = new Address(city, state, pincode, country);
            student = new Student(firstName, dateOfBirth, address);

            FileOutputStream path = new FileOutputStream("..\\Programs\\src\\output1.ser");     //create output1 file if it's not exist
            ObjectOutputStream data = new ObjectOutputStream(path);     //converts objects into corresponding streams
            data.writeObject(student);
            path.close();
            data.close();
            System.out.println("Serialization has been performed");
            System.out.println("------------------------------");

        } catch (Exception e) {
            System.out.println(e);
        }

    }

}

class DeserializationTest implements Serializable {

    public DeserializationTest() {

        try {

            FileInputStream path = new FileInputStream("..\\Programs\\src\\output1.ser");       //used for reading data from output1 file
            ObjectInputStream read = new ObjectInputStream(path);       //read data which is written by the ObjectOutputStream

            Student s = (Student) read.readObject();

            System.out.println(s.toString());
            System.out.println("Deserialization has been performed");
            System.out.println("------------------------------");
            path.close();
            read.close();


        } catch (Exception e) {
            System.out.println("Perform Serialization before");
        }
    }
}

public class SerializesDeserializes {

    public static void main(String[] args) {

        int choice;

        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("1) Perform serialization");
            System.out.println("1) Perform deserialization");
            System.out.println("1) Exit");

            System.out.print("Enter your choice ");
            choice = sc.nextInt();

            switch (choice) {

                case 1: {
                    SerializationTest serializationTest = new SerializationTest();      //object is being crated for SerializationTest class
                    break;
                }

                case 2: {
                    DeserializationTest deserializationTest = new DeserializationTest();        //object is being created for DeserializationTest class
                    break;
                }

                case 3: {
                    System.out.println("All done!");
                    return;
                }

                default: {
                    System.out.println("Please choose right option :");
                }
            }       //end of switch block

        } while (true);
    }       //end of the main method
}
