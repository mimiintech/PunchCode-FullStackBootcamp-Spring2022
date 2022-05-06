package com.techelevator;

import com.techelevator.model.City;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JDBCDemo {
    public static void main(String[] args) {
        BasicDataSource dataSource = new BasicDataSource();  // where we are getting the data from
        dataSource.setUrl("jdbc:postgresql://localhost:5432/UnitedStates"); // set the url for the local db UnitedStates
        dataSource.setUsername("postgres");
        dataSource.setPassword("postgres1");

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);  // set the JdbcTemplate to the dataSource
        // connecting our app to the db UnitedStates\

        Scanner input = new Scanner(System.in);

        System.out.print("Enter state abbreviation: ");
        String state = input.nextLine();

        List<City> cityList = new ArrayList<>();  // programming to the interface

         String sqlStr = "SELECT * FROM city WHERE state_abbreviation = '" + state + "'"; // this is the sql select statement

        SqlRowSet results = jdbcTemplate.queryForRowSet(sqlStr); // queryforRowset method sends the sql statement to the db
        // and returns the records or rows and holds them in the var results

        while (results.next()){
            City city = new City();  //create an empty city object

            long id = results.getLong("city_id");  // returns from the db the city_id
            city.setCityId(id);

            String name = results.getString("city_name");  // city_name must match with the column in db
            city.setCityName(name);

            city.setArea(results.getDouble("area"));
            city.setStateAbbreviation(results.getString("state_abbreviation"));
            city.setPopulation(results.getLong("population"));

            cityList.add(city);  //load into the list of city objects
        }

        System.out.println("Cities in the state of Michigan:");
        for (City city: cityList){
            System.out.println(city.getCityName());
        }
    }
}
