package eu.lundegaard.excel.demo;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import eu.lundegaard.excel.demo.model.Person;
import org.jxls.common.Context;
import org.jxls.util.JxlsHelper;

/**
 * Created by Jan Jaros on 3/27/2019
 **/

public class ExcelGenerator {
    private final static String template = "firstTemplate.xlsx";

    public void generate() {
        final InputStream resourceStream = ClassLoader.getSystemClassLoader().getResourceAsStream(template);
//        final Context context = PoiTransformer.createInitialContext();
        final Context context = new Context();

        context.putVar("persons", createData(10));
        context.putVar("bonus", 1500);

        try {
            final FileOutputStream fileOutputStream = new FileOutputStream("C:\\Lundegaard\\JXLSdemo\\autput\\firstExcel.xlsx");
            JxlsHelper.getInstance().processTemplate(resourceStream, fileOutputStream, context);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<Person> createData(int numberOfRows) {
        final List<Person> personList = new ArrayList<>();
        for (int i = 1; i < numberOfRows + 1; i++) {
            final Person person = new Person("Karel" + i, "Novak" + i, 656565 + i, 29 + i, 25000 + new Random().nextInt(5000), new Random().nextBoolean());
            personList.add(person);
        }

        return personList;
    }
}