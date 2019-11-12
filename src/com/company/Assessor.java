package com.company;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Assessor {
    public static ArrayList<InsuranceScore> AssessMembers(ArrayList<InsuranceMember> InsuranceMembers) {
        ArrayList<InsuranceScore> InsuranceScores = new ArrayList<InsuranceScore>();

        for (int i = 0; i < InsuranceMembers.size(); ++i) {
            InsuranceScore newScore = new InsuranceScore();
            newScore.setFirstName(InsuranceMembers.get(i).getFirstName());
            newScore.setLastName(InsuranceMembers.get(i).getLastName());
            //This section is devoted to passing the various parts of InsuranceMember data to the right functions in
            //order to calculate scores to ascertain risk levels.
            int score1 = calculateBMIScore(InsuranceMembers.get(i).getHeight(), InsuranceMembers.get(i).getWeight());
            int score2 = calculateBloodPressureScore(InsuranceMembers.get(i).getBPSys(), InsuranceMembers.get(i).getBPDias());
            int score3 = calculateHistoryScore(InsuranceMembers.get(i).getCancer(), InsuranceMembers.get(i).getDiabetes(), InsuranceMembers.get(i).getAlzheimers());
            //This section uses the information collected above to ascertain risk levels.
            newScore.setScore(score1 + score2 + score3);
            newScore.setRiskLevel(calculateRiskLevel(score1, score2, score3));
            //Finally, we push the new score onto the ArrayList of InsuranceScore objects.
            InsuranceScores.add(newScore);
        }
        return InsuranceScores;
    }

    public static int calculateBMIScore(int height, int weight) {
        int BMI_score;
        double height2 = height;
        double weight2 = weight;
        double BMI = (weight2 * 703) / (height2 * height2);

        if (BMI >= 18.5 && BMI <= 24.9) {
            BMI_score = 0;
        }
        else if (BMI >= 25 && BMI <= 29.9) {
            BMI_score = 30;
        }
        else {
            BMI_score = 75;
        }
        return BMI_score;
    }
    public static int calculateBloodPressureScore(int BPSys, int BPDias) {
        int BP_score = 0;
         if (BPSys <= 120 && BPDias <= 80) {
            BP_score = 0;
        }
         else if ((BPSys > 120 && BPSys <= 129) && BPDias <= 80) {
             BP_score = 15;
         }
         else if ((BPSys > 129 && BPSys <= 139) && (BPDias > 80 && BPDias <= 89)) {
            BP_score = 30;
        }
        else if ((BPSys > 130 && BPSys <= 140) && (BPDias > 89 && BPDias <= 119)) {
            BP_score = 75;
        }
        else if (BPSys > 180 && BPDias > 120) {
            BP_score = 100;
        }
        return BP_score;
    }
    public static int calculateHistoryScore(String Cancer, String Diabetes, String Alzheimers) {
        int historyScore = 0;

        if (Cancer.equals("y") || Cancer.equals("Y")) {
            historyScore += 10;
        }
        else if (Diabetes.equals("y") || Diabetes.equals("Y")) {
            historyScore += 10;
        }
        else if (Alzheimers.equals("y") || Alzheimers.equals("Y")) {
            historyScore += 10;
        }
        return historyScore;
    }
    public static String calculateRiskLevel(int score1, int score2, int score3) {
        int finalScore = score1 + score2 + score3;
        String riskLevel;
        if (finalScore <= 20) {
            riskLevel = "Low Risk";
        }
        else if (finalScore <= 50) {
            riskLevel = "Moderate Risk";
        }
        else if (finalScore <= 75) {
            riskLevel = "High Risk";
        }
        else {
            riskLevel = "Cannot be insured";
        }
        return riskLevel;
    }
    public static void printScoreCards(ArrayList<InsuranceScore> InsuranceScores) {
        System.out.println("The insurance assessments are as follows: ");
        for (int i = 0; i < InsuranceScores.size(); ++i) {
            System.out.print("Name: ");
            System.out.print(InsuranceScores.get(i).getLastName());
            System.out.print(",");
            System.out.println(InsuranceScores.get(i).getFirstName());
            System.out.print("Score: ");
            System.out.println(InsuranceScores.get(i).getScore());
            System.out.print("Risk Level: ");
            System.out.println(InsuranceScores.get(i).getRiskLevel());
            System.out.println("*********************************");
        }
    }
}
