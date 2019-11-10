package com.company;
import java.util.Scanner;
import java.io.File;

public class Main {
    public static void printWelcomeMessage() {
            System.out.println("Welcome to the INSURANCE SCORE CARD PROGRAM");
            System.out.println("This program will be used to calculate risk");
            System.out.println("on insurance. File saving can be done in binary,");
            System.out.println("XML, and text.");
    }
    public static void main(String[] args) {
        printWelcomeMessage();
        //Collect Input for file name
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the name of the data file: ");
        String fname = sc.nextLine();
        //I am declaring an array of InsuranceMember objects and setting them equal to what
        //is read out of the file and into the InsuranceMember Array in the MemberReader function.
        InsuranceMember[] InsuranceMemberArray = new InsuranceMember[3];
        InsuranceMemberArray = MemberReader.readMembers(fname);
        if(InsuranceMemberArray == null) {
            System.out.println("The file could not be read...");
        }
        MemberPrinter.printInsuranceMember(InsuranceMemberArray);
    }
}
