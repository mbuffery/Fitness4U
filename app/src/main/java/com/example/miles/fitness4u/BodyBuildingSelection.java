package com.example.miles.fitness4u;

/**
 * Created by miles on 5/17/2018.
 */

public class BodyBuildingSelection {

    public String title;
    public String subHeader;
    public String mainText;
    public String mainText2;
    public int imageId;


    public BodyBuildingSelection(String title, String mainText, String subHeader, String mainText2, int imageId)
    {
        this.title = title;
        this.mainText = mainText;
        this.subHeader = subHeader;
        this.mainText2 = mainText2;
        this.imageId = imageId;
    }
}
