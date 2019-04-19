package com.chipin.chipin.view;

import java.util.ArrayList;

public class UserObject {
    String profilePictureUrl;
    String firstName;
    String lastName;
    double donatedAmount;
    int helped;
    int impacted;
    ArrayList<CaseObject> favorites;
    ArrayList<CaseObject> donations;

    public UserObject()
    {

    }

    public UserObject(String profilePictureUrl, String firstName, String lastName, double donatedAmount, int helped, int impacted, ArrayList<CaseObject> favorites, ArrayList<CaseObject> donations) {
        this.profilePictureUrl = profilePictureUrl;
        this.firstName = firstName;
        this.lastName = lastName;
        this.donatedAmount = donatedAmount;
        this.helped = helped;
        this.impacted = impacted;
        this.favorites = favorites;
        this.donations = donations;
    }

    public String getProfilePictureUrl() {
        return profilePictureUrl;
    }

    public void setProfilePictureUrl(String profilePictureUrl) {
        this.profilePictureUrl = profilePictureUrl;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getDonatedAmount() {
        return donatedAmount;
    }

    public void setDonatedAmount(double donatedAmount) {
        this.donatedAmount = donatedAmount;
    }

    public int getHelped() {
        return helped;
    }

    public void setHelped(int helped) {
        this.helped = helped;
    }

    public int getImpacted() {
        return impacted;
    }

    public void setImpacted(int impacted) {
        this.impacted = impacted;
    }

    public ArrayList<CaseObject> getFavorites() {
        return favorites;
    }

    public void setFavorites(ArrayList<CaseObject> favorites) {
        this.favorites = favorites;
    }

    public ArrayList<CaseObject> getDonations() {
        return donations;
    }

    public void setDonations(ArrayList<CaseObject> donations) {
        this.donations = donations;
    }
}
