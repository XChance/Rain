package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Rain extends JPanel implements Runnable, KeyListener {
    public static final int WIDTH = 640, HEIGHT = 400;
    public static Rain rain;
    public Raindrop[] rd = new Raindrop[700];
    public JFrame jf;
    public Thread thread;
    public Color background;
    public Color purplish;
    public int flashMed;
    public boolean isFlashing;
    public int ticks;


    public Rain() {
        thread = new Thread(this);

        purplish = new Color(230, 230, 250);
        background = purplish;

        ticks = 0;
        flashMed = 0;
        isFlashing = false;

        jf = new JFrame("Rain");
        jf.setSize(WIDTH, HEIGHT);
        jf.add(this);
        jf.addKeyListener(this);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setResizable(false);
        jf.setVisible(true);

        startUp();

        thread.start();
    }

    public static void main(String[] args){
        rain = new Rain();
    }

    public void startUp(){
        for(int i = 0; i < rd.length; i++){
            rd[i] = new Raindrop();
        }
    }

    protected void paintComponent(Graphics g){
        g.setColor(background);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        draw(g);
    }

    public void draw(Graphics g){
        for(int i = 0; i < rd.length; i++){
            rd[i].draw(g);
        }
    }

    public void move(){
        for(int i = 0; i < rd.length; i++){
            rd[i].move();
        }
    }

    @Override
    public void run() {
        while(true){
            move();
            repaint();

            ticks++;

            if(isFlashing && ticks >= 12){
                rgb(true);
                ticks = 0;
            }

            try {
                thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void rgb(boolean input){
        for(int i= 0; i < rd.length; i++){
            rd[i].RGB(input);
        }
    }

    public void setPurple(boolean input){
        for(int i= 0; i < rd.length; i++){
            rd[i].setPurple(input);
        }
    }

    public void setBlack(boolean input){
        for(int i= 0; i < rd.length; i++){
            rd[i].setBlack(input);
        }
    }

    public void setRed(boolean input){
        for(int i= 0; i < rd.length; i++){
            rd[i].setRed(input);
        }
    }

    public void setGreen(boolean input){
        for(int i= 0; i < rd.length; i++){
            rd[i].setGreen(input);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_SPACE){
            if(flashMed % 2 == 0){
                isFlashing = true;
                flashMed++;
            }else{
                isFlashing = false;
                flashMed++;
            }
        }else if(e.getKeyCode() == KeyEvent.VK_1){
            setPurple(true);
            if(isFlashing){
                isFlashing = false;
                flashMed++;
            }
        }else if(e.getKeyCode() == KeyEvent.VK_2){
            setRed(true);
            if(isFlashing){
                isFlashing = false;
                flashMed++;
            }
        }else if(e.getKeyCode() == KeyEvent.VK_3){
            setBlack(true);
            if(isFlashing){
                isFlashing = false;
                flashMed++;
            }
        }else if(e.getKeyCode() == KeyEvent.VK_4){
            setGreen(true);
            if(isFlashing){
                isFlashing = false;
                flashMed++;
            }

        }else if(e.getKeyCode() == KeyEvent.VK_Z){
            background = Color.BLACK;
        }else if(e.getKeyCode() == KeyEvent.VK_X){
            background = Color.GREEN;
        }else if(e.getKeyCode() == KeyEvent.VK_C){
            background = purplish;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
