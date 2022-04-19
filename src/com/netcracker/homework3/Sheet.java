package com.netcracker.homework3;

/*
    Programming project 3.4
 */


public class Sheet {
    private int heigth = 1189;
    private int width = 841;
    private String type = "A0";


    public Sheet cutInHalf(){


        Sheet halfSheet = new Sheet();
        switch (this.type){
            case "A0": halfSheet.type = "A1"; break;
            case "A1": halfSheet.type = "A2"; break;
            case "A2": halfSheet.type = "A3"; break;
            case "A3": halfSheet.type = "A4"; break;
            case "A4": halfSheet.type = "A5"; break;
            case "A5": halfSheet.type = "A6"; break;
            default: {
                System.out.println("Меньше нельзя!");
                return this;
            }
        }
        halfSheet.heigth = this.width;
        halfSheet.width = this.heigth/2;
        return halfSheet;
    }

    @Override
    public String toString() {
        return "Sheet{" +
                "heigth=" + heigth +
                ", width=" + width +
                ", type='" + type + '\'' +
                '}';
    }
}
