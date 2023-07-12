package gui;

import com.toedter.calendar.JCalendar;

import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;

import javax.swing.SwingConstants;
import javax.swing.border.Border;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import model.FileUtil;
import model.PublicDestination;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class AddPublicDestination extends JDialog {
	private static final long serialVersionUID = 1L;
	private JLabel lblTitleAddPublic;
	private JLabel lblAddPublicTitle;
	private JTextField txtAddPublicTitle;
	private JLabel lblAddPublicDescription;
	private JScrollPane scrollPanePublicDescription;
	private JTextArea textAreaPublicDescription;
	private JLabel lblAddPublicGeolocation;
	private JTextField txtAddPublicGeolocation;
	private JLabel lblAddPublicInitialDate;
	private JLabel lblAddPublicEndDate;
	private JCalendar calendarPublicInitialDate;
	private JCalendar calendarPublicEndDate;
	private JLabel lblAddPublicImage;
	private JFileChooser imageChooser;
	private JButton btnAddPublicImageChooseFile;
	private JButton btnSavePublicDestination;
	
	private MainWindow mainWindow;

	/**
	 * Create the dialog.
	 */
	public AddPublicDestination(MainWindow mainWindow) {
		setTitle("Vacation Bucket List");
		setIconImage(Toolkit.getDefaultToolkit().getImage(AddPublicDestination.class.getResource("/img/logo.png")));
		this.mainWindow = mainWindow;
		setBounds(100, 100, 946, 786);
		getContentPane().setLayout(null);
		getContentPane().add(getLblTitleAddPublic());
		getContentPane().add(getLblAddPublicTitle());
		getContentPane().add(getTxtAddPublicTitle());
		getContentPane().add(getLblAddPublicDescription());
		getContentPane().add(getScrollPanePublicDescription());
		getContentPane().add(getLblAddPublicGeolocation());
		getContentPane().add(getTxtAddPublicGeolocation());
		getContentPane().add(getLblAddPublicInitialDate());
		getContentPane().add(getLblAddPublicEndDate());
		getContentPane().add(getCalendarPublicInitialDate());
		getContentPane().add(getCalendarPublicEndDate());
		getContentPane().add(getLblAddPublicImage());
		getContentPane().add(getBtnAddPublicImageChooseFile());
		getContentPane().add(getBtnSavePublicDestination());

	}
	private JLabel getLblTitleAddPublic() {
		if (lblTitleAddPublic == null) {
			lblTitleAddPublic = new JLabel("Add a new public destination");
			lblTitleAddPublic.setFont(new Font("Tahoma", Font.BOLD, 20));
			lblTitleAddPublic.setHorizontalAlignment(SwingConstants.CENTER);
			lblTitleAddPublic.setBounds(10, 10, 912, 56);
		}
		return lblTitleAddPublic;
	}
	private JLabel getLblAddPublicTitle() {
		if (lblAddPublicTitle == null) {
			lblAddPublicTitle = new JLabel("Title:");
			lblAddPublicTitle.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lblAddPublicTitle.setBounds(224, 77, 63, 32);
		}
		return lblAddPublicTitle;
	}
	private JTextField getTxtAddPublicTitle() {
		if (txtAddPublicTitle == null) {
			txtAddPublicTitle = new JTextField();
			txtAddPublicTitle.setBounds(315, 76, 337, 35);
			txtAddPublicTitle.setColumns(10);
		}
		return txtAddPublicTitle;
	}
	private JLabel getLblAddPublicDescription() {
		if (lblAddPublicDescription == null) {
			lblAddPublicDescription = new JLabel("Description:");
			lblAddPublicDescription.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lblAddPublicDescription.setBounds(35, 545, 97, 32);
		}
		return lblAddPublicDescription;
	}
	private JScrollPane getScrollPanePublicDescription() {
		if (scrollPanePublicDescription == null) {
			scrollPanePublicDescription = new JScrollPane();
			scrollPanePublicDescription.setBounds(150, 520, 706, 82);
			scrollPanePublicDescription.setViewportView(getTextAreaPublicDescription());
		}
		return scrollPanePublicDescription;
	}
	private JTextArea getTextAreaPublicDescription() {
		if (textAreaPublicDescription == null) {
			textAreaPublicDescription = new JTextArea();
		}
		return textAreaPublicDescription;
	}
	private JLabel getLblAddPublicGeolocation() {
		if (lblAddPublicGeolocation == null) {
			lblAddPublicGeolocation = new JLabel("Geolocation:");
			lblAddPublicGeolocation.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lblAddPublicGeolocation.setBounds(189, 147, 110, 32);
		}
		return lblAddPublicGeolocation;
	}
	private JTextField getTxtAddPublicGeolocation() {
		if (txtAddPublicGeolocation == null) {
			txtAddPublicGeolocation = new JTextField();
			txtAddPublicGeolocation.setColumns(10);
			txtAddPublicGeolocation.setBounds(315, 147, 337, 35);
		}
		return txtAddPublicGeolocation;
	}
	private JLabel getLblAddPublicInitialDate() {
		if (lblAddPublicInitialDate == null) {
			lblAddPublicInitialDate = new JLabel("Initial date:");
			lblAddPublicInitialDate.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lblAddPublicInitialDate.setBounds(170, 210, 110, 32);
		}
		return lblAddPublicInitialDate;
	}
	private JLabel getLblAddPublicEndDate() {
		if (lblAddPublicEndDate == null) {
			lblAddPublicEndDate = new JLabel("End date:");
			lblAddPublicEndDate.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lblAddPublicEndDate.setBounds(654, 210, 110, 32);
		}
		return lblAddPublicEndDate;
	}
	private JCalendar getCalendarPublicInitialDate() {
		if (calendarPublicInitialDate == null) {
			calendarPublicInitialDate = new JCalendar();
			Border borderStart = BorderFactory.createLineBorder(Color.BLACK, 1);
			calendarPublicInitialDate.setBorder(borderStart);
			calendarPublicInitialDate.setBounds(50, 260, 365, 220);
		}
		return calendarPublicInitialDate;
	}
	private JCalendar getCalendarPublicEndDate() {
		if (calendarPublicEndDate == null) {
			calendarPublicEndDate = new JCalendar();
			Border borderEnd = BorderFactory.createLineBorder(Color.BLACK, 1);
			calendarPublicEndDate.setBorder(borderEnd);
			calendarPublicEndDate.setBounds(500, 260, 365, 220);
		}
		return calendarPublicEndDate;
	}
	private JLabel getLblAddPublicImage() {
		if (lblAddPublicImage == null) {
			lblAddPublicImage = new JLabel("Image:");
			lblAddPublicImage.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lblAddPublicImage.setBounds(50, 626, 70, 42);
		}
		return lblAddPublicImage;
	}	
	private JButton getBtnAddPublicImageChooseFile() {
		if (btnAddPublicImageChooseFile == null) {
			btnAddPublicImageChooseFile = new JButton("Choose file...");
			btnAddPublicImageChooseFile.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					imageChooser=FileUtil.chooseImage();
				}
			});
			btnAddPublicImageChooseFile.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnAddPublicImageChooseFile.setBounds(352, 627, 237, 42);
		}
		return btnAddPublicImageChooseFile;
	}	

	private JButton getBtnSavePublicDestination() {
		if (btnSavePublicDestination == null) {
			btnSavePublicDestination = new JButton("SAVE");
			btnSavePublicDestination.setFont(new Font("Tahoma", Font.BOLD, 15));
			btnSavePublicDestination.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(getTxtAddPublicGeolocation().getText().isBlank() || getTxtAddPublicTitle().getText().isBlank() || imageChooser == null || getTextAreaPublicDescription().getText().isBlank() || getCalendarPublicInitialDate().getDate() == null || getCalendarPublicEndDate().getDate()==null) {
						JOptionPane.showMessageDialog(rootPane, "Some of the fields are empty, please complete them");
					}else if(!containsOnlyNumbers(getTxtAddPublicGeolocation().getText())){
						JOptionPane.showMessageDialog(rootPane, "The geolocation doesn't match the pattern (00.0000,00.0000) being the '0' numbers");
					}else if(getCalendarPublicInitialDate().getDate().compareTo(getCalendarPublicEndDate().getDate())>0){
						JOptionPane.showMessageDialog(rootPane, "The end date must be later than the initial date");
					}else {
						savePublicDestination();
						dispose(); // close window
					}
				}
			});
			btnSavePublicDestination.setBounds(410, 689, 120, 32);
		}
		return btnSavePublicDestination;
	}
	
	private boolean containsOnlyNumbers(String input) {
		int dotCount=0;
		int colonCount=0;
	    for (int i = 0; i < input.length(); i++) {
	        if (!Character.isDigit(input.charAt(i)) && input.charAt(i)!='.' && input.charAt(i)!=',') {
	            return false;
	        }else if(input.charAt(i)=='.') {
	        	dotCount++;
	        }else if(input.charAt(i)==',') {
	        	colonCount++;
	        }
	        if(dotCount>2 || colonCount>1) {
	        	return false;
	        }
	    }
	    return true;
	}
	
	public void savePublicDestination() {
		SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd-MM-yyyy");
		SimpleDateFormat dateFormat2 = new SimpleDateFormat("dd-MM-yyyy");
		dateFormat1.format(getCalendarPublicInitialDate().getDate());
		dateFormat2.format(getCalendarPublicEndDate().getDate());
		// Create the public destination with the information given on the fields
		PublicDestination publicDestination = new PublicDestination(getTxtAddPublicGeolocation().getText(), getTxtAddPublicTitle().getText(), "/img/" + imageChooser.getSelectedFile().getName(), getTextAreaPublicDescription().getText(), getCalendarPublicInitialDate().getDate(), getCalendarPublicEndDate().getDate());
		// Add the new destination to it list
		mainWindow.getApp().getPublicDestinations().add(publicDestination);
		// Add the new destination to it model list
		mainWindow.publicListModel.addElement(publicDestination);
		// Add the new destination to the files to be persisted
		mainWindow.getApp().saveNewPublicDestination(publicDestination);
	}
	
	public static Date stringToDate(String dateString) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            return dateFormat.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null; // Return null if parsing fails
    }
}
