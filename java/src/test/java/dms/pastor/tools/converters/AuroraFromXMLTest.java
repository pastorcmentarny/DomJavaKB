package dms.pastor.tools.converters;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AuroraFromXMLTest {

    @Test
    void toJsonAcceptanceTest() {
        // given
        var xml = """
<!-- AuroraWatch API DTD version 0.2.5 -->
<!ELEMENT abbreviation (#PCDATA)>

<!ELEMENT activity (datetime,value?)>
<!ATTLIST activity status_id (green|yellow|amber|red) #REQUIRED>

<!ELEMENT altitude (#PCDATA)>

<!ELEMENT attribution (#PCDATA)>
<!ATTLIST attribution lang CDATA #REQUIRED>

<!ELEMENT avatar (url)>

<!ELEMENT color (#PCDATA)>

<!ELEMENT copyright (#PCDATA)>
<!ATTLIST copyright lang CDATA #REQUIRED>

<!ELEMENT current_status (updated,site_status*,message*)>
<!ATTLIST current_status api_version CDATA #REQUIRED>

<!ELEMENT data_location (#PCDATA)>

<!ELEMENT data_type (description+,summary_plot)>
<!ATTLIST data_type id ID #REQUIRED>
<!ATTLIST data_type project_id IDREF #REQUIRED>
<!ATTLIST data_type site_id IDREF #REQUIRED>
<!ATTLIST data_type type CDATA #REQUIRED>

<!ELEMENT datetime (#PCDATA)>

<!ELEMENT description (#PCDATA)>
<!ATTLIST description lang CDATA #REQUIRED>

<!ELEMENT end_datetime (datetime)>

<!ELEMENT expires (datetime)>

<!ELEMENT latitude (#PCDATA)>

<!ELEMENT license (#PCDATA)>
<!ATTLIST license lang CDATA #REQUIRED>

<!ELEMENT location (#PCDATA)>

<!ELEMENT longitude (#PCDATA)>

<!ELEMENT lower_threshold (#PCDATA)>
<!ATTLIST lower_threshold status_id (green|yellow|amber|red) #REQUIRED>

<!ELEMENT meaning (#PCDATA)>
<!ATTLIST meaning lang CDATA #REQUIRED>

<!-- Message description should not exceed 140 characters. 
     Aim to keep < 65 characters. Allow for multiple descriptions, one
     per language -->
<!ELEMENT message (expires,description+,url?)>
<!ATTLIST message id ID #REQUIRED>
<!ATTLIST message priority (high|low|test) #REQUIRED>

<!ELEMENT name (#PCDATA)>

<!ELEMENT project (name,abbreviation,url*,description*,site*)>
<!ATTLIST project api_version CDATA #REQUIRED>
<!ATTLIST project id ID #REQUIRED>
<!ATTLIST project url CDATA #REQUIRED>
<!ATTLIST project default (true|false) #IMPLIED>

<!ELEMENT project_list (project+)>
<!ATTLIST project_list api_version CDATA #REQUIRED>

<!ELEMENT start_datetime (datetime)>

<!ELEMENT site (location,abbreviation,url*,latitude,longitude,altitude?,start_datetime,end_datetime?,description*,copyright*,attribution*,license*,data_type*)>
<!ATTLIST site id ID #REQUIRED>
<!ATTLIST site project_id IDREF #REQUIRED>
<!ATTLIST site url CDATA #REQUIRED>
<!ATTLIST site default (true|false) #IMPLIED>

<!ELEMENT site_activity (lower_threshold+,updated,activity+,message*)>
<!ATTLIST site_activity api_version CDATA #REQUIRED>
<!ATTLIST site_activity project_id CDATA #REQUIRED>
<!ATTLIST site_activity site_id CDATA #REQUIRED>
<!ATTLIST site_activity site_url CDATA #REQUIRED>

<!ELEMENT site_status EMPTY>
<!ATTLIST site_status project_id CDATA #REQUIRED>
<!ATTLIST site_status site_id CDATA #REQUIRED>
<!ATTLIST site_status site_url CDATA #REQUIRED>
<!ATTLIST site_status status_id (green|yellow|amber|red) #REQUIRED>
<!ATTLIST site_status alerting (true|false) #IMPLIED>

<!ELEMENT status (color,description+,meaning+)>
<!ATTLIST status id (green|yellow|amber|red) #REQUIRED>

<!ELEMENT status_list (status+)>
<!ATTLIST status_list api_version CDATA #REQUIRED>

<!ELEMENT summary_plot (url_fstr+)>

<!ELEMENT system (name,url?,avatar?,description*,copyright*,attribution*,license*,system_plot_list)>
<!ATTLIST system api_version CDATA #REQUIRED>

<!ELEMENT system_plot (name,abbreviation,start_datetime,end_datetime?,description*,url_fstr+)>
<!ATTLIST system_plot id ID #REQUIRED>

<!ELEMENT system_plot_list (system_plot*)>

<!ELEMENT updated (datetime)>

<!ELEMENT url (#PCDATA)>

<!ELEMENT url_fstr (#PCDATA)>
<!ATTLIST url_fstr type (daily|rolling) #REQUIRED>

<!ELEMENT value (#PCDATA)>""";

        // when
        String result = AuroraFromXML.toJson(xml);

        // then
        System.out.println(result);
    }
}