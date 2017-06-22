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
@SuppressWarnings("MagicNumber")// they are actual values
public class ArabicToRomanConverterTest {

    private RomanArabicConverter converter;

    @Before
    public void setUp() throws Exception {
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
    public void testIf1GivesI() throws Exception {
        Assert.assertEquals("I", converter.convertArabicToRoman(1));
    }

    @Test
    public void testIf2GivesII() throws Exception {
        Assert.assertEquals("II", converter.convertArabicToRoman(2));
    }

    @Test
    public void testIf3GivesIII() throws Exception {
        Assert.assertEquals("III", converter.convertArabicToRoman(3));
    }

    @Test
    public void testIf4GivesIV() throws Exception {
        Assert.assertEquals("IV", converter.convertArabicToRoman(4));
    }

    @Test
    public void testIf5GivesV() throws Exception {
        Assert.assertEquals("V", converter.convertArabicToRoman(5));
    }

    @Test
    public void testIf6GivesVI() throws Exception {
        Assert.assertEquals("VI", converter.convertArabicToRoman(6));
    }

    @Test
    public void testIf8GivesVIII() throws Exception {
        Assert.assertEquals("VIII", converter.convertArabicToRoman(8));
    }

    @Test
    public void testIf10GivesX() throws Exception {
        Assert.assertEquals("X", converter.convertArabicToRoman(10));
    }

    @Test
    public void testIf11GivesXI() throws Exception {
        Assert.assertEquals("XI", converter.convertArabicToRoman(11));
    }

    @Test
    public void testIf13GivesXIII() throws Exception {
        Assert.assertEquals("XIII", converter.convertArabicToRoman(13));
    }

    @Test
    public void testIf14GivesXIV() throws Exception {
        Assert.assertEquals("XIV", converter.convertArabicToRoman(14));
    }

    @Test
    public void testIf15GivesXV() throws Exception {
        Assert.assertEquals("XV", converter.convertArabicToRoman(15));
    }

    @Test
    public void testIf19GivesXIX() throws Exception {
        Assert.assertEquals("XIX", converter.convertArabicToRoman(19));
    }

    @Test
    public void testIf20GivesXX() throws Exception {
        Assert.assertEquals("XX", converter.convertArabicToRoman(20));
    }

    @Test
    public void testIf34GivesXXXIV() throws Exception {
        Assert.assertEquals("XXXIV", converter.convertArabicToRoman(34));
    }

    @Test
    public void testIf35GivesXXXV() throws Exception {
        Assert.assertEquals("XXXV", converter.convertArabicToRoman(35));
    }

    @Test
    public void testIf39GivesXXXIX() throws Exception {
        Assert.assertEquals("XXXIX", converter.convertArabicToRoman(39));
    }

    @Test
    public void testIf40GivesXL() throws Exception {
        Assert.assertEquals("XL", converter.convertArabicToRoman(40));
    }

    @Test
    public void testIf50GivesL() throws Exception {
        Assert.assertEquals("L", converter.convertArabicToRoman(50));
    }

    @Test
    public void testIf53GivesLIII() throws Exception {
        Assert.assertEquals("LIII", converter.convertArabicToRoman(53));
    }

    @Test
    public void testIf54GivesLIV() throws Exception {
        Assert.assertEquals("LIV", converter.convertArabicToRoman(54));
    }

    @Test
    public void testIf58GivesLVIII() throws Exception {
        Assert.assertEquals("LVIII", converter.convertArabicToRoman(58));
    }

    @Test
    public void testIf59GivesLIX() throws Exception {
        Assert.assertEquals("LIX", converter.convertArabicToRoman(59));
    }

    @Test
    public void testIf84GivesLXXXIV() throws Exception {
        Assert.assertEquals("LXXXIV", converter.convertArabicToRoman(84));
    }

    @Test
    public void testIf99GivesXCIX() throws Exception {
        Assert.assertEquals("XCIX", converter.convertArabicToRoman(99));
    }

    @Test
    public void testIf100GivesC() throws Exception {
        Assert.assertEquals("C", converter.convertArabicToRoman(100));
    }

    @Test
    public void testIf134GivesCXXXIV() throws Exception {
        Assert.assertEquals("CXXXIV", converter.convertArabicToRoman(134));
    }

    @Test
    public void testIf149GivesCXLIX() throws Exception {
        Assert.assertEquals("CXLIX", converter.convertArabicToRoman(149));
    }

    @Test
    public void testIf150GivesCL() throws Exception {
        Assert.assertEquals("CL", converter.convertArabicToRoman(150));
    }

    @Test
    public void testIf349GivesCCCXLIX() throws Exception {
        Assert.assertEquals("CCCXLIX", converter.convertArabicToRoman(349));
    }

    @Test
    public void testIf400GivesCD() throws Exception {
        Assert.assertEquals("CD", converter.convertArabicToRoman(400));
    }

    @Test
    public void testIf500GivesD() throws Exception {
        Assert.assertEquals("D", converter.convertArabicToRoman(500));
    }

    @Test
    public void testIf849GivesDCCCXLIX() throws Exception {
        Assert.assertEquals("DCCCXLIX", converter.convertArabicToRoman(849));
    }

    @Test
    public void testIf900GivesCM() throws Exception {
        Assert.assertEquals("CM", converter.convertArabicToRoman(900));
    }

    @Test
    public void testIf1000GivesCM() throws Exception {
        Assert.assertEquals("M", converter.convertArabicToRoman(1000));
    }

    @Test
    public void testIf1111GivesMCXI() throws Exception {
        Assert.assertEquals("MCXI", converter.convertArabicToRoman(1111));
    }

    @Test
    public void testIf34444GivesMMMCDXLIV() throws Exception {
        Assert.assertEquals("MMMCDXLIV", converter.convertArabicToRoman(3444));
    }

    @Test
    public void testIf3999GivesMMMCMXCIX() throws Exception {
        Assert.assertEquals("MMMCMXCIX", converter.convertArabicToRoman(3999));
    }
}