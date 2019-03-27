package eu.lundegaard.excel.demo;


import eu.lundegaard.excel.demo.model.Address;
import eu.lundegaard.excel.demo.model.Person;
import org.jxls.common.Context;
import org.jxls.transform.poi.PoiTransformer;
import org.jxls.util.JxlsHelper;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jan Jaros on 3/27/2019
 **/

public class ExcelGenerator {
    private final static String template = "secondTemplate.xlsx";

    public void generate() {
        InputStream resourceStream = ClassLoader.getSystemClassLoader().getResourceAsStream(template);

        Context context = PoiTransformer.createInitialContext();
        context.putVar("rows", createData(15));
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("autput/secondExcel.xlsx");
            JxlsHelper.getInstance().processTemplate(resourceStream, fileOutputStream, context);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<Person> createData(int numberOfRows) {
        List<Person> persons = new ArrayList<>();
        for (int i = 1; i < numberOfRows + 1; i++) {
            List<Address> addresses = createAddress(i % 2);
            Person person = new Person("Karel" + i, "Novak" + i, addresses, 65478965 + i, 25 + i);
            persons.add(person);
        }

        return persons;
    }

    private List<Address> createAddress(int addressCount) {
        List<Address> addresses = new ArrayList<>();
        for (int i = 1; i < addressCount + 1; i++) {
            Address address = new Address("Street" + i, "Praha " + i, i, 29541 + i);
            addresses.add(address);
        }

        return addresses;
    }
}