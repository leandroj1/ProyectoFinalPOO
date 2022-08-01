package testData;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import logico.BolsaTrabajo;
import logico.Obrero;
import logico.Tecnico;
import logico.Ubicacion;
import logico.Universitario;
import logico.Utils;

public class DataGenerator {
	
	private static ArrayList<String> genIdiomas () {
		ArrayList<String> arrayIdiomas = new ArrayList<String>();
		arrayIdiomas.add("Espa\u00F1ol");

		if ((Math.random() * 10) < 6)
			arrayIdiomas.add("Ingl\u00E9s");
		if ((Math.random() * 10) < 6)
			arrayIdiomas.add("Hindi");
		if ((Math.random() * 10) < 6)
			arrayIdiomas.add("Ruso");
		if ((Math.random() * 10) < 6)
			arrayIdiomas.add("Franc\u00E9s");
		if ((Math.random() * 10) < 6)
			arrayIdiomas.add("Mandar\u00EDn");
		if ((Math.random() * 10) < 6)
			arrayIdiomas.add("Portugu\u00E9s");
		if ((Math.random() * 10) < 6)
			arrayIdiomas.add("Alem\u00E1n");
		
		return arrayIdiomas;
	}
	
	public static void personal() {
		JSONArray jsonArray = Utils.getJSONContent("./dummyData/personal.json");
		for (int index = 0; index < jsonArray.size(); index++) {
//			System.out.println(index);
			JSONObject jsonObject = (JSONObject) jsonArray.get(index);
			Date fechaNacimiento = null;
			try {
				fechaNacimiento = new SimpleDateFormat("MM/dd/yyyy").parse((String) jsonObject.get("fechaNacimiento"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			ArrayList<String> arrayIdiomas = genIdiomas();

			if ((boolean) jsonObject.get("oficios"))
				BolsaTrabajo.getInstance().agregarPersonal(new Obrero((String) jsonObject.get("cedula"),
						(String) jsonObject.get("nombre"), fechaNacimiento, (boolean) jsonObject.get("casado"),
						(String) jsonObject.get("telefonoPrincipal"), (String) jsonObject.get("telefonoSecundario"),
						(String) jsonObject.get("nacionalidad"), arrayIdiomas,
						new Ubicacion((String) jsonObject.get("pais"), (String) jsonObject.get("provincia"),
								(String) jsonObject.get("ciudad"), (String) jsonObject.get("direccion"))));
			else if (jsonObject.get("areaTecnica") != null && jsonObject.get("areaTecnica") != "")
				BolsaTrabajo.getInstance().agregarPersonal(new Tecnico((String) jsonObject.get("cedula"),
						(String) jsonObject.get("nombre"), fechaNacimiento, (boolean) jsonObject.get("casado"),
						(String) jsonObject.get("telefonoPrincipal"), (String) jsonObject.get("telefonoSecundario"),
						(String) jsonObject.get("nacionalidad"), arrayIdiomas,
						(String) jsonObject.get("areaTecnica"), new Ubicacion((String) jsonObject.get("pais"), (String) jsonObject.get("provincia"),
								(String) jsonObject.get("ciudad"), (String) jsonObject.get("direccion"))));
			else
				BolsaTrabajo.getInstance().agregarPersonal(new Universitario((String) jsonObject.get("cedula"),
						(String) jsonObject.get("nombre"), fechaNacimiento, (boolean) jsonObject.get("casado"),
						(String) jsonObject.get("telefonoPrincipal"), (String) jsonObject.get("telefonoSecundario"),
						(String) jsonObject.get("nacionalidad"), arrayIdiomas,
						(String) jsonObject.get("carrera"), (String) jsonObject.get("universidad"),
						new Ubicacion((String) jsonObject.get("pais"), (String) jsonObject.get("provincia"),
								(String) jsonObject.get("ciudad"), (String) jsonObject.get("direccion"))));
		}

		System.out.println(BolsaTrabajo.getInstance().getPersonalByID("").size());
		System.out.println(jsonArray.size());
	}
}
