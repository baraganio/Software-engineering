package gui;

import javax.swing.JDialog;

import model.Destination;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JScrollPane;
import java.awt.Toolkit;
import java.text.SimpleDateFormat;

import javax.swing.ScrollPaneConstants;
import javax.swing.JTextArea;
import java.awt.Insets;

public class DestinationDetailsPanel extends JDialog {

	private static final long serialVersionUID = 1L;
	private JLabel lblDetailTitle;
	private Destination selectedDestination;
	private JLabel lblDetailImage;
	private JScrollPane lblDetailDescriptionScroll;
	private JLabel lblDetailGeoTitle;
	private JLabel lblDetailGeolocation;
	private JLabel lblDetailInitialDateTitle;
	private JLabel lblDetailInitialDate;
	private JLabel lblDetailEndDateTitle;
	private JLabel lblDetailEndDate;
	private JTextArea txtDetailDescription;

	/**
	 * Create the dialog.
	 * @param selectedDestination 
	 */
	public DestinationDetailsPanel(Destination selectedDestination) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(DestinationDetailsPanel.class.getResource("/img/logo.png")));
		setTitle("Details of the destination");
		this.selectedDestination = selectedDestination;
		setResizable(false);
		setBounds(100, 100, 695, 442);
		getContentPane().setLayout(null);
		getContentPane().add(getLblDetailTitle());
		getContentPane().add(getLblDetailImage());
		getContentPane().add(getLblDetailDescriptionScroll());
		getContentPane().add(getLblDetailGeoTitle());
		getContentPane().add(getLblDetailGeolocation());
		getContentPane().add(getLblDetailInitialDateTitle());
		getContentPane().add(getLblDetailInitialDate());
		getContentPane().add(getLblDetailEndDateTitle());
		getContentPane().add(getLblDetailEndDate());

	}
	
	
	private JLabel getLblDetailTitle() {
		if (lblDetailTitle == null) {
			lblDetailTitle = new JLabel(selectedDestination.getTitle());
			lblDetailTitle.setHorizontalAlignment(SwingConstants.CENTER);
			lblDetailTitle.setFont(new Font("Tahoma", Font.BOLD, 20));
			lblDetailTitle.setBounds(39, 21, 601, 71);
		}
		return lblDetailTitle;
	}
	
	private JLabel getLblDetailImage() {
		if (lblDetailImage == null) {
			lblDetailImage = new JLabel("");
			lblDetailImage.setBackground(Color.WHITE);
			lblDetailImage.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource(selectedDestination.getImage())).getImage().getScaledInstance(230, 259, Image.SCALE_DEFAULT)));
			lblDetailImage.setBounds(39, 90, 230, 259);
		}
		return lblDetailImage;
	}
	
	private JScrollPane getLblDetailDescriptionScroll() {
		if (lblDetailDescriptionScroll == null) {
			lblDetailDescriptionScroll = new JScrollPane();
			lblDetailDescriptionScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			lblDetailDescriptionScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			lblDetailDescriptionScroll.setBounds(291, 90, 349, 136);
			lblDetailDescriptionScroll.setViewportView(getTxtDetailDescription());
		}
		return lblDetailDescriptionScroll;
	}
	
	private JLabel getLblDetailGeoTitle() {
		if (lblDetailGeoTitle == null) {
			lblDetailGeoTitle = new JLabel("Geolocation:");
			lblDetailGeoTitle.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lblDetailGeoTitle.setBounds(290, 236, 113, 31);
		}
		return lblDetailGeoTitle;
	}
	
	private JLabel getLblDetailGeolocation() {
		if (lblDetailGeolocation == null) {
			lblDetailGeolocation = new JLabel(selectedDestination.getGeolocation());
			lblDetailGeolocation.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lblDetailGeolocation.setBounds(413, 236, 227, 31);
		}
		return lblDetailGeolocation;
	}
	
	private JLabel getLblDetailInitialDateTitle() {
		if (lblDetailInitialDateTitle == null) {
			lblDetailInitialDateTitle = new JLabel("Initial date:");
			lblDetailInitialDateTitle.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lblDetailInitialDateTitle.setBounds(290, 277, 113, 31);
		}
		return lblDetailInitialDateTitle;
	}
	
	private JLabel getLblDetailInitialDate() {
		if (lblDetailInitialDate == null) {
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			String formattedDate = dateFormat.format(selectedDestination.getInitialDate());
			lblDetailInitialDate = new JLabel(formattedDate);
			lblDetailInitialDate.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lblDetailInitialDate.setBounds(413, 277, 227, 31);
		}
		return lblDetailInitialDate;
	}
	
	private JLabel getLblDetailEndDateTitle() {
		if (lblDetailEndDateTitle == null) {
			lblDetailEndDateTitle = new JLabel("Ending date:");
			lblDetailEndDateTitle.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lblDetailEndDateTitle.setBounds(291, 318, 113, 31);
		}
		return lblDetailEndDateTitle;
	}
	
	private JLabel getLblDetailEndDate() {
		if (lblDetailEndDate == null) {
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			String formattedDate = dateFormat.format(selectedDestination.getEndDate());
			lblDetailEndDate = new JLabel(formattedDate);
			lblDetailEndDate.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lblDetailEndDate.setBounds(413, 318, 227, 31);
		}
		return lblDetailEndDate;
	}
	
	private JTextArea getTxtDetailDescription() {
		if (txtDetailDescription == null) {
			txtDetailDescription = new JTextArea(selectedDestination.getDescription());
			txtDetailDescription.setMargin(new Insets(4, 4, 4, 4));
			txtDetailDescription.setEditable(false);
			txtDetailDescription.setFont(new Font("Calibri", Font.PLAIN, 16));
			txtDetailDescription.setLineWrap(true);
	        txtDetailDescription.setWrapStyleWord(true);
		}
		return txtDetailDescription;
	}
}
