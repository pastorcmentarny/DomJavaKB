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
@SuppressWarnings({"MagicNumber"})
//all numbers are used as numbers, so nothing magic about it and spell check doesn't understand roman numbers :(
public class RomanToArabicConverterTest {

    private RomanArabicConverter converter;

    @Before
    public void setUp() {
        converter = new RomanArabicConverter();
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowsExceptionIfInvalidNumber() {
        converter.convertRomanToArabic("UFO");
    }

    @Test
    public void testIfIEquals1() {
        Assert.assertEquals(1, converter.convertRomanToArabic("I"));
    }

    @Test
    public void testIfIIEquals2() {
        Assert.assertEquals(2, converter.convertRomanToArabic("II"));
    }

    @Test
    public void testIfIIIEquals3() {
        Assert.assertEquals(3, converter.convertRomanToArabic("III"));
    }

    @Test
    public void testIfIIIEquals4() {
        Assert.assertEquals(4, converter.convertRomanToArabic("IV"));
    }

    @Test
    public void testIfVEquals5() {
        Assert.assertEquals(5, converter.convertRomanToArabic("V"));
    }

    @Test
    public void testIfVIEquals6() {
        Assert.assertEquals(6, converter.convertRomanToArabic("VI"));
    }

    @Test
    public void testIfIXEquals9() {
        Assert.assertEquals(9, converter.convertRomanToArabic("IX"));
    }

    @Test
    public void testIfXEquals10() {
        Assert.assertEquals(10, converter.convertRomanToArabic("X"));
    }

    @Test
    public void testIfXIEquals11() {
        Assert.assertEquals(11, converter.convertRomanToArabic("XI"));
    }

    @Test
    public void testIfXIVEquals14() {
        Assert.assertEquals(14, converter.convertRomanToArabic("XIV"));
    }

    @Test
    public void testIfXIXEquals19() {
        Assert.assertEquals(19, converter.convertRomanToArabic("XIX"));
    }

    @Test
    public void testIfXXEquals20() {
        Assert.assertEquals(20, converter.convertRomanToArabic("XX"));
    }

    @Test
    public void testIfXLEquals40() {
        Assert.assertEquals(40, converter.convertRomanToArabic("XL"));
    }

    @Test
    public void testIfLEquals50() {
        Assert.assertEquals(50, converter.convertRomanToArabic("L"));
    }

    @Test
    public void testIfLIVEquals54() {
        Assert.assertEquals(54, converter.convertRomanToArabic("LIV"));
    }

    @Test
    public void testIfLIXEquals59() {
        Assert.assertEquals(59, converter.convertRomanToArabic("LIX"));
    }

    @Test
    public void testIfLXEquals60() {
        Assert.assertEquals(60, converter.convertRomanToArabic("LX"));
    }

    @Test
    public void testIfLXIVEquals64() {
        Assert.assertEquals(64, converter.convertRomanToArabic("LXIV"));
    }

    @Test
    public void testIfLXIXEquals69() {
        Assert.assertEquals(69, converter.convertRomanToArabic("LXIX"));
    }

    @Test
    public void testIfLXXEquals70() {
        Assert.assertEquals(70, converter.convertRomanToArabic("LXX"));
    }

    @Test
    public void testIfLXXXIXEquals89() {
        Assert.assertEquals(89, converter.convertRomanToArabic("LXXXIX"));
    }

    @Test
    public void testIfXCEquals90() {
        Assert.assertEquals(90, converter.convertRomanToArabic("XC"));
    }

    @Test
    public void testIfXCIXEquals99() {
        Assert.assertEquals(99, converter.convertRomanToArabic("XCIX"));
    }

    @Test
    public void testIfCEquals100() {
        Assert.assertEquals(100, converter.convertRomanToArabic("C"));
    }

    @Test
    public void testIfCXIVEquals114() {
        Assert.assertEquals(114, converter.convertRomanToArabic("CXIV"));
    }

    @Test
    public void testIfCXXXIVEquals134() {
        Assert.assertEquals(134, converter.convertRomanToArabic("CXXXIV"));
    }

    @Test
    public void testIfCXXXIXEquals139() {
        Assert.assertEquals(139, converter.convertRomanToArabic("CXXXIX"));
    }

    @Test
    public void testIfCXLEquals140() {
        Assert.assertEquals(140, converter.convertRomanToArabic("CXL"));
    }

    @Test
    public void testIfCLEquals150() {
        Assert.assertEquals(150, converter.convertRomanToArabic("CL"));
    }

    @Test
    public void testIfCCCXCIXEquals399() {
        Assert.assertEquals(399, converter.convertRomanToArabic("CCCXCIX"));
    }

    @Test
    public void testIfCDEquals400() {
        Assert.assertEquals(400, converter.convertRomanToArabic("CD"));
    }

    @Test
    public void testIfCDXLIVEquals444() {
        Assert.assertEquals(444, converter.convertRomanToArabic("CDXLIV"));
    }

    @Test
    public void testIfCDXCIXEquals499() {
        Assert.assertEquals(499, converter.convertRomanToArabic("CDXCIX"));
    }

    @Test
    public void testIfDEquals500() {
        Assert.assertEquals(500, converter.convertRomanToArabic("D"));
    }

    @Test
    public void testIfDCCCXCIXEquals899() {
        Assert.assertEquals(899, converter.convertRomanToArabic("DCCCXCIX"));
    }

    @Test
    public void testIfCMEquals900() {
        Assert.assertEquals(900, converter.convertRomanToArabic("CM"));
    }

    @Test
    public void testIfCMXCIXEquals999() {
        Assert.assertEquals(999, converter.convertRomanToArabic("CMXCIX"));
    }

    @Test
    public void testIfMEquals1000() {
        Assert.assertEquals(1000, converter.convertRomanToArabic("M"));
    }

    @Test
    public void testIfMCMXCIXEquals1999() {
        Assert.assertEquals(1999, converter.convertRomanToArabic("MCMXCIX"));
    }

    @Test
    public void testIfMMCDXLIVEquals2444() {
        Assert.assertEquals(2444, converter.convertRomanToArabic("MMCDXLIV"));
    }

    @Test
    public void testMaximumRomanNumber() {
        Assert.assertEquals(3999, converter.convertRomanToArabic("MMMCMXCIX"));
    }

}