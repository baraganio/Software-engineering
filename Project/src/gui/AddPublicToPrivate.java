package gui;

import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.List;

import javax.swing.SwingConstants;

import model.PrivateDestination;
import model.PublicDestination;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class AddPublicToPrivate extends JDialog {
	private static final long serialVersionUID = 1L;
	private JLabel lblAddPublicToPrivate;
	private JLabel lblChooseList;
	private JScrollPane scrollPanePublicDestinations;
	private JList<PublicDestination> listPublicDestinations;
	private JButton btnAddToPrivate;
	
	private MainWindow mainWindow;
	/**
	 * Create the dialog.
	 */
	public AddPublicToPrivate(MainWindow mainWindow) {
		setTitle("Vacation Bucket List");
		setIconImage(Toolkit.getDefaultToolkit().getImage(AddPublicToPrivate.class.getResource("/img/logo.png")));
		this.mainWindow = mainWindow;
		setBounds(100, 100, 629, 472);
		getContentPane().setLayout(null);
		getContentPane().add(getLblAddPublicToPrivate());
		getContentPane().add(getLblChooseList());
		getContentPane().add(getScrollPanePublicDestinations());
		getContentPane().add(getBtnAddToPrivate());

	}
	
	private JLabel getLblAddPublicToPrivate() {
		if (lblAddPublicToPrivate == null) {
			lblAddPublicToPrivate = new JLabel("Add public destination to private bucket list");
			lblAddPublicToPrivate.setHorizontalAlignment(SwingConstants.CENTER);
			lblAddPublicToPrivate.setFont(new Font("Tahoma", Font.BOLD, 18));
			lblAddPublicToPrivate.setBounds(10, 10, 595, 60);
		}
		return lblAddPublicToPrivate;
	}
	private JLabel getLblChooseList() {
		if (lblChooseList == null) {
			lblChooseList = new JLabel("Choose from the list of public destinations:");
			lblChooseList.setHorizontalAlignment(SwingConstants.CENTER);
			lblChooseList.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lblChooseList.setBounds(98, 61, 399, 49);
		}
		return lblChooseList;
	}
	private JScrollPane getScrollPanePublicDestinations() {
		if (scrollPanePublicDestinations == null) {
			scrollPanePublicDestinations = new JScrollPane();
			scrollPanePublicDestinations.setBounds(30, 120, 550, 242);
			scrollPanePublicDestinations.setViewportView(getListPublicDestinations());
		}
		return scrollPanePublicDestinations;
	}
	private JList<PublicDestination> getListPublicDestinations() {
		if (listPublicDestinations == null) {
			List<PublicDestination> publicDestinations = mainWindow.getApp().getPublicDestinations();
	        DefaultListModel<PublicDestination> listModel = new DefaultListModel<>();
	        for (PublicDestination element : publicDestinations) {
	            listModel.addElement(element);
	        }
	        listPublicDestinations = new JList<PublicDestination>(listModel);
	        listPublicDestinations.addListSelectionListener(new ListSelectionListener() {
	        	public void valueChanged(ListSelectionEvent e) {
	        		getBtnAddToPrivate().setEnabled(!listPublicDestinations.isSelectionEmpty());
	        	}
	        });
		}
		return listPublicDestinations;
	}
		
	private JButton getBtnAddToPrivate() {
		if (btnAddToPrivate == null) {
			btnAddToPrivate = new JButton("Add to private list");
			btnAddToPrivate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					savePublicAsPrivate((PublicDestination) listPublicDestinations.getSelectedValue());
					dispose();
				}
			});
			btnAddToPrivate.setEnabled(false);
			btnAddToPrivate.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnAddToPrivate.setBounds(219, 381, 159, 29);
		}
		return btnAddToPrivate;
	}

	private void savePublicAsPrivate(PublicDestination selectedValue) {
		// Create a private destination based on the selected (public) one
		PrivateDestination publicToPrivateDestination = new PrivateDestination(selectedValue.getGeolocation(), selectedValue.getTitle(), selectedValue.getImage(), selectedValue.getDescription(), selectedValue.getInitialDate(), selectedValue.getEndDate(), mainWindow.getApp().getLoggedUser());
		// Add the new destination to it list
		mainWindow.getApp().getPrivateDestinations().add(publicToPrivateDestination);
		// Add the new destination to it model list
		mainWindow.getPrivateListModel().addElement(publicToPrivateDestination);
		// Add the new destination to the files to be persisted
		mainWindow.getApp().saveNewPrivateDestination(publicToPrivateDestination);
	}
}
