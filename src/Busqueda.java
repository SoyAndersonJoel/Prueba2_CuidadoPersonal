import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Busqueda {
    public JPanel mainPanel;
    private JTextField procuctoBuscadoTF;
    private JButton buscarB;
    private JLabel codigoTxt;
    private JLabel nombreTxt;
    private JLabel descripcionTxt;
    private JLabel precioTxt;
    private JLabel cantidadTxt;
    private JLabel categoriaTxt;
    private JButton regresarButton;
    private JButton cerrarSesiónButton;

    public Busqueda() {
        buscarB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String url = "jdbc:mysql://localhost:3306/productos_cp";
                String user = "root";
                String password = "123456";

                String codigo_producto = procuctoBuscadoTF.getText();
                String sql = "SELECT * FROM PRODUCTO WHERE codigo_producto = ?";

                try (Connection connection = DriverManager.getConnection(url, user, password)) {
                    PreparedStatement preparedStatement = connection.prepareStatement(sql);
                    preparedStatement.setString(1,codigo_producto );
                    ResultSet resultSet = preparedStatement.executeQuery();
                    if (resultSet.next()) {
                        codigoTxt.setText(resultSet.getString("codigo_producto"));
                        nombreTxt.setText(resultSet.getString("nombre"));
                        descripcionTxt.setText(resultSet.getString("descripcion"));
                        precioTxt.setText(resultSet.getString("precio"));
                        cantidadTxt.setText(resultSet.getString("cantidad"));
                        categoriaTxt.setText(resultSet.getString("categoria"));


                    } else {
                        JOptionPane.showMessageDialog(null, "producto no encontrado");
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error al buscar datos");
                }

            }
        });
        cerrarSesiónButton.addActionListener(new ActionListener() {
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
                ((JFrame) SwingUtilities.getWindowAncestor(mainPanel)).dispose();

            }
        });
        regresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Mi aplicación");
                frame.setContentPane(new Bienvenida().mainPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setResizable(false);
                frame.setLocationRelativeTo(null);
                frame.setSize(450, 500);
                frame.setVisible(true);
                ((JFrame) SwingUtilities.getWindowAncestor(mainPanel)).dispose();

            }
        });
    }
}
