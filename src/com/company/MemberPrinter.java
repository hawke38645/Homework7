package com.company;
import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class MemberPrinter {
    public static void printInsuranceMember(InsuranceMember[] InsuranceMemberArray) {
        for (int i = 0; i < InsuranceMemberArray.length; i++) {
            System.out.print(InsuranceMemberArray[i].getFirstName());
            System.out.print(",");
            System.out.println(InsuranceMemberArray[i].getLastName());
            System.out.print("Age: ");
            System.out.println(InsuranceMemberArray[i].getAge());
            System.out.print("Height: ");
            System.out.println(InsuranceMemberArray[i].getHeight());
            System.out.print("Weight: ");
            System.out.println(InsuranceMemberArray[i].getWeight());
            System.out.print("BP Sys: ");
            System.out.println(InsuranceMemberArray[i].getBPSys());
            System.out.print("BP Dias: ");
            System.out.println(InsuranceMemberArray[i].getBPDias());
            System.out.print("Cancer: ");
            System.out.println(InsuranceMemberArray[i].getCancer());
            System.out.print("Diabetes: ");
            System.out.println(InsuranceMemberArray[i].getDiabetes());
            System.out.print("Alzheimer's: ");
            System.out.println(InsuranceMemberArray[i].getAlzheimers());
        }
    }
}
