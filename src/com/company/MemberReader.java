package com.company;
import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MemberReader {
    public static List<String> MemberData;
    public static InsuranceMember[] InsuranceMemberArray = new InsuranceMember[3];
    public static InsuranceMember[] readMembers (String fname) {
        try {
            MemberData = new ArrayList<String>();
            Scanner fsc = new Scanner(new File(fname));
            String line;
            int counter = 0;

            while(fsc.hasNextLine()) {
                line = fsc.nextLine().trim();
                MemberData = Arrays.asList(line.split("\t"));

                InsuranceMemberArray[counter].setFirstName(MemberData.get(0));
                InsuranceMemberArray[counter].setLastName(MemberData.get(1));
                InsuranceMemberArray[counter].setAge(Integer.parseInt(MemberData.get(2)));
                InsuranceMemberArray[counter].setHeight(Integer.parseInt(MemberData.get(3)));
                InsuranceMemberArray[counter].setWeight(Integer.parseInt(MemberData.get(4)));
                InsuranceMemberArray[counter].setBPSys(Integer.parseInt(MemberData.get(5)));
                InsuranceMemberArray[counter].setBPDias(Integer.parseInt(MemberData.get(6)));
                InsuranceMemberArray[counter].setCancer(MemberData.get(7));
                InsuranceMemberArray[counter].setDiabetes(MemberData.get(8));
                InsuranceMemberArray[counter].setAlzheimers(MemberData.get(9));

                counter = counter + 1;
                fsc.nextLine();
            }
            fsc.close();
        }
        catch (Exception ex) {
            return null;
        }
        return InsuranceMemberArray;
    }
}