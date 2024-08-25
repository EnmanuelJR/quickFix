import javax.swing.*;
import java.awt.*;

public class RegisterPanel extends JPanel {

    private QuickFixFrame parentFrame;

    public RegisterPanel(QuickFixFrame parentFrame) {
        this.parentFrame = parentFrame;
        setBackground(new Color(18, 28, 58));
        setLayout(null);
        setBounds(0, 0, 900, 600);

        JLabel titleLabel = new JLabel("Welcome to QuickFix");
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 36));
        titleLabel.setBounds(250, 30, 600, 50);

        JLabel instructionLabel = new JLabel("Please select from the following what type of Account you'd like to Register");
        instructionLabel.setForeground(Color.WHITE);
        instructionLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        instructionLabel.setBounds(120, 100, 700, 30);

        JButton clientButton = new JButton("CLIENT");
        clientButton.setBackground(new Color(113, 46, 208));
        clientButton.setForeground(Color.WHITE);
        clientButton.setFont(new Font("Arial", Font.BOLD, 16));
        clientButton.setBounds(200, 150, 150, 50);

        JButton contractorButton = new JButton("CONTRACTOR");
        contractorButton.setBackground(new Color(113, 46, 208));
        contractorButton.setForeground(Color.WHITE);
        contractorButton.setFont(new Font("Arial", Font.BOLD, 16));
        contractorButton.setBounds(550, 150, 150, 50);

        // Load and resize images
        JLabel clientImage = new JLabel(resizeImage(new ImageIcon("images/client.png"), 250, 150));
        clientImage.setBounds(150, 250, 250, 150);

        JLabel contractorImage = new JLabel(resizeImage(new ImageIcon("images/contractor.png"), 250, 150));
        contractorImage.setBounds(500, 250, 250, 150);

        add(titleLabel);
        add(instructionLabel);
        add(clientButton);
        add(contractorButton);
        add(clientImage);
        add(contractorImage);

        clientButton.addActionListener(e -> parentFrame.switchToLoginPanel());
        contractorButton.addActionListener(e -> parentFrame.switchToLoginPanel());
    }

    // Method to resize the image
    private ImageIcon resizeImage(ImageIcon originalIcon, int width, int height) {
        Image img = originalIcon.getImage();
        Image resizedImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImg);
    }
}