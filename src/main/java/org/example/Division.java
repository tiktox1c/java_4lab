package org.example;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * The Division class represents a division within an organization.
 */
class Division {
    private static final AtomicInteger divisionIdCounter = new AtomicInteger(1);

    private int id;
    private String name;

    /**
     * Constructs a new Division with the given name.
     *
     * @param name The name of the division.
     */
    public Division(String name) {
        this.id = generateDivisionId();
        this.name = name;
    }

    /**
     * Gets the unique identifier of the division.
     *
     * @return The division ID.
     */
    public int getId() {
        return id;
    }

    /**
     * Gets the name of the division.
     *
     * @return The name of the division.
     */
    public String getName() {
        return name;
    }

    // Additional getters and setters

    /**
     * Generates a unique division ID.
     *
     * @return The generated division ID.
     */
    private static int generateDivisionId() {
        return divisionIdCounter.getAndIncrement();
    }
}
