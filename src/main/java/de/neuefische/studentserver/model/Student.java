package de.neuefische.studentserver.model;

import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Objects;

@Data
@AllArgsConstructor
public class Student {

    private int id;
    private String name;


}
