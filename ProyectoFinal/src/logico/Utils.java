package logico;

import java.awt.Checkbox;
import java.awt.Component;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.Locale;
import java.util.regex.Pattern;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.text.MaskFormatter;

import com.toedter.calendar.JDateChooser;

public class Utils {
	private static char defaultPlaceholder = '_';

	// Obtener string de fecha ya formateado
	public static String getDateFormatted(Date date) {
		Locale locale = new Locale("es", "DO");
		DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.DEFAULT, locale);
		String resultString = dateFormat.format(date);

		return resultString;
	}

	// Obtener cantidad de agnos entre una fecha y fecha actual
	public static int yearsBetween(Date date) {
		LocalDate dt = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

		return Period.between(dt, LocalDate.now()).getYears();
	}

	// Mask de cedula
	public static MaskFormatter getMaskCedula() {
		MaskFormatter mask = null;
		try {
			mask = new MaskFormatter("###-#######-#");
			mask.setPlaceholderCharacter(defaultPlaceholder);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return mask;
	}

	// Evaluar si la entrada es el valor por defecto de la mask de cedula
	public static boolean isMaskCedulaDefaultValue(String entry) {
		boolean isDefault = false;
		try {
			isDefault = getMaskCedula().getMask().replace('#', defaultPlaceholder).equalsIgnoreCase(entry);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isDefault;
	}

	// Mask de telefono
	public static MaskFormatter getMaskTelefono() {
		MaskFormatter mask = null;
		try {
			mask = new MaskFormatter("(###)-###-####");
			mask.setPlaceholderCharacter(defaultPlaceholder);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return mask;
	}

	// Evaluar si la entrada es el valor por defecto de la mask de telefono
	public static boolean isMaskTelefonoDefaultValue(String entry) {
		boolean isDefault = false;
		try {
			isDefault = getMaskTelefono().getMask().replace('#', defaultPlaceholder).equalsIgnoreCase(entry);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isDefault;
	}

	// Redondear a dos cifras decimales
	public static float roundTo2(float num) {
		return (float) (Math.round(num * 100.0) / 100.0);
	}

	// Obtener valor flotante de un spinner
	public static float getSpinnerFloatValue(JSpinner spinner) {
		return ((Float) spinner.getValue()).floatValue();
	}

	// Obtener valor entero de un spinner
	public static int getSpinnerIntValue(JSpinner spinner) {
		return ((Integer) spinner.getValue()).intValue();
	}

	// Para hacer que un spinner deshabilitado se vea mejor
	public static void makeSpinnerMoreReadable(JSpinner spinner) {
		if (spinner.getEditor() instanceof JSpinner.DefaultEditor) {
			JSpinner.DefaultEditor editor = (JSpinner.DefaultEditor) spinner.getEditor();
			editor.getTextField().setEnabled(true);
			editor.getTextField().setEditable(false);
		}
	}

	// Para saber si un combobox est� en el valor por defecto ("<Seleccione>")
	public static boolean isCbxDefaultValue(JComboBox comboBox) {
		return comboBox.getSelectedIndex() <= 0;
	}

	// Obtener el texto del radio button seleccionado
	public static String getSelectedRadioButtonText(ButtonGroup group) {
		for (Enumeration<AbstractButton> buttons = group.getElements(); buttons.hasMoreElements();) {
			AbstractButton button = buttons.nextElement();
			if (button.isSelected()) {
				return button.getText();
			}
		}
		return null;
	}

	// Regex para evalaur si un email es valido
	public static boolean isAValidEmail(String email) {
		final String regex = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
				+ "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
		final Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);

		return pattern.matcher(email).find();
	}

	// Deshabilitar cada radio button
	public static void setEachAbstractButtonState(ButtonGroup group, boolean state) {
		Enumeration<AbstractButton> enumeration = group.getElements();
		while (enumeration.hasMoreElements()) {
			enumeration.nextElement().setEnabled(state);
		}
	}

	public static void desactivarPanel(JPanel panel) {
		for (Component component : panel.getComponents()) {
			if (component instanceof JTextField) {
				((JTextField) component).setEditable(false);
			} else if (component instanceof JDateChooser) {
				((JDateChooser) component).setEnabled(false);
			} else if (component instanceof JSpinner) {
				((JSpinner) component).setEnabled(false);
				makeSpinnerMoreReadable((JSpinner) component);
			} else if (component instanceof JTextPane) {
				((JTextPane) component).setEditable(false);
			} else if (component instanceof Checkbox) {
				((Checkbox) component).setEnabled(false);
			} else if (component instanceof JCheckBox) {
				((JCheckBox) component).setEnabled(false);
			} else if (component instanceof JRadioButton) {
				((JRadioButton) component).setEnabled(false);
			} else if (component instanceof JComboBox) {
				((JComboBox) component).setEnabled(false);
			}
		}
	}

	public static int getCbxSelectedIndex(JComboBox combobox, String selection) {
		int indexFound = 0;
		for (int index = 0; index < combobox.getItemCount() && indexFound == 0; index++)
			if (combobox.getItemAt(index).equals(selection))
				indexFound = index;

		return indexFound;
	}

	public static void activarCheckboxEnPanel(JPanel panel, ArrayList<String> itemsList) {
		for (Component component : panel.getComponents()) {
			if (component instanceof Checkbox && itemsList.contains((((Checkbox) component).getLabel()))) {
				((Checkbox) component).setState(true);
				;
			}
		}
	}
}
