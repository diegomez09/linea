package b17.linea;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Interfaz extends JFrame implements ActionListener{
    JLabel c1, c2, pendiente; // Coordenadas 1 y 2
    JTextField x0, y0, x1, y1;
    JButton btn;
    private Graphics graPixel;
    private BufferedImage buffer;
    
    Interfaz(){
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setBounds(0,0,5,5);
        this.setLayout (null);
        this.setVisible(true);
        
        // Pendiente
        pendiente = new JLabel();
        pendiente.setText("Pendiente: ");
        pendiente.setBounds(20, 180, 100, 20);
        pendiente.setVisible(true);
        
        
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese x1:");
        String x1 = "";
        x1 = teclado.nextLine();
        
        System.out.println("Ingrese y1:");
        String y1 = "";
        y1 = teclado.nextLine();
        
        System.out.println("Ingrese x2:");
        String x2 = "";
        x2 = teclado.nextLine();
        
        System.out.println("Ingrese y2:");
        String y2 = "";
        y2 = teclado.nextLine();
        
        buffer = new BufferedImage(1,1,BufferedImage.TYPE_INT_RGB);
            graPixel = (Graphics2D) buffer.createGraphics();
            Linea l = new Linea(Integer.parseInt(x1),Integer.parseInt(y1),Integer.parseInt(x2),Integer.parseInt(y2));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btn){
            buffer = new BufferedImage(1,1,BufferedImage.TYPE_INT_RGB);
            graPixel = (Graphics2D) buffer.createGraphics();
            Linea l = new Linea(Integer.parseInt(x0.getText()),Integer.parseInt(y0.getText()),Integer.parseInt(x1.getText()),Integer.parseInt(y1.getText()));        
                pendiente.setText("Pendiente: " + l.getPendiente());
            
        }
    }

}
