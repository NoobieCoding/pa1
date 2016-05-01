import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

/**
 * Graphic user interface used for converting units. Can convert the
 * unit from left to right or right to left. The output is in scientific notation number. The
 * initial direction is left to right.
 * 
 * @author Nuttapong Rojanavanich
 */
public class ConverterUI extends JFrame {

	private JMenu menu;
	private JMenuBar menuBar;

	private JPanel upperPart, lowerPart;
	private JButton convertButton, clearButton;
	private UnitConverter unitconverter;
	private JTextField inputField1, inputField2;
	private JLabel equalSymbol;
	private JComboBox<Unit> unit1ComboBox, unit2ComboBox;
	private ButtonGroup directionGroup;
	private JRadioButton direction1, direction2;

	/**
	 * Constructor with UnitConverter object as argument
	 * 
	 * @param uc is the UnitConverter object
	 */
	public ConverterUI(UnitConverter uc) {
		unitconverter = uc;

		this.setTitle("Unit Converter");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		initComponents();
	}

	/**
	 * Manage the layout of GUI. Create and add components of the GUI.
	 */
	private void initComponents() {

		UnitType[] unitTypes = unitconverter.getUnitTypes();
		menu = new JMenu("Unit type");
		for (int i = 0; i < unitTypes.length; i++) {
			menu.add(new SwitchUnitTypeAction(unitTypes[i]));
		}
		menu.add(new ExitAction());

		menuBar = new JMenuBar();
		menuBar.add(menu);

		upperPart = new JPanel();
		lowerPart = new JPanel();

		convertButton = new JButton("Convert!");
		ActionListener listener = new ConvertButtonListener();
		convertButton.addActionListener(listener);

		clearButton = new JButton("Clear");
		clearButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				clearField();
			}
		});

		inputField1 = new JTextField(10);
		inputField1.addActionListener(new ConvertButtonListener());
		inputField1.addFocusListener(new InputFocusListener());

		inputField2 = new JTextField(10);
		inputField2.addActionListener(new ConvertButtonListener());
		inputField2.addFocusListener(new InputFocusListener());
		inputField2.setEditable(false);

		equalSymbol = new JLabel("=");

		Unit[] defaultUnits = unitconverter.getUnits(unitTypes[0]);
		unit1ComboBox = new JComboBox<Unit>(defaultUnits);
		unit2ComboBox = new JComboBox<Unit>(defaultUnits);

		direction1 = new JRadioButton("Left->Right");
		direction1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				changeDirectionLeftToRight();
			}
		});

		direction2 = new JRadioButton("Right->Left");
		direction2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				changeDirectionRightToLeft();
			}
		});

		directionGroup = new ButtonGroup();
		directionGroup.add(direction1);
		directionGroup.add(direction2);

		setJMenuBar(menuBar);
		this.setLayout(new BorderLayout());
		this.add(upperPart, BorderLayout.NORTH);
		this.add(lowerPart, BorderLayout.SOUTH);
		upperPart.add(inputField1);
		upperPart.add(unit1ComboBox);
		upperPart.add(equalSymbol);
		upperPart.add(inputField2);
		upperPart.add(unit2ComboBox);
		upperPart.add(convertButton);
		upperPart.add(clearButton);
		lowerPart.add(direction1);
		lowerPart.add(direction2);

	}

	/**
	 * Change the editable of left text field to be true and right text field to be false.
	 */
	private void changeDirectionLeftToRight() {
		inputField2.setEditable(false);
		inputField1.setEditable(true);
	}

	/**
	 * Change the editable of right text field to be true and left text field to be false.
	 */
	private void changeDirectionRightToLeft() {
		inputField2.setEditable(true);
		inputField1.setEditable(false);
	}

	/**
	 * Clear the number in both left and right text field.
	 */
	private void clearField() {
		inputField2.setText("");
		inputField1.setText("");
	}

	/**
	 * Make this frame visible. Make the size of the frame automatically fit the components.
	 */
	public void run() {
		setVisible(true);
		pack();
	}

	/**
	 * ActionListener when pressing enter or convert button. Convert the unit.
	 * 
	 * @author Nuttapong Rojanavanich
	 */
	class ConvertButtonListener implements ActionListener {

		/**
		 * Convert the unit(can do for both left to right or right to left).
		 * Change the number in text box to red when the input is not valid.
		 */
		public void actionPerformed(ActionEvent evt) {
			String s;
			if (direction2.isSelected() || evt.getSource() == inputField2)
				s = inputField2.getText().trim();
			else
				s = inputField1.getText().trim();

			if (s.length() > 0) {
				try {
					double resultValue;
					double value = Double.valueOf(s);
					Unit unit1 = (Unit) unit1ComboBox.getSelectedItem();
					Unit unit2 = (Unit) unit2ComboBox.getSelectedItem();
					if (direction2.isSelected() || evt.getSource() == inputField2) {
						resultValue = unitconverter.convert(value, unit2, unit1);
						inputField1.setText(String.format("%g", resultValue));
						inputField1.setEditable(false);
					} else {
						resultValue = unitconverter.convert(value, unit1, unit2);
						inputField2.setText(String.format("%g", resultValue));
						inputField2.setEditable(false);
					}
				} catch (Exception e) {
					if (evt.getSource() == inputField2)
						inputField2.setForeground(Color.red);
					else
						inputField1.setForeground(Color.red);
				}
			}
		}
	}
	
	/**
	 * ActionListener when pressing Exit in the menu.
	 * Exit the program.
	 * 
	 * @author Nuttapong Rojanavanich
	 */
	class ExitAction extends AbstractAction {
		
		/**
		 * Initialize name for menu item.
		 */
		public ExitAction() {
			super("Exit");
		}
		
		/**
		 * Exit the program.
		 */
		public void actionPerformed(ActionEvent evt) {
			System.exit(0);
		}
	}

	/**
	 * Switch the type of unit that is going to be converted.
	 * 
	 * @author Nuttapong Rojanavanich
	 */
	class SwitchUnitTypeAction extends AbstractAction {
		private UnitType unitType;

		/**
		 * Initialize name for menu item.
		 * @param unitType is the unit type chosen by user .
		 */
		public SwitchUnitTypeAction(UnitType unitType) {
			super(unitType.toString());
			this.unitType = unitType;
		}
		
		/**
		 * Switch the units in the JComboBoxs.
		 */
		public void actionPerformed(ActionEvent evt) {
			unit1ComboBox.removeAllItems();
			unit2ComboBox.removeAllItems();
			Unit[] units = unitconverter.getUnits(unitType);
			for (Unit u : units) {
				unit1ComboBox.addItem(u);
				unit2ComboBox.addItem(u);
			}
		}
	}
	
	/**
	 * When a text field is being focused, change the text in text fields to be black.
	 * 
	 * @author Nuttapong Rojanavanich
	 */
	class InputFocusListener implements FocusListener {
		
		/**
		 * Change the color of texts to be black.  
		 */
		public void focusGained(FocusEvent e) {
			inputField1.setForeground(Color.BLACK);
			inputField2.setForeground(Color.BLACK);
		}
		
		/**
		 * Not used.
		 */
		public void focusLost(FocusEvent e) {}
	}
}