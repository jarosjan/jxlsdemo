package eu.lundegaard.excel.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Created by Jan Jaros on 3/27/2019
 **/

@Getter
@Setter
@AllArgsConstructor
public class Person {
    private String name;
    private String surname;
    private int age;
    private int salary;
}