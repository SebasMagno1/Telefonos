import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class InterfazRegistroDispositivo extends JFrame {

    private List<Dispositivos> listaDispositivos;

    public InterfazRegistroDispositivo() {
        listaDispositivos = new ArrayList<>();

        JFrame frame = new JFrame("Registro de Dispositivos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        JLabel lblNombre = new JLabel("Dispositivo:");
        JTextField txtNombre = new JTextField();

        JLabel lblDireccion = new JLabel("Numero:");
        JTextField txtDireccion = new JTextField();

        JButton btnRegistrar = new JButton("Registrar");
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = txtNombre.getText();
                String direccion = txtDireccion.getText();

                // Validar que se hayan ingresado datos
                if (!nombre.isEmpty() && !direccion.isEmpty()) {
                    Dispositivos nuevoDispositivo = new Dispositivos(nombre, direccion);

                    listaDispositivos.add(nuevoDispositivo);

                    // Puedes realizar acciones adicionales aquí, como limpiar los campos
                    JOptionPane.showMessageDialog(null, "Dispositivo registrado correctamente");
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos");
                }
            }
        });

        // Agregar componentes al panel
        panel.add(lblNombre);
        panel.add(txtNombre);
        panel.add(lblDireccion);
        panel.add(txtDireccion);
        panel.add(new JLabel()); // Espacio en blanco
        panel.add(btnRegistrar);

        // Agregar el panel al frame
        frame.add(panel);

        frame.setVisible(true);
    }

    public static void main() {
        SwingUtilities.invokeLater(() -> new RegistroUsuariosInterfaz());
    }
}

class Dispositivos {
    private String nombre;
    private String direccion;

    public Dispositivos(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
    }

    // Getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}

