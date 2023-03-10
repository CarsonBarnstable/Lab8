package com.example.lab8;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


//import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {

    private CustomList list;
    /**
     * create a mock list for my citylist
     * @return custom list to be used
     */
    public CustomList MockCityList(){
        list = new CustomList(null,new ArrayList<>());
        return list;
    }

    /**
     * get the size of the list
     * increase the list by adding a new city
     * check if our current size matches the initial size plus
     one
     */
    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(),listSize + 1);
    }

    /**
     * add city, test if it it can observe
     * then test if correctly identifies missing city
     */
    @Test
    public void hasCityTest(){
        list = MockCityList();
        list.addCity(new City("Estevan", "SK"));
        assertTrue(list.hasCity(new City("Estevan", "SK")));

        assertFalse(list.hasCity(new City("Edmonton", "AB")));
        list.addCity(new City("Edmonton", "AB"));
        assertTrue(list.hasCity(new City("Edmonton", "AB")));

    }

    /**
     * add city, check that it exists
     * then delete and see if successfully deletes
     */
    @Test
    public void deleteCityTest(){
        list = MockCityList();
        City ev = new City("Estevan", "SK");
        list.addCity(ev);
        assertTrue(list.hasCity(ev));

        list.deleteCity(ev);
        assertFalse(list.hasCity(ev));
    }

    /**
     * add city, check that count is 1
     * then delete and see if count goes to 0
     * then add again and test if count is 1
     */
    @Test
    public void countCitiesTest(){
        list = MockCityList();
        City ev = new City("Estevan", "SK");

        list.addCity(ev);
        assertEquals(1, list.countCities());

        list.deleteCity(ev);
        assertEquals(0, list.countCities());

        list.addCity(ev);
        assertEquals(1, list.countCities());
    }

}
