package dms.pastor.tasks.romanarabicconverter;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Author Dominik Symonowicz
 * Created 2015-06-22
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
@SuppressWarnings({"MagicNumber"})// they are actual values
public class ArabicToRomanConverterTest {

    private RomanArabicConverter converter;

    @BeforeEach
    public void setUp() {
        converter = new RomanArabicConverter();
    }

    @Test
    public void testIfNegativeNumberGivesException() {
        assertThrows(IllegalArgumentException.class, () -> converter.convertArabicToRoman(-15));
    }

    @Test
    public void testIf0GivesException() {
        assertThrows(IllegalArgumentException.class, () -> converter.convertArabicToRoman(0));
    }

    @Test
    public void testIf4000GivesException() {
        assertThrows(IllegalArgumentException.class, () -> converter.convertArabicToRoman(4000));
    }

    @Test
    public void testIf1GivesI() {
        assertThat("I").isEqualTo(converter.convertArabicToRoman(1));
    }

    @Test
    public void testIf2GivesII() {
        assertThat("II").isEqualTo(converter.convertArabicToRoman(2));
    }

    @Test
    public void testIf3GivesIII() {
        assertThat("III").isEqualTo(converter.convertArabicToRoman(3));
    }

    @Test
    public void testIf4GivesIV() {
        assertThat("IV").isEqualTo(converter.convertArabicToRoman(4));
    }

    @Test
    public void testIf5GivesV() {
        assertThat("V").isEqualTo(converter.convertArabicToRoman(5));
    }

    @Test
    public void testIf6GivesVI() {
        assertThat("VI").isEqualTo(converter.convertArabicToRoman(6));
    }

    @Test
    public void testIf8GivesVIII() {
        assertThat("VIII").isEqualTo(converter.convertArabicToRoman(8));
    }

    @Test
    public void testIf10GivesX() {
        assertThat("X").isEqualTo(converter.convertArabicToRoman(10));
    }

    @Test
    public void testIf11GivesXI() {
        assertThat("XI").isEqualTo(converter.convertArabicToRoman(11));
    }

    @Test
    public void testIf13GivesXIII() {
        assertThat("XIII").isEqualTo(converter.convertArabicToRoman(13));
    }

    @Test
    public void testIf14GivesXIV() {
        assertThat("XIV").isEqualTo(converter.convertArabicToRoman(14));
    }

    @Test
    public void testIf15GivesXV() {
        assertThat("XV").isEqualTo(converter.convertArabicToRoman(15));
    }

    @Test
    public void testIf19GivesXIX() {
        assertThat("XIX").isEqualTo(converter.convertArabicToRoman(19));
    }

    @Test
    public void testIf20GivesXX() {
        assertThat("XX").isEqualTo(converter.convertArabicToRoman(20));
    }

    @Test
    public void testIf34GivesXXXIV() {
        assertThat("XXXIV").isEqualTo(converter.convertArabicToRoman(34));
    }

    @Test
    public void testIf35GivesXXXV() {
        assertThat("XXXV").isEqualTo(converter.convertArabicToRoman(35));
    }

    @Test
    public void testIf39GivesXXXIX() {
        assertThat("XXXIX").isEqualTo(converter.convertArabicToRoman(39));
    }

    @Test
    public void testIf40GivesXL() {
        assertThat("XL").isEqualTo(converter.convertArabicToRoman(40));
    }

    @Test
    public void testIf50GivesL() {
        assertThat("L").isEqualTo(converter.convertArabicToRoman(50));
    }

    @Test
    public void testIf53GivesLIII() {
        assertThat("LIII").isEqualTo(converter.convertArabicToRoman(53));
    }

    @Test
    public void testIf54GivesLIV() {
        assertThat("LIV").isEqualTo(converter.convertArabicToRoman(54));
    }

    @Test
    public void testIf58GivesLVIII() {
        assertThat("LVIII").isEqualTo(converter.convertArabicToRoman(58));
    }

    @Test
    public void testIf59GivesLIX() {
        assertThat("LIX").isEqualTo(converter.convertArabicToRoman(59));
    }

    @Test
    public void testIf84GivesLXXXIV() {
        assertThat("LXXXIV").isEqualTo(converter.convertArabicToRoman(84));
    }

    @Test
    public void testIf99GivesXCIX() {
        assertThat("XCIX").isEqualTo(converter.convertArabicToRoman(99));
    }

    @Test
    public void testIf100GivesC() {
        assertThat("C").isEqualTo(converter.convertArabicToRoman(100));
    }

    @Test
    public void testIf134GivesCXXXIV() {
        assertThat("CXXXIV").isEqualTo(converter.convertArabicToRoman(134));
    }

    @Test
    public void testIf149GivesCXLIX() {
        assertThat("CXLIX").isEqualTo(converter.convertArabicToRoman(149));
    }

    @Test
    public void testIf150GivesCL() {
        assertThat("CL").isEqualTo(converter.convertArabicToRoman(150));
    }

    @Test
    public void testIf349GivesCCCXLIX() {
        assertThat("CCCXLIX").isEqualTo(converter.convertArabicToRoman(349));
    }

    @Test
    public void testIf400GivesCD() {
        assertThat("CD").isEqualTo(converter.convertArabicToRoman(400));
    }

    @Test
    public void testIf500GivesD() {
        assertThat("D").isEqualTo(converter.convertArabicToRoman(500));
    }

    @Test
    public void testIf849GivesDCCCXLIX() {
        assertThat("DCCCXLIX").isEqualTo(converter.convertArabicToRoman(849));
    }

    @Test
    public void testIf900GivesCM() {
        assertThat("CM").isEqualTo(converter.convertArabicToRoman(900));
    }

    @Test
    public void testIf1000GivesCM() {
        assertThat("M").isEqualTo(converter.convertArabicToRoman(1000));
    }

    @Test
    public void testIf1111GivesMCXI() {
        assertThat("MCXI").isEqualTo(converter.convertArabicToRoman(1111));
    }

    @Test
    public void testIf34444GivesMMMCDXLIV() {
        assertThat("MMMCDXLIV").isEqualTo(converter.convertArabicToRoman(3444));
    }

    @Test
    public void testIf3999GivesMMMCMXCIX() {
        assertThat("MMMCMXCIX").isEqualTo(converter.convertArabicToRoman(3999));
    }
}