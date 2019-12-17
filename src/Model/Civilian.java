/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.time.LocalDate;

/**
 * This model class contains the definition of a Civilian.
 * TODO: Remove unused CoordinateLocation.
 * @author jxw5883
 */
public class Civilian implements Reportable {

    private final String fullname;
    private final LocalDate birthday;
    private final boolean sex;
    private final double weight;
    private final double height;
    private final String preexistingDisability;
    private final CoordinateLocation location;

    /**
     * Initializes a Civilian with all of its details. 
     * @param fullname
     * @param birthday
     * @param sex
     * @param weight
     * @param height
     * @param preexistingDisability
     */
    public Civilian(String fullname, LocalDate birthday, boolean sex, double weight, double height, String preexistingDisability, CoordinateLocation location) {
        this.fullname = fullname;
        this.birthday = birthday;
        this.sex = sex;
        this.weight = weight;
        this.height = height;
        this.preexistingDisability = preexistingDisability;
        this.location = location;
    }

    /**
     * @return the fullname
     */
    public String getFullname() {
        return fullname;
    }

    /**
     * @return the birthday
     */
    public LocalDate getBirthday() {
        return birthday;
    }

    /**
     * @return the sex
     */
    public boolean isSex() {
        return sex;
    }

    /**
     * @return the weight
     */
    public double getWeight() {
        return weight;
    }

    /**
     * @return the height
     */
    public double getHeight() {
        return height;
    }

    /**
     * @return the preexistingDisability
     */
    public String getPreexistingDisability() {
        return preexistingDisability;
    }

    /**
     * Generates a JSON String containing all details of a Civilian.
     *
     * @return JSON String
     */
    @Override
    public String generateReport() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(this);
    }

}
