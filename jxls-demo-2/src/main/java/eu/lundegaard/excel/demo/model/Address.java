package eu.lundegaard.excel.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by Jan Jaros on 3/27/2019
 **/

@Getter
@Setter
@AllArgsConstructor
public class Address {
    private String street;
    private String city;
    private int houseNumber;
    private int zipCode;
}