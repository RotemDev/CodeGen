package codegen.java;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
/**
 * This is the signup screen.
 * Uses the User class.
 * @author RotemDev
 * @see codegen.java.User
 */
public class SignupScreen {

	private JFrame frame;
	private JLabel lblSignUp;
	private JTextField txtUsername;
	private JLabel lblUsername;
	private JPasswordField passwordField;
	private JLabel lblPassword;
	private JButton btnSignUp;
	private JLabel lblError;
	private User user = new User();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignupScreen window = new SignupScreen();
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
	public SignupScreen() {
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
		frame.getContentPane().add(getLblSignUp());
		frame.getContentPane().add(getTxtUsername());
		frame.getContentPane().add(getLblUsername());
		frame.getContentPane().add(getPasswordField());
		frame.getContentPane().add(getLblPassword());
		frame.getContentPane().add(getBtnSignUp());
		frame.getContentPane().add(getLblError());
	}

	private JLabel getLblSignUp() {
		if (lblSignUp == null) {
			lblSignUp = new JLabel("Sign Up");
			lblSignUp.setHorizontalAlignment(SwingConstants.CENTER);
			lblSignUp.setFont(new Font("Tahoma", Font.BOLD, 36));
			lblSignUp.setBounds(15, 16, 398, 54);
		}
		return lblSignUp;
	}
	private JTextField getTxtUsername() {
		if (txtUsername == null) {
			txtUsername = new JTextField();
			txtUsername.setBounds(142, 86, 146, 26);
			txtUsername.setColumns(10);
		}
		return txtUsername;
	}
	private JLabel getLblUsername() {
		if (lblUsername == null) {
			lblUsername = new JLabel("Username:");
			lblUsername.setBounds(51, 89, 86, 20);
		}
		return lblUsername;
	}
	private JPasswordField getPasswordField() {
		if (passwordField == null) {
			passwordField = new JPasswordField();
			passwordField.setBounds(142, 128, 146, 26);
		}
		return passwordField;
	}
	private JLabel getLblPassword() {
		if (lblPassword == null) {
			lblPassword = new JLabel("Password:");
			lblPassword.setBounds(51, 131, 86, 20);
		}
		return lblPassword;
	}
	private JButton getBtnSignUp() {
		if (btnSignUp == null) {
			btnSignUp = new JButton("Sign Up!");
			btnSignUp.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseReleased(MouseEvent arg0) {
					String username = txtUsername.getText();
					String password = charrayToStr(passwordField.getPassword());
					if (username.equals("") || password.equals("")) {
						lblError.setText("Error: Blank feilds.");
						return;
					}
					if (user.exists(username)) {
						lblError.setText("Error: User exists.");
						return;
					}
					user.addUser(username, password);
				}
			});
			btnSignUp.setBounds(123, 170, 115, 29);
		}
		return btnSignUp;
	}
	private JLabel getLblError() {
		if (lblError == null) {
			lblError = new JLabel("");
			lblError.setForeground(Color.RED);
			lblError.setBounds(15, 208, 398, 20);
		}
		return lblError;
	}
	
	public String charrayToStr(char[] c) {
		String s = "";
		for (char cc : c) {
			s += cc;
		}
		return s;
	}
}
