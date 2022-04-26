package com.netcracker.homework3.chess;

import java.util.ArrayList;
import java.util.Arrays;

public class Rook extends Figure{

    public Rook(String color, String position) {
        this.color = color.toLowerCase();
        setPosition(position);
    }

    @Override
    public ArrayList<String> canMoveTo() {
        int[] pos = ChessPiece.stringToArrayInt(this.getPosition());

        ArrayList<String> moves = new ArrayList<>();

        int[] temp = pos.clone();

        for(int i=0;i<temp[0];i++){
            moves.add(ChessPiece.arrayIntToString(new int[]{i, temp[1]}));
        }
        for(int i=temp[0]+1;i<8;i++){
            moves.add(ChessPiece.arrayIntToString(new int[]{i, temp[1]}));
        }
        for(int i=0;i<temp[1];i++){
            moves.add(ChessPiece.arrayIntToString(new int[]{temp[0], i}));
        }
        for(int i=temp[1]+1;i<8;i++){
            moves.add(ChessPiece.arrayIntToString(new int[]{temp[0], i}));
        }


        return moves;
    }
}
