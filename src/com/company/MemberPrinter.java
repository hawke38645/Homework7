package com.company;
import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class MemberPrinter {
    public static void printInsuranceMember(ArrayList<InsuranceMember> InsuranceMembers) {
        for (int i = 0; i < InsuranceMembers.size(); ++i) {
            System.out.print(InsuranceMembers.get(i).getFirstName());
            System.out.print(",");
            System.out.println(InsuranceMembers.get(i).getLastName());
            System.out.print("Age: ");
            System.out.println(InsuranceMembers.get(i).getAge());
            System.out.print("Height: ");
            System.out.println(InsuranceMembers.get(i).getHeight());
            System.out.println(" in.");
            System.out.print("Weight: ");
            System.out.print(InsuranceMembers.get(i).getWeight());
            System.out.println(" lbs.");
            System.out.print("BP Sys: ");
            System.out.println(InsuranceMembers.get(i).getBPSys());
            System.out.print("BP Dias: ");
            System.out.println(InsuranceMembers.get(i).getBPDias());
            System.out.print("Cancer: ");
            System.out.println(InsuranceMembers.get(i).getCancer());
            System.out.print("Diabetes: ");
            System.out.println(InsuranceMembers.get(i).getDiabetes());
            System.out.print("Alzheimer's: ");
            System.out.println(InsuranceMembers.get(i).getAlzheimers());
            System.out.println("*****************************");
        }
    }
}
