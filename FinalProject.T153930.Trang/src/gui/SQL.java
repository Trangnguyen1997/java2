package gui;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import da.SQLiteDB;
import dataobject.Category;

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
	private SQLiteDB salesDb;
	private JTextField textField_1;

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
		salesDb.getAllProducts();

		frame = new JFrame();
		frame.setBounds(100, 100, 429, 441);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblCate = new JLabel("Category:");
		lblCate.setBounds(23, 167, 79, 14);
		frame.getContentPane().add(lblCate);

		JLabel lblNewLabel_1 = new JLabel("Unit Price:");
		lblNewLabel_1.setBounds(23, 309, 79, 14);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Unit of Measure:");
		lblNewLabel_2.setBounds(23, 217, 96, 14);
		frame.getContentPane().add(lblNewLabel_2);

		txtname = new JTextField();
		txtname.setBounds(124, 118, 254, 20);
		frame.getContentPane().add(txtname);
		txtname.setColumns(10);

		txtunitprice = new JTextField();
		txtunitprice.setColumns(10);
		txtunitprice.setBounds(124, 306, 254, 20);
		frame.getContentPane().add(txtunitprice);

		JButton btnNewButton = new JButton("Add");

		btnNewButton.setBounds(102, 354, 89, 29);
		frame.getContentPane().add(btnNewButton);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(228, 354, 89, 29);
		frame.getContentPane().add(btnCancel);

		JComboBox Category = new JComboBox();
		Category.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				// System.out.println(cmbCategry.getSelectedItem());
				Category cat = (Category) Category.getSelectedItem();
				System.out.println(cat.getCategoryId() + "-" + cat.getCategoryName());
			}
		});
		Vector<Category> catList = salesDb.getCategories();
		Category.setModel(new DefaultComboBoxModel(catList));
		Category.setBounds(124, 164, 254, 20);
		frame.getContentPane().add(Category);

		JLabel lblNewLabel = new JLabel("Add Product");
		lblNewLabel.setFont(new Font("VnArialRounded", Font.PLAIN, 20));
		lblNewLabel.setBounds(137, 11, 130, 57);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(23, 121, 79, 14);
		frame.getContentPane().add(lblName);
		
		JLabel lblBrand = new JLabel("Brand:");
		lblBrand.setBounds(24, 262, 46, 14);
		frame.getContentPane().add(lblBrand);
		
		JLabel lblNewLabel_3 = new JLabel("Product Code:");
		lblNewLabel_3.setBounds(23, 78, 96, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		textField_1 = new JTextField();
		textField_1.setBounds(124, 79, 254, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JComboBox Brand = new JComboBox();
		Brand.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				// System.out.println(cmbCategry.getSelectedItem());
				dataobject.Brand bra = (dataobject.Brand)Brand.getSelectedItem();
				System.out.println(bra.getId() + "-" + bra.getName());
			}
		});
		Vector<dataobject.Brand> braList = salesDb.getbr();
		Category.setModel(new DefaultComboBoxModel(catList));
		Brand.setBounds(124, 256, 254, 20);
		frame.getContentPane().add(Brand);
		
		JComboBox Measure = new JComboBox();
		Category.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				// System.out.println(cmbCategry.getSelectedItem());
				Category cat = (Category) Category.getSelectedItem();
				System.out.println(cat.getCategoryId() + "-" + cat.getCategoryName());
			}
		});
		Vector<Measure> catList = salesDb.getCategories();
		Category.setModel(new DefaultComboBoxModel(catList));
		Measure.setBounds(124, 214, 254, 20);
		frame.getContentPane().add(Measure);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String productName = txtname.getText();
				double unitPrice = Double.parseDouble(txtunitprice.getText());
				//int unitInStock = Integer.parseInt(txtunitinstock.getText());
				Category selectedCat = (Category) Category.getSelectedItem();
				int catId = selectedCat.getCategoryId();

				//salesDb.insert(pCode,name, Category, brandid, unitid);
				salesDb.getAllProducts();
			}
		});
	}
}
