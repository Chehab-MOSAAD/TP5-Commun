package dialog;

import java.awt.EventQueue;

import presentation.JFrameReservation;

public class DialogueReservation {
	
	private String date;
	private String time;
	private String numPersons;
	private String numTable;
	private JFrameReservation presentationReservation;
	private int numClient;
	private int numService;
	private int[] proposition;
	private ControlReserverTable control;
	private ControlVisualiserCarnetClientele controlVisualiserCarnetClientele;
	
	public void initDialog() {
		//Create presentation frame
		presentationReservation = new JFrameReservation();
		//Associate dialogue to presentation
		presentationReservation.setDialogue(this);
		//Initialize and enable presentation frame
		presentationReservation.initPresentation();
		presentationReservation.setVisible(true);
	}
	
	
	public void handleDateSelectedEvent(String date) {
		this.date = date;
		presentationReservation.enableTime();
	}
	
	public void handleTimeSelectedEvent(String time) {
		this.time = time;
		presentationReservation.enableNumofPersons();
	}
	
	public void handleNumofPersonsSelectedEvent(String numPersons) {
		this.numPersons = numPersons;
		presentationReservation.enableTableMap();
		presentationReservation.initTableMap(proposition);
	}
	
	public void handleTableSelectedEvent(String numTable) {
		this.numTable = numTable;
		presentationReservation.enableValidationbtn();
	}
	
	public void handleCancelEvent() {
		presentationReservation.initPresentation();
	}
	
	public void handleValidateEvent() {
		//Display confirmation window using JOptionPane
		presentationReservation.enableValidationInformation(date, time, numPersons, numTable);
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		//Create dialogReservation
		DialogueReservation dialogReservation = new DialogueReservation();
				
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dialogReservation.initDialog();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
