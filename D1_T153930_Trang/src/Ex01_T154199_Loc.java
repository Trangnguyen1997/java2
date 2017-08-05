import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Ex01_T154199_Loc extends JFrame {
	// khai bao bien
	JLabel lblUsername;
	JTextField txtUsername;
	private JPasswordField txtPassword;

	// ham dung - constructor
	public Ex01_T154199_Loc() {
		getContentPane().setBackground(new Color(0, 255, 255));
		setResizable(false);
		setSize(266, 366);
		getContentPane().setLayout(null);
		// Label
		lblUsername = new JLabel("UserName");
		lblUsername.setLocation(30, 50);
		lblUsername.setSize(80, 25);

		// textfiel
		txtUsername = new JTextField();
		txtUsername.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				txtUsername.setBackground(Color.GREEN);

			}

			@Override
			public void focusLost(FocusEvent e) {
				txtUsername.setBackground(Color.WHITE);

			}
		});
		txtUsername.setLocation(30, 80);
		txtUsername.setSize(150, 25);
		// add
		getContentPane().add(txtUsername);
		getContentPane().add(lblUsername);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(30, 116, 46, 14);
		getContentPane().add(lblPassword);

		txtPassword = new JPasswordField();
		txtPassword.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtPassword.setBackground(Color.GREEN);
			}

			@Override
			public void focusLost(FocusEvent e) {
				txtPassword.setBackground(Color.WHITE);
			}
		});
		txtPassword.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode()== KeyEvent.VK_ENTER){
					login();
				}
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		txtPassword.setBounds(30, 141, 150, 25);
		getContentPane().add(txtPassword);
		txtPassword.setColumns(10);

		JLabel lblLogin = new JLabel("LOGIN");
		lblLogin.setBounds(96, 11, 57, 28);
		getContentPane().add(lblLogin);

		JCheckBox chckbxRememberMe = new JCheckBox("Remember Me");
		chckbxRememberMe.setBounds(30, 173, 123, 25);
		getContentPane().add(chckbxRememberMe);

		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				login();
			}

		});
		btnLogin.setBounds(78, 213, 89, 23);
		getContentPane().add(btnLogin);
		setLocationRelativeTo(null);
	}

	public static void main(String[] args) {
		Ex01_T154199_Loc frame = new Ex01_T154199_Loc();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	private void login() {
		String userName = txtUsername.getText();
		char[] passArray = txtPassword.getPassword();
		String password = new String(passArray);
		if (userName.equals("admin") && password.equals("root")) {
			Main mainwindown = new Main();
			Ex01_T154199_Loc.this.setVisible(false);
			mainwindown.setVisible(true);
		} else {
			JOptionPane.showMessageDialog(Ex01_T154199_Loc.this, "Login Fail!");
		}
	}
}