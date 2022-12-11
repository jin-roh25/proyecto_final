package proyectofinal;

import javax.swing.*;
import java.awt.*;

/**
 * Ventana de Windows
 * 
 * @author Keyteer
 * @author segonzalez2021
 * @version versión 0.1, 27 de noviembre de 2022
 * @see PanelPrincipal
 */

public class Ventana extends JFrame {

    private PanelPrincipal p;

    public Ventana() {
        this.setLayout(new BorderLayout());
        this.setTitle("Pool");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        p = new PanelPrincipal();
        this.add(p, BorderLayout.CENTER);

        this.setSize(p.getPreferredSize());
        this.setResizable(true);

        this.setVisible(true);
    }
}
