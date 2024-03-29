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
    public static void printGoodbyeMessage() {
        System.out.println("****************************************************");
        System.out.println("THANK YOU FOR USING THE INSURANCE SCORE CARD PROGRAM");
        System.out.println("****************************************************");
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
    public static <label> void main(String[] args) {
        printWelcomeMessage();
        //Collect Input for file name
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the name of the data file: ");
        String fname = sc.nextLine();
        //I am declaring an array of InsuranceMember objects and setting them equal to what
        //is read out of the file and into the InsuranceMember Array in the MemberReader function.
        ArrayList<InsuranceMember> InsuranceMembers = MemberReader.readMembersFromTextFile(fname);
        if(InsuranceMembers == null) {
            System.out.println("The file could not be read...");
        }
        if (InsuranceMembers != null) {
            System.out.print(InsuranceMembers.size());
            System.out.println(" members were read.");
        }
        //Now we will be showing the menu and taking in the user's choice (an integer).
        showMenu();
        int choice = sc.nextInt();
        LOOP:
        do {
            if (choice == 1) {
                //List all members
                MemberPrinter.printInsuranceMember(InsuranceMembers);
            }
            else if (choice == 2) {
                //Add a new member
               InsuranceMembers.add(AddMember.addNewMember());
            }
            else if (choice == 3) {
                //Save members(As text(T or t), binary(B or b), or XML(X or x))
                Scanner nsc = new Scanner(System.in);
                System.out.print("Please enter the name of the file to create: ");
                String fileName = nsc.nextLine();
                System.out.println("(T)ext, (B)inary, or (X)ML?");
                System.out.print("Please enter your choice: ");
                String fileChoice = nsc.nextLine();
                    if (fileChoice.equals("T") || fileChoice.equals("t")) {
                        MemberWriter.writeMembersToTextFile(fileName, InsuranceMembers);
                    }
                    else if (fileChoice.equals("B") || fileChoice.equals("b")) {
                        MemberWriter.writeMembersToBinaryFile(fileName, InsuranceMembers);
                    }
                    else if (fileChoice.equals("X") || fileChoice.equals("x")) {
                        MemberWriter.writeMembersToXMLFile(fileName, InsuranceMembers);
                    }
                    else {
                        System.out.println("Could not verify file type.");
                        System.out.println("Please select the 'Save Members' option again and enter t, b, or x.");
                    }
            }
            else if (choice == 4) {
                //Load members
                //This ArrayList was created to store the new members until the check for whether or not any new members
                //have been read is made at the end of the loop (last if statement).
                ArrayList<InsuranceMember> InsuranceMembersRead = new ArrayList<InsuranceMember>();
                Scanner nsc = new Scanner(System.in);
                System.out.println("(T)ext, (B)inary, or (X)ML?");
                String fileChoice = nsc.nextLine();
                System.out.print("Please enter the name of the file to load: ");
                String fileName = nsc.nextLine();
                if (fileChoice.equals("T") || fileChoice.equals("t")) {
                    InsuranceMembersRead = MemberReader.readMembersFromTextFile(fileName);
                }
                else if (fileChoice.equals("B") || fileChoice.equals("b")) {
                    InsuranceMembersRead = MemberReader.readMembersFromBinaryFile(fileName);
                }
                else if (fileChoice.equals("X") || fileChoice.equals("x")) {
                    InsuranceMembersRead = MemberReader.readMembersFromXMLFile(fileName);
                }
                else {
                    System.out.println("Could not verify file type.");
                    System.out.println("Please select the 'Load Members' option again and enter t, b, or x.");
                }
                //If the members were read into the InsuranceMembers ArrayList properly, this loop will print out.
                if (InsuranceMembersRead != null) {
                    System.out.print(InsuranceMembersRead.size());
                    System.out.println(" members were read.");
                }
                //This is setting the ArrayList used to list members on the screen equal to the one just read from file.
                InsuranceMembers = InsuranceMembersRead;
            }
            else if (choice == 5) {
                //Assess members
                Assessor.printScoreCards(Assessor.AssessMembers(InsuranceMembers));
            }
            else if (choice == 6) {
                //Save assessments as JSON file.
                Scanner nsc = new Scanner(System.in);
                //This first part is creating an array list of InsuranceScore objects and filling it with the return of
                //the AssessMembers function in order to send it to the writeMembersToJSON function next.
                ArrayList<InsuranceScore> InsuranceScores = new ArrayList<InsuranceScore>();
                InsuranceScores = Assessor.AssessMembers(InsuranceMembers);
                System.out.print("Please enter the name of the JSON file to create: ");
                String fileName = nsc.nextLine();
                MemberWriter.writeMembersToJSON(fileName, InsuranceScores);
            }
            else if (choice == 7){
                break LOOP;
            }
            else {
                System.out.println("Please select a valid choice from above.");
            }
            showMenu();
            choice = sc.nextInt();
        } while(choice != 7);
        printGoodbyeMessage();
    }
}
