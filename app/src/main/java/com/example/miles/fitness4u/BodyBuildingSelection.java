package com.example.miles.fitness4u;

/**
 * Created by miles on 5/17/2018.
 */

public class BodyBuildingSelection {

    public String title;
    public String subHeader;
    public String mainText;
    public String mainText2;
    public String mainText3;
    public String mainText4;
    public String mainText5;
    public int imageId;


    public BodyBuildingSelection(String title,String subHeader, String mainText,String mainText2,String mainText3,String mainText4,String mainText5, int imageId)
    {
        this.title = title;
        this.subHeader = subHeader;
        this.mainText = mainText;
        this.mainText2 = mainText2;
        this.mainText3 = mainText3;
        this.mainText4 = mainText4;
        this.mainText5 = mainText5;
        this.imageId = imageId;
    }
}
