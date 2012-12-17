package lea.generator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

import lea.TypeTable;
import lea.types.*;
import lea.types.TupleType;
import lea.types.Type;

public class TypeGenerator {
	/*
	 * En java, une structure équivaut à une nouvelle classe... Donc pour chaque
	 * structure, nous allons devoir créer une nouvelle classe.
	 */

	FileWriter newClass;
	String contenu, str;
	int i;
	Type t;

	public TypeGenerator(File nameDir, TypeTable typeTable) throws IOException {

		for (Map.Entry<String, Type> entry : typeTable.entrySet()) {
			i = 0;
			str = "";
			/* Création de la classe associé au struct */
			this.newClass = new FileWriter(nameDir + File.separator
					+ entry.getKey() + ".java");

			/* Création du contenu du fichier */
			
			str += "public class " + entry.getKey() + " { " +
					"\n\tpublic " + entry.getKey() + "() \n\t{";

			t = entry.getValue();
			
			if (t instanceof TupleType) {
				str += "\n\t//TUPLE";
				
				str += typeAndName(t);

			}
			if (t instanceof StructType) {
				str += "\n\t//STRUCT \n";
				str += "\n\t " + ((StructType) t).toString();
				
			}

			str += "\n\t}\n}"; // Fermeture de la classe

			this.newClass.write(str);

			this.newClass.close();

		}
	}
	
	public String typeAndName(Type type) {
		String result = "";

		if (type.getLeft() != null) {
			if (type.getLeft() instanceof TupleType)
				result += typeAndName(type.getLeft());
			else {
				result += "\n\t\t" + type.getLeft() + " variable" + i + ";";
				i++;
			}

		}

		if (type.getRight() != null) {
			if (type.getRight() instanceof TupleType)
				result += typeAndName(type.getRight());
			else {
				result += "\n\t\t" + type.getRight() + " variable" + i + ";";
				i++;
			}
		}
		return result;
	}

	public String generate() {

		return str;
	}
}
