package com.company;
import java.util.Scanner;
import java.util.ArrayList;

public class AddMember {
    public static InsuranceMember addNewMember()
    {
        //Here we create a new InsuranceMember object and use the member set functions to feed it values from the user.
        Scanner sc = new Scanner(System.in);
        InsuranceMember newMember = new InsuranceMember();

        System.out.println("Please enter the new member's first name: ");
        newMember.setFirstName(sc.nextLine().trim());
        System.out.println("Please enter the new member's surname: ");
        newMember.setLastName(sc.nextLine().trim());
        System.out.println("Please enter the new member's age: ");
        newMember.setAge(sc.nextInt());
        System.out.println("Please enter the new member's height: ");
        newMember.setHeight(sc.nextInt());
        System.out.println("Please enter the new member's weight: ");
        newMember.setWeight(sc.nextInt());
        System.out.println("Please enter the new member's Systolic Blood Pressure Number: ");
        newMember.setBPSys(sc.nextInt());
        System.out.println("Please enter the new member's Diastolic Blood Pressure Number: ");
        newMember.setBPDias(sc.nextInt());
        System.out.println("Does the new member have a family history of cancer? (Y or N) ");
        newMember.setCancer(sc.nextLine().trim());
        System.out.println("Does the new member have a family history of diabetes? (Y or N) ");
        newMember.setDiabetes(sc.nextLine().trim());
        System.out.println("Does the new member have a family history of Alzheimer's Disease? (Y or N) ");
        newMember.setAlzheimers(sc.nextLine().trim());
        System.out.println("Thank you, the new member has been added.");

        return newMember;
    }
}
