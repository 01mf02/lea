package lea.generator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

import lea.TypeTable;
import lea.types.Type;

public class TypeGenerator {
	/*En java, une structure équivaut à une nouvelle classe... Donc pour chaque structure, nous allons devoir créer une nouvelle classe.*/

	FileWriter newClass;
	String contenu, str;

	public TypeGenerator(File nameDir, TypeTable typeTable) throws IOException {
		
		for (Map.Entry<String, Type> entry : typeTable.entrySet())
		{
			str = "";
			/*Création de la classe associé au struct*/
			this.newClass = new FileWriter(nameDir + File.separator + entry.getKey() + ".java");
			
			/*Création du contenu du fichier*/
			str += "public class " + entry.getKey() + " { \n";
			str += "\tpublic " + entry.getKey() + "() \n\t{\n";
			
			
			/*Création des variables de la classe*/
			
			
			
			str += "\t}\n}"; //Fermeture de la classe
			
			
			this.newClass.write(str);
			
			this.newClass.close();	
					
				
		}
	}

	public String generate()
	{
		
		return str;
	}
}
