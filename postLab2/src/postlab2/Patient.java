/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package postlab2;
import java.util.Scanner;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author Amirul
 */
public class Patient {

    String patientName;
    int patientNumber;
    String patientAddress;

    public Patient() {
    }

    public Patient(String patientName, int patientNumber, String patientAddress) {
        this.patientName = patientName;
        this.patientNumber = patientNumber;
        this.patientAddress = patientAddress;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public int getPatientNumber() {
        return patientNumber;
    }

    public void setPatientNumber(int patientNumber) {
        this.patientNumber = patientNumber;
    }

    public String getPatientAddress() {
        return patientAddress;
    }

    public void setPatientAddress(String patientAddress) {
        this.patientAddress = patientAddress;
    }
    
    @Override
    public String toString() {
        return "Patient{" + "patientName=" + patientName + ", patientNumber=" + patientNumber + ", patientAddress=" + patientAddress + '}';
    }
        
    public static void main(String[] args) {
        
        String numberOfData = JOptionPane.showInputDialog("Number of data want to store: ");
        
        Room[] ptd = new Room[Integer.parseInt(numberOfData)];
        
        for (int i = 0; i < Integer.parseInt(numberOfData); i++) {
            String name = JOptionPane.showInputDialog("Enter patient name: ");
            String patientNumber = JOptionPane.showInputDialog("Enter patient number: ");
            String address = JOptionPane.showInputDialog("Enter patient address: ");
            String noDay = JOptionPane.showInputDialog("Number of stay: ");
            String typeRoom = JOptionPane.showInputDialog("Enter room type"+"(Diamond/Gold/Silver/Bronze): ");
            ptd[i] = new Room();
            ptd[i].setInformation(name, patientNumber, address, noDay, typeRoom);
        }
        
        int count20DayPatient = 0;
        float totalAll = 0, totalDay = 0, totalDiamond = 0, totalGold = 0, totalSilver = 0, totalBronze = 0;
        
        System.out.println("Patients who stayed more than 20 days:");
        for (int i = 0; i < Integer.parseInt(numberOfData); i++) {
            if (ptd[i].getNoDay() > 20) {
                count20DayPatient++;
                System.out.println(count20DayPatient + ". " + ptd[i].getPatientName());
            }
            
            if (ptd[i].typeRoom.equals("Diamond")) {
                totalDiamond += ptd[i].calcPayment();
                totalAll += totalDiamond;
            } else if (ptd[i].typeRoom.equals("Gold")) {
                totalGold += ptd[i].calcPayment();
                totalAll += totalGold;
            } else if (ptd[i].typeRoom.equals("Silver")) {
                totalSilver += ptd[i].calcPayment();
                totalAll += totalSilver;
            } else if (ptd[i].typeRoom.equals("Bronze")) {
                totalBronze += ptd[i].calcPayment();
                totalAll += totalBronze;
            }
            
            totalDay += ptd[i].getNoDay();
        }
        
        System.out.println("Diamond Room: RM" + totalDiamond);
        System.out.println("Gold Room: RM" + totalGold);
        System.out.println("Silver Room: RM" + totalSilver);
        System.out.println("Bronze Room: RM" + totalBronze);
        
        System.out.println("Average Payment per Day: RM" + totalAll / totalDay);
    }
}

class Room extends Patient {
    String typeRoom;
    int noDay;

    public Room() {
    }

    public String getTypeRoom() {
        return typeRoom;
    }

    public void setTypeRoom(String typeRoom) {
        this.typeRoom = typeRoom;
    }

    public int getNoDay() {
        return noDay;
    }

    public void setNoDay(int noDay) {
        this.noDay = noDay;
    }

    @Override
    public String toString() {
        return "Room{" + "typeRoom=" + typeRoom + ", noDay=" + noDay + '}';
    }
    
    public float calcPayment() {
        float roomPrice;
        float totalPrice;
        
        if (typeRoom.equals("Diamond")) {
            roomPrice = 200;
        } else if (typeRoom.equals("Gold")) {
            roomPrice = 100;
        } else if (typeRoom.equals("Silver")) {
            roomPrice = 80;
        } else if (typeRoom.equals("Bronze")) {
            roomPrice = 50;
        } else {
            roomPrice = 0;
        }
        
        if (noDay > 20) {
            totalPrice = roomPrice * noDay * Float.parseFloat("0.75");
        }
        else {
            totalPrice = roomPrice * noDay;
        }
        
        return totalPrice;
    }
    
    public void setInformation(String name, String patientNumber, String address, String noDay, String typeRoom) {
        this.patientName = name;
        this.patientNumber = Integer.parseInt(patientNumber);
        this.patientAddress = address;
        this.noDay = Integer.parseInt(noDay);
        this.typeRoom = typeRoom;
    }
}

        


