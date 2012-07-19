/**
 * 
 */
package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.fdm.clifford.Engine;


/**
 * @author michael.wambeek
 *
 */
public class Gui {
	private final JFrame frame = new JFrame();
	private final JPanel inputPanel = new JPanel();
	private final JPanel northPanel = new JPanel();
	private final JPanel southPanel = new JPanel();
	private final JPanel centerPanel = new JPanel();
	private final JPanel infoPanel = new JPanel();
	private final JTextField input = new JTextField(40);
	private final JButton calc = new JButton("Calculate");
	private final JLabel output = new JLabel("0");
	private final JLabel infoLabel = new JLabel("Insert Calculation String", SwingConstants.CENTER);
	private JLabel inputLabel = new JLabel("Input:");
	private JLabel outputLabel = new JLabel("Result:");

	/**
	 * 
	 */
	public Gui(){
		calc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				action();
			}
		});
		
		input.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				action();
			}
		});
		
		input.setFont(new Font("Sans Serif", Font.BOLD, 28));
		output.setFont(new Font("Sans Serif", Font.BOLD, 28));
		infoLabel.setFont(new Font("Sans Serif", Font.BOLD, 20));
		inputLabel.setFont(new Font("Sans Serif", Font.BOLD, 28));
		outputLabel.setFont(new Font("Sans Serif", Font.BOLD, 28));
		output.setForeground(new Color(50,205,50));
		
		inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.PAGE_AXIS));
		
		northPanel.setLayout(new FlowLayout());
		northPanel.add(inputLabel);
		northPanel.add(input);
		
		centerPanel.setLayout(new FlowLayout());
		centerPanel.add(calc);
		
		southPanel.setLayout(new FlowLayout());
		southPanel.add(outputLabel);
		southPanel.add(output);
		
		inputPanel.add(northPanel);
		inputPanel.add(centerPanel);
		inputPanel.add(southPanel);
		
		infoPanel.add(infoLabel);
		
		
		
		frame.setLayout(new BorderLayout());
		frame.add(inputPanel, BorderLayout.CENTER);
		frame.add(infoLabel, BorderLayout.SOUTH);
		
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	/**
	 * 
	 */
	private void action(){
		infoLabel.setText("Insert Calculation String");
		infoLabel.setForeground(Color.BLACK);
		output.setText("");
		String args = input.getText();
		BigInteger result;
		try {
			result = Engine.run(args);
			output.setText(result.toString());
		} catch (Exception e1) {
			infoLabel.setText(e1.getMessage());
			infoLabel.setForeground(Color.RED);
		}
	}
}
