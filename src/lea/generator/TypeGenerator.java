package lea.generator;

import java.util.Map;
import lea.TypeTable;
import lea.types.StructType;
import lea.types.Type;

public class TypeGenerator {

    TypeTable typeTable;

    public TypeGenerator(TypeTable typeTable) {
        this.typeTable = typeTable;
    }

    public void generate(CodeWriter cw) {
        for (Map.Entry<String, Type> entry : typeTable.entrySet()) {

            if (entry.getValue() instanceof StructType) {
                StructType st = (StructType) entry.getValue();
                ;
                cw.writeLine("");
                cw.writeLine("public static class " + Generator.generateName(entry.getKey()));
                cw.openBlock();
                st.getEnvironment().toJava(cw);
                cw.closeBlock();

            }
        }

    }
}