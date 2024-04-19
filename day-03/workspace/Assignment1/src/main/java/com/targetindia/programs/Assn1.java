package com.targetindia.programs;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.targetindia.util.KeyboardUtil;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.security.Key;
import java.util.Objects;

public class Assn1 {

    public static String filepath = "C:\\Users\\prabh\\OneDrive\\Desktop\\target-ready24\\day-03\\workspace\\Assignment1\\src\\main\\resources\\Customer.csv";
    static File file = new File(filepath);
    public static int Menu(){
        System.out.println("Here are the available options in the Menu:");
        System.out.println("1.Add Customer");
        System.out.println("2.View all Customers");
        System.out.println("3.Search Customer by city");
        System.out.println("4.Delete Customer by ID");
        System.out.println("5.Search Customer by ID and edit/update details");
        System.out.println("6.Exit");
        System.out.println();
        System.out.println();
        return KeyboardUtil.getInt("Please enter a valid input from the options given above: ");
    }
    public static void AddCustomer(String name,String city,String email, String number){

        int ID = 0;
        try {
            FileWriter outfile = new FileWriter(file, true); // true for append mode
            CSVWriter writer = new CSVWriter(outfile);

            try (CSVReader reader = new CSVReader(new FileReader(filepath))) {
                while (reader.readNext() != null) {
                    ID++;
                }
            } catch (IOException e) {
                System.out.println("An error occurred while reading the CSV file: " + e.getMessage());
            }
            if(ID==0){
                String[] header = {"ID","Name","City","Email","Phone"};
                writer.writeNext(header);
            }
            // Write data
            ID++;
            if(ID>=2){
                ID--;
            }
            String id = Integer.toString(ID);
            String[] data1 = { id, name, city, email, number };
            writer.writeNext(data1);
            writer.close();
            System.out.println("Data written to CSV file successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the CSV file: " + e.getMessage());
        }
    }

    public static void DisplayCustomers(){
        try (CSVReader reader = new CSVReader(new FileReader(filepath))) {
            String[] nextRecord;
            while ((nextRecord = reader.readNext()) != null) {
                for (String cell : nextRecord) {
                    System.out.print(cell + "   "); // Print each cell value
                }
                System.out.println();
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the CSV file: " + e.getMessage());
        }
    }

    public static void searchCustomerByCity(String city){
        int cnt=0;
        try (CSVReader reader = new CSVReader(new FileReader(filepath))) {
            String[] nextRecord;

            while ((nextRecord = reader.readNext()) != null) {
                if(Objects.equals(nextRecord[2], city)){
                    System.out.printf("Customer with %s as id belong to the city %s",nextRecord[0],city);
                    cnt++;
                }
                if(cnt>0){
                    System.out.println();
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the CSV file: " + e.getMessage());
        }
        if(cnt==0){
            System.out.println("Sorry there are no customers with given city");
        }
        System.out.println();
    }

//    public static void deleteCustomerByID(String ID){
//        int cnt=0;
//        try (CSVReader reader = new CSVReader(new FileReader(filepath))) {
//            String[] nextRecord;
//
//            while ((nextRecord = reader.readNext()) != null) {
//                if(Objects.equals(nextRecord[0], ID)){
//                    System.out.printf("Customer with %s as id belong to the city %s",nextRecord[0],city);
//                    cnt++;
//                }
//                if(cnt>0){
//                    System.out.println();
//                }
//            }
//        } catch (IOException e) {
//            System.out.println("An error occurred while reading the CSV file: " + e.getMessage());
//        }
//        if(cnt==0){
//            System.out.println("Sorry there are no customers with given city");
//        }
//        System.out.println();
//    }

    public static void searchAndEdit(){
        String id = KeyboardUtil.getString("Please input the customer id whose details are to be updated: ");
        String city = KeyboardUtil.getString("enter city to be updated");
        String mail = KeyboardUtil.getString("enter new mail: ");
        String number = KeyboardUtil.getString("enter number: ");
        try (CSVReader reader = new CSVReader(new FileReader(filepath))) {
            String[] nextRecord;
            while ((nextRecord = reader.readNext()) != null) {
                if(Objects.equals(nextRecord[0], id)){
                    nextRecord[2] = city;
                    nextRecord[3] = mail;
                    nextRecord[4] = number;
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the CSV file: " + e.getMessage());
        }

    }

    public static void main(String[] args) {
        int option = Assn1.Menu();
        while(option!=6){
            if(option>6 || option<1){
                System.out.println("Please enter a valid option");
            }
            switch (option){
                case 1:
                    System.out.println("Please provide customer Details:");
                    String name = KeyboardUtil.getString("Enter name: ");
                    String city = KeyboardUtil.getString("Enter city: ");
                    String email = KeyboardUtil.getString("Enter mail: ");
                    String number = KeyboardUtil.getString("Enter number: ");
                    Assn1.AddCustomer(name,city,email,number);
                    break;
                case 2:
                    System.out.println("Here is the data of all customers");
                    Assn1.DisplayCustomers();
                    break;

                case 3:
                    String cityName = KeyboardUtil.getString("Please enter the city name: ");
                    Assn1.searchCustomerByCity(cityName);
                    break;
                case 4:
                    break;
                case 5:
                    Assn1.searchAndEdit();
                    break;
            }
            option = Assn1.Menu();
        }
    }
}
