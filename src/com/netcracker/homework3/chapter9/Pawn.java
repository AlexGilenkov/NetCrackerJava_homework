package com.netcracker.homework3.chapter9;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends Figure{


    public Pawn(String color, String position) {
        this.color = color;
        setPosition(position);
    }

    @Override
    public ArrayList<String> canMoveTo() {
        int[] pos = ChessPiece.stringToArrayInt(this.getPosition());

        ArrayList<String> moves = new ArrayList<>();

        if(color!=null && color.toUpperCase().equals("white")){
            if(pos[0]==1)
        }


        return moves;
    }
}
