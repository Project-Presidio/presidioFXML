package Model;

import java.util.HashMap;

public class Alert {

    private String threat;
    private Civilian civilianDetails;
    private Location location;

    private HashMap<String, String> contactNumbers;

    /**
     * @return the threat
     */
    public String getThreat() {
        return threat;
    }

    /**
     * @param threat the threat to set
     */
    public void setThreat(String threat) {
        this.threat = threat;
    }
    
    /**
     * @return the civilianDetails
     */
    public Civilian getCivilianDetails() {
        return civilianDetails;
    }

    /**
     * @param civilianDetails the civilianDetails to set
     */
    public void setCivilianDetails(Civilian civilianDetails) {
        this.civilianDetails = civilianDetails;
    }


    /**
     * @return the location
     */
    public Location getLocation() {
        return location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(Location location) {
        this.location = location;
    }

    /**
     * @return the contactNumbers
     */
    public HashMap<String, String> getContactNumbers() {
        return contactNumbers;
    }

    /**
     * @param contactNumbers the contactNumbers to set
     */
    public void setContactNumbers(HashMap<String, String> contactNumbers) {
        this.contactNumbers = contactNumbers;
    }

    /**
     * Constructs an alert and generates example contact information
     * @param threat
     * @param civilianDetails
     * @param location 
     */
    public Alert(String threat, Civilian civilianDetails, Location location) {
        this.threat = threat;
        this.civilianDetails = civilianDetails;
        this.location = location;
        this.contactNumbers = new HashMap();
        contactNumbers.put("Rescue Team", "+2222");
        contactNumbers.put("Medical Team", "3333");
        contactNumbers.put("Police", "4444");

    }
    
    /**
     * Returns contact information for contacts on the contactNumbers mapping.
     * @deprecated determineContact and contactNumbers should be replaced with a JSON list containing phone numbers listed by region
     * @return a phone number of users in the contactNumbers list 
     */
    public String determineContact(){
        switch (threat) {
            case "Rescue Team":
                return contactNumbers.get("Rescue Team");
            case "Medical Team":
                return contactNumbers.get("Medical Team");
            case "Police":
                return contactNumbers.get("Police");
            default:
                break;
        }
        return "Could Not Find Number";
    
    }

    

}
