package model;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

public abstract class FileUtil {
	
	public FileUtil(Application app) {
	}

	public static void loadUsersFile(List<NormalUser> userList,List<AdminUser> adminList) {
		String linea;
		String[] userData = null;

		try {
			BufferedReader fichero = new BufferedReader(new FileReader("files/users.txt"));
			while (fichero.ready()) {
				linea = fichero.readLine();
				userData = linea.split("#");
				if(Integer.parseInt(userData[3])==1) {
					adminList.add(new AdminUser(userData[0],userData[1],userData[2]));
				}else {
					userList.add(new NormalUser(userData[0],userData[1],userData[2]));
				}
			}
			fichero.close();
		} catch (FileNotFoundException fnfe) {
			System.out.println("El archivo no se ha encontrado.");
		} catch (IOException ioe) {
			new RuntimeException("Error de entrada/salida.");
		}
	}
	
	public static void loadDestinationsFile(Application app, List<PublicDestination> publicDestinationList, List<PrivateDestination> privateDestinationList) throws ParseException {
		String linea;
		String[] destinationData = null;
		SimpleDateFormat dateFormatInitial = new SimpleDateFormat("dd-MM-yyyy");
		SimpleDateFormat dateFormatEnd = new SimpleDateFormat("dd-MM-yyyy");
		List<NormalUser> usersInApp = app.getUsers();
		try {
			BufferedReader fichero = new BufferedReader(new FileReader("files/destinations.txt"));
			while (fichero.ready()) {
				linea = fichero.readLine();
				destinationData = linea.split("#");
				if(destinationData[6].equals("public")) {
					publicDestinationList.add(new PublicDestination(destinationData[0], destinationData[1], destinationData[2], destinationData[3], dateFormatInitial.parse(destinationData[4]), dateFormatEnd.parse(destinationData[5])));
				}else if (destinationData[6].equals("private")) {
					String username = destinationData[7];
					NormalUser thisUser = null;
					for (NormalUser i : usersInApp) {
					    if (i.getUsername().equals(username)) {
					        thisUser = new NormalUser(i.getUsername(), i.getEmail(), i.getPassword());
					        break; // Exit the loop once the user is found
					    }
					}
					privateDestinationList.add(new PrivateDestination(destinationData[0], destinationData[1], destinationData[2], destinationData[3], dateFormatInitial.parse(destinationData[4]), dateFormatEnd.parse(destinationData[5]), thisUser));
				}
			}
			fichero.close();
		} catch (FileNotFoundException fnfe) {
			System.out.println("El archivo no se ha encontrado.");
		} catch (IOException ioe) {
			new RuntimeException("Error de entrada/salida.");
		}
	}
	
	public static void saveToFilePublic(PublicDestination publicDestination) {
        try {
            BufferedWriter file = new BufferedWriter(new FileWriter("files/destinations.txt", true));
            String line = publicDestination.toStringToFile();
            file.write(line);
            file.newLine(); // move to next line
            file.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
	
	public static void saveToFilePrivate(PrivateDestination privateDestination) {
        try {
            BufferedWriter file = new BufferedWriter(new FileWriter("files/destinations.txt", true));
            String line = privateDestination.toStringToFile();
            file.write(line);
            file.newLine(); // move to next line
            file.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
	
	public static JFileChooser chooseImage() {
		
		JFileChooser imageChooser = new JFileChooser(FileSystemView.getFileSystemView());
			
			// Create a file filter for .png files
            FileNameExtensionFilter pngFilter = new FileNameExtensionFilter("PNG Files", "png");
            
            // Set the file filter for the file chooser
            imageChooser.setFileFilter(pngFilter);
            
			int returnValue = imageChooser.showOpenDialog(null);
			// Check if a file was selected
	        if (returnValue == JFileChooser.APPROVE_OPTION) {
	            File selectedFile = imageChooser.getSelectedFile();
	            System.out.println(selectedFile);
	            
	         // Specify the destination directory within the "img" folder
	            String destinationPath = "src/img/" + selectedFile.getName();
	            try {
	                // Copy the selected image file to the destination directory
	                FileInputStream fileInputStream = new FileInputStream(selectedFile);
	                FileOutputStream fileOutputStream = new FileOutputStream(destinationPath);
	                byte[] buffer = new byte[1024];
	                int bytesRead;
	                while ((bytesRead = fileInputStream.read(buffer)) != -1) {
	                    fileOutputStream.write(buffer, 0, bytesRead);
	                }
	                fileOutputStream.close();
	                fileInputStream.close();

	                System.out.println("Image saved to: " + destinationPath);
	                return imageChooser;
	            } catch (IOException ex) {
	                ex.printStackTrace();
	            }           
	            
	        } else {
	        	System.out.println("No image selected.");
	        	
	        }
			return null;			
	}
}
