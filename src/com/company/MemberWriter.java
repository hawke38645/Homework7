package com.company;
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.beans.XMLEncoder;
import org.json.simple.*;


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
                bw.write(InsuranceMembersToWrite.get(i).getFirstName() + "\t");
                bw.write(InsuranceMembersToWrite.get(i).getLastName() + "\t");
                bw.write(InsuranceMembersToWrite.get(i).getAge() + "\t");
                bw.write(InsuranceMembersToWrite.get(i).getHeight() + "\t");
                bw.write(InsuranceMembersToWrite.get(i).getWeight() + "\t");
                bw.write(InsuranceMembersToWrite.get(i).getBPSys() + "\t");
                bw.write(InsuranceMembersToWrite.get(i).getBPDias() + "\t");
                bw.write(InsuranceMembersToWrite.get(i).getCancer() + "\t");
                bw.write(InsuranceMembersToWrite.get(i).getDiabetes() + "\t");
                bw.write(InsuranceMembersToWrite.get(i).getAlzheimers() + "\t");
                bw.newLine();
            }
            bw.close();
            System.out.println("The data has been successfully written to the file.");
        } catch (IOException ex) {
            System.out.println("Could not write to file...");
        }
    }

    public static void writeMembersToBinaryFile(String fileName, ArrayList<InsuranceMember> InsuranceMembersToWrite) {
        try {
            FileOutputStream fos = new FileOutputStream(fileName);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(InsuranceMembersToWrite);
            oos.close();
            System.out.println("The data has been successfully written to the file.");
        } catch (IOException ex) {
            System.out.println("Could not write to file...");
        }
    }

    /***
     *
     * @param fileName the name of the file to be written to
     * @param InsuranceMembersToWrite The array list of members to write to the file
     */
    public static void writeMembersToXMLFile(String fileName, ArrayList<InsuranceMember> InsuranceMembersToWrite) {
        try {
            FileOutputStream fos = new FileOutputStream(fileName);
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            XMLEncoder xml = new XMLEncoder(new BufferedOutputStream(fos));
            xml.writeObject(InsuranceMembersToWrite);
            xml.close();
            System.out.println("The data has been successfully written to the file.");
        } catch (Exception ex) {
            System.out.println("Could not write to the file...");
        }
    }

    /***
     *
     * @param fileName the name of the JSON file to be written to
     * @param InsuranceScoresToWrite The array list of scores to write to the JSON file
     */
    public static void writeMembersToJSON(String fileName, ArrayList<InsuranceScore> InsuranceScoresToWrite) {
        try {
            FileWriter fw = new FileWriter(fileName);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            JSONObject ScoreObj;
            JSONArray ScoreObjArray = new JSONArray();
            //This is the loop for
            for (int i = 0; i < InsuranceScoresToWrite.size(); ++i) {
                ScoreObj = new JSONObject();
                ScoreObj.put("FirstName",InsuranceScoresToWrite.get(i).getFirstName());
                ScoreObj.put("LastName",InsuranceScoresToWrite.get(i).getLastName());
                ScoreObj.put("Score",InsuranceScoresToWrite.get(i).getScore());
                ScoreObj.put("RiskLevel",InsuranceScoresToWrite.get(i).getRiskLevel());
                ScoreObjArray.add(ScoreObj);
            }
            JSONObject outer = new JSONObject();
            outer.put("Insurance Scores", ScoreObjArray);
            pw.println(outer.toJSONString());
            pw.close();
            System.out.println("The data has been successfully written to the file.");
        }
        catch(Exception ex) {
            System.out.println("Could not write to the file...");
        }
    }
}