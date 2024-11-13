package dms.pastor.tasks.romanarabicconverter;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Author Dominik Symonowicz
 * Created 2015-06-22
 * WWW:	<a href="https://dominiksymonowicz.com/">HOME PAGE</a>
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
@SuppressWarnings({"MagicNumber"})
//all numbers are used as numbers).isEqualTo(so nothing magic about it and spell check doesn't understand roman numbers :(
public class RomanToArabicConverterTest {

    private RomanArabicConverter converter;

    @BeforeEach
    public void setUp() {
        converter = new RomanArabicConverter();
    }

    @Test
    public void shouldThrowsExceptionIfInvalidNumber() {
        assertThrows(IllegalArgumentException.class, () -> converter.convertRomanToArabic("UFO"));
    }

    @Test
    public void testIfIEquals1() {
        assertThat(1).isEqualTo(converter.convertRomanToArabic("I"));
    }

    @Test
    public void testIfIIEquals2() {
        assertThat(2).isEqualTo(converter.convertRomanToArabic("II"));
    }

    @Test
    public void testIfIIIEquals3() {
        assertThat(3).isEqualTo(converter.convertRomanToArabic("III"));
    }

    @Test
    public void testIfIIIEquals4() {
        assertThat(4).isEqualTo(converter.convertRomanToArabic("IV"));
    }

    @Test
    public void testIfVEquals5() {
        assertThat(5).isEqualTo(converter.convertRomanToArabic("V"));
    }

    @Test
    public void testIfVIEquals6() {
        assertThat(6).isEqualTo(converter.convertRomanToArabic("VI"));
    }

    @Test
    public void testIfIXEquals9() {
        assertThat(9).isEqualTo(converter.convertRomanToArabic("IX"));
    }

    @Test
    public void testIfXEquals10() {
        assertThat(10).isEqualTo(converter.convertRomanToArabic("X"));
    }

    @Test
    public void testIfXIEquals11() {
        assertThat(11).isEqualTo(converter.convertRomanToArabic("XI"));
    }

    @Test
    public void testIfXIVEquals14() {
        assertThat(14).isEqualTo(converter.convertRomanToArabic("XIV"));
    }

    @Test
    public void testIfXIXEquals19() {
        assertThat(19).isEqualTo(converter.convertRomanToArabic("XIX"));
    }

    @Test
    public void testIfXXEquals20() {
        assertThat(20).isEqualTo(converter.convertRomanToArabic("XX"));
    }

    @Test
    public void testIfXLEquals40() {
        assertThat(40).isEqualTo(converter.convertRomanToArabic("XL"));
    }

    @Test
    public void testIfLEquals50() {
        assertThat(50).isEqualTo(converter.convertRomanToArabic("L"));
    }

    @Test
    public void testIfLIVEquals54() {
        assertThat(54).isEqualTo(converter.convertRomanToArabic("LIV"));
    }

    @Test
    public void testIfLIXEquals59() {
        assertThat(59).isEqualTo(converter.convertRomanToArabic("LIX"));
    }

    @Test
    public void testIfLXEquals60() {
        assertThat(60).isEqualTo(converter.convertRomanToArabic("LX"));
    }

    @Test
    public void testIfLXIVEquals64() {
        assertThat(64).isEqualTo(converter.convertRomanToArabic("LXIV"));
    }

    @Test
    public void testIfLXIXEquals69() {
        assertThat(69).isEqualTo(converter.convertRomanToArabic("LXIX"));
    }

    @Test
    public void testIfLXXEquals70() {
        assertThat(70).isEqualTo(converter.convertRomanToArabic("LXX"));
    }

    @Test
    public void testIfLXXXIXEquals89() {
        assertThat(89).isEqualTo(converter.convertRomanToArabic("LXXXIX"));
    }

    @Test
    public void testIfXCEquals90() {
        assertThat(90).isEqualTo(converter.convertRomanToArabic("XC"));
    }

    @Test
    public void testIfXCIXEquals99() {
        assertThat(99).isEqualTo(converter.convertRomanToArabic("XCIX"));
    }

    @Test
    public void testIfCEquals100() {
        assertThat(100).isEqualTo(converter.convertRomanToArabic("C"));
    }

    @Test
    public void testIfCXIVEquals114() {
        assertThat(114).isEqualTo(converter.convertRomanToArabic("CXIV"));
    }

    @Test
    public void testIfCXXXIVEquals134() {
        assertThat(134).isEqualTo(converter.convertRomanToArabic("CXXXIV"));
    }

    @Test
    public void testIfCXXXIXEquals139() {
        assertThat(139).isEqualTo(converter.convertRomanToArabic("CXXXIX"));
    }

    @Test
    public void testIfCXLEquals140() {
        assertThat(140).isEqualTo(converter.convertRomanToArabic("CXL"));
    }

    @Test
    public void testIfCLEquals150() {
        assertThat(150).isEqualTo(converter.convertRomanToArabic("CL"));
    }

    @Test
    public void testIfCCCXCIXEquals399() {
        assertThat(399).isEqualTo(converter.convertRomanToArabic("CCCXCIX"));
    }

    @Test
    public void testIfCDEquals400() {
        assertThat(400).isEqualTo(converter.convertRomanToArabic("CD"));
    }

    @Test
    public void testIfCDXLIVEquals444() {
        assertThat(444).isEqualTo(converter.convertRomanToArabic("CDXLIV"));
    }

    @Test
    public void testIfCDXCIXEquals499() {
        assertThat(499).isEqualTo(converter.convertRomanToArabic("CDXCIX"));
    }

    @Test
    public void testIfDEquals500() {
        assertThat(500).isEqualTo(converter.convertRomanToArabic("D"));
    }

    @Test
    public void testIfDCCCXCIXEquals899() {
        assertThat(899).isEqualTo(converter.convertRomanToArabic("DCCCXCIX"));
    }

    @Test
    public void testIfCMEquals900() {
        assertThat(900).isEqualTo(converter.convertRomanToArabic("CM"));
    }

    @Test
    public void testIfCMXCIXEquals999() {
        assertThat(999).isEqualTo(converter.convertRomanToArabic("CMXCIX"));
    }

    @Test
    public void testIfMEquals1000() {
        assertThat(1000).isEqualTo(converter.convertRomanToArabic("M"));
    }

    @Test
    public void testIfMCMXCIXEquals1999() {
        assertThat(1999).isEqualTo(converter.convertRomanToArabic("MCMXCIX"));
    }

    @Test
    public void testIfMMCDXLIVEquals2444() {
        assertThat(2444).isEqualTo(converter.convertRomanToArabic("MMCDXLIV"));
    }

    @Test
    public void testMaximumRomanNumber() {
        assertThat(3999).isEqualTo(converter.convertRomanToArabic("MMMCMXCIX"));
    }

}