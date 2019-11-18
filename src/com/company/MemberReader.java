package com.company;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.beans.XMLDecoder;

public class MemberReader {
    public static List<String> MemberData;
    public static ArrayList<InsuranceMember> InsuranceMemberArrayList = new ArrayList<InsuranceMember>();
    public static ArrayList<InsuranceMember> readMembersFromTextFile (String fname) {
        try {
            MemberData = new ArrayList<String>();
            Scanner fsc = new Scanner(new File(fname));
            String line;

            while (fsc.hasNextLine()) {
                line = fsc.nextLine().trim();
                MemberData = Arrays.asList(line.split("\t"));
                //Here I created an InsuranceMember object to hold the data from the file then adding it to the list.
                InsuranceMember member = new InsuranceMember();
                member.setFirstName(MemberData.get(0));
                member.setLastName(MemberData.get(1));
                member.setAge(Integer.parseInt(MemberData.get(2)));
                member.setHeight(Integer.parseInt(MemberData.get(3)));
                member.setWeight(Integer.parseInt(MemberData.get(4)));
                member.setBPSys(Integer.parseInt(MemberData.get(5)));
                member.setBPDias(Integer.parseInt(MemberData.get(6)));
                member.setCancer(MemberData.get(7));
                member.setDiabetes(MemberData.get(8));
                member.setAlzheimers(MemberData.get(9));

                InsuranceMemberArrayList.add(member);
            }
            fsc.close();
            return InsuranceMemberArrayList;
        }
        catch (Exception ex) {
            return null;
        }
    }
    public static ArrayList<InsuranceMember> readMembersFromBinaryFile (String fname) {
        try {
            FileInputStream fis = new FileInputStream(fname);
            ObjectInputStream ois = new ObjectInputStream(fis);
            InsuranceMemberArrayList = (ArrayList<InsuranceMember>)ois.readObject();
            ois.close();
            return InsuranceMemberArrayList;
        }
        catch (Exception ex) {
            return null;
        }
    }
    public static ArrayList<InsuranceMember> readMembersFromXMLFile (String fname) {
        try {
            FileInputStream fis = new FileInputStream(fname);
            BufferedInputStream bis = new BufferedInputStream(fis);
            XMLDecoder xml = new XMLDecoder(bis);
            ArrayList<InsuranceMember> InsuranceMemberArrayList = (ArrayList<InsuranceMember>) xml.readObject();
            xml.close();
            return InsuranceMemberArrayList;
        }
        catch (Exception ex) {
            return null;
        }
    }
}