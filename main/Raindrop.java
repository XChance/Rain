package main;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Raindrop {
    int x;
    int y ;
    int z;
    int width;
    int length;
    int yVel;
    Random rd;
    Color purple;
    Color color;

    public Raindrop(){
        rd = new Random();
        z = rd.nextInt(20);
        choosePos();
        chooseVel();
        chooseDims();
        purple = new Color(110, 0, 150);
        setPurple(true);
    }

    public void choosePos(){
        x = rd.nextInt(640)+1;
        y = rd.nextInt(401)-500;
    }

    public void chooseVel(){
        yVel = rd.nextInt(3)+4;
    }

    public void move(){
        y += yVel;

        if(y > 390){
            y = 0;
            choosePos();
        }

    }

    public void chooseDims(){
        if(yVel > 5){
            width = 3;
            length = 12;
        }else{
            width = 2;
            length = 8;
        }
    }

    public void RGB(boolean input){
        if(input){
            int r = rd.nextInt(256);
            int g = rd.nextInt(256);
            int b = rd.nextInt(256);
            color = new Color(r,g,b);
        }
    }

    public void setPurple(boolean input){
        if(input){
            color = purple;
        }
    }

    public void setBlack(boolean input){
        if(input){
            color = Color.BLACK;
        }
    }

    public void setRed(boolean input){
        if(input){
            color = Color.RED;
        }
    }

    public void setGreen(boolean input){
        if(input){
            color = Color.green;
        }
    }


    public int getY(){
        return y;
    }

    public void draw(Graphics g){
        g.setColor(color);
        g.fillRect(x, y, width, length);
    }

}
