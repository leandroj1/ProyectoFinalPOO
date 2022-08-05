package ficheros;


import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import logico.BolsaTrabajo;

public class UtilsFicheros {
	public static String backupFileName = "bolsaTrabajo_data.dat";
	
	public static WindowAdapter getWindowAdapterToSave() {
		return new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				FileOutputStream fabricaOutputStream;
				ObjectOutputStream empresaWrite;
				try {
					fabricaOutputStream = new FileOutputStream(backupFileName);
					empresaWrite = new ObjectOutputStream(fabricaOutputStream);
					empresaWrite.writeObject(BolsaTrabajo.getInstance());
				} 
				catch (FileNotFoundException e1) {} 
				catch (IOException e1) {}
			}
		};
	}

	public static void loadBolsaTrabajoSaved() {
		FileInputStream bolsaTrabajoInputStream;
		FileOutputStream bolsaTrabajoOutputStream;
		ObjectInputStream bolsaTrabajoToRead;
		ObjectOutputStream bolsaTrabajoToWrite;
		try {
			bolsaTrabajoInputStream = new FileInputStream(backupFileName);
			bolsaTrabajoToRead = new ObjectInputStream(bolsaTrabajoInputStream);
			BolsaTrabajo temp = (BolsaTrabajo)bolsaTrabajoToRead.readObject();
			BolsaTrabajo.setBolsaTrabajo(temp);
			bolsaTrabajoInputStream.close();
			bolsaTrabajoToRead.close();
		} 
		catch (FileNotFoundException e) {
			try {
				bolsaTrabajoOutputStream = new FileOutputStream(backupFileName);
				bolsaTrabajoToWrite = new ObjectOutputStream(bolsaTrabajoOutputStream);
				bolsaTrabajoToWrite.writeObject(BolsaTrabajo.getInstance());
				bolsaTrabajoOutputStream.close();
				bolsaTrabajoToWrite.close();
			} 
			catch (FileNotFoundException e1) {} 
			catch (IOException e1) {}
		} 
		catch (IOException e) {} 
		catch (ClassNotFoundException e){}
	}
}