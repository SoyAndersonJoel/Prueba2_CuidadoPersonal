import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Login {
    public JPanel mainPanel;
    private JTextField userTF;
    private JPasswordField passwordTF;
    private JButton ingresarTf;

    public Login() {
        ingresarTf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String url = "jdbc:mysql://localhost:3306/productos_cp";
                String dbUser = "root";
                String dbPassword = "123456";

                String username = userTF.getText();
                String pass = new String(passwordTF.getPassword());

                String sql = "SELECT * FROM USUARIO WHERE username = ? AND password = ?";

                try (Connection connection = DriverManager.getConnection(url, dbUser, dbPassword)) {
                    PreparedStatement preparedStatement = connection.prepareStatement(sql);
                    preparedStatement.setString(1, username);
                    preparedStatement.setString(2, pass);

                    ResultSet resultSet = preparedStatement.executeQuery();
                    if (resultSet.next()) {

                        JFrame frame = new JFrame("Mi aplicación");
                        frame.setContentPane(new Bienvenida().mainPanel);
                        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        frame.pack();
                        frame.setResizable(false);
                        frame.setLocationRelativeTo(null);
                        frame.setSize(450, 500);
                        frame.setVisible(true);
                        ((JFrame) SwingUtilities.getWindowAncestor(mainPanel)).dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "Credenciales incorrectas", "Error de login", JOptionPane.ERROR_MESSAGE);
                        userTF.setText("");
                        passwordTF.setText("");
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error al buscar datos");
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Login");
        frame.setContentPane(new Login().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setSize(450, 500);
        frame.setVisible(true);
    }
}
