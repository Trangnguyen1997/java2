import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * 
 */

/**
 * @author Trang
 *
 */
public class MyTextEditor extends JFrame {
	JMenuBar mnbBar;
	JMenu mnuFile, mnuFormat;
	JMenuItem mniOpen, mniExit, mniChangeBgColor, mniChangeFontColor;

	JTextArea txaContent;
	JScrollPane scrPane;

	public void initializeMenu() {
		mnbBar = new JMenuBar();
		mnuFile = new JMenu("File");
		mnuFormat = new JMenu("Format");
		mniOpen = new JMenuItem("Open");
		mniExit = new JMenuItem("Exit");
		mniChangeBgColor = new JMenuItem("ChangeBgColor");
		mniChangeFontColor = new JMenuItem("ChangeFontColor");
		// Them menu item vao menu File
		mnuFile.add(mniOpen);
		mnuFile.addSeparator();
		mnuFile.add(mniExit);
		// Them menu item vao menu Format
		mnuFormat.add(mniChangeBgColor);
		mnuFormat.add(mniChangeFontColor);
		// Them menu File va menu Format va menuBar
		mnbBar.add(mnuFile);
		mnbBar.add(mnuFormat);
		// Thiet lap menuBar thanh menu chinh Frame
		setJMenuBar(mnbBar);
	}

	/**
	 * @param args
	 */
	public MyTextEditor() {
		setTitle("Text Editor");
		setPreferredSize(new Dimension(600, 500));
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		pack();
		setLocationRelativeTo(null);
		// Goi phuong thuc ta menu
		initializeMenu();

		// Tao vung hien thi van ban
		// Van ban hien thi trng textArea
		txaContent = new JTextArea();

		scrPane = new JScrollPane(txaContent);

		getContentPane().add(scrPane);

		ActionListener action = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (e.getSource() == mniOpen) {
					// Xu li khi nhan menu Open
					openFile();

				} else if (e.getSource() == mniExit) {
					// Xu li khi nhan menu Open
					closeApplication();

				} else if (e.getSource() == mniChangeBgColor) {
					// Xu li khi nhan menu Chang BG Color
					changBGColor();

				} else if (e.getSource() == mniChangeFontColor) {
					// Xu li khi nhan menu Chang Font Color
					changFontColor();
				}
			}
		};
		// Them ang nghe su kien vao cac menu item
		mniOpen.addActionListener(action);
		mniExit.addActionListener(action);
		mniChangeBgColor.addActionListener(action);
		mniChangeFontColor.addActionListener(action);

		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				closeApplication();
			}
		});
	}

	public void openFile() {
		JFileChooser fchOpenFile = new JFileChooser();

		int result = fchOpenFile.showOpenDialog(this);
		if (result == JFileChooser.APPROVE_OPTION) {
			try {
				Scanner scn = new Scanner(fchOpenFile.getSelectedFile());

				while (scn.hasNextLine()) {
					txaContent.append(scn.nextLine() + "\n");
				}
				scn.close();
			} catch (FileNotFoundException e) {
				JOptionPane.showMessageDialog(null, "Selected file is not found");
			}
		}
	}

	public void changBGColor() {
		Color newColor = JColorChooser.showDialog(this, "Choose new background color", txaContent.getBackground());
		txaContent.setBackground(newColor);
	}

	public void changFontColor() {
		Color newColor = JColorChooser.showDialog(this, "Choose new foreground color", txaContent.getForeground());
		txaContent.setForeground(newColor);
	}

	public void closeApplication() {
		int result = JOptionPane.showConfirmDialog(null, "Are you sure want to exit the program?", "Confirm",
				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
		if (result == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyTextEditor T = new MyTextEditor();
		T.setVisible(true);
	}

}
