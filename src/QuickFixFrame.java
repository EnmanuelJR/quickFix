import javax.swing.*;

public class QuickFixFrame extends JFrame {

    private RegisterPanel registerPanel;
    private LoginPanel loginPanel;
    private WelcomePanel welcomePanel;

    public QuickFixFrame() {
        setTitle("QuickFix");
        setSize(900, 635);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        // Inicializar los paneles
        welcomePanel = new WelcomePanel(this);
        registerPanel = new RegisterPanel(this);
        loginPanel = new LoginPanel(this);

        // Añadir los paneles al frame
        add(welcomePanel);
        add(registerPanel);
        add(loginPanel);

        // Mostrar el panel de bienvenida primero
        switchToWelcomePanel();

        setVisible(true);
    }

    public void switchToWelcomePanel() {
        registerPanel.setVisible(false);
        loginPanel.setVisible(false);
        welcomePanel.setVisible(true);
    }

    public void switchToRegisterPanel() {
        welcomePanel.setVisible(false);
        loginPanel.setVisible(false);
        registerPanel.setVisible(true);
    }

    public void switchToLoginPanel() {
        welcomePanel.setVisible(false);
        registerPanel.setVisible(false);
        loginPanel.setVisible(true);
    }
}