package proyectofinal;

import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame {

    private PanelPrincipal p;

    public Ventana() {
        this.setLayout(new BorderLayout());
        this.setTitle("Pool");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        this.setResizable(true);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

        p = new PanelPrincipal();
        this.add(p, BorderLayout.CENTER);

        this.setVisible(true);
    }
}
