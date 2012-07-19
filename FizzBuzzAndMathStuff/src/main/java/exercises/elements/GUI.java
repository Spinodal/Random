/**
 * 
 */
package exercises.elements;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * @author michael.wambeek
 *
 */
public class GUI {
	private final JLabel info;
	public GUI(Element[][] table){
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		info = new JLabel("Select an Element...");
		JLabel title = new JLabel("Mike's Periodic Table", SwingConstants.CENTER);
		JPanel key = new JPanel();
		JPanel southPanel = new JPanel();
		
		info.setFont(new Font("Sans Serif", Font.ITALIC, 15));
		title.setFont(new Font("Sans Serif", Font.BOLD, 28));
		title.setBorder(BorderFactory.createEmptyBorder(2, 2, 5, 2));
		
		JLabel alkKey = new JLabel("");
		alkKey.setOpaque(true);
		//alkKey.setSize(5, 5);
		alkKey.setBackground(Color.ORANGE);
		alkKey.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		JLabel alkLab = new JLabel(" - Alkaline");
		
		JLabel tranKey = new JLabel("");
		tranKey.setOpaque(true);
		//tranKey.setSize(5, 5);
		tranKey.setBackground(Color.PINK);
		tranKey.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		JLabel tranLab = new JLabel(" - Transition Metal");
		
		JLabel metKey = new JLabel("");
		metKey.setOpaque(true);
		//metKey.setSize(5, 5);
		metKey.setBackground(Color.LIGHT_GRAY);
		metKey.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		JLabel metLab = new JLabel(" - Metal");
		
		JLabel othKey = new JLabel("");
		othKey.setOpaque(true);
		//othKey.setSize(5, 5);
		othKey.setBackground(Color.WHITE);
		othKey.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		JLabel othLab = new JLabel(" - Other");
		
		key.setLayout(new GridLayout(1, 8));
		key.add(alkKey);
		key.add(alkLab);
		key.add(tranKey);
		key.add(tranLab);
		key.add(metKey);
		key.add(metLab);
		key.add(othKey);
		key.add(othLab);
		
		southPanel.setLayout(new GridLayout(1, 2));
		southPanel.setBorder(BorderFactory.createEmptyBorder(15, 5, 5, 5));
		southPanel.add(info);
		southPanel.add(key);
		
		panel.setLayout(new GridLayout(7, 18));
		panel.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));
		for(Element[] row : table){
			for(Element el : row){
				if(el == null){
					panel.add(new JLabel());
				}
				else{
					panel.add(createElement(el));
				}
			}
		}
		
		frame.setLayout(new BorderLayout());
		frame.add(panel, BorderLayout.CENTER);
		frame.add(title, BorderLayout.NORTH);
		frame.add(southPanel, BorderLayout.SOUTH);
		
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private JButton createElement(final Element el) {
		MyJButton button = new MyJButton();
		button.setLayout(new BorderLayout());
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				info.setText(el.toString());
			}
		});
		
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		
		JLabel symbol = new JLabel(el.getSymbolicName(), SwingConstants.CENTER);
		JLabel name = new JLabel(el.getName());
		JLabel atomic = new JLabel(""+el.getAtomicNumber(), SwingConstants.RIGHT);
		
		symbol.setFont(new Font("Sans Serif", Font.BOLD, 18));
		name.setFont(new Font("Sans Serif", Font.ITALIC, 12));
		atomic.setFont(new Font("Sans Serif", Font.PLAIN, 12));
		
		panel.add(symbol, BorderLayout.CENTER);
		panel.add(name, BorderLayout.SOUTH);
		panel.add(atomic, BorderLayout.NORTH);

		button.add(symbol, BorderLayout.CENTER);
		button.add(name, BorderLayout.SOUTH);
		button.add(atomic, BorderLayout.NORTH);
		
		if(el.isAlkali()){
			button.setGradientColour(Color.ORANGE);
		}
		else if(el.isTransitionMetal()){
			button.setGradientColour(Color.PINK);
		}
		else if(el.isMetal()){
			button.setGradientColour(Color.LIGHT_GRAY);
		}
		else{
			button.setBackground(null);
		}
		
		button.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		return button;
	}
}

class MyJButton extends JButton{
	private static final long serialVersionUID = -2263084967014139652L;
	private Color c = Color.WHITE;
	public MyJButton(){
        super();
        setContentAreaFilled(false);
        //setFocusPainted(false); // used for demonstration
    }
	
	public void setGradientColour(Color c){
		this.c = c;
	}

    @Override
    protected void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D)g.create();
        g2.setPaint(new GradientPaint(
                new Point(0, 0), 
                Color.WHITE, 
                new Point(0, getHeight()), 
                c));
        g2.fillRect(0, 0, getWidth(), getHeight());
        g2.dispose();

        super.paintComponent(g);
    }

}
