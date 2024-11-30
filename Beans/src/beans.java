import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class beans {

    public static void main(String[] args) {
        // Create a list of customers
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer(1, "John", "Doe", 1000.0));
        customers.add(new Customer(2, "Jane", "Doe", 500.0));
        customers.add(new Customer(3, "Alice", "Smith", 2000.0));
        customers.add(new Customer(4, "Bob", "Smith", 1500.0));

        // Sort the list of customers
        Collections.sort(customers, new CustomerComparator());

        // Print the sorted list of customers
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }
}

class Customer {
    private int id;
    private String firstName;
    private String lastName;
    private double balance;

    public Customer(int id, String firstName, String lastName, double balance) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", balance=" + balance +
                '}';
    }
}

class CustomerComparator implements Comparator<Customer> {
    @Override
    public int compare(Customer c1, Customer c2) {
        // Compare by first name
        int firstNameComparison = c1.getFirstName().compareTo(c2.getFirstName());
        if (firstNameComparison != 0) {
            return firstNameComparison;
        }

        // Compare by last name
        int lastNameComparison = c1.getLastName().compareTo(c2.getLastName());
        if (lastNameComparison != 0) {
            return lastNameComparison;
        }

        // Compare by ID
        int idComparison = Integer.compare(c1.getId(), c2.getId());
        if (idComparison != 0) {
            return idComparison;
        }

        // Compare by balance
        return Double.compare(c1.getBalance(), c2.getBalance());
    }
}