// Parcel.java
// Represents a single parcel in the courier system

public class Parcel {
    private String parcelId;
    private String status;

   
    public Parcel(String parcelId) {
        this.parcelId = parcelId;
        this.status = "Dispatched"; // Default status
    }

    
    public String getParcelId() {
        return parcelId;
    }

    
    public String getStatus() {
        return status;
    }

    
    public void updateStatus(String newStatus) {
        this.status = newStatus;
    }

    // Display parcel details
    public void displayStatus() {
        System.out.println("Parcel ID: " + parcelId + " | Current Status: " + status);
    }
}
