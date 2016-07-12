package codegen.java;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
/**
 * This class is the login screen that the user sees.
 * @author RotemDev
 *
 */
public class LoginScreen {

	private JFrame frame;
	private JLabel lblLoginScreen;
	private JLabel lblUsername;
	private JTextField textField;
	private JPasswordField passwordField;
	private JLabel lblPassword;
	private JButton btnLogin;
	private JButton btnBack;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginScreen window = new LoginScreen();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getLblLoginScreen());
		frame.getContentPane().add(getLblUsername());
		frame.getContentPane().add(getTextField());
		frame.getContentPane().add(getPasswordField());
		frame.getContentPane().add(getLblPassword());
		frame.getContentPane().add(getBtnLogin());
		frame.getContentPane().add(getBtnBack());
	}
	private JLabel getLblLoginScreen() {
		if (lblLoginScreen == null) {
			lblLoginScreen = new JLabel("Login Screen");
			lblLoginScreen.setHorizontalAlignment(SwingConstants.CENTER);
			lblLoginScreen.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 40));
			lblLoginScreen.setBounds(15, 16, 398, 59);
		}
		return lblLoginScreen;
	}
	private JLabel getLblUsername() {
		if (lblUsername == null) {
			lblUsername = new JLabel("Username:");
			lblUsername.setBounds(54, 91, 88, 20);
		}
		return lblUsername;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setBounds(142, 91, 146, 26);
			textField.setColumns(10);
		}
		return textField;
	}
	private JPasswordField getPasswordField() {
		if (passwordField == null) {
			passwordField = new JPasswordField();
			passwordField.setBounds(142, 133, 146, 26);
		}
		return passwordField;
	}
	private JLabel getLblPassword() {
		if (lblPassword == null) {
			lblPassword = new JLabel("Password:");
			lblPassword.setBounds(54, 136, 88, 20);
		}
		return lblPassword;
	}
	private JButton getBtnLogin() {
		if (btnLogin == null) {
			btnLogin = new JButton("Login");
			btnLogin.setBounds(54, 185, 115, 29);
		}
		return btnLogin;
	}
	private JButton getBtnBack() {
		if (btnBack == null) {
			btnBack = new JButton("Back");
			btnBack.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseReleased(MouseEvent e) {
					WelcomeScreen.main(null);
				}
			});
			btnBack.setBounds(224, 185, 115, 29);
		}
		return btnBack;
	}
}
