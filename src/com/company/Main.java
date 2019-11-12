package com.company;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;

public class Main {
    public static void printWelcomeMessage() {
            System.out.println("**INSURANCE SCORE CARD PROGRAM**");
            System.out.println("This program will be used to calculate risk");
            System.out.println("on insurance. File saving can be done in binary,");
            System.out.println("XML, and text.");
    }
    public static void showMenu() {
        System.out.println("Please choose an option from the menu below:");
        System.out.println("1.List all members");
        System.out.println("2.Add a new member");
        System.out.println("3.Save members");
        System.out.println("4.Load members");
        System.out.println("5.Assess members");
        System.out.println("6.Save assessments as JSON file");
        System.out.println("7.Exit");
    }
    public static void main(String[] args) {
        printWelcomeMessage();
        //Collect Input for file name
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the name of the data file: ");
        String fname = sc.nextLine();
        //I am declaring an array of InsuranceMember objects and setting them equal to what
        //is read out of the file and into the InsuranceMember Array in the MemberReader function.
        ArrayList<InsuranceMember> InsuranceMembers = MemberReader.readMembers(fname);
        if(InsuranceMembers == null) {
            System.out.println("The file could not be read...");
        }
        //Now we will be showing the menu and taking in the user's choice (an integer).
        showMenu();
        int choice = sc.nextInt();
        do {
            if(choice == 1) {
                //List all members
                MemberPrinter.printInsuranceMember(InsuranceMembers);
            }

            else if(choice == 2) {
                //Add a new member
               InsuranceMembers.add(AddMember.addNewMember());
            }
            else if(choice == 3) {
                //Save members(As text(T), binary(B), or XML(X))
            }
            else if(choice == 4) {
                //Load members
            }
            else if(choice == 5) {
                //Assess members
                Assessor.printScoreCards(Assessor.AssessMembers(InsuranceMembers));
            }
            else if(choice == 6) {
                //Save assessments as JSON file.
            }
            else {
                System.out.println("Please select a valid choice from above.");
            }
            showMenu();
            choice = sc.nextInt();
        } while(choice != 7);
    }
}
