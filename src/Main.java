import javax.swing.*;

public class Main {
    public static void main(String[] args) {


        JFrame frame = new JFrame("Mi aplicación");
        frame.setContentPane(new  Busqueda().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setSize(450, 500);
        frame.setVisible(true);


    }
}