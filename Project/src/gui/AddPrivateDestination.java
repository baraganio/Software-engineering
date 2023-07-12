package gui;

import com.toedter.calendar.JCalendar;

import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import model.FileUtil;
import model.PrivateDestination;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class AddPrivateDestination extends JDialog {
	private static final long serialVersionUID = 1L;
	private JLabel lblTitleAddPrivate;
	private JLabel lblAddPrivateTitle;
	private JTextField txtAddPrivateTitle;
	private JLabel lblAddPrivateDescription;
	private JScrollPane scrollPanePrivateDescription;
	private JTextArea textAreaPublicDescription;
	private JLabel lblAddPrivateGeolocation;
	private JTextField txtAddPrivateGeolocation;
	private JLabel lblAddPrivateInitialDate;
	private JLabel lblAddPrivateEndDate;
	private JCalendar calendarPrivateInitialDate;
	private JCalendar calendarPrivateEndDate;
	private JLabel lblAddPrivateImage;
	private JFileChooser imageChooser;
	private JButton btnAddPrivateImageChooseFile;
	private JButton btnSavePrivateDestination;
	
	private MainWindow mainWindow;

	/**
	 * Create the dialog.
	 */
	public AddPrivateDestination(MainWindow mainWindow) {
		setTitle("Vacation Bucket List");
		setIconImage(Toolkit.getDefaultToolkit().getImage(AddPrivateDestination.class.getResource("/img/logo.png")));
		this.mainWindow = mainWindow;
		setBounds(100, 100, 946, 786);
		getContentPane().setLayout(null);
		getContentPane().add(getLblTitleAddPrivate());
		getContentPane().add(getLblAddPrivateTitle());
		getContentPane().add(getTxtAddPrivateTitle());
		getContentPane().add(getLblAddPrivateDescription());
		getContentPane().add(getScrollPanePrivateDescription());
		getContentPane().add(getLblAddPrivateGeolocation());
		getContentPane().add(getTxtAddPrivateGeolocation());
		getContentPane().add(getLblAddPrivateInitialDate());
		getContentPane().add(getLblAddPrivateEndDate());
		getContentPane().add(getCalendarPrivateInitialDate());
		getContentPane().add(getCalendarPrivateEndDate());
		getContentPane().add(getLblAddPrivateImage());
		getContentPane().add(getBtnAddPrivateImageChooseFile());
		getContentPane().add(getBtnSavePrivateDestination());

	}
	private JLabel getLblTitleAddPrivate() {
		if (lblTitleAddPrivate == null) {
			lblTitleAddPrivate = new JLabel("Add a new private destination");
			lblTitleAddPrivate.setFont(new Font("Tahoma", Font.BOLD, 20));
			lblTitleAddPrivate.setHorizontalAlignment(SwingConstants.CENTER);
			lblTitleAddPrivate.setBounds(10, 10, 912, 56);
		}
		return lblTitleAddPrivate;
	}
	private JLabel getLblAddPrivateTitle() {
		if (lblAddPrivateTitle == null) {
			lblAddPrivateTitle = new JLabel("Title:");
			lblAddPrivateTitle.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lblAddPrivateTitle.setBounds(224, 77, 63, 32);
		}
		return lblAddPrivateTitle;
	}
	private JTextField getTxtAddPrivateTitle() {
		if (txtAddPrivateTitle == null) {
			txtAddPrivateTitle = new JTextField();
			txtAddPrivateTitle.setBounds(315, 76, 337, 35);
			txtAddPrivateTitle.setColumns(10);
		}
		return txtAddPrivateTitle;
	}
	private JLabel getLblAddPrivateDescription() {
		if (lblAddPrivateDescription == null) {
			lblAddPrivateDescription = new JLabel("Description:");
			lblAddPrivateDescription.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lblAddPrivateDescription.setBounds(35, 545, 97, 32);
		}
		return lblAddPrivateDescription;
	}
	private JScrollPane getScrollPanePrivateDescription() {
		if (scrollPanePrivateDescription == null) {
			scrollPanePrivateDescription = new JScrollPane();
			scrollPanePrivateDescription.setBounds(150, 520, 706, 82);
			scrollPanePrivateDescription.setViewportView(getTextAreaPublicDescription());
		}
		return scrollPanePrivateDescription;
	}
	private JTextArea getTextAreaPublicDescription() {
		if (textAreaPublicDescription == null) {
			textAreaPublicDescription = new JTextArea();
		}
		return textAreaPublicDescription;
	}
	private JLabel getLblAddPrivateGeolocation() {
		if (lblAddPrivateGeolocation == null) {
			lblAddPrivateGeolocation = new JLabel("Geolocation:");
			lblAddPrivateGeolocation.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lblAddPrivateGeolocation.setBounds(189, 147, 110, 32);
		}
		return lblAddPrivateGeolocation;
	}
	private JTextField getTxtAddPrivateGeolocation() {
		if (txtAddPrivateGeolocation == null) {
			txtAddPrivateGeolocation = new JTextField();
			txtAddPrivateGeolocation.setColumns(10);
			txtAddPrivateGeolocation.setBounds(315, 147, 337, 35);
		}
		return txtAddPrivateGeolocation;
	}
	private JLabel getLblAddPrivateInitialDate() {
		if (lblAddPrivateInitialDate == null) {
			lblAddPrivateInitialDate = new JLabel("Initial date:");
			lblAddPrivateInitialDate.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lblAddPrivateInitialDate.setBounds(170, 210, 110, 32);
		}
		return lblAddPrivateInitialDate;
	}
	private JLabel getLblAddPrivateEndDate() {
		if (lblAddPrivateEndDate == null) {
			lblAddPrivateEndDate = new JLabel("End date:");
			lblAddPrivateEndDate.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lblAddPrivateEndDate.setBounds(654, 210, 110, 32);
		}
		return lblAddPrivateEndDate;
	}
	private JCalendar getCalendarPrivateInitialDate() {
		if (calendarPrivateInitialDate == null) {
			calendarPrivateInitialDate = new JCalendar();
			Border borderStart = BorderFactory.createLineBorder(Color.BLACK, 1);
			calendarPrivateInitialDate.setBorder(borderStart);
			calendarPrivateInitialDate.setBounds(50, 260, 365, 220);
		}
		return calendarPrivateInitialDate;
	}
	private JCalendar getCalendarPrivateEndDate() {
		if (calendarPrivateEndDate == null) {
			calendarPrivateEndDate = new JCalendar();
			Border borderEnd = BorderFactory.createLineBorder(Color.BLACK, 1);
			calendarPrivateEndDate.setBorder(borderEnd);
			calendarPrivateEndDate.setBounds(500, 260, 365, 220);
		}
		return calendarPrivateEndDate;
	}
	private JLabel getLblAddPrivateImage() {
		if (lblAddPrivateImage == null) {
			lblAddPrivateImage = new JLabel("Image:");
			lblAddPrivateImage.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lblAddPrivateImage.setBounds(50, 626, 70, 42);
		}
		return lblAddPrivateImage;
	}
	
	private JButton getBtnAddPrivateImageChooseFile() {
		if (btnAddPrivateImageChooseFile == null) {
			btnAddPrivateImageChooseFile = new JButton("Choose file...");
			btnAddPrivateImageChooseFile.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					imageChooser=FileUtil.chooseImage();
				}
			});
			btnAddPrivateImageChooseFile.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnAddPrivateImageChooseFile.setBounds(352, 627, 237, 42);
		}
		return btnAddPrivateImageChooseFile;
	}
	private JButton getBtnSavePrivateDestination() {
		if (btnSavePrivateDestination == null) {
			btnSavePrivateDestination = new JButton("SAVE");
			btnSavePrivateDestination.setFont(new Font("Tahoma", Font.BOLD, 15));
			btnSavePrivateDestination.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(getTxtAddPrivateGeolocation().getText().isBlank() || getTxtAddPrivateTitle().getText().isBlank() || imageChooser == null || getTextAreaPublicDescription().getText().isBlank() || getCalendarPrivateInitialDate().getDate() == null || getCalendarPrivateEndDate().getDate()==null) {
						JOptionPane.showMessageDialog(rootPane, "Some of the fields are empty, please complete them");
					}else if(!containsOnlyNumbers(getTxtAddPrivateGeolocation().getText())){
						JOptionPane.showMessageDialog(rootPane, "The geolocation doesn't match the pattern (00.0000,00.0000) being the '0' numbers");
					}else if(getCalendarPrivateInitialDate().getDate().compareTo(getCalendarPrivateEndDate().getDate())>0){
						JOptionPane.showMessageDialog(rootPane, "The end date must be later than the initial date");
					}else {
						savePrivateDestination();
						dispose(); // close window
					}
					
				}
			});
			btnSavePrivateDestination.setBounds(410, 689, 120, 32);
		}
		return btnSavePrivateDestination;
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
	
	
	
	private void savePrivateDestination() {
		SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd-MM-yyyy");
		SimpleDateFormat dateFormat2 = new SimpleDateFormat("dd-MM-yyyy");
		dateFormat1.format(getCalendarPrivateInitialDate().getDate());
		dateFormat2.format(getCalendarPrivateEndDate().getDate());
		// Create the private destination with the information given on the fields
		PrivateDestination privateDestination = new PrivateDestination(getTxtAddPrivateGeolocation().getText(), getTxtAddPrivateTitle().getText(), "/img/" + imageChooser.getSelectedFile().getName(), getTextAreaPublicDescription().getText(), getCalendarPrivateInitialDate().getDate(), getCalendarPrivateEndDate().getDate(), mainWindow.getApp().getLoggedUser());
		// Add the new destination to it list
		mainWindow.getApp().getPrivateDestinations().add(privateDestination);
		// Add the new destination to it model list
		mainWindow.privateListModel.addElement(privateDestination);
		// Add the new destination to the files to be persisted
		mainWindow.getApp().saveNewPrivateDestination(privateDestination);
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
