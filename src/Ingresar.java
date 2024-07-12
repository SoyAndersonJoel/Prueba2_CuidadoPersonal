import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Ingresar {
    private JTextField codigoTF;
    public JPanel mainPanel;
    private JTextField nombreTF;
    private JTextField descripcionTF;
    private JTextField precioTF;
    private JTextField cantidadTF;
    private JTextField categoriaTF;
    private JButton regresarB;
    private JButton loginB;
    private JButton cancelarB;
    private JButton resgistarB;

    public Ingresar() {
        regresarB.addActionListener(new ActionListener() {
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
        loginB.addActionListener(new ActionListener() {
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
        resgistarB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String url = "jdbc:mysql://localhost:3306/productos_cp";
                String user = "root";
                String password = "123456";

                String codigo = codigoTF.getText();
                String nombre = nombreTF.getText();
                String descripcion = descripcionTF.getText();
                double precio=Double.parseDouble(precioTF.getText());
                int cantidad=Integer.parseInt(cantidadTF.getText());
                String categoria = categoriaTF.getText();


                String sql = "INSERT INTO PRODUCTO (codigo_producto,nombre,descripcion,precio ,cantidad,categoria ) VALUES (?, ?, ?, ?,?,?)";

                try (Connection connection = DriverManager.getConnection(url, user, password)) {
                    PreparedStatement preparedStatement = connection.prepareStatement(sql);

                    Productos producto1 = new Productos(codigo,nombre,descripcion,precio ,cantidad,categoria );
                    preparedStatement.setString(1,producto1.getCodigo_producto());
                    preparedStatement.setString(2,producto1.getNombre());
                    preparedStatement.setString(3,producto1.getDescripcion());
                    preparedStatement.setDouble(4,producto1.getPrecio());
                    preparedStatement.setInt(5,producto1.getCantidad());
                    preparedStatement.setString(6,producto1.getCategoria());
                    preparedStatement.execute();
                    codigoTF.setText("");
                    nombreTF.setText("");
                    descripcionTF.setText("");
                    precioTF.setText("");
                    cantidadTF.setText("");
                    categoriaTF.setText("");

                    JOptionPane.showMessageDialog(null, "Datos insertados");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error al insertar datos");
                }

            }
        });
        cancelarB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                codigoTF.setText("");
                nombreTF.setText("");
                descripcionTF.setText("");
                precioTF.setText("");
                cantidadTF.setText("");
                categoriaTF.setText("");


            }
        });
    }
}
