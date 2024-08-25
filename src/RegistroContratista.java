import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class RegistroContratista extends JFrame {
    private QuickFixFrame parentFrame;
    private JTextField txtFullName;
    private JTextField txtDateofBirth;
    private JComboBox<String> cmbTipoDocumento;
    private JTextField txtDocumentNumber;
    private JTextField txtCellphone;
    private JTextField txtEmail;
    private JTextField txtUserName;
    private JPasswordField txtPassword;
    private JTextField txtAddress;
    private JLabel lblPhoto;
    private JButton btnRegistrar;
    private JLabel lblImagenFondo;

    public RegistroContratista(QuickFixFrame parentFrame) {
        super("Registro de Contratista");
        this.parentFrame = parentFrame;
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(parentFrame);

        setLayout(new BorderLayout());

        // Crear imagen de fondo
        lblImagenFondo = new JLabel(new ImageIcon("path/to/your/image.png"));
        lblImagenFondo.setLayout(new BorderLayout());

        // Crear panel de campos de texto
        JPanel panelCampos = new JPanel();
        panelCampos.setLayout(new GridLayout(10, 2));
        panelCampos.setOpaque(false); // Para que el panel sea transparente

        // Crear campos de texto
        txtFullName = new JTextField();
        txtDateofBirth = new JTextField();
        cmbTipoDocumento = new JComboBox<>(new String[]{"Pasaporte", "Cédula De Ciudadania", "Cedula De Extranjeria", "Visa", "DNI", "PPT", "PEP"});
        txtDocumentNumber = new JTextField();
        txtCellphone = new JTextField();
        txtEmail = new JTextField();
        txtUserName = new JTextField();
        txtPassword = new JPasswordField();
        txtAddress = new JTextField();

        // Agregar campos de texto al panel
        panelCampos.add(new JLabel("Nombre Completo:"));
        panelCampos.add(txtFullName);
        panelCampos.add(new JLabel("Fecha de Nacimiento (dd/MM/yyyy):"));
        panelCampos.add(txtDateofBirth);
        panelCampos.add(new JLabel("Tipo de Documento:"));
        panelCampos.add(cmbTipoDocumento);
        panelCampos.add(new JLabel("Número de Documento:"));
        panelCampos.add(txtDocumentNumber);
        panelCampos.add(new JLabel("Celular:"));
        panelCampos.add(txtCellphone);
        panelCampos.add(new JLabel("Correo Electrónico:"));
        panelCampos.add(txtEmail);
        panelCampos.add(new JLabel("Nombre de Usuario:"));
        panelCampos.add(txtUserName);
        panelCampos.add(new JLabel("Contraseña:"));
        panelCampos.add(txtPassword);
        panelCampos.add(new JLabel("Dirección:"));
        panelCampos.add(txtAddress);

        // Crear panel de foto
        JPanel panelFoto = new JPanel();
        lblPhoto = new JLabel("Seleccione una foto:");
        JButton btnSeleccionarFoto = new JButton("Seleccionar");
        btnSeleccionarFoto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser();
                int returnVal = chooser.showOpenDialog(RegistroContratista.this);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    String filePath = chooser.getSelectedFile().getPath();
                    lblPhoto.setIcon(new ImageIcon(filePath));
                }
            }
        });
        panelFoto.add(lblPhoto);
        panelFoto.add(btnSeleccionarFoto);

        // Crear panel de botones
        JPanel panelBotones = new JPanel();
        btnRegistrar = new JButton("Registrar");
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Código para registrar el usuario
                String nombreCompleto = txtFullName.getText();
                LocalDate fechaNacimiento = LocalDate.parse(txtDateofBirth.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                String tipoDocumento = (String) cmbTipoDocumento.getSelectedItem();
                String numeroDocumento = txtDocumentNumber.getText();
                String celular = txtCellphone.getText();
                String correoElectronico = txtEmail.getText();
                String nombreUsuario = txtUserName.getText();
                String contraseña = new String(txtPassword.getPassword());
                String direccion = txtAddress.getText();
                // Aquí puedes agregar la lógica para registrar el usuario en una base de datos o archivo
                JOptionPane.showMessageDialog(RegistroContratista.this, "Contratista registrado con éxito!");
                File archivo = new File("Contratistas.txt");

                // Verificar si el archivo existe, si no existe crearlo
                if (!archivo.exists()) {
                    try {
                        archivo.createNewFile();
                    } catch (IOException n) {
                        System.err.println("Error al crear el archivo: " + n.getMessage());
                    }
                }

                // Escribir los datos del usuario en el archivo
                try (PrintWriter writer = new PrintWriter(new FileWriter(archivo, true))) {
                    writer.println("Nombre Completo: " + nombreCompleto);
                    writer.println("Fecha de Nacimiento: " + fechaNacimiento);
                    writer.println("Tipo de Documento: " + tipoDocumento);
                    writer.println("Número de Documento: " + numeroDocumento);
                    writer.println("Celular: " + celular);
                    writer.println("Correo Electrónico: " + correoElectronico);
                    writer.println("Nombre de Usuario: " + nombreUsuario);
                    writer.println("Contraseña: " + contraseña);
                    writer.println("Dirección: " + direccion);
                    writer.println("Foto: "  ); // ruta del archivo de la foto
                    writer.println(); // separador entre usuarios
                } catch (IOException n) {
                    System.err.println("Error al escribir en el archivo: " + n.getMessage());
                }
            }
        });
        panelBotones.add(btnRegistrar);

        // Agregar paneles al frame
        lblImagenFondo.add(panelCampos, BorderLayout.CENTER);
        lblImagenFondo.add(panelFoto, BorderLayout.NORTH);
        lblImagenFondo.add(panelBotones, BorderLayout.SOUTH);
        add(lblImagenFondo);

        setSize(600, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}
