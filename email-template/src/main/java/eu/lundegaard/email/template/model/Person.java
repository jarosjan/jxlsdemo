package eu.lundegaard.email.template.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by Jan Jaros on 3/29/2019
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