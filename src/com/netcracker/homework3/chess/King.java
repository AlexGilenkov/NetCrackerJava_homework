package com.netcracker.homework3.chess;

import java.util.ArrayList;
import java.util.Arrays;

public class King extends Figure{

    public King(String color, String position) {
        this.color = color.toLowerCase();
        setPosition(position);
    }

    @Override
    public ArrayList<String> canMoveTo() {
        int[] pos = ChessPiece.stringToArrayInt(this.getPosition());

        ArrayList<String> moves = new ArrayList<>();

        for(int i = pos[0]-1; i<= pos[0]+1; i++){
            if(i<0 || i>7){
                continue;
            }
            for(int j = pos[1]-1; j <= pos[1]+1; j++){
                if(j<0 || j>7){
                    continue;
                }
                if(!Arrays.equals(new int[]{i,j}, pos))
                    moves.add(ChessPiece.arrayIntToString(new int[]{i,j}));
            }
        }

        return moves;
    }
}
