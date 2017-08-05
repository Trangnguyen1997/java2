import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class Main extends JFrame {

	private JDesktopPane contentPane;
	private int count;

	/**
	 * Create the frame.
	 */
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("File");
		menuBar.add(mnNewMenu);

		JMenuItem mntmNew = new JMenuItem("New");
		mnNewMenu.add(mntmNew);

		JMenuItem mntmOpen = new JMenuItem("Open");
		mnNewMenu.add(mntmOpen);

		JMenuItem mntmSave = new JMenuItem("Save");
		mnNewMenu.add(mntmSave);

		JMenuItem mntmExit = new JMenuItem("Exit");
		mnNewMenu.add(mntmExit);

		JMenu mnEdit = new JMenu("Edit");
		menuBar.add(mnEdit);

		JMenu mnTool = new JMenu("Tool");
		menuBar.add(mnTool);

		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		contentPane = new JDesktopPane();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		setExtendedState(JFrame.MAXIMIZED_BOTH);

		// Xu y su kien
		mntmNew.addActionListener(new ActionListener() {
		
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int x = 0,y = 0;
				JInternalFrame newWindow = new JInternalFrame("New Window "+" "+count, true, true, true);
				newWindow.setVisible(true);
				newWindow.setSize(300, 300);
				contentPane.add(newWindow);
				newWindow.moveToFront();
				newWindow.setBounds(x, y, 300, 300);
				x = x + 30;
				y = y + 30;
				count = count + 1;		
			}
		});
	}

}
