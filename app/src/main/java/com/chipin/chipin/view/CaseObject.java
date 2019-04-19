package com.chipin.chipin.view;

import java.util.ArrayList;

public class CaseObject {
    ArrayList<String> caseImages;
    ArrayList<String> caseGoals;
    String caseTitle;
    int progressReached;
    int progressTarget;
    String caseLocation;
    String caseDetails;

    public CaseObject(){

    }

    public CaseObject(ArrayList<String> caseImages, ArrayList<String> caseGoals, String caseTitle, int progressReached, int progressTarget, String caseLocation, String caseDetails) {
        this.caseImages = caseImages;
        this.caseGoals = caseGoals;
        this.caseTitle = caseTitle;
        this.progressReached = progressReached;
        this.progressTarget = progressTarget;
        this.caseLocation = caseLocation;
        this.caseDetails = caseDetails;
    }

    public ArrayList<String> getCaseImages() {
        return caseImages;
    }

    public void setCaseImages(ArrayList<String> caseImages) {
        this.caseImages = caseImages;
    }

    public ArrayList<String> getCaseGoals() {
        return caseGoals;
    }

    public void setCaseGoals(ArrayList<String> caseGoals) {
        this.caseGoals = caseGoals;
    }

    public String getCaseTitle() {
        return caseTitle;
    }

    public void setCaseTitle(String caseTitle) {
        this.caseTitle = caseTitle;
    }

    public int getProgressReached() {
        return progressReached;
    }

    public void setProgressReached(int progressReached) {
        this.progressReached = progressReached;
    }

    public int getProgressTarget() {
        return progressTarget;
    }

    public void setProgressTarget(int progressTarget) {
        this.progressTarget = progressTarget;
    }

    public String getCaseLocation() {
        return caseLocation;
    }

    public void setCaseLocation(String caseLocation) {
        this.caseLocation = caseLocation;
    }

    public String getCaseDetails() {
        return caseDetails;
    }

    public void setCaseDetails(String caseDetails) {
        this.caseDetails = caseDetails;
    }
}
