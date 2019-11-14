package com.company;
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;


public class MemberWriter {
    public static void writeMembersToTextFile(String fileName, ArrayList<InsuranceMember> InsuranceMembersToWrite) {
        try {
            //Creating a new file and object to write to the file
            File file = new File(fileName);
            FileOutputStream fos = new FileOutputStream(file);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
            //Here we cycle through the ArrayList of InsuranceMember objects and use the get functions to push out each
            //individual InsuranceMember's information with a tab. A new line is created at the end and it all repeats.
            for (int i = 0; i < InsuranceMembersToWrite.size(); ++i) {
                bw.write(InsuranceMembersToWrite.get(i).getFirstName()+"\t");
                bw.write(InsuranceMembersToWrite.get(i).getLastName()+"\t");
                bw.write(InsuranceMembersToWrite.get(i).getAge()+"\t");
                bw.write(InsuranceMembersToWrite.get(i).getHeight()+"\t");
                bw.write(InsuranceMembersToWrite.get(i).getWeight()+"\t");
                bw.write(InsuranceMembersToWrite.get(i).getBPSys()+"\t");
                bw.write(InsuranceMembersToWrite.get(i).getBPDias()+"\t");
                bw.write(InsuranceMembersToWrite.get(i).getCancer()+"\t");
                bw.write(InsuranceMembersToWrite.get(i).getDiabetes()+"\t");
                bw.write(InsuranceMembersToWrite.get(i).getAlzheimers()+"\t");
                bw.newLine();
            }
            bw.close();
            System.out.println("The file has been written.");
        }
        catch (IOException ex) {
            System.out.println("Could not write to file...");
        }
    }
    public static void writeMembersToBinaryFile(String fileName, ArrayList<InsuranceMember> InsuranceMembersToWrite) {
        try {
            FileOutputStream fos = new FileOutputStream(new File(fileName));
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(InsuranceMembersToWrite);
            oos.close();
            System.out.println("Successfully written data to the file");
        }
        catch (IOException ex) {
            System.out.println("Could not write to file...");
        }
    }
    public static void writeMembersToXMLFile(String fileName, ArrayList<InsuranceMember> InsuranceMembersToWrite) {

    }
}