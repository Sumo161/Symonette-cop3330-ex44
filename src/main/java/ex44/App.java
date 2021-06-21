package ex44;

/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 first_name last_name
 */


import java.io.*;
import java.util.*;
import org.json.simple.*;
import org.json.simple.parser.*;

public class App {
    public static void main(String[] args){
        // read the json file
        // create one json parser object

        JSONParser parser = new JSONParser();
        try {
            // read json object using parser and store it
            Object obj = parser.parse(new FileReader("D:/products.json"));

            //create json object to read internal values
            JSONObject jsonObject = (JSONObject) obj;

            JSONArray subjects = (JSONArray)jsonObject.get("Products");

            //create buffered reader object to take user input
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            //create sting variable
            String input;

            //Flag is used whether given string is present/not
            int flag = 0;

            System.out.print("What is the product name? ");
            input = bufferedReader.readLine();

            //create iterator for products array
            Iterator iterator = subjects.iterator();

            //loop though the iterator
            while (iterator.hasNext()) {
                //create another json
                JSONObject json = (JSONObject) iterator.next();
                String name = (String) json.get("name");

                //compare it with given input
                if (input.toLowerCase().equals(name.toLowerCase())) {
                    System.out.print("Name: " + name);
                    System.out.print("Price: " + json.get("price"));
                    System.out.print("Quantity: " + json.get("quantity"));
                    flag = 1;
                }
            }
            // if flag value is zero, then value isnt found
            if (flag == 0) {
                System.out.print("Sorry, that product was not found in our inventory ");
            }
        }
            catch(Exception e){
                e.printStackTrace();
            }
        }

    }

