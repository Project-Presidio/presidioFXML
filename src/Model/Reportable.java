/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 * This interface contains the definition of a Reportable object.
 * @author jxw5883
 */
public interface Reportable {
    /**
     * A reportable object creates a report and returns it as a String.
     * @return a report
     */
    public String generateReport();
}
