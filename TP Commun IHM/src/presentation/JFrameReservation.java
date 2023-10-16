package presentation;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import com.github.lgooddatepicker.components.DatePicker;

import dialog.DialogueReservation;

import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.JButton;

import com.github.lgooddatepicker.optionalusertools.DateChangeListener;
import com.github.lgooddatepicker.zinternaltools.DateChangeEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import java.awt.Choice;
import java.awt.Label;
import javax.swing.AbstractListModel;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class JFrameReservation extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panelDateTime;
	private JLabel lblChooseDate;
	private JLabel lblChooseTime;
	private JPanel panelNumofPersons;
	private JLabel lblNumofPersons;
	private DatePicker datePicker;
	private JPanel panelTable;
	private JLabel lblTableMap;
	private JPanel panelConfirmCancel;
	private DialogueReservation dialogueReservation;
	private JButton btnValidate;
	private JComboBox tableNumPers;
	private JLabel lblChoisissezVotreTable;
	private JComboBox tableHoraires;
	private JButton btnAnnuler;
	private JList ListeNumTable;
	/**
	 * @wbp.nonvisual location=143,119
	 */
	


	/**
	 * Create the frame.
	 */
	public JFrameReservation() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(JFrameReservation.class.getResource("/resources/Plan_tables.JPG")));
		setTitle("R\u00E9servez une table");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 501, 736);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		panelDateTime = new JPanel();
		panelNumofPersons = new JPanel();
		panelTable = new JPanel();
		
		panelConfirmCancel = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(panelConfirmCancel, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
						.addComponent(panelTable, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
						.addComponent(panelNumofPersons, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
						.addComponent(panelDateTime, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 459, Short.MAX_VALUE))
					.addContainerGap(80, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panelDateTime, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panelNumofPersons, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panelTable, GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(panelConfirmCancel, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		lblTableMap = new JLabel("");
		lblTableMap.setForeground(new Color(0, 0, 0));
		lblTableMap.setIcon(new ImageIcon(JFrameReservation.class.getResource("/resources/Plan_tables.JPG")));
		
		lblChoisissezVotreTable = new JLabel("3. Choisissez votre table");
		lblChoisissezVotreTable.setEnabled(false);
		lblChoisissezVotreTable.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		ListeNumTable = new JList();
		ListeNumTable.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    JList<String> list = (JList<String>) e.getSource();
                    String selectedOption = (String) list.getSelectedValue();
                    do_ListeNumTable_listvalueChanged(selectedOption);
                }
            }
		});
		ListeNumTable.setEnabled(false);
		ListeNumTable.setModel(new AbstractListModel() {
			String[] values = new String[] {"Table 1", "Table 2", "Table 3", "Table 4", "Table 5", "Table 6"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		GroupLayout gl_panelTable = new GroupLayout(panelTable);
		gl_panelTable.setHorizontalGroup(
			gl_panelTable.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelTable.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelTable.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelTable.createSequentialGroup()
							.addComponent(lblTableMap, GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
							.addGap(28)
							.addComponent(ListeNumTable, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
							.addGap(37))
						.addGroup(gl_panelTable.createSequentialGroup()
							.addComponent(lblChoisissezVotreTable, GroupLayout.PREFERRED_SIZE, 323, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(126, Short.MAX_VALUE))))
		);
		gl_panelTable.setVerticalGroup(
			gl_panelTable.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelTable.createSequentialGroup()
					.addGroup(gl_panelTable.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelTable.createSequentialGroup()
							.addGap(10)
							.addComponent(lblChoisissezVotreTable, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblTableMap, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(gl_panelTable.createSequentialGroup()
							.addGap(147)
							.addComponent(ListeNumTable)))
					.addContainerGap())
		);
		panelTable.setLayout(gl_panelTable);
		
		btnValidate = new JButton("Valider");
		btnValidate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnValidate_actionPerformed();
			}
		});
		btnValidate.setEnabled(false);
		btnValidate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		btnAnnuler = new JButton("Annuler");
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnAnnuler_actionPerformed();
			}
		});
		
		GroupLayout gl_panelConfirmCancel = new GroupLayout(panelConfirmCancel);
		gl_panelConfirmCancel.setHorizontalGroup(
			gl_panelConfirmCancel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelConfirmCancel.createSequentialGroup()
					.addContainerGap(289, Short.MAX_VALUE)
					.addComponent(btnValidate, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnAnnuler, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
					.addGap(4))
		);
		gl_panelConfirmCancel.setVerticalGroup(
			gl_panelConfirmCancel.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panelConfirmCancel.createSequentialGroup()
					.addGap(22)
					.addGroup(gl_panelConfirmCancel.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnAnnuler, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnValidate, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panelConfirmCancel.setLayout(gl_panelConfirmCancel);
		
		lblNumofPersons = new JLabel("2. Indiquez le nombre de personnes");
		lblNumofPersons.setEnabled(false);
		lblNumofPersons.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		tableNumPers = new JComboBox();
		tableNumPers.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JComboBox<String> comboBox = (JComboBox<String>) e.getSource();
                String selectedOption = (String) comboBox.getSelectedItem();
                do_tableNumPers_numpersChanged(selectedOption); 
            }
		});
		
		tableNumPers.setEnabled(false);
		tableNumPers.setModel(new DefaultComboBoxModel(new String[] {"2", "3", "4", "5", "6", "7", "8"}));

		GroupLayout gl_panelNumofPersons = new GroupLayout(panelNumofPersons);
		gl_panelNumofPersons.setHorizontalGroup(
			gl_panelNumofPersons.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelNumofPersons.createSequentialGroup()
					.addGroup(gl_panelNumofPersons.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelNumofPersons.createSequentialGroup()
							.addGap(10)
							.addComponent(lblNumofPersons, GroupLayout.PREFERRED_SIZE, 323, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelNumofPersons.createSequentialGroup()
							.addGap(57)
							.addComponent(tableNumPers, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(126, Short.MAX_VALUE))
		);
		gl_panelNumofPersons.setVerticalGroup(
			gl_panelNumofPersons.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelNumofPersons.createSequentialGroup()
					.addGap(10)
					.addComponent(lblNumofPersons, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(tableNumPers, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(35, Short.MAX_VALUE))
		);
		panelNumofPersons.setLayout(gl_panelNumofPersons);
		
		lblChooseDate = new JLabel("1. Choisissez la date");
		lblChooseDate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		lblChooseTime = new JLabel("et l'heure");
		lblChooseTime.setEnabled(false);
		lblChooseTime.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		datePicker = new DatePicker();
		datePicker.getComponentToggleCalendarButton().setIcon(new ImageIcon(JFrameReservation.class.getResource("/resources/calender2icon.png")));
		datePicker.setText("  /  /    ");
		datePicker.addDateChangeListener(new DateChangeListener() {
			public void dateChanged(DateChangeEvent arg0) {
				do_datePicker_dateChanged(arg0);
			}
		});
		
		tableHoraires = new JComboBox();
		tableHoraires.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                JComboBox<String> comboBox = (JComboBox<String>) e.getSource();
                String selectedOption = (String) comboBox.getSelectedItem();
				do_tableHoraires_timeChanged(selectedOption);
			}
			
		});
		
		tableHoraires.setEnabled(false);
		tableHoraires.setModel(new DefaultComboBoxModel(new String[] {"12h00", "12h30", "13h00", "19h30", "20h00", "20h30"}));
		
		GroupLayout gl_panelDateTime = new GroupLayout(panelDateTime);
		gl_panelDateTime.setHorizontalGroup(
			gl_panelDateTime.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelDateTime.createSequentialGroup()
					.addGroup(gl_panelDateTime.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelDateTime.createSequentialGroup()
							.addGap(10)
							.addGroup(gl_panelDateTime.createParallelGroup(Alignment.LEADING)
								.addComponent(lblChooseDate, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panelDateTime.createSequentialGroup()
									.addGap(148)
									.addComponent(lblChooseTime, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_panelDateTime.createSequentialGroup()
							.addGap(37)
							.addComponent(datePicker, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(128)
							.addComponent(tableHoraires, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(66)))
					.addContainerGap())
		);
		gl_panelDateTime.setVerticalGroup(
			gl_panelDateTime.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelDateTime.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_panelDateTime.createParallelGroup(Alignment.LEADING)
						.addComponent(lblChooseDate, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblChooseTime, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addGap(44)
					.addGroup(gl_panelDateTime.createParallelGroup(Alignment.BASELINE)
						.addComponent(datePicker, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(tableHoraires))
					.addGap(33))
		);
		panelDateTime.setLayout(gl_panelDateTime);
		contentPane.setLayout(gl_contentPane);
	}
	
	public void initPresentation() {
		lblChooseDate.setEnabled(true);
		datePicker.setEnabled(true);
		lblChooseTime.setEnabled(false);
		tableHoraires.setEnabled(false);
		lblNumofPersons.setEnabled(false);
		tableNumPers.setEnabled(false);
		lblTableMap.setEnabled(false);
		ListeNumTable.setEnabled(false);
		lblChoisissezVotreTable.setEnabled(false);
		btnValidate.setEnabled(false);
		datePicker.setText("  /  /    ");
		System.out.println("InitPresentation done !");
	}
	
	public void enableTime() {
		tableHoraires.setEnabled(true);
		lblChooseTime.setEnabled(true);
	}
	
	public void enableNumofPersons() {
		lblNumofPersons.setEnabled(true);
		tableNumPers.setEnabled(true);
	}
	
	public void enableTableMap() {
		lblChoisissezVotreTable.setEnabled(true);
		lblTableMap.setEnabled(true);
		ListeNumTable.setEnabled(true);	
	}
	
	public void enableValidationbtn() {
		btnValidate.setEnabled(true);
	}
	
	public void enableValidationInformation(String date, String time, String numPersons, String numTable) {
		int response = JOptionPane.showConfirmDialog(this, "Vous confirmez cette réservation : Le " + date + " à " + time + " pour " + numPersons + " personnes à la " + numTable + " ?"," Confirmation de réservation : ", JOptionPane.YES_NO_OPTION);
		
		if (response == JOptionPane.YES_OPTION) {
			System.out.println("Confirmation Done ! Lets do another reservation ... ");
			initPresentation();
		}
	}
	
//Record reference to Dialogue
	public void setDialogue(DialogueReservation dialogReservation) {
		dialogueReservation = dialogReservation;
	}
	
	protected void do_datePicker_dateChanged(DateChangeEvent arg0) {
		String date = arg0.getNewDate().toString();
		System.out.println("Date Selected : " + date);
		dialogueReservation.handleDateSelectedEvent(date);
	}
	
	protected void do_tableHoraires_timeChanged(String time) {
		System.out.println("Time Selected : " + time);
		dialogueReservation.handleTimeSelectedEvent(time);
	}
	
	protected void do_tableNumPers_numpersChanged(String numPersons) {
		System.out.println("Number of persons Selected : " + numPersons);
		dialogueReservation.handleNumofPersonsSelectedEvent(numPersons);
	}
	
	protected void do_ListeNumTable_listvalueChanged(String numTable) {
		System.out.println("Table Selected : " + numTable);
		dialogueReservation.handleTableSelectedEvent(numTable);
	}
	
	protected void do_btnAnnuler_actionPerformed() {
		System.out.println("Annuler Pressed !");
		dialogueReservation.handleCancelEvent();
	}
	
	protected void do_btnValidate_actionPerformed() {
		System.out.println("Valider Pressed !");
		dialogueReservation.handleValidateEvent();
	}

	public void initTableMap(int[] propositions) {
		int nbProposition = 0;
		int[] propositionRetenue = new int[propositions.length-1];
		for(int i = 1 ; i<propositions.length -1; i++) {
			if(propositions[i] != 0) {
				propositionRetenue[nbProposition] = propositions[i];
				nbProposition++;
			}
		}
		
		propString = new String[nbProposition];
		for (int i = 0; i < nbProposition; i++) {
			propString[i] = "" + propositionRetenue[i];
		}
		
		listTableMap.setModel(new AbstractListModel() {
			String[] values = propString;
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
	}

}
