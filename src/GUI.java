/**************************************************************
* Name        : D&D dice and character helper
* Author      : Kelly Klein
* Created     : 11/2020
* Course      : CIS 152 Data Structures
* Version     : 1.0
* OS          : Windows 10
* Copyright   : This is my own original work based on
*               specifications issued by our instructor
* Description : This program overall description here
*               Input:  list and describe
*               Output: list and describe
* Academic Honesty: I attest that this is my original work.
* I have not used unauthorized source code, either modified or 
* unmodified. I have not given other fellow student(s) access to
* my program.         
***************************************************************/

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.PriorityQueue;
import java.util.Queue;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUI implements ActionListener {

	Queue<Integer> pq = new PriorityQueue<Integer>();

	private JLabel nameLabel;
	private JLabel strLabel;
	private JLabel intLabel;
	private JLabel dexLabel;
	private JLabel wisLabel;
	private JLabel charLabel;
	private JLabel conLabel;
	private JLabel hpLabel;
	private JLabel diceRollLabel;
	private JLabel totalRollLabel;
	private JLabel fillerLabel;
	private JLabel warningLabel;
	private JFrame frame;
	private JPanel panel;

	private JTextField nameText;
	private JTextField strText;
	private JTextField intText;
	private JTextField dexText;
	private JTextField wisText;
	private JTextField charText;
	private JTextField conText;
	private JTextField hpText;
	private JTextField numDiceText;
	private JTextField numSidesText;

	private JButton nameSaveButton;
	private JButton strButton;
	private JButton intButton;
	private JButton dexButton;
	private JButton wisButton;
	private JButton charButton;
	private JButton conButton;
	private JButton hpButton;
	private JButton rollDiceButton;
	private JButton undoButton;

	public GUI() {
		frame = new JFrame();

		nameLabel = new JLabel("Name: ");
		strLabel = new JLabel("STR: ");
		intLabel = new JLabel("INT: ");
		dexLabel = new JLabel("DEX: ");
		wisLabel = new JLabel("WIS: ");
		charLabel = new JLabel("CHAR: ");
		conLabel = new JLabel("CON: ");
		hpLabel = new JLabel("HP: ");
		diceRollLabel = new JLabel("Please select number and type of dice: ");
		totalRollLabel = new JLabel();
		fillerLabel = new JLabel();
		warningLabel = new JLabel();

		nameText = new JTextField(5);
		strText = new JTextField(3);
		intText = new JTextField(3);
		dexText = new JTextField(3);
		wisText = new JTextField(3);
		charText = new JTextField(3);
		conText = new JTextField(3);
		hpText = new JTextField(3);
		numDiceText = new JTextField(3);
		numDiceText.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent ke) {
				String value = numDiceText.getText();
				int l = value.length();
				if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') {
					numDiceText.setEditable(true);
					warningLabel.setText("");
				} else {
					numDiceText.setEditable(false);
					warningLabel.setText("* Enter only numeric digits(0-9)");
				}
			}
		});
		numSidesText = new JTextField(3);
		numSidesText.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent ke) {
				String value = numSidesText.getText();
				int l = value.length();
				if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') {
					numSidesText.setEditable(true);
					warningLabel.setText("");
				} else {
					numSidesText.setEditable(false);
					warningLabel.setText("* Enter only numeric digits(0-9)");
				}
			}
		});

		nameSaveButton = new JButton("Save Name");
		strButton = new JButton("Roll Str");
		strButton.addActionListener(this);
		intButton = new JButton("Roll Int");
		intButton.addActionListener(this);
		dexButton = new JButton("Roll Dex");
		dexButton.addActionListener(this);
		wisButton = new JButton("Roll Wis");
		wisButton.addActionListener(this);
		charButton = new JButton("Roll Char");
		charButton.addActionListener(this);
		conButton = new JButton("Roll Con");
		conButton.addActionListener(this);
		hpButton = new JButton("Roll HP");
		hpButton.addActionListener(this);
		rollDiceButton = new JButton("Roll Dice");
		rollDiceButton.addActionListener(this);
		undoButton = new JButton("Undo Roll");
		undoButton.addActionListener(this);

		JPanel fillerPanel = new JPanel();
		fillerPanel.setBackground(Color.gray);
		fillerPanel.setBorder(BorderFactory.createEmptyBorder(300, 300, 100, 300));
		fillerPanel.add(fillerLabel);

		panel = new JPanel();
		panel.setBackground(Color.gray);
		panel.setBorder(BorderFactory.createEmptyBorder(300, 300, 100, 300));
		GridLayout layout = new GridLayout(0, 3);
		layout.setHgap(10);
		panel.setLayout(layout);
		panel.add(nameLabel);
		panel.add(nameText);
		panel.add(nameSaveButton);
		panel.add(strLabel);
		panel.add(strText);
		panel.add(strButton);
		panel.add(intLabel);
		panel.add(intText);
		panel.add(intButton);
		panel.add(dexLabel);
		panel.add(dexText);
		panel.add(dexButton);
		panel.add(wisLabel);
		panel.add(wisText);
		panel.add(wisButton);
		panel.add(charLabel);
		panel.add(charText);
		panel.add(charButton);
		panel.add(conLabel);
		panel.add(conText);
		panel.add(conButton);
		panel.add(hpLabel);
		panel.add(hpText);
		panel.add(hpButton);
		panel.add(diceRollLabel);
		panel.add(numDiceText);
		panel.add(numSidesText);
		panel.add(rollDiceButton);
		panel.add(totalRollLabel);
		panel.add(undoButton);
		panel.add(warningLabel);

		frame.add(panel, BorderLayout.WEST);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("D&D Character sheet assistant");
		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) {

		new GUI();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Dice dice = new Dice(3, 6);
		Queue<Integer> pq = new PriorityQueue<Integer>();

		if (e.getSource() == nameSaveButton) {
			String nameSave = nameText.getText();
			nameLabel.setText("Name: " + nameSave);
		}
		if (e.getSource() == strButton) {
			int strRoll = dice.rollStats();
			strText.setText(Integer.toString(strRoll));
		}
		if (e.getSource() == intButton) {
			int intRoll = dice.rollStats();
			intText.setText(Integer.toString(intRoll));
		}
		if (e.getSource() == dexButton) {
			int dexRoll = dice.rollStats();
			dexText.setText(Integer.toString(dexRoll));
		}
		if (e.getSource() == wisButton) {
			int wisRoll = dice.rollStats();
			wisText.setText(Integer.toString(wisRoll));
		}
		if (e.getSource() == charButton) {
			int charRoll = dice.rollStats();
			charText.setText(Integer.toString(charRoll));
		}
		if (e.getSource() == conButton) {
			int conRoll = dice.rollStats();
			conText.setText(Integer.toString(conRoll));
		}
		if (e.getSource() == hpButton) {
			int hpRoll = dice.rollStats();
			hpText.setText(Integer.toString(hpRoll));
		}
		if (e.getSource() == rollDiceButton) {

			int diceNum = Integer.parseInt(numDiceText.getText());
			int sideNum = Integer.parseInt(numSidesText.getText());
			Dice newDice = new Dice(diceNum, sideNum);
			int diceRolled = newDice.rollDice();
			pq.add(diceRolled);
			totalRollLabel.setText(diceNum + " d" + sideNum + "'s roll a " + diceRolled);
			numDiceText.setText("");
			numSidesText.setText("");

			for (int i = 0; i < pq.size(); i++) {
				System.out.println(i + " : " + pq);
			}

		}
		if (e.getSource() == undoButton) {

			totalRollLabel.setText("Previous Roll total was: " + pq.poll());
		}

	}

}
