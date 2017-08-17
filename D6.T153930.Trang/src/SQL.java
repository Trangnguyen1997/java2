import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ComboBoxEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Font;
import java.util.Vector;

import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SQL {

	private JFrame frame;
	private JTextField txtname;
	private JTextField txtunitprice;
	private JTextField txtunitinstock;
	private SQLiteDB salesDb;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SQL window = new SQL();
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
	public SQL() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		salesDb = new SQLiteDB();
		salesDb.getCategories();

		frame = new JFrame();
		frame.setBounds(100, 100, 429, 416);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblCate = new JLabel("Category:");
		lblCate.setBounds(23, 134, 79, 14);
		frame.getContentPane().add(lblCate);

		JLabel lblNewLabel_1 = new JLabel("Unit Price:");
		lblNewLabel_1.setBounds(23, 190, 79, 14);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Unit in Stock:");
		lblNewLabel_2.setBounds(23, 245, 79, 14);
		frame.getContentPane().add(lblNewLabel_2);

		txtname = new JTextField();
		txtname.setBounds(112, 79, 266, 20);
		frame.getContentPane().add(txtname);
		txtname.setColumns(10);

		txtunitprice = new JTextField();
		txtunitprice.setColumns(10);
		txtunitprice.setBounds(112, 187, 266, 20);
		frame.getContentPane().add(txtunitprice);

		txtunitinstock = new JTextField();
		txtunitinstock.setColumns(10);
		txtunitinstock.setBounds(112, 242, 266, 20);
		frame.getContentPane().add(txtunitinstock);

		JButton btnNewButton = new JButton("Add");

		btnNewButton.setBounds(96, 308, 89, 29);
		frame.getContentPane().add(btnNewButton);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(247, 308, 89, 29);
		frame.getContentPane().add(btnCancel);

		JComboBox comboBox = new JComboBox();
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				// System.out.println(cmbCategry.getSelectedItem());
				Category cat = (Category) comboBox.getSelectedItem();
				System.out.println(cat.getCategoryId() + "-" + cat.getCategoryName());
			}
		});
		Vector<Category> catList = salesDb.getCategories();
		comboBox.setModel(new DefaultComboBoxModel(catList));
		comboBox.setBounds(112, 131, 266, 20);
		frame.getContentPane().add(comboBox);

		JLabel lblNewLabel = new JLabel("Add Product");
		lblNewLabel.setFont(new Font("VnArialRounded", Font.PLAIN, 20));
		lblNewLabel.setBounds(137, 11, 130, 57);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(23, 84, 79, 14);
		frame.getContentPane().add(lblName);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String productName = txtname.getText();
				double unitPrice = Double.parseDouble(txtunitprice.getText());
				int unitInStock = Integer.parseInt(txtunitinstock.getText());
				Category selectedCat = (Category) comboBox.getSelectedItem();
				int catId = selectedCat.getCategoryId();

				salesDb.insert(productName, catId, unitPrice, unitInStock);
				salesDb.getAllProducts();
			}
		});
	}
}
