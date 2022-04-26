package com.netcracker.homework3.chess;

import java.util.ArrayList;

public class Pawn extends Figure{


    public Pawn(String color, String position) {
        this.color = color.toLowerCase();
        setPosition(position);
    }

    @Override
    public ArrayList<String> canMoveTo() {
        int[] pos = ChessPiece.stringToArrayInt(this.getPosition());

        ArrayList<String> moves = new ArrayList<>();

        if(pos[0]==BLACK_EDGE || pos[1] == WHITE_EDGE){
            // замена фигуры, так как пешка прошла до противоположного конца поля
            System.out.println("I can't it!");
        }

        if(this.color.equals("white") && pos[1] < BLACK_EDGE){
            moves.add(ChessPiece.arrayIntToString(new int[]{pos[0], pos[1]+1}));
        }
        if(this.color.equals("white") && pos[1] == 1){
            moves.add(ChessPiece.arrayIntToString(new int[]{pos[0], pos[1]+2}));
        }
        if(this.color.equals("black") && pos[1] > WHITE_EDGE){
            moves.add(ChessPiece.arrayIntToString(new int[]{pos[0], pos[1]-1}));
        }
        if(this.color.equals("black") && pos[1] == 6){
            moves.add(ChessPiece.arrayIntToString(new int[]{pos[0], pos[1]-2}));
        }

        return moves;
    }
}
