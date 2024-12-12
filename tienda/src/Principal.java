import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Clase Principal que contiene la interfaz gráfica
public class Principal {

    public static void main(String[] args) {
        // Crear una instancia de la ventana
        SwingUtilities.invokeLater(() -> {
            new VentanaPrincipal();
        });
    }
}

// Clase para definir la ventana principal
class VentanaPrincipal extends JFrame {

    public VentanaPrincipal() {
        // Configurar la ventana
        setTitle("Interfaz de Ejemplo");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Crear un panel principal
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        add(panel);

        // Crear un título
        JLabel titulo = new JLabel("Bienvenido a la Aplicación");
        titulo.setFont(new Font("Arial", Font.BOLD, 18));
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(titulo);

        // Espaciador
        panel.add(Box.createRigidArea(new Dimension(0, 10)));

        // Crear una etiqueta y un cuadro de texto
        JLabel etiquetaNombre = new JLabel("Nombre:");
        etiquetaNombre.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(etiquetaNombre);

        JTextField campoNombre = new JTextField();
        campoNombre.setMaximumSize(new Dimension(200, 30));
        panel.add(campoNombre);

        // Crear una etiqueta y un área de texto
        JLabel etiquetaComentario = new JLabel("Comentario:");
        etiquetaComentario.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(etiquetaComentario);

        JTextArea areaComentario = new JTextArea(5, 20);
        JScrollPane scrollPane = new JScrollPane(areaComentario);
        panel.add(scrollPane);

        // Crear un botón
        JButton botonEnviar = new JButton("Enviar");
        botonEnviar.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(botonEnviar);

        // Agregar acción al botón
        botonEnviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = campoNombre.getText();
                String comentario = areaComentario.getText();
                JOptionPane.showMessageDialog(VentanaPrincipal.this,
                        "Nombre: " + nombre + "\nComentario: " + comentario,
                        "Información Enviada",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });

        // Hacer visible la ventana
        setVisible(true);
    }
}

