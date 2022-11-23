/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectofinal;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author segonzalez2021
 */
public class Ventana extends JFrame {
    
    private PanelPrincipal p;
    
    public Ventana(){
        this.setLayout(new BorderLayout());
        this.setTitle("Pool");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(515, 538); //contrarresta el achicamiento
        this.setResizable(false);

        p = new PanelPrincipal();
        p.setSize(500, 500);
        this.add(p, BorderLayout.CENTER);

        this.setVisible(true);
    }
}
