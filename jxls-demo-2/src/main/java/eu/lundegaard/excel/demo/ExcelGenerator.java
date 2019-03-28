package eu.lundegaard.excel.demo;


import eu.lundegaard.excel.demo.model.Person;
import org.jxls.common.Context;
import org.jxls.transform.poi.PoiTransformer;
import org.jxls.util.JxlsHelper;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by Jan Jaros on 3/27/2019
 **/

public class ExcelGenerator {
    private final static String template = "secondTemplate.xlsx";

    public void generate() {
        final InputStream resourceStream = ClassLoader.getSystemClassLoader().getResourceAsStream(template);
        final List<List<Object>> data = createGridData(createData(15));

        final Context context = PoiTransformer.createInitialContext();
        context.putVar("headers", Arrays.asList("Name", "Surname", "Age", "Salary"));
        context.putVar("data", data);
        try {
            final FileOutputStream fileOutputStream = new FileOutputStream("C:\\Lundegaard\\JXLSdemo\\autput\\secondExcel.xlsx");
            JxlsHelper.getInstance().processTemplate(resourceStream, fileOutputStream, context);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<Person> createData(int numberOfRows) {
        final List<Person> persons = new ArrayList<>();
        for (int i = 1; i < numberOfRows + 1; i++) {
            Person person = new Person("Karel" + i, "Novak" + i, 25 + i, new Random().nextInt(100000));
            persons.add(person);
        }

        return persons;
    }

    private static List<List<Object>> createGridData(List<Person> personList) {
        final List<List<Object>> data = new ArrayList<>();
        for(Person person : personList){
            data.add( convertPersonsToList(person));
        }

        return data;
    }

    private static List<Object> convertPersonsToList(Person person){
        final List<Object> list = new ArrayList<>();
        list.add(person.getName());
        list.add(person.getSurname());
        list.add(person.getAge());
        list.add(person.getSalary());

        return list;
    }

}