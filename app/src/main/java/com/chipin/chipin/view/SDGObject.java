package com.chipin.chipin.view;

import android.media.Image;

public class SDGObject {
    String sdgImage;
    String sdgTitle;
    String sdgDetails;

    public SDGObject(){

    }

    public String getSdgImage() {
        return sdgImage;
    }

    public void setSdgImage(String sdgImage) {
        this.sdgImage = sdgImage;
    }

    public String getSdgTitle() {
        return sdgTitle;
    }

    public void setSdgTitle(String sdgTitle) {
        this.sdgTitle = sdgTitle;
    }

    public String getSdgDetails() {
        return sdgDetails;
    }

    public void setSdgDetails(String sdgDetails) {
        this.sdgDetails = sdgDetails;
    }

    public SDGObject(String sdgImage, String sdgTitle, String sdgDetails) {
        this.sdgImage = sdgImage;
        this.sdgTitle = sdgTitle;
        this.sdgDetails = sdgDetails;
    }
}
