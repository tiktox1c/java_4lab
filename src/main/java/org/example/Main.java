package org.example;

import java.util.List;

/**
 * The Main class contains the main method to read data from a CSV file
 * and display information about people.
 */
public class Main {

    /**
     * The main method of the program.
     *
     * @param args Command line arguments (not used in this program).
     */
    public static void main(String[] args) {

        String csvFilePath = "src\\main\\resources\\foreign_names.csv";

        String separator = ";";

        List<Person> people = Person.readPersonsFromCSV(csvFilePath, separator);

        for (Person person : people) {
            System.out.println("Person ID: " + person.getId());
            System.out.println("Name: " + person.getName());
            System.out.println("Gender: " + person.getGender());
            System.out.println("Birth Date: " + person.getBirthDate());
            System.out.println("Division ID: " + person.getDivision().getId());
            System.out.println("Division Name: " + person.getDivision().getName());
            System.out.println("Salary: " + person.getSalary());
            System.out.println("----------------------------");
        }
    }
}
