package com.jengelmo.kwtfizzbuzz;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class FizzBuzzTest {

    @Test
    public void shouldReturnFizzForANumberMultipleOfThree() throws Exception {
        assertThat(fizzbuzz(3), is("Fizz"));
    }

    @Test
    public void shouldReturnFizzForANumberMultipleOfFive() throws Exception {
        assertThat(fizzbuzz(10), is("Buzz"));
    }

    @Test
    public void shouldReturnTheNumberAsStringForANumberNotMultipleOfThreeOrFive() throws Exception {
        int number = 7;
        assertThat(fizzbuzz(number), is(String.valueOf(number)));
    }

    @Test
    public void shouldReturnFizzBuzzForANumberMultipleOfThreeAndFive() throws Exception {
        assertThat(fizzbuzz(15), is("FizzBuzz"));
    }

    public String fizzbuzz(int number) {
        if (number % 3 == 0) {
            if (number % 5 == 0) {
                return "FizzBuzz";
            }
            return "Fizz";
        } else if (number % 5 == 0) {
            return "Buzz";
        } else {
            return String.valueOf(number);
        }
    }
}