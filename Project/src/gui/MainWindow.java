package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Application;
import model.Destination;
import model.PrivateDestination;
import model.PublicDestination;

import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainWindow extends JFrame {
	private static final long serialVersionUID = 1L;

	private Application app;

	private JPanel contentPane;
	private JPanel loginPanel;
	private JPanel adminHomePanel;
	private JPanel userHomePanel;
	private JButton loginBtn;
	private JTextField usernameTxtField;
	private JLabel errorLbl;
	private JPasswordField passwordTxtField;
	private JLabel usernameLbl;
	private JLabel passwordLbl;
	private JLabel lblUserPanel;
	private JLabel lblAdminPanel;
	private JLabel lblListPublicDestinations;
	private JScrollPane scrollPanePublicDestinations;
	private JList<PublicDestination> listPublicDestinations;
	private JPanel destinationDetailsPanel;
	private JLabel lblPublicDetailTitle;
	
	private DestinationDetailsPanel destinationPanel;
	private AddPublicToPrivate publicToPrivate;
	private AddPublicDestination addPublic;
	private AddPrivateDestination addPrivate;
	private JLabel lblWelcome;
	private JLabel lblIcon;
	private JButton btnReloadDestinations;
	private JLabel lblListPrivateDestinations;
	private JScrollPane scrollPanePrivateDestinations;
	private JList<PrivateDestination> listPrivateDestinations;
	private JButton btnAddPrivateDestination;
	private JButton btnAddFromPublic;
	
	DefaultListModel<PublicDestination> publicListModel = new DefaultListModel<>();
	DefaultListModel<PrivateDestination> privateListModel = new DefaultListModel<>();
	
	/**
	 * Create the frame.
	 */
	public MainWindow(Application app) {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				if (checkExit()) {
					System.exit(0);
				}
			}
		});
		setTitle("Vacation Bucket List");
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainWindow.class.getResource("/img/logo.png")));
		this.app=app;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 853, 560);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		addPanels();
	}
	
	private void addPanels() {
		contentPane.add(getLoginPanel(), "loginPanel");
		contentPane.add(getAdminHomePanel(), "adminHomePanel");
		contentPane.add(getUserHomePanel(), "userHomePanel");
		//contentPane.add(getDestinationDetailsPanel(null), "destinationDetailsPanel");
	}
	
	public Application getApp() {
		return app;
	}
	
	public boolean checkExit() {
		if (JOptionPane.showConfirmDialog(this, "Are you sure you want to exit the application?") == JOptionPane.YES_OPTION) {
			return true;
		}
		return false;
	}
	
	
	//--------------------------------------------------------------------------
	//--------------------------------------------------------------------------
	//--------------------------------------------------------------------------
	//--------------------------------------------------------------------------
	//------------------------------ Admin Window-------------------------------
	//--------------------------------------------------------------------------
	//--------------------------------------------------------------------------
	//--------------------------------------------------------------------------
	private JPanel getAdminHomePanel() {
		if (adminHomePanel == null) {
			adminHomePanel = new JPanel();
			adminHomePanel.setLayout(null);
			
			JButton btnAddPublicDestination = new JButton("+");
			btnAddPublicDestination.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					showAddPublicDestination();
				}
			});
			btnAddPublicDestination.setFont(new Font("Tahoma", Font.BOLD, 15));
			btnAddPublicDestination.setBounds(753, 117, 55, 21);
			adminHomePanel.add(btnAddPublicDestination);
			adminHomePanel.add(getLblAdminPanel());
			adminHomePanel.add(getLblListPublicDestinations());
			adminHomePanel.add(getScrollPanePublicDestinations());
			adminHomePanel.add(getBtnReloadDestinations());
		}
		return adminHomePanel;
	}
	
	private void showAddPublicDestination() {
		addPublic = new AddPublicDestination(this);
		addPublic.setLocationRelativeTo(this);
		addPublic.setModal(true);
		addPublic.setVisible(true);
	}
	
	private void showAddPrivateDestination() {
		addPrivate = new AddPrivateDestination(this);
		addPrivate.setLocationRelativeTo(this);
		addPrivate.setModal(true);
		addPrivate.setVisible(true);
	}

	private JLabel getLblAdminPanel() {
		if (lblAdminPanel == null) {
			lblAdminPanel = new JLabel("Admin panel");
			lblAdminPanel.setHorizontalAlignment(SwingConstants.CENTER);
			lblAdminPanel.setFont(new Font("Tahoma", Font.BOLD, 20));
			lblAdminPanel.setBounds(306, 28, 167, 48);
		}
		return lblAdminPanel;
	}
	private JLabel getLblListPublicDestinations() {
		if (lblListPublicDestinations == null) {
			lblListPublicDestinations = new JLabel("List of public destinations:");
			lblListPublicDestinations.setHorizontalAlignment(SwingConstants.CENTER);
			lblListPublicDestinations.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lblListPublicDestinations.setBounds(209, 95, 347, 43);
		}
		return lblListPublicDestinations;
	}
	
	private JScrollPane getScrollPanePublicDestinations() {
		if (scrollPanePublicDestinations == null) {
			scrollPanePublicDestinations = new JScrollPane();
			scrollPanePublicDestinations.setBounds(22, 149, 786, 326);
			scrollPanePublicDestinations.setViewportView(getListPublicDestinations());
		}
		return scrollPanePublicDestinations;
	}
	
	private JList<PublicDestination> getListPublicDestinations() {
		if (listPublicDestinations == null) {
			
			List<PublicDestination> publicDestinations = app.getPublicDestinations();
	        for (PublicDestination element : publicDestinations) {
	        	publicListModel.addElement(element);
	        }
	        listPublicDestinations = new JList<PublicDestination>(publicListModel);
	        listPublicDestinations.addMouseListener(new MouseAdapter() {
	        	@Override
	        	public void mouseClicked(MouseEvent e) {
	        		if (e.getClickCount() == 2) {  // Double-click
	                    PublicDestination selectedDestination = (PublicDestination) listPublicDestinations.getSelectedValue();
	                    if (selectedDestination != null) {
	                    	showDestinationDetails(selectedDestination);
	                    	//((CardLayout) getContentPane().getLayout()).show(getContentPane(), "destinationDetailsPanel");
	                    }
	                }
	        	}
	        });
		}
		return listPublicDestinations;
	}
	
	private void showDestinationDetails(Destination selectedDestination) {
		destinationPanel = new DestinationDetailsPanel(selectedDestination);
		destinationPanel.setLocationRelativeTo(this);
		destinationPanel.setModal(true);
		destinationPanel.setVisible(true);
		
	}

	//--------------------------------------------------------------------------
	//--------------------------------------------------------------------------
	//--------------------------------------------------------------------------
	//--------------------------------------------------------------------------
	//------------------------------ Public List Details Window-----------------
	//--------------------------------------------------------------------------
	//--------------------------------------------------------------------------
	//--------------------------------------------------------------------------
	
	@SuppressWarnings("unused")
	private JPanel getDestinationDetailsPanel(PublicDestination selectedDestination) {
		if (destinationDetailsPanel == null) {
			destinationDetailsPanel = new JPanel();
			destinationDetailsPanel.setLayout(null);
			destinationDetailsPanel.add(getLblPublicDetailTitle());
		}
		return destinationDetailsPanel;
	}
	private JLabel getLblPublicDetailTitle() {
		if (lblPublicDetailTitle == null) {
			lblPublicDetailTitle = new JLabel();
			lblPublicDetailTitle.setText(getTitle()); // a�adir title dinamically
			lblPublicDetailTitle.setBounds(157, 10, 354, 55);
		}
		return lblPublicDetailTitle;
	}
	
	//--------------------------------------------------------------------------
	//--------------------------------------------------------------------------
	//--------------------------------------------------------------------------
	//--------------------------------------------------------------------------
	//------------------------------ User Window--------------------------------
	//--------------------------------------------------------------------------
	//--------------------------------------------------------------------------
	//--------------------------------------------------------------------------
	private JPanel getUserHomePanel() {
		if (userHomePanel == null) {
			userHomePanel = new JPanel();
			userHomePanel.setLayout(null);
			userHomePanel.add(getLblUserPanel());
			userHomePanel.add(getLblListPrivateDestinations());
			userHomePanel.add(getScrollPanePrivateDestinations());
			userHomePanel.add(getBtnAddPrivateDestination());
			userHomePanel.add(getBtnAddFromPublic());
		}
		return userHomePanel;
	}
	
	//--------------------------------------------------------------------------
	//--------------------------------------------------------------------------
	//--------------------------------------------------------------------------
	//--------------------------------------------------------------------------
	//------------------------------ Login Window ------------------------------
	//--------------------------------------------------------------------------
	//--------------------------------------------------------------------------
	//--------------------------------------------------------------------------
	private JPanel getLoginPanel() {
		if (loginPanel == null) {
			loginPanel = new JPanel();
			loginPanel.setFont(new Font("Tahoma", Font.PLAIN, 20));
			loginPanel.setLayout(null);
			loginPanel.add(getLoginBtn());
			loginPanel.add(getUsernameTxtField());
			loginPanel.add(getErrorLbl());
			loginPanel.add(getPasswordTxtField());
			loginPanel.add(getUsernameLbl());
			loginPanel.add(getPasswordLbl());
			loginPanel.add(getLblWelcome());
			loginPanel.add(getLblIcon());
		}
		return loginPanel;
	}
	
	private JButton getLoginBtn() {
		if (loginBtn == null) {
			loginBtn = new JButton("Login");
			loginBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
			loginBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int privilege = app.checkLoggedUser(getUsernameTxtField().getText(), getPasswordTxtField().getPassword());
					if(privilege==0) {
						((CardLayout) getContentPane().getLayout()).show(getContentPane(), "userHomePanel");
					}else if (privilege==1){
						((CardLayout) getContentPane().getLayout()).show(getContentPane(), "adminHomePanel");
					}else {
						getErrorLbl().setVisible(true);
					}
				}
			});
			loginBtn.setBounds(520, 325, 96, 34);
		}
		return loginBtn;
	}
	private JTextField getUsernameTxtField() {
		if (usernameTxtField == null) {
			usernameTxtField = new JTextField();
			usernameTxtField.setBounds(505, 166, 136, 34);
			usernameTxtField.setColumns(10);
		}
		return usernameTxtField;
	}
	private JLabel getErrorLbl() {
		if (errorLbl == null) {
			errorLbl = new JLabel("Error: User not registered in the application.");
			errorLbl.setFont(new Font("Tahoma", Font.BOLD, 15));
			errorLbl.setForeground(new Color(255, 0, 0));
			errorLbl.setBounds(406, 411, 363, 25);
			errorLbl.setVisible(false);
		}
		return errorLbl;
	}
	
	private JPasswordField getPasswordTxtField() {
		if (passwordTxtField == null) {
			passwordTxtField = new JPasswordField();
			passwordTxtField.setBounds(505, 260, 136, 34);
		}
		return passwordTxtField;
	}
	
	private JLabel getUsernameLbl() {
		if (usernameLbl == null) {
			usernameLbl = new JLabel("Username:");
			usernameLbl.setFont(new Font("Tahoma", Font.PLAIN, 20));
			usernameLbl.setBounds(520, 131, 110, 25);
		}
		return usernameLbl;
	}
	
	private JLabel getPasswordLbl() {
		if (passwordLbl == null) {
			passwordLbl = new JLabel("Password:");
			passwordLbl.setFont(new Font("Tahoma", Font.PLAIN, 20));
			passwordLbl.setBounds(520, 229, 96, 20);
		}
		return passwordLbl;
	}
	
	private JLabel getLblUserPanel() {
		if (lblUserPanel == null) {
			lblUserPanel = new JLabel("User panel");
			lblUserPanel.setHorizontalAlignment(SwingConstants.CENTER);
			lblUserPanel.setFont(new Font("Tahoma", Font.BOLD, 20));
			lblUserPanel.setBounds(10, 23, 799, 46);
		}
		return lblUserPanel;
	}
	
	private JLabel getLblWelcome() {
		if (lblWelcome == null) {
			lblWelcome = new JLabel("Welcome to the Vacation Bucket List app!");
			lblWelcome.setFont(new Font("Tahoma", Font.BOLD, 30));
			lblWelcome.setBounds(107, 33, 652, 50);
		}
		return lblWelcome;
	}
	
	private JLabel getLblIcon() {
		if (lblIcon == null) {
			lblIcon = new JLabel("New label");
			lblIcon.setIcon(new ImageIcon(MainWindow.class.getResource("/img/logo.png")));
			lblIcon.setBounds(63, 119, 316, 283);
		}
		return lblIcon;
	}
	
	private JButton getBtnReloadDestinations() {
		if (btnReloadDestinations == null) {
			btnReloadDestinations = new JButton("Reload");
			btnReloadDestinations.setEnabled(false); // de momento no se usa, si se encuentra la manera de hacer refresh a la lista se activa
			btnReloadDestinations.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//getListPublicDestinations().update(getGraphics());
					//getListPublicDestinations().updateUI(); update List visually besides adding it to file
					app.initialize();
				}
			});
			btnReloadDestinations.setFont(new Font("Tahoma", Font.BOLD, 15));
			btnReloadDestinations.setBounds(647, 117, 85, 21);
		}
		return btnReloadDestinations;
	}
	
	private JLabel getLblListPrivateDestinations() {
		if (lblListPrivateDestinations == null) {
			lblListPrivateDestinations = new JLabel("List of private destinations:");
			lblListPrivateDestinations.setHorizontalAlignment(SwingConstants.CENTER);
			lblListPrivateDestinations.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lblListPrivateDestinations.setBounds(296, 79, 239, 34);
		}
		return lblListPrivateDestinations;
	}
	private JScrollPane getScrollPanePrivateDestinations() {
		if (scrollPanePrivateDestinations == null) {
			scrollPanePrivateDestinations = new JScrollPane();
			scrollPanePrivateDestinations.setBounds(40, 128, 753, 355);
			scrollPanePrivateDestinations.setViewportView(getListPrivateDestinations());
		}
		return scrollPanePrivateDestinations;
	}
	
	JList<PrivateDestination> getListPrivateDestinations() {
		if (listPrivateDestinations == null) {
			List<PrivateDestination> privateDestinations = app.getPrivateDestinations();
			for (PrivateDestination element : privateDestinations) {
				privateListModel.addElement(element);
			}
			listPrivateDestinations = new JList<PrivateDestination>(privateListModel);
			listPrivateDestinations.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if (e.getClickCount() == 2) { // Double-click
						PrivateDestination selectedDestination = (PrivateDestination) listPrivateDestinations.getSelectedValue();
						if (selectedDestination != null) {
							showDestinationDetails(selectedDestination);
						}
					}
				}
			});
		}
		return listPrivateDestinations;
	}
	
	private JButton getBtnAddPrivateDestination() {
		if (btnAddPrivateDestination == null) {
			btnAddPrivateDestination = new JButton("Create new private destination");
			btnAddPrivateDestination.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					showAddPrivateDestination();
				}
			});
			btnAddPrivateDestination.setBounds(607, 89, 186, 21);
		}
		return btnAddPrivateDestination;
	}
	private JButton getBtnAddFromPublic() {
		if (btnAddFromPublic == null) {
			btnAddFromPublic = new JButton("Add from public");
			btnAddFromPublic.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					showPublicListDestination();
				}
			});
			btnAddFromPublic.setBounds(607, 53, 186, 21);
		}
		return btnAddFromPublic;
	}

	private void showPublicListDestination() {
		publicToPrivate = new AddPublicToPrivate(this);
		publicToPrivate.setLocationRelativeTo(this);
		publicToPrivate.setModal(true);
		publicToPrivate.setVisible(true);
	}

	public DefaultListModel<PublicDestination> getPublicListModel() {
		return publicListModel;
	}

	public DefaultListModel<PrivateDestination> getPrivateListModel() {
		return privateListModel;
	}
}
