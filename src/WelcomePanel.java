import javax.swing.*;
import java.awt.*;

class WelcomePanel extends JPanel {

    private QuickFixFrame parentFrame;

    public WelcomePanel(QuickFixFrame parentFrame) {
        this.parentFrame = parentFrame;
        setBackground(new Color(18, 28, 58));
        setLayout(null);
        setBounds(0, 0, 900, 600);

        JLabel quickFixLabel = new JLabel("QuickFix");
        quickFixLabel.setForeground(new Color(113, 46, 208));
        quickFixLabel.setFont(new Font("Arial", Font.BOLD, 36));
        quickFixLabel.setBounds(100, 50, 200, 50);

        JButton loginButton = new JButton("LOGIN");
        loginButton.setBackground(new Color(113, 46, 208));
        loginButton.setForeground(Color.WHITE);
        loginButton.setFont(new Font("Arial", Font.BOLD, 16));
        loginButton.setBounds(100, 150, 150, 50);

        JButton registerButton = new JButton("REGISTER");
        registerButton.setBackground(new Color(113, 46, 208));
        registerButton.setForeground(Color.WHITE);
        registerButton.setFont(new Font("Arial", Font.BOLD, 16));
        registerButton.setBounds(100, 220, 150, 50);

        JLabel handshakeImage = new JLabel(resizeImage(new ImageIcon("images/handshake.png"), 500, 300));
        handshakeImage.setBounds(350, 100, 500, 300);

        add(quickFixLabel);
        add(loginButton);
        add(registerButton);
        add(handshakeImage);

        registerButton.addActionListener(e -> parentFrame.switchToRegisterPanel());
        loginButton.addActionListener(e -> parentFrame.switchToLoginPanel());
    }

    private ImageIcon resizeImage(ImageIcon originalIcon, int width, int height) {
        Image img = originalIcon.getImage();
        Image resizedImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImg);
    }
}