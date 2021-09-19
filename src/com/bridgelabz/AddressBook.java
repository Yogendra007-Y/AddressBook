package com.bridgelabz;

import java.util.ArrayList;
import java.util.Scanner;

class personalDetails{
    private String FirstName,LastName,Address,City,State,Email;
    long Zip,PhoneNumber;

    //create Constructor of the class to pass the parameters to constructor
    public personalDetails(String FirstName,String LastName,String Address,String City,String State,String Email,long Zip,long PhoneNumber){
        this.FirstName=FirstName;
        this.LastName=LastName;
        this.Address=Address;
        this.City=City;
        this.State=State;
        this.Email=Email;
        this.Zip=Zip;
        this.PhoneNumber=PhoneNumber;
    }
    /*Get And Set method used to access private variables of the class
    And also main class uses this variable with class object
     */
    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public long getZip() {
        return Zip;
    }

    public void setZip(long zip) {
        Zip = zip;
    }

    public long getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        PhoneNumber = phoneNumber;
    }
}

public class AddressBook {
    // taking arraylist with class object And it will store the value dynamic
    public static ArrayList<personalDetails> list = new ArrayList<personalDetails>();
    public static Scanner Sc = new Scanner(System.in);

    /* addperson method is to take input from the user
    personalDetails given as return type to the method as there are different type of parameter need to return the method
 */
    private static personalDetails addPerson() {
        System.out.println("Enter FirstName: ");
        String FirstName = Sc.next();
        System.out.println("Enter LastName: ");
        String LastName = Sc.next();
        System.out.println("Enter Address: ");
        String Address = Sc.next();
        System.out.println("Enter City: ");
        String City = Sc.next();
        System.out.println("Enter State: ");
        String State = Sc.next();
        System.out.println("Enter Email: ");
        String Email = Sc.next();
        System.out.println("Enter Zip: ");
        long Zip = Sc.nextLong();
        System.out.println("Enter PhoneNumber: ");
        long PhoneNumber = Sc.nextLong();
        personalDetails personalDetails = new personalDetails(FirstName, LastName, Address, City, State, Email, Zip, PhoneNumber);
        return personalDetails;

    }


    /* Display method is used to display the person data
    personalDetails class object given as the parameter to the Display method
     */
    private static void display(personalDetails personalDetail) {
        System.out.println("firstname is: " + personalDetail.getFirstName());
        System.out.println("lastname is: " + personalDetail.getLastName());
        System.out.println("address is: " + personalDetail.getAddress());
        System.out.println("city is: " + personalDetail.getCity());
        System.out.println("state is: " + personalDetail.getState());
        System.out.println("email is: " + personalDetail.getEmail());
        System.out.println("zip is: " + personalDetail.getZip());
        System.out.println("phoneNumber is: " + personalDetail.getPhoneNumber());
    }

    /*
     edit personmethod to edit the person detail
     */
    public static void editPersonalDetails() {
        System.out.println("Enter the name to edit in the addressBook");
        String editName = Sc.next();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getFirstName().equals(editName)) {
                System.out.print("Enter the below data user need to edit the addressBook");
                System.out.println("Press 1.firstname 2.lastname 3.address 4.city 5.state 6.email 7.zip 8.phone");
                int choice = Sc.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("Enter the firstname");
                        list.get(i).setFirstName(Sc.next());
                        break;
                    case 2:
                        System.out.println("Enter the lastname");
                        list.get(i).setLastName(Sc.next());
                        break;
                    case 3:
                        System.out.println("Enter the address");
                        list.get(i).setAddress(Sc.next());
                        break;
                    case 4:
                        System.out.println("Enter the city");
                        list.get(i).setCity(Sc.next());
                        break;
                    case 5:
                        System.out.println("Enter the state");
                        list.get(i).setState(Sc.next());
                        break;
                    case 6:
                        System.out.println("Emter the email");
                        list.get(i).setEmail(Sc.next());
                        break;
                    case 7:
                        System.out.println("Enter the zip");
                        list.get(i).setZip(Sc.nextInt());
                        break;
                    case 8:
                        System.out.println("Enter the phone");
                        list.get(i).setPhoneNumber(Sc.nextInt());
                        break;
                }
            }
        }
    }
    /*
     removepersondetails method to remove the person data
     */
    public static void removePersonDetails() {
        System.out.print("Enter the name you want to remove through the addressBook: ");
        String choice = Sc.next();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getFirstName().equals(choice)) {
                list.remove(i);
            } else {
                System.out.println("Enter the proper choice");
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Welcome to the Address Book");
        //creating the personal1Details class object to add the person detail

        int Val = 0;
        do {
            System.out.println("If You Want To Add, Edit Address Book Then Enter 1.Add 2.Edit 3.Remove:  ");
            int choice = Sc.nextInt();
            switch (choice) {
                case 1:
                    addPerson();
                    break;
                case 2:
                    editPersonalDetails();
                    break;
                case 3: removePersonDetails();
                    break;
            }
            personalDetails personalDetail1 = addPerson();
            list.add(personalDetail1);
            System.out.println("If You Want to Make Changes In AddressBook Then Enter 1 Else 0: ");
            Val = Sc.nextInt();
        }while (Val==1);
        System.out.println(list.size());
        for (int i = 0; i <list.size(); i++) {
            AddressBook.display(list.get(i)); //display method take the input as list and print the data
            System.out.println();
        }
    }
}