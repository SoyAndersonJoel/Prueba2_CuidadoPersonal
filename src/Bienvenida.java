import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Bienvenida {
    public JPanel mainPanel;
    private JButton registrarB;
    private JButton buscarB;
    private JButton cerrarSesionB;

    public Bienvenida() {
        registrarB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Mi aplicación");
                frame.setContentPane(new Ingresar().mainPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setResizable(false);
                frame.setLocationRelativeTo(null);
                frame.setSize(450, 500);
                frame.setVisible(true);

            }
        });
        buscarB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Mi aplicación");
                frame.setContentPane(new Busqueda().mainPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setResizable(false);
                frame.setLocationRelativeTo(null);
                frame.setSize(450, 500);
                frame.setVisible(true);

            }
        });
        cerrarSesionB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Mi aplicación");
                frame.setContentPane(new Login().mainPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setResizable(false);
                frame.setLocationRelativeTo(null);
                frame.setSize(450, 500);
                frame.setVisible(true);

            }
        });
    }
}
