package logico;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.text.MaskFormatter;

public class Utils {
	// Obtener string de fecha ya formateado
	public static String getDateFormatted(Date date) {
		Locale locale = new Locale("es", "DO");
		DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.DEFAULT, locale);
		String resultString = dateFormat.format(date);

		return resultString;
	}

	// Mask de cedula
	public static MaskFormatter getMaskCedula() {
		MaskFormatter mask = null;
		try {
			mask = new MaskFormatter("###-#######-#");
			mask.setPlaceholderCharacter('_');
		} catch (Exception e) {
			e.printStackTrace();
		}

		return mask;
	}

	// Mask de telefono
	public static MaskFormatter getMaskTelefono() {
		MaskFormatter mask = null;
		try {
			mask = new MaskFormatter("(###)-###-####");
			mask.setPlaceholderCharacter('_');
		} catch (Exception e) {
			e.printStackTrace();
		}

		return mask;
	}

	// Redondear a dos cifras decimales
	public static float roundTo2(float num) {
		return (float) (Math.round(num * 100.0) / 100.0);
	}

	// Obtener valor flotante de un spinner
	public static float getSpinnerFloatValue(JSpinner spinner) {
		return ((Float)spinner.getValue()).floatValue();
	}

	// Obtener valor entero de un spinner
	public static int getSpinnerIntValue(JSpinner spinner) {
		return ((Integer)spinner.getValue()).intValue();
	}

	// Para hacer que un spinner deshabilitado se vea mejor
	public static void makeSpinnerMoreReadable(JSpinner spinner) {
		if (spinner.getEditor() instanceof JSpinner.DefaultEditor) {
			JSpinner.DefaultEditor editor = (JSpinner.DefaultEditor) spinner.getEditor();
			editor.getTextField().setEnabled(true);
			editor.getTextField().setEditable(false);
		}
	}

	// Para saber si un combobox está en el valor por defecto ("<Seleccione>")
	public static boolean isCbxDefaultValue(JComboBox comboBox) {
		return comboBox.getSelectedIndex() <= 0;
	}
}
