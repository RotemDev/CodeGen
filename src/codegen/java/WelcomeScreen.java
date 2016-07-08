package codegen.java;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.UIManager;
/**
 * Here is the welcome screen for the program.
 * @author RotemDev
 * @since CodeGen v1.0
 */
public class WelcomeScreen {

	private JFrame frame;
	private JLabel lblCodegen;
	private JButton btnLogin;
	private JButton btnUseAsGuest;
	private JButton btnSignup;
	private JLabel lblV;
	private JLabel lblByRotemdev;
	private JSeparator separator;

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
					WelcomeScreen window = new WelcomeScreen();
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
	public WelcomeScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setAlwaysOnTop(true);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getLblCodegen());
		frame.getContentPane().add(getBtnLogin());
		frame.getContentPane().add(getBtnUseAsGuest());
		frame.getContentPane().add(getBtnSignup());
		frame.getContentPane().add(getLblV());
		frame.getContentPane().add(getLblByRotemdev());
		frame.getContentPane().add(getSeparator());
	}
	private JLabel getLblCodegen() {
		if (lblCodegen == null) {
			lblCodegen = new JLabel("CodeGen");
			lblCodegen.setFont(new Font("Tahoma", Font.BOLD, 30));
			lblCodegen.setHorizontalAlignment(SwingConstants.CENTER);
			lblCodegen.setBounds(15, 16, 398, 59);
		}
		return lblCodegen;
	}
	private JButton getBtnLogin() {
		if (btnLogin == null) {
			btnLogin = new JButton("Login");
			btnLogin.setBounds(157, 91, 115, 29);
		}
		return btnLogin;
	}
	private JButton getBtnUseAsGuest() {
		if (btnUseAsGuest == null) {
			btnUseAsGuest = new JButton("Use As Guest");
			btnUseAsGuest.setBounds(145, 142, 139, 29);
		}
		return btnUseAsGuest;
	}
	private JButton getBtnSignup() {
		if (btnSignup == null) {
			btnSignup = new JButton("Signup");
			btnSignup.setBounds(157, 199, 115, 29);
		}
		return btnSignup;
	}
	private JLabel getLblV() {
		if (lblV == null) {
			lblV = new JLabel("v1.0");
			lblV.setHorizontalAlignment(SwingConstants.TRAILING);
			lblV.setBounds(360, 224, 69, 20);
		}
		return lblV;
	}
	private JLabel getLblByRotemdev() {
		if (lblByRotemdev == null) {
			lblByRotemdev = new JLabel("By RotemDev");
			lblByRotemdev.setBounds(15, 226, 79, 16);
		}
		return lblByRotemdev;
	}
	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setBounds(115, 187, 202, 2);
		}
		return separator;
	}
}
