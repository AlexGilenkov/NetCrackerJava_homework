package com.netcracker.homework2;

public class Container {
    private int x1;
    private int y1;
    private int x2;
    private int y2;

    public Container(int x, int y, int width, int height){
        this.x1 = x;
        this.y1 = y;
        this.x2 = x+width;
        this.y2 = y+height;

    }

    public int getX() {
        return x1;
    }

    public int getY() {
        return y1;
    }

    public int getWidth(){
        return x2 - x1;
    }

    public int getHeight(){
        return y2 - y1;
    }

    public boolean collides(Ball ball){
        // Проверка, а влезет ли мяч вообще....
        if(ball.getRadius()*2>this.getWidth() ||
                ball.getRadius()*2>this.getHeight()){
            System.out.println("Мяч не влез в контейнер '_'");
            return false;
        }


        if((ball.getX() - ball.getRadius()<this.x1) ||
                (ball.getX() + ball.getRadius()>this.x2) ||
                (ball.getY() - ball.getRadius()<this.y1) ||
                (ball.getY() + ball.getRadius()>this.y2))
            return false;

        return true;
    }

    @Override
    public String toString() {
        return "Container[(" + x1 +',' + y1 +
                "),(" + x2 +',' + y2 +")]";
    }
}
