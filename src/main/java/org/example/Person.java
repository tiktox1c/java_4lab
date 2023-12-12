package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * The Person class represents an individual in an organization.
 */
public class Person {
    private static final AtomicInteger personIdCounter = new AtomicInteger(1);

    private int id;
    private String name;
    private String gender;
    private String birthDate;
    private Division division;
    private double salary;

    /**
     * Constructs a new Person with the specified attributes.
     *
     * @param id       The unique identifier of the person.
     * @param name     The name of the person.
     * @param gender   The gender of the person.
     * @param birthDate The birth date of the person.
     * @param division The division to which the person belongs.
     * @param salary   The salary of the person.
     */
    public Person(int id, String name, String gender, String birthDate, Division division, double salary) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.division = division;
        this.salary = salary;
    }

    /**
     * Gets the unique identifier of the person.
     *
     * @return The person ID.
     */
    public int getId() {
        return id;
    }

    /**
     * Gets the name of the person.
     *
     * @return The name of the person.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the gender of the person.
     *
     * @return The gender of the person.
     */
    public String getGender() {
        return gender;
    }

    /**
     * Gets the birth date of the person.
     *
     * @return The birth date of the person.
     */
    public String getBirthDate() {
        return birthDate;
    }

    /**
     * Gets the division to which the person belongs.
     *
     * @return The division of the person.
     */
    public Division getDivision() {
        return division;
    }

    /**
     * Gets the salary of the person.
     *
     * @return The salary of the person.
     */
    public double getSalary() {
        return salary;
    }

    // Additional getters and setters can be added if needed.

    /**
     * Reads a list of Person objects from a CSV file.
     *
     * @param csvFilePath The path to the CSV file.
     * @param separator   The separator used in the CSV file.
     * @return A list of Person objects read from the CSV file.
     */
    public static List<Person> readPersonsFromCSV(String csvFilePath, String separator) {
        List<Person> people = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
            String line;
            // Skip the first line (header)
            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] values = line.split(separator);

                // Creating a division object
                Division division = new Division(values[4]);

                // Checking if the salary value can be converted to double
                try {
                    double salary = Double.parseDouble(values[5]);

                    // Creating a person object
                    Person person = new Person(
                            personIdCounter.getAndIncrement(),
                            values[1],
                            values[2],
                            values[3],
                            division,
                            salary
                    );

                    people.add(person);
                } catch (NumberFormatException e) {
                    System.err.println("Error in salary format: " + values[5]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return people;
    }

}
