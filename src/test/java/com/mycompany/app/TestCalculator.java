package com.mycompany.app;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class TestCalculator {
    Calculator calc= new Calculator();

    @Test
    public void should_Return_Array_With_Operations(){
        //Act
       ArrayList<String> operations=new ArrayList<>(Arrays.asList(calc.getOperations()));
        //Assertion
       assertTrue("no + operation",operations.contains("+"));
       assertTrue("no - operation",operations.contains("-"));
    }
    @Test
    public void should_Perform_Addition_Two_Double(){
        //Arrange
        Double firstNumber = 1.2D;
        Double secondNumber = 4.1D;
        Double expected = firstNumber+secondNumber;
        String operation = "+";

        try{
        //Act
            Double actual= calc.perform(operation,firstNumber,secondNumber);
        //Assert
            assertEquals(expected,actual);
        }catch (Exception e){
            fail("Exception"+e.getClass()+"shouldn't be thrown");
        }
    }

    @Test
    public void should_Perform_Subtraction_Two_Double(){
        //Arrange
        Double firstNumber = 5.5D;
        Double secondNumber = 2.2D;
        Double expected = firstNumber-secondNumber;
        String operation = "-";

        try{
        //Act
            Double actual= calc.perform(operation,firstNumber,secondNumber);
         //Assert
            assertEquals(expected,actual);
        }catch (Exception e){
            fail("Exception"+e.getClass()+"shouldn't be thrown");
        }
    }

    @Test
    public void should_Throw_UnknownOperationException_With_Message_If_Unknown_Operation(){
        //Arrange
        Double firstNumber = 5.5D;
        Double secondNumber = 2.2D;
        String operation = "*#";
        String expectedMessage="Unsupported operation sign: \""+operation+"\"";

        try{
        //Act
            Double actual = calc.perform(operation,firstNumber,secondNumber);
            fail();
        }catch (Exception e){
        //Assert
            assertTrue(e.getMessage().equals(expectedMessage));
        }
    }
}
