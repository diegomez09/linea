package b17.linea;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;

public class Linea extends JFrame implements ActionListener{
    private BufferedImage buffer;
    private Graphics graPixel;
    int x0,x1,y0,y1;
    private float pendiente;
    public Linea(int x0, int y0, int x1, int y1){    
        super("Linea");
        this.x0 = x0;
        this.x1 = x1;
        this.y0 = y0;
        this.y1 = y1;
        Pendiente(x0,y0,x1,y1);
        this.setLayout(null);
        this.setBounds(1000, 100, 200, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        buffer = new BufferedImage(1,1,BufferedImage.TYPE_INT_RGB);
        graPixel = (Graphics2D) buffer.createGraphics();
        this.setVisible(true);
    }
    
    
    public float getPendiente(){
        return this.pendiente;
    }  
    public void setPendiente(float p){
        //System.out.println("Se asignó valor a pendiente");
        //System.out.println(p);
        this.pendiente = p;
    }
    public void Pendiente(int x0, int y0, int x1, int y1){
        int dx = x1 - x0;
        int dy = y1 - y0;
        float m;
        if(Math.abs(dx) > Math.abs(dy)){ // Pendiente < 1
            m = (float) dy / (float) dx;
            setPendiente(-m);
        }
        else{
            if(dy != 0){
                m = (float) dx / (float) dy;
                setPendiente(-m);
            }
        }
    }
    
    @Override
    public void paint(Graphics g){
        //System.out.println(x0);
        int dx = x1 - x0;
        int dy = y1 - y0;
        
        putPixel(x0, y0, Color.GREEN);
        
        if(Math.abs(dx) > Math.abs(dy)){ // Pendiente < 1
            float m = (float) dy / (float) dx;
            //System.out.println("-Pendiente: " + m);
            setPendiente(-m);
            float b = y0 - m*x0;
            if(dx < 0)
                dx = -1;
            else
                dx = 1;
            while(x0 != x1){
                x0 += dx;
                y0 = Math.round(m*x0 + b);
                putPixel(x0, y0, Color.GREEN);
            }
            String str = "Pendiente = " + String.valueOf(pendiente);
            g.drawString(str, 10, 10);
        }
        else{
            if(dy != 0){
                float m = (float) dx / (float) dy;
                //System.out.println("-Pendiente: " + m);
                setPendiente(-m);
                float b = x0 - m*y0;
                if(dy < 0)
                    dy = -1;
                else
                    dy = 1;
                while(y0 != y1){
                    y0 += dy;
                    x0 = Math.round(m*y0 + b);
                    putPixel(x0, y0, Color.GREEN);
                }
                String str = "Pendiente = " + String.valueOf(pendiente);
                //System.out.println(str);
                g.drawString(str, 10, 10);
            }
        }
        
    }
    
    public void putPixel(int x, int y, Color c){
        buffer.setRGB(0,0,c.getRGB());
        this.getGraphics().drawImage(buffer, x, y, this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
