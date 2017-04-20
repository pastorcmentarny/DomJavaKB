package dms.pastor.utils;

import org.joda.time.LocalDate;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Date;

import static dms.pastor.utils.DateUtils.*;
import static java.time.LocalDate.now;
import static java.time.LocalDate.of;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;

/**
 * Author Dominik Symonowicz
 * Created 19/06/2016
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class DateUtilsTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @SuppressWarnings("SpellCheckingInspection")
    @Test
    public void shouldReturnTimeZoneListExample() throws Exception {

        // when
        final String displayTimeZoneList = displayTimeZoneList();

        // then
        Assert.assertThat(displayTimeZoneList, is("Asia/AdenAmerica/CuiabaEtc/GMT+9Etc/GMT+8Africa/NairobiAmerica/MarigotAsia/AqtauPacific/KwajaleinAmerica/El_SalvadorAsia/PontianakAfrica/CairoPacific/Pago_PagoAfrica/MbabaneAsia/KuchingPacific/HonoluluPacific/RarotongaAmerica/GuatemalaAustralia/HobartEurope/LondonAmerica/BelizeAmerica/PanamaAsia/ChungkingAmerica/ManaguaAmerica/Indiana/PetersburgAsia/YerevanEurope/BrusselsGMTEurope/WarsawAmerica/ChicagoAsia/KashgarChile/ContinentalPacific/YapCETEtc/GMT-1Etc/GMT-0Europe/JerseyAmerica/TegucigalpaEtc/GMT-5Europe/IstanbulAmerica/EirunepeEtc/GMT-4America/MiquelonEtc/GMT-3Europe/LuxembourgEtc/GMT-2Etc/GMT-9America/Argentina/CatamarcaEtc/GMT-8Etc/GMT-7Etc/GMT-6Europe/ZaporozhyeCanada/YukonCanada/AtlanticAtlantic/St_HelenaAustralia/TasmaniaLibyaEurope/GuernseyAmerica/Grand_TurkUS/Pacific-NewAsia/SamarkandAmerica/Argentina/CordobaAsia/Phnom_PenhAfrica/KigaliAsia/AlmatyUS/AlaskaAsia/DubaiEurope/Isle_of_ManAmerica/AraguainaCubaAsia/NovosibirskAmerica/Argentina/SaltaEtc/GMT+3Africa/TunisEtc/GMT+2Etc/GMT+1Pacific/FakaofoAfrica/TripoliEtc/GMT+0IsraelAfrica/BanjulEtc/GMT+7Indian/ComoroEtc/GMT+6Etc/GMT+5Etc/GMT+4Pacific/Port_MoresbyUS/ArizonaAntarctica/SyowaIndian/ReunionPacific/PalauEurope/KaliningradAmerica/MontevideoAfrica/WindhoekAsia/KarachiAfrica/MogadishuAustralia/PerthBrazil/EastEtc/GMTAsia/ChitaPacific/EasterAntarctica/DavisAntarctica/McMurdoAsia/MacaoAmerica/ManausAfrica/FreetownEurope/BucharestAmerica/Argentina/MendozaAsia/MacauEurope/MaltaMexico/BajaSurPacific/TahitiAfrica/AsmeraEurope/BusingenAmerica/Argentina/Rio_GallegosAfrica/MalaboEurope/SkopjeAmerica/CatamarcaAmerica/GodthabEurope/SarajevoAustralia/ACTGB-EireAfrica/LagosAmerica/CordobaEurope/RomeAsia/DaccaIndian/MauritiusPacific/SamoaAmerica/ReginaAmerica/Fort_WayneAmerica/Dawson_CreekAfrica/AlgiersEurope/MariehamnAmerica/St_JohnsAmerica/St_ThomasEurope/ZurichAmerica/AnguillaAsia/DiliAmerica/DenverAfrica/BamakoGBMexico/GeneralPacific/WallisEurope/GibraltarAfrica/ConakryAfrica/LubumbashiAsia/IstanbulAmerica/HavanaNZ-CHATAsia/ChoibalsanAmerica/Porto_AcreAsia/OmskEurope/VaduzUS/MichiganAsia/DhakaAmerica/BarbadosEurope/TiraspolAtlantic/Cape_VerdeAsia/YekaterinburgAmerica/LouisvillePacific/JohnstonPacific/ChathamEurope/LjubljanaAmerica/Sao_PauloAsia/JayapuraAmerica/CuracaoAsia/DushanbeAmerica/GuyanaAmerica/GuayaquilAmerica/MartiniquePortugalEurope/BerlinEurope/MoscowEurope/ChisinauAmerica/Puerto_RicoAmerica/Rankin_InletPacific/PonapeEurope/StockholmEurope/BudapestAmerica/Argentina/JujuyAustralia/EuclaAsia/ShanghaiUniversalEurope/ZagrebAmerica/Port_of_SpainEurope/HelsinkiAsia/BeirutAsia/Tel_AvivPacific/BougainvilleUS/CentralAfrica/Sao_TomeIndian/ChagosAmerica/CayenneAsia/YakutskPacific/GalapagosAustralia/NorthEurope/ParisAfrica/NdjamenaPacific/FijiAmerica/Rainy_RiverIndian/MaldivesAustralia/YancowinnaSystemV/AST4Asia/OralAmerica/YellowknifePacific/EnderburyAmerica/JuneauAustralia/VictoriaAmerica/Indiana/VevayAsia/TashkentAsia/JakartaAfrica/CeutaAmerica/RecifeAmerica/Buenos_AiresAmerica/NoronhaAmerica/Swift_CurrentAustralia/AdelaideAmerica/MetlakatlaAfrica/DjiboutiAmerica/ParamariboEurope/SimferopolEurope/SofiaAfrica/NouakchottEurope/PragueAmerica/Indiana/VincennesAntarctica/MawsonAmerica/KralendijkAntarctica/TrollEurope/SamaraIndian/ChristmasAmerica/AntiguaPacific/GambierAmerica/IndianapolisAmerica/InuvikAmerica/IqaluitPacific/FunafutiUTCAntarctica/MacquarieCanada/PacificAmerica/MonctonAfrica/GaboronePacific/ChuukAsia/PyongyangAmerica/St_VincentAsia/GazaEtc/UniversalPST8PDTAtlantic/FaeroeAsia/QyzylordaCanada/NewfoundlandAmerica/Kentucky/LouisvilleAmerica/YakutatAsia/Ho_Chi_MinhAntarctica/CaseyEurope/CopenhagenAfrica/AsmaraAtlantic/AzoresEurope/ViennaROKPacific/PitcairnAmerica/MazatlanAustralia/QueenslandPacific/NauruEurope/TiraneAsia/KolkataSystemV/MST7Australia/CanberraMETAustralia/Broken_HillEurope/RigaAmerica/DominicaAfrica/AbidjanAmerica/MendozaAmerica/SantaremKwajaleinAmerica/AsuncionAsia/Ulan_BatorNZAmerica/BoiseAustralia/CurrieEST5EDTPacific/GuamPacific/WakeAtlantic/BermudaAmerica/Costa_RicaAmerica/DawsonAsia/ChongqingEireEurope/AmsterdamAmerica/Indiana/KnoxAmerica/North_Dakota/BeulahAfrica/AccraAtlantic/FaroeMexico/BajaNorteAmerica/MaceioEtc/UCTPacific/ApiaGMT0America/AtkaPacific/NiueCanada/East-SaskatchewanAustralia/Lord_HoweEurope/DublinPacific/TrukMST7MDTAmerica/MonterreyAmerica/NassauAmerica/JamaicaAsia/BishkekAmerica/AtikokanAtlantic/StanleyAustralia/NSWUS/HawaiiSystemV/CST6Indian/MaheAsia/AqtobeAmerica/SitkaAsia/VladivostokAfrica/LibrevilleAfrica/MaputoZuluAmerica/Kentucky/MonticelloAfrica/El_AaiunAfrica/OuagadougouAmerica/Coral_HarbourPacific/MarquesasBrazil/WestAmerica/ArubaAmerica/North_Dakota/CenterAmerica/CaymanAsia/UlaanbaatarAsia/BaghdadEurope/San_MarinoAmerica/Indiana/Tell_CityAmerica/TijuanaPacific/SaipanSystemV/YST9Africa/DoualaAmerica/ChihuahuaAmerica/OjinagaAsia/HovdAmerica/AnchorageChile/EasterIslandAmerica/HalifaxAntarctica/RotheraAmerica/Indiana/IndianapolisUS/MountainAsia/DamascusAmerica/Argentina/San_LuisAmerica/SantiagoAsia/BakuAmerica/Argentina/UshuaiaAtlantic/ReykjavikAfrica/BrazzavilleAfrica/Porto-NovoAmerica/La_PazAntarctica/DumontDUrvilleAsia/TaipeiAntarctica/South_PoleAsia/ManilaAsia/BangkokAfrica/Dar_es_SalaamPolandAtlantic/MadeiraAntarctica/PalmerAmerica/Thunder_BayAfrica/Addis_AbabaEurope/UzhgorodBrazil/DeNoronhaAsia/AshkhabadEtc/ZuluAmerica/Indiana/MarengoAmerica/CrestonAmerica/Mexico_CityAntarctica/VostokAsia/JerusalemEurope/AndorraUS/SamoaPRCAsia/VientianePacific/KiritimatiAmerica/MatamorosAmerica/Blanc-SablonAsia/RiyadhIcelandPacific/PohnpeiAsia/Ujung_PandangAtlantic/South_GeorgiaEurope/LisbonAsia/HarbinEurope/OsloAsia/NovokuznetskCST6CDTAtlantic/CanaryAmerica/Knox_INAsia/KuwaitSystemV/HST10Pacific/EfateAfrica/LomeAmerica/BogotaAmerica/MenomineeAmerica/AdakPacific/NorfolkAmerica/ResolutePacific/TarawaAfrica/KampalaAsia/KrasnoyarskGreenwichSystemV/EST5America/EdmontonEurope/PodgoricaAustralia/SouthCanada/CentralAfrica/BujumburaAmerica/Santo_DomingoUS/EasternEurope/MinskPacific/AucklandAfrica/CasablancaAmerica/Glace_BayCanada/EasternAsia/QatarEurope/KievSingaporeAsia/MagadanSystemV/PST8America/Port-au-PrinceEurope/BelfastAmerica/St_BarthelemyAsia/AshgabatAfrica/LuandaAmerica/NipigonAtlantic/Jan_MayenBrazil/AcreAsia/MuscatAsia/BahrainEurope/VilniusAmerica/FortalezaEtc/GMT0US/East-IndianaAmerica/HermosilloAmerica/CancunAfrica/MaseruPacific/KosraeAfrica/KinshasaAsia/KathmanduAsia/SeoulAustralia/SydneyAmerica/LimaAustralia/LHIAmerica/St_LuciaEurope/MadridAmerica/Bahia_BanderasAmerica/MontserratAsia/BruneiAmerica/Santa_IsabelCanada/MountainAmerica/Cambridge_BayAsia/ColomboAustralia/WestIndian/AntananarivoAustralia/BrisbaneIndian/MayotteUS/Indiana-StarkeAsia/UrumqiUS/AleutianEurope/VolgogradAmerica/Lower_PrincesAmerica/VancouverAfrica/BlantyreAmerica/Rio_BrancoAmerica/DanmarkshavnAmerica/DetroitAmerica/ThuleAfrica/LusakaAsia/Hong_KongIranAmerica/Argentina/La_RiojaAfrica/DakarSystemV/CST6CDTAmerica/TortolaAmerica/Porto_VelhoAsia/SakhalinEtc/GMT+10America/ScoresbysundAsia/KamchatkaAsia/ThimbuAfrica/HarareEtc/GMT+12Etc/GMT+11NavajoAmerica/NomeEurope/TallinnTurkeyAfrica/KhartoumAfrica/JohannesburgAfrica/BanguiEurope/BelgradeJamaicaAfrica/BissauAsia/TehranWETAfrica/JubaAmerica/Campo_GrandeAmerica/BelemEtc/GreenwichAsia/SaigonAmerica/EnsenadaPacific/MidwayAmerica/JujuyAfrica/TimbuktuAmerica/BahiaAmerica/Goose_BayAmerica/VirginAmerica/PangnirtungAsia/KatmanduAmerica/PhoenixAfrica/NiameyAmerica/WhitehorsePacific/NoumeaAsia/TbilisiAmerica/MontrealAsia/MakassarAmerica/Argentina/San_JuanHongkongUCTAsia/NicosiaAmerica/Indiana/WinamacSystemV/MST7MDTAmerica/Argentina/ComodRivadaviaAmerica/Boa_VistaAmerica/GrenadaAustralia/DarwinAsia/KhandygaAsia/Kuala_LumpurAsia/ThimphuAsia/RangoonEurope/BratislavaAsia/CalcuttaAmerica/Argentina/TucumanAsia/KabulIndian/CocosJapanPacific/TongatapuAmerica/New_YorkEtc/GMT-12Etc/GMT-11Etc/GMT-10SystemV/YST9YDTEtc/GMT-14Etc/GMT-13W-SUAmerica/MeridaEETAmerica/RosarioCanada/SaskatchewanAmerica/St_KittsArctic/LongyearbyenAmerica/CaracasAmerica/GuadeloupeAsia/HebronIndian/KerguelenSystemV/PST8PDTAfrica/MonroviaAsia/Ust-NeraEgyptAsia/SrednekolymskAmerica/North_Dakota/New_SalemAsia/AnadyrAustralia/MelbourneAsia/IrkutskAmerica/ShiprockAmerica/WinnipegEurope/VaticanAsia/AmmanEtc/UTCSystemV/AST4ADTAsia/TokyoAmerica/TorontoAsia/SingaporeAustralia/LindemanAmerica/Los_AngelesSystemV/EST5EDTPacific/MajuroAmerica/Argentina/Buenos_AiresEurope/NicosiaPacific/GuadalcanalEurope/AthensUS/PacificEurope/Monaco"));
    }

    @SuppressWarnings("ConstantConditions") //because this is purpose of test
    @Test
    public void shouldThrowExceptionWhenAcronymIsNull() throws Exception {
        // expect
        exception.expect(IllegalArgumentException.class);

        // when
        DateUtils.getMonthNumberFromShortedName(null);
    }

    @Test
    public void shouldThrowExceptionWhenAcronymDoesNotMatchMonth() throws Exception {
        // expect
        exception.expect(IllegalArgumentException.class);

        // when
        DateUtils.getMonthNumberFromShortedName("Dominik");
    }

    @Test
    public void shouldReturn1WhenAcronymIsJan() {
        // when
        int monthNumber = DateUtils.getMonthNumberFromShortedName("Jan");

        // then
        assertThat(monthNumber).isEqualTo(1);
    }

    @Test
    public void shouldConvertJodaDateToJava8Date() throws Exception {
        // given
        final String date = "2016-11-30";
        org.joda.time.LocalDate jodaDate = LocalDate.parse(date);

        // when
        java.time.LocalDate java8Date = DateUtils.toJavaDate(jodaDate);

        // then
        assertThat(java8Date.toString()).isEqualTo(date);
    }

    @Test
    public void shouldConvertDateToLocalDate() throws Exception {
        // given
        Date date = new Date();

        // when
        final java.time.LocalDate localDate = DateUtils.convertDateToLocalDate(date);

        // then
        assertThat(localDate).isNotNull();
        System.out.println("java.util.Date: " + date);
        System.out.println("java.time.LocalDate: " + localDate);
    }

    @Test
    public void getDayOfTheYearShouldThrowIllegalArgumentExceptionForNull() throws Exception {
        // expect
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Date cannot be null.");
        // when
        final long days = getDayOfTheYearFor(null);

        // then
        assertThat(days).isEqualTo(1);
    }

    @Test
    public void getDayOfTheYearForShouldGetOneForFirstJanuary() throws Exception {
        // when
        final long days = getDayOfTheYearFor(of(2017, 1, 1));

        // then
        assertThat(days).isEqualTo(1);
    }

    @Test
    public void getDayOfTheYearForShouldGetOneForFirstFebruary() throws Exception {
        // when
        final long days = getDayOfTheYearFor(of(2017, 2, 1));

        // then
        assertThat(days).isEqualTo(32);
    }

    @Test
    public void getDayOfTheYearForShouldGet365ForLeapYear() throws Exception {
        // when
        final long days = getDayOfTheYearFor(of(2017, 12, 31));

        // then
        assertThat(days).isEqualTo(365);
    }

    @Test
    public void getDayOfTheYearForShouldGet366ForLeapYear() throws Exception {
        // given

        // when
        final long days = getDayOfTheYearFor(of(2016, 12, 31));

        // then
        assertThat(days).isEqualTo(366);
    }

    @Test
    public void countLeapYearBetweenShouldIllegalArgumentExceptionIfStartDateIsNull() throws Exception {
        // expect
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Start date cannot be null.");

        // when
        countLeapYearBetween(null, now());
    }

    @Test
    public void countLeapYearBetweenShouldIllegalArgumentExceptionIfEndDateIsNull() throws Exception {
        // expect
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("End date cannot be null.");

        // when
        countLeapYearBetween(now(), null);
    }

    @Test
    public void countLeapYearBetweenShouldThrowIllegalArgumentExceptionWhenEndDateIsBeforeStartDate() throws Exception {
        // expect
        exception.expect(IllegalArgumentException.class);

        // given
        final java.time.LocalDate start = java.time.LocalDate.of(2017, 12, 31);
        final java.time.LocalDate end = java.time.LocalDate.of(2015, 1, 1);

        // when
        countLeapYearBetween(start, end);
    }

    @Test
    public void countLeapYearBetweenShouldReturn1ForYearsBetween2016And2016() throws Exception {
        // given
        final java.time.LocalDate leapYear = java.time.LocalDate.of(2016, 1, 1);

        // when
        final long leapYearsCounter = countLeapYearBetween(leapYear, leapYear);

        // then
        assertThat(leapYearsCounter).isEqualTo(1);
    }

    @Test
    public void countLeapYearBetweenShouldReturn1ForYearsBetween2015And2017() throws Exception {
        // given
        final java.time.LocalDate start = java.time.LocalDate.of(2015, 1, 1);
        final java.time.LocalDate end = java.time.LocalDate.of(2017, 12, 31);

        // when
        final long leapYearsCounter = countLeapYearBetween(start, end);

        // then
        assertThat(leapYearsCounter).isEqualTo(1);
    }

    @Test
    public void countLeapYearBetweenShouldReturn5ForYearsBetween2000And2016() throws Exception {
        // given
        final java.time.LocalDate start = java.time.LocalDate.of(2000, 1, 1);
        final java.time.LocalDate end = java.time.LocalDate.of(2016, 12, 31);

        // when
        final long leapYearsCounter = countLeapYearBetween(start, end);

        // then
        assertThat(leapYearsCounter).isEqualTo(5);
    }

}
