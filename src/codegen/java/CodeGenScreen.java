package codegen.java;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class CodeGenScreen {

	private JFrame frame;
	private JLabel lblGenerateCode;
	private JLabel lblLength;
	private JLabel lblSeedaNumber;
	private JTextField txtLength;
	private JTextField txtSeed;
	private JTextField txtCode;
	private JLabel lblCode;
	private JButton btnGenerateCode;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CodeGenScreen window = new CodeGenScreen();
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
	public CodeGenScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getLblGenerateCode());
		frame.getContentPane().add(getLblLength());
		frame.getContentPane().add(getLblSeedaNumber());
		frame.getContentPane().add(getTxtLength());
		frame.getContentPane().add(getTxtSeed());
		frame.getContentPane().add(getTxtCode());
		frame.getContentPane().add(getLblCode());
		frame.getContentPane().add(getBtnGenerateCode());
	}
	private JLabel getLblGenerateCode() {
		if (lblGenerateCode == null) {
			lblGenerateCode = new JLabel("Generate Code");
			lblGenerateCode.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 40));
			lblGenerateCode.setHorizontalAlignment(SwingConstants.CENTER);
			lblGenerateCode.setBounds(15, 16, 398, 92);
		}
		return lblGenerateCode;
	}
	private JLabel getLblLength() {
		if (lblLength == null) {
			lblLength = new JLabel("Length:");
			lblLength.setBounds(15, 124, 69, 20);
		}
		return lblLength;
	}
	private JLabel getLblSeedaNumber() {
		if (lblSeedaNumber == null) {
			lblSeedaNumber = new JLabel("Seed (A number):");
			lblSeedaNumber.setBounds(15, 160, 135, 20);
		}
		return lblSeedaNumber;
	}
	private JTextField getTxtLength() {
		if (txtLength == null) {
			txtLength = new JTextField();
			txtLength.setBounds(159, 121, 146, 26);
			txtLength.setColumns(10);
		}
		return txtLength;
	}
	private JTextField getTxtSeed() {
		if (txtSeed == null) {
			txtSeed = new JTextField();
			txtSeed.setBounds(159, 157, 146, 26);
			txtSeed.setColumns(10);
		}
		return txtSeed;
	}
	private JTextField getTxtCode() {
		if (txtCode == null) {
			txtCode = new JTextField();
			txtCode.setEnabled(false);
			txtCode.setBounds(0, 369, 428, 26);
			txtCode.setColumns(10);
		}
		return txtCode;
	}
	private JLabel getLblCode() {
		if (lblCode == null) {
			lblCode = new JLabel("Code:");
			lblCode.setBounds(140, 333, 69, 20);
		}
		return lblCode;
	}
	private JButton getBtnGenerateCode() {
		if (btnGenerateCode == null) {
			btnGenerateCode = new JButton("Generate Code!");
			btnGenerateCode.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseReleased(MouseEvent arg0) {
					try {
						int length = Integer.parseInt(txtLength.getText());
						long seed = Long.parseLong(txtSeed.getText());
						RandomCode rc = new RandomCode(length, seed);
						String code = rc.generateCode();
						txtCode.setText(code);
						txtCode.setEnabled(true);
					} catch (Exception e) {
						txtCode.setText("Put integers only in length and seed.");
						return;
					}
				}
			});
			btnGenerateCode.setBounds(25, 211, 371, 29);
		}
		return btnGenerateCode;
	}
}
