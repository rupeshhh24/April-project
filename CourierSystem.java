// CourierSystem.java
// Main class to test Courier Delivery Tracking System

import java.util.ArrayList;
import java.util.Scanner;

public class CourierSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Parcel> parcels = new ArrayList<>();

        
        parcels.add(new Parcel("P101"));
        parcels.add(new Parcel("P102"));
        parcels.add(new Parcel("P103"));

        
        parcels.get(0).updateStatus("In Transit");
        parcels.get(1).updateStatus("Out for Delivery");
        parcels.get(2).updateStatus("Delivered");

        System.out.println("=== COURIER DELIVERY TRACKING SYSTEM ===");

        boolean running = true;
        while (running) {
            System.out.println("\nMenu:");
            System.out.println("1. Track Parcel by ID");
            System.out.println("2. Update Parcel Status");
            System.out.println("3. View All Parcels");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Parcel ID: ");
                    String id = sc.next();
                    boolean found = false;
                    for (Parcel p : parcels) {
                        if (p.getParcelId().equalsIgnoreCase(id)) {
                            p.displayStatus();
                            found = true;
                            break;
                        }
                    }
                    if (!found)
                        System.out.println("Parcel not found!");
                    break;

                case 2:
                    System.out.print("Enter Parcel ID to update: ");
                    String updateId = sc.next();
                    found = false;
                    for (Parcel p : parcels) {
                        if (p.getParcelId().equalsIgnoreCase(updateId)) {
                            System.out.print("Enter new status (Dispatched/In Transit/Out for Delivery/Delivered): ");
                            String newStatus = sc.nextLine();
                            if (newStatus.isEmpty()) newStatus = sc.nextLine(); 
                            p.updateStatus(newStatus);
                            System.out.println("Status updated successfully!");
                            found = true;
                            break;
                        }
                    }
                    if (!found)
                        System.out.println("Parcel not found!");
                    break;

                case 3:
                    System.out.println("All Parcels:");
                    for (Parcel p : parcels) {
                        p.displayStatus();
                    }
                    break;

                case 4:
                    running = false;
                    System.out.println("Exiting system. Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
        sc.close();
    }
}
