package dms.pastor.tasks.romanarabicconverter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Author Dominik Symonowicz
 * Created 2015-06-22
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
@SuppressWarnings({"MagicNumber", "SpellCheckingInspection"})// they are actual values
public class ArabicToRomanConverterTest {

    private RomanArabicConverter converter;

    @Before
    public void setUp() {
        converter = new RomanArabicConverter();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIfNegativeNumberGivesException() {
        converter.convertArabicToRoman(-15);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIf0GivesException() {
        converter.convertArabicToRoman(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIf4000GivesException() {
        converter.convertArabicToRoman(4000);
    }

    @Test
    public void testIf1GivesI() {
        Assert.assertEquals("I", converter.convertArabicToRoman(1));
    }

    @Test
    public void testIf2GivesII() {
        Assert.assertEquals("II", converter.convertArabicToRoman(2));
    }

    @Test
    public void testIf3GivesIII() {
        Assert.assertEquals("III", converter.convertArabicToRoman(3));
    }

    @Test
    public void testIf4GivesIV() {
        Assert.assertEquals("IV", converter.convertArabicToRoman(4));
    }

    @Test
    public void testIf5GivesV() {
        Assert.assertEquals("V", converter.convertArabicToRoman(5));
    }

    @Test
    public void testIf6GivesVI() {
        Assert.assertEquals("VI", converter.convertArabicToRoman(6));
    }

    @Test
    public void testIf8GivesVIII() {
        Assert.assertEquals("VIII", converter.convertArabicToRoman(8));
    }

    @Test
    public void testIf10GivesX() {
        Assert.assertEquals("X", converter.convertArabicToRoman(10));
    }

    @Test
    public void testIf11GivesXI() {
        Assert.assertEquals("XI", converter.convertArabicToRoman(11));
    }

    @Test
    public void testIf13GivesXIII() {
        Assert.assertEquals("XIII", converter.convertArabicToRoman(13));
    }

    @Test
    public void testIf14GivesXIV() {
        Assert.assertEquals("XIV", converter.convertArabicToRoman(14));
    }

    @Test
    public void testIf15GivesXV() {
        Assert.assertEquals("XV", converter.convertArabicToRoman(15));
    }

    @Test
    public void testIf19GivesXIX() {
        Assert.assertEquals("XIX", converter.convertArabicToRoman(19));
    }

    @Test
    public void testIf20GivesXX() {
        Assert.assertEquals("XX", converter.convertArabicToRoman(20));
    }

    @Test
    public void testIf34GivesXXXIV() {
        Assert.assertEquals("XXXIV", converter.convertArabicToRoman(34));
    }

    @Test
    public void testIf35GivesXXXV() {
        Assert.assertEquals("XXXV", converter.convertArabicToRoman(35));
    }

    @Test
    public void testIf39GivesXXXIX() {
        Assert.assertEquals("XXXIX", converter.convertArabicToRoman(39));
    }

    @Test
    public void testIf40GivesXL() {
        Assert.assertEquals("XL", converter.convertArabicToRoman(40));
    }

    @Test
    public void testIf50GivesL() {
        Assert.assertEquals("L", converter.convertArabicToRoman(50));
    }

    @Test
    public void testIf53GivesLIII() {
        Assert.assertEquals("LIII", converter.convertArabicToRoman(53));
    }

    @Test
    public void testIf54GivesLIV() {
        Assert.assertEquals("LIV", converter.convertArabicToRoman(54));
    }

    @Test
    public void testIf58GivesLVIII() {
        Assert.assertEquals("LVIII", converter.convertArabicToRoman(58));
    }

    @Test
    public void testIf59GivesLIX() {
        Assert.assertEquals("LIX", converter.convertArabicToRoman(59));
    }

    @Test
    public void testIf84GivesLXXXIV() {
        Assert.assertEquals("LXXXIV", converter.convertArabicToRoman(84));
    }

    @Test
    public void testIf99GivesXCIX() {
        Assert.assertEquals("XCIX", converter.convertArabicToRoman(99));
    }

    @Test
    public void testIf100GivesC() {
        Assert.assertEquals("C", converter.convertArabicToRoman(100));
    }

    @Test
    public void testIf134GivesCXXXIV() {
        Assert.assertEquals("CXXXIV", converter.convertArabicToRoman(134));
    }

    @Test
    public void testIf149GivesCXLIX() {
        Assert.assertEquals("CXLIX", converter.convertArabicToRoman(149));
    }

    @Test
    public void testIf150GivesCL() {
        Assert.assertEquals("CL", converter.convertArabicToRoman(150));
    }

    @Test
    public void testIf349GivesCCCXLIX() {
        Assert.assertEquals("CCCXLIX", converter.convertArabicToRoman(349));
    }

    @Test
    public void testIf400GivesCD() {
        Assert.assertEquals("CD", converter.convertArabicToRoman(400));
    }

    @Test
    public void testIf500GivesD() {
        Assert.assertEquals("D", converter.convertArabicToRoman(500));
    }

    @Test
    public void testIf849GivesDCCCXLIX() {
        Assert.assertEquals("DCCCXLIX", converter.convertArabicToRoman(849));
    }

    @Test
    public void testIf900GivesCM() {
        Assert.assertEquals("CM", converter.convertArabicToRoman(900));
    }

    @Test
    public void testIf1000GivesCM() {
        Assert.assertEquals("M", converter.convertArabicToRoman(1000));
    }

    @Test
    public void testIf1111GivesMCXI() {
        Assert.assertEquals("MCXI", converter.convertArabicToRoman(1111));
    }

    @Test
    public void testIf34444GivesMMMCDXLIV() {
        Assert.assertEquals("MMMCDXLIV", converter.convertArabicToRoman(3444));
    }

    @Test
    public void testIf3999GivesMMMCMXCIX() {
        Assert.assertEquals("MMMCMXCIX", converter.convertArabicToRoman(3999));
    }
}