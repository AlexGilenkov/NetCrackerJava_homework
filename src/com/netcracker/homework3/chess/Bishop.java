package com.netcracker.homework3.chess;

import java.util.ArrayList;
import java.util.Arrays;

public class Bishop extends Figure{

    public Bishop(String color, String position) {
        this.color = color.toLowerCase();
        setPosition(position);
    }

    @Override
    public ArrayList<String> canMoveTo() {
        int[] pos = ChessPiece.stringToArrayInt(this.getPosition());

        ArrayList<String> moves = new ArrayList<>();

        int[] temp;
        temp = pos.clone();
        while((temp[0]-= 1) >= 0 && (temp[1]-=1)>=0){
            moves.add(ChessPiece.arrayIntToString(temp));
        }
        temp = Arrays.copyOf(pos, pos.length);
        while((temp[0]+=1)<8 && (temp[1]-=1)>=0){
            moves.add(ChessPiece.arrayIntToString(temp));
        }
        temp = Arrays.copyOf(pos, pos.length);
        while((temp[0]-=1)>=0 && (temp[1]+=1)<8){
            moves.add(ChessPiece.arrayIntToString(temp));
        }
        temp = Arrays.copyOf(pos, pos.length);
        while((temp[0]+=1)<8 && (temp[1]+=1)<8){
            moves.add(ChessPiece.arrayIntToString(temp));
        }

        return moves;
    }
}
