package com.netcracker.homework3.chess;

import java.util.ArrayList;

public class Queen extends Figure{

    public Queen(String color, String position) {
        this.color = color.toLowerCase();
        setPosition(position);
    }

    @Override
    public ArrayList<String> canMoveTo() {
        ArrayList<String> moves = new ArrayList<>();

        moves.addAll(new Bishop(this.color, this.getPosition()).canMoveTo());
        moves.addAll(new Rook(this.color, this.getPosition()).canMoveTo());

        return moves;
    }
}
