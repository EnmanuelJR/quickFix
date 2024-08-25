import javax.swing.*;
import java.awt.*;

class LoginPanel extends JPanel {

    private QuickFixFrame parentFrame;

    public LoginPanel(QuickFixFrame parentFrame) {
        this.parentFrame = parentFrame;
        setBackground(new Color(18, 28, 58));
        setLayout(null);
        setBounds(0, 0, 1024, 768);

        // Panel izquierdo
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(null);
        leftPanel.setBounds(0, 0, 450, 768);
        leftPanel.setBackground(new Color(18, 28, 58));

        JLabel titleLabel = new JLabel("QuickFix");
        titleLabel.setForeground(new Color(140, 101, 245));
        titleLabel.setFont(new Font("Arial", Font.BOLD, 36));
        titleLabel.setBounds(50, 100, 200, 50);
        leftPanel.add(titleLabel);

        JTextField usernameField = new JTextField("Username");
        usernameField.setBounds(50, 200, 350, 50);
        usernameField.setFont(new Font("Arial", Font.PLAIN, 16));
        usernameField.setBackground(new Color(30, 50, 86));
        usernameField.setForeground(Color.WHITE);
        leftPanel.add(usernameField);

        JPasswordField passwordField = new JPasswordField("Password");
        passwordField.setBounds(50, 270, 350, 50);
        passwordField.setFont(new Font("Arial", Font.PLAIN, 16));
        passwordField.setBackground(new Color(30, 50, 86));
        passwordField.setForeground(Color.WHITE);
        leftPanel.add(passwordField);

        JLabel forgotPasswordLabel = new JLabel("Forgot Password?");
        forgotPasswordLabel.setForeground(new Color(140, 101, 245));
        forgotPasswordLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        forgotPasswordLabel.setBounds(50, 340, 150, 30);
        leftPanel.add(forgotPasswordLabel);

        JButton loginButton = new JButton("LOG IN");
        loginButton.setBounds(50, 400, 350, 50);
        loginButton.setFont(new Font("Arial", Font.BOLD, 16));
        loginButton.setBackground(new Color(140, 101, 245));
        loginButton.setForeground(Color.WHITE);
        leftPanel.add(loginButton);

        JLabel registerLabel = new JLabel("Register an Account");
        registerLabel.setForeground(new Color(140, 101, 245));
        registerLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        registerLabel.setBounds(50, 470, 150, 30);
        leftPanel.add(registerLabel);

        // Panel derecho
        JPanel rightPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon imageIcon = new ImageIcon("images/contractor_2.png");
                Image image = imageIcon.getImage();
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
        };
        rightPanel.setBounds(450, 0, 574, 768);

        add(leftPanel);
        add(rightPanel);
    }
}