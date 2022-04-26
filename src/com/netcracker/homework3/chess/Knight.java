package com.netcracker.homework3.chess;

import java.util.ArrayList;
import java.util.Arrays;

public class Knight extends Figure{

    public Knight(String color, String position) {
        this.color = color.toLowerCase();
        setPosition(position);
    }

    @Override
    public ArrayList<String> canMoveTo() {
        int[] pos = ChessPiece.stringToArrayInt(this.getPosition());

        ArrayList<String> moves = new ArrayList<>();

        int[][] temp = new int[8][2];
        temp[0][0] = pos[0]+1; temp[0][1] = pos[1]+2;
        temp[1][0] = pos[0]-1; temp[1][1] = pos[1]+2;
        temp[2][0] = pos[0]+2; temp[2][1] = pos[1]-1;
        temp[3][0] = pos[0]+2; temp[3][1] = pos[1]+1;
        temp[4][0] = pos[0]-2; temp[4][1] = pos[1]-1;
        temp[5][0] = pos[0]-2; temp[5][1] = pos[1]+1;
        temp[6][0] = pos[0]+1; temp[6][1] = pos[1]-2;
        temp[7][0] = pos[0]-1; temp[7][1] = pos[1]-2;

        for(int i=0; i<8; i++){
            if(temp[i][0]>7 || temp[i][0]<0 || temp[i][1]>7 || temp[i][1]<0){
                temp[i] = null;
            }
        }

        for(int i=0; i< 8; i++){
            if(Arrays.equals(temp[i], null)){
                continue;
            }
            moves.add(ChessPiece.arrayIntToString(temp[i]));
        }


        return moves;
    }
}
