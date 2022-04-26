package com.netcracker.homework3.chess;

import java.util.ArrayList;

public abstract class Figure extends ChessPiece{
    String color;

    public abstract ArrayList<String> canMoveTo();

}
