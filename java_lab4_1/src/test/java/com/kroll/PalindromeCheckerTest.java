package com.kroll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PalindromeCheckerTest {

    @Test
    public void testIsTextPalindrome() {
        assertFalse(Main.isTextPalindrome(null));
        assertTrue(Main.isTextPalindrome("radar"));
        assertFalse(Main.isTextPalindrome("banana"));
        assertTrue(Main.isTextPalindrome("hannah"));
        assertTrue(Main.isTextPalindrome("pup"));
        assertTrue(Main.isTextPalindrome("nan"));
        assertFalse(Main.isTextPalindrome("lollipop"));
        assertTrue(Main.isTextPalindrome("eye"));
        assertTrue(Main.isTextPalindrome("6543456"));
        assertTrue(Main.isTextPalindrome("step on no pets"));
        assertTrue(Main.isTextPalindrome("A man a plan a canal Panama"));
    }
}
