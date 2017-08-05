package D2;

import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.border.EmptyBorder;
import javax.swing.text.AbstractDocument.Content;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.CardLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class pClass04_Layout_T153930_Trang extends JFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	public pClass04_Layout_T153930_Trang() {
		getContentPane().setLayout(new CardLayout(0, 0));
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, "name_10858381934727");
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("Next");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO: Kiem tra thong tin hop le
				
				//TODO: Luu vao CSDL
				
				//TODO: Chuyen den man hinh thong bao thanh cong
				CardLayout cards = (CardLayout)getContentPane().getLayout();
				cards.next(getContentPane());
				
			}
		});
		
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_1.add(btnNewButton);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("First Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(31, 67, 105, 25);
		panel_2.add(lblNewLabel);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLastName.setBounds(258, 68, 105, 22);
		panel_2.add(lblLastName);
		
		JLabel lblNewLabel_1 = new JLabel("Choose your username");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(31, 144, 175, 25);
		panel_2.add(lblNewLabel_1);
		
		JLabel lblCreate = new JLabel("Create a password");
		lblCreate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCreate.setBounds(31, 211, 152, 25);
		panel_2.add(lblCreate);
		
		JLabel lblNewLabel_2 = new JLabel("Confirm your password");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(31, 273, 180, 22);
		panel_2.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Birthday (d/m/y)");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(31, 337, 152, 25);
		panel_2.add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setBounds(27, 103, 199, 20);
		panel_2.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(258, 101, 152, 20);
		panel_2.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(31, 180, 379, 20);
		panel_2.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(31, 247, 379, 20);
		panel_2.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Gender");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(31, 395, 57, 14);
		panel_2.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Mobile Phone");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(31, 447, 93, 14);
		panel_2.add(lblNewLabel_5);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("I agree to the Term of Service ");
		chckbxNewCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
		chckbxNewCheckBox.setBounds(27, 507, 204, 23);
		panel_2.add(chckbxNewCheckBox);
		
		textField_4 = new JTextField();
		textField_4.setBounds(31, 306, 379, 20);
		panel_2.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(31, 364, 93, 20);
		panel_2.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(311, 364, 99, 20);
		panel_2.add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(31, 472, 379, 20);
		panel_2.add(textField_7);
		textField_7.setColumns(10);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Male");
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnNewRadioButton.setBounds(27, 417, 109, 23);
		panel_2.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Famale");
		rdbtnNewRadioButton_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnNewRadioButton_1.setBounds(165, 417, 109, 23);
		panel_2.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Other");
		rdbtnNewRadioButton_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnNewRadioButton_2.setBounds(311, 417, 109, 23);
		panel_2.add(rdbtnNewRadioButton_2);
		
		JLabel lblNewLabel_6 = new JLabel("Create Your Account");
		lblNewLabel_6.setFont(new Font("VnArialRounded", Font.PLAIN, 30));
		lblNewLabel_6.setBounds(63, 18, 315, 39);
		panel_2.add(lblNewLabel_6);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"January", "February", "March", "April", "May", "June ", "July", "August", "September", "October", "November", "December"}));
		comboBox.setBounds(151, 364, 146, 20);
		panel_2.add(comboBox);
		
		JPanel panel_3 = new JPanel();
		getContentPane().add(panel_3, "name_10861835697507");
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_7 = new JLabel("Welcome");
		lblNewLabel_7.setFont(new Font("VnBookman2", Font.PLAIN, 20));
		lblNewLabel_7.setBounds(178, 47, 98, 46);
		panel_3.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("New label");
		lblNewLabel_8.setIcon(new ImageIcon(pClass04_Layout_T153930_Trang.class.getResource("/images/user.png")));
		lblNewLabel_8.setBounds(96, 116, 252, 256);
		panel_3.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Thank for creating an account!");
		lblNewLabel_9.setFont(new Font("VnBookman2", Font.PLAIN, 20));
		lblNewLabel_9.setBounds(72, 402, 308, 36);
		panel_3.add(lblNewLabel_9);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 459, 629);
		
		
	}
	public static void main (String[] args){
		pClass04_Layout_T153930_Trang main = new pClass04_Layout_T153930_Trang();
		main.setVisible(true);
		main.setDefaultCloseOperation(EXIT_ON_CLOSE);
		main.setLocationRelativeTo(null);
		
		
	}
}
				
	
