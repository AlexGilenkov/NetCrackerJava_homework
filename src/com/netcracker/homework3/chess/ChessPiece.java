package com.netcracker.homework3.chess;


public class ChessPiece {

    public static final int BLACK_EDGE = 7;
    public static final int WHITE_EDGE = 0;
    public static final int LEFT_EDGE = 0;
    public static final int RIGHT_EDGE = 7;

    private int row = -1; // 0 - 7
    private int column = -1; // 0 - 7

    public void setPosition (String coordinates){
        int[] coord = ChessPiece.stringToArrayInt(coordinates);

        if(coord == null){
            System.out.println("Error!");
            return;
        }

        this.row = coord[1];
        this.column = coord[0];
    }

    public String getPosition (){
        String coord = ChessPiece.arrayIntToString(new int[]{column, row});
        if(coord == null){
            System.out.println("error!");
        }
        return coord;
    }

    public static int[] stringToArrayInt(String coordinates){
        if(coordinates == null){
            System.out.println("Coordinates is null!");
            return null;
        }
        if(coordinates.equals("")) {
            System.out.println("Empty coordinates!");
            return null;
        }
        if(coordinates.length()!=2){
            System.out.println("Wrong lenght!");
            return null;
        }

        String str = coordinates.toLowerCase();
        char rowCh = str.charAt(0);
        char colCh = str.charAt(1);

        if(rowCh!='a' && rowCh!='b' && rowCh!='c' && rowCh!='d' &&
                rowCh!='e' && rowCh!='f' && rowCh!='g' && rowCh!='h'){
            System.out.println("Wrong first coordinate!");
            return null;
        }
        if(colCh!='1' && colCh!='2' && colCh!='3' && colCh!='4' &&
                colCh!='5' && colCh!='6' && colCh!='7' && colCh!='8') {
            System.out.println("Wrong second coordinate!");
            return null;
        }

        int col = Integer.parseInt(""+colCh) - 1;
        int row;

        switch (rowCh){
            case 'a': row = 0; break;
            case 'b': row = 1; break;
            case 'c': row = 2; break;
            case 'd': row = 3; break;
            case 'e': row = 4; break;
            case 'f': row = 5; break;
            case 'g': row = 6; break;
            case 'h': row = 7; break;
            default: System.out.println("error translater"); return null;
        }

        return new int[]{col, row};
    }

    public static String arrayIntToString(int[] coord){
        if(coord == null){
            System.out.println("Coordinates is null!");
            return null;
        }
        if(coord.length != 2){
            System.out.println("Wrong length!");
            return null;
        }
        if(coord[0] < 0 || coord[0] > 7){
            System.out.println("Wrong first coordinates!");
            return null;
        }
        if(coord[1] < 0 || coord[1] > 7){
            System.out.println("Wrong second coordinates!");
            return null;
        }

        String res = "";

        switch (coord[0]){
            case 0 : res = res + 'a'; break;
            case 1 : res = res + 'b'; break;
            case 2 : res = res + 'c'; break;
            case 3 : res = res + 'd'; break;
            case 4 : res = res + 'e'; break;
            case 5 : res = res + 'f'; break;
            case 6 : res = res + 'g'; break;
            case 7 : res = res + 'h'; break;
            default:
                System.out.println("wrong coordinates!"); return null;
        }

        res = res + (coord[1] + 1);

        return res.toUpperCase();
    }

}
