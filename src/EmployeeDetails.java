import java.io.*;
import java.util.*;

class Employee implements Serializable {        //serializable interface is being implemented for Object

    public int id;
    private String name;
    private String email;
    private int age;
    private String dob;

    Employee(int id, String name, String email, int age, String dob) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", DOB=" + dob +
                '}';
    }
}

public class EmployeeDetails {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        String name;
        String email;
        String dob;
        int id;
        int age;
        int year;
        int month;
        int date;
        int n;
        int choice;
        boolean found = false;

        Scanner sc = new Scanner(System.in);        //for integer type of variable
        Scanner st = new Scanner(System.in);        //for String type of variable
        ArrayList<Employee> details = new ArrayList<Employee>();        //for Storing data into ArrayList
        File path = new File("EmployeeDetails.txt");        //File path is passed into path object
        ObjectOutputStream writedata = null;        //writedata is being used for taking object to write data into file
        ObjectInputStream readdata = null;           //readdata is being used for taking object to read data from file
        ListIterator itrate = null;

        do {
            System.out.println("Please choose any one operation");      //Driver for performing Operation
            System.out.println("\n1). Add Employee");
            System.out.println("\n2). Delete Employee by Id");
            System.out.println("\n3). Search Employee by Id");
            System.out.println("\n4). Display Employee Information with sorted form");
            System.out.println("\n5). Exit");
            System.out.println("---------------------------------------------------------");

            System.out.println("Enter a number between the range :");
            choice = sc.nextInt();

            switch (choice) {

                case 1: {
                    try {

                        System.out.println("Add Employee :");
                        System.out.println("Please Enter how many Employee you want :");
                        n = sc.nextInt();

                        for (int i = 0; i < n; i++) {

                            System.out.println("Employe :" + (i + 1));      //input is being taken for Employe i+1
                            System.out.println("Enter ID :");
                            id = sc.nextInt();
                            System.out.println("Enter Name :");
                            name = st.nextLine();
                            System.out.println("Enter Email Address :");
                            email = st.nextLine();
                            System.out.println("Enter Age :");
                            age = sc.nextInt();
                            System.out.println("Enter Date Of Birth :");
                            System.out.println("Date :");
                            date = sc.nextInt();
                            System.out.println("Month :");
                            month = sc.nextInt();
                            System.out.println("Year :");
                            year = sc.nextInt();

                            dob = (date + "/" + month + "/" + year);
                            details.add(new Employee(id, name, email, age, dob));     //Add data into ArrayList

                        }       //end of the for loop

                        writedata = new ObjectOutputStream(new FileOutputStream(path));     //pass objcet of FileOutputStream class in ObjectOutputStream
                        writedata.writeObject(details);
                        writedata.close();      //close file
                        System.out.println("Record Inserted Successfully");

                    } catch (Exception e) {

                        System.out.println(e);
                    }

                    break;
                }

                case 2: {
                    System.out.println("Delete Employee :");

                    if (path.isFile()) {

                        readdata = new ObjectInputStream(new FileInputStream(path));        //ObjectInputStream and FileInputStream class objcet is made
                        details = (ArrayList<Employee>) readdata.readObject();
                        readdata.close();

                        System.out.println("Enter Employee id to Delete :");
                        int cid = sc.nextInt();
                        itrate = details.listIterator();

                        while (itrate.hasNext()) {       //iterate ArrayList till the end

                            Employee e1 = (Employee) itrate.next();

                            if (e1.id == cid) {       //check id is equals to cid or not
                                itrate.remove();
                                found = true;
                            }
                        }
                        if (found) {

                            System.out.println("Record Deleted successfully");
                            writedata = new ObjectOutputStream(new FileOutputStream(path));
                            writedata.writeObject(details);
                            writedata.close();

                        } else {
                            System.out.println("Record Not Found");
                        }
                        if (!found) {
                            System.out.println("Record Not found");

                        }
                    } else {
                        System.out.println("File not Exist");
                    }

                    break;
                }

                case 3: {
                    System.out.println("Search Employee :");
                    if (path.isFile()) {

                        readdata = new ObjectInputStream(new FileInputStream(path));        //ObjectInputStream and FileInputStream class objcet is made
                        details = (ArrayList<Employee>) readdata.readObject();
                        readdata.close();

                        System.out.println("Enter Employee id :");
                        int cid = sc.nextInt();
                        itrate = details.listIterator();

                        while (itrate.hasNext()) {       //iterate ArrayList till the end

                            Employee e1 = (Employee) itrate.next();

                            if (e1.id == cid) {       //check id is equals to cid or not
                                System.out.println("Record Found");
                                System.out.println(e1);
                                found = true;
                            }
                        }

                        if (!found) {
                            System.out.println("Record Not found");
                        }

                    } else {        //else for outer if
                        System.out.println("File not Exist");
                    }

                    break;
                }

                case 4: {

                    System.out.println("Display Employee :");
                    try {

                        if (path.isFile()) {      //file is available or not

                            readdata = new ObjectInputStream(new FileInputStream(path));        //ObjectInputStream and FileInputStream class objcet is made
                            details = (ArrayList<Employee>) readdata.readObject();
                            readdata.close();

                            Collections.sort(details, new Comparator<Employee>() {      //anonymous Class is being created
                                @Override
                                public int compare(Employee o1, Employee o2) {      //override compare method here

                                    return o1.id - o2.id;       //sorted data into ascending order
                                }
                            });

                            writedata = new ObjectOutputStream(new FileOutputStream(path));
                            writedata.writeObject(details);     //passes ArrayList object into ObjectOutputStream
                            writedata.close();

                            for (Employee s : details)       //iterate data from Arraylist
                            {
                                System.out.println(s + "\n");      //Print data
                            }

                        } else {

                            System.out.println("File not Found");
                        }

                    } catch (Exception e) {
                        System.out.println("Please Insert Data");
                    }

                    break;
                }

                case 5: {
                    System.out.println("All done");
                    return;
                }

                default: {
                    System.out.println("Please choose right option");

                    break;
                }
            }       //end of switch case
        } while (true);
    }       //end of main method

}
