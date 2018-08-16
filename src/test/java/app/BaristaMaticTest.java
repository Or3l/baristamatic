package app;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BaristaMaticTest {




    @Test
    public void test_isInteger(){
        assertTrue(BaristaMatic.isInteger("123".toCharArray()));
    }

    @Test
    public void test_isInteger_false(){
        assertFalse(BaristaMatic.isInteger("123c".toCharArray()));
    }

    @Test
    public void test_authorizedCharacter(){
        assertTrue(BaristaMatic.isAuthorizedCharacter("q"));
    }

    @Test
    public void test_authorizedCharacter_False1(){
        assertFalse(BaristaMatic.isAuthorizedCharacter("qr"));
    }

    @Test
    public void test_authorizedCharacter_False2(){
        assertFalse(BaristaMatic.isAuthorizedCharacter("1"));
    }

    @Test
    public void test_isAuthorizedSelection(){
        assertTrue(BaristaMatic.isAuthorizedSelection(3, 5));
    }

    @Test
    public void test_isAuthorizedSelection2(){
        assertTrue(BaristaMatic.isAuthorizedSelection(1, 5));
    }

    @Test
    public void test_isAuthorizedSelection_False(){
        assertFalse(BaristaMatic.isAuthorizedSelection(6, 5));
    }





}