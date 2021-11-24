package dom.coffirgar.transportmanager.services;

import dom.coffirgar.transportmanager.domain.Response;
import dom.coffirgar.transportmanager.domain.stations.Station;
import dom.coffirgar.transportmanager.exceptions.NotFoundException;
import dom.coffirgar.transportmanager.exceptions.SomethingWentWrongException;
import dom.coffirgar.transportmanager.mappers.ToResponseConverter;
import dom.coffirgar.transportmanager.mappers.ToStationConverter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import java.net.ConnectException;
import java.text.MessageFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import static dom.coffirgar.transportmanager.configurations.Constants.TM_DB_URL;
import static java.text.MessageFormat.format;

//TODO test with WebClient
@Slf4j
@Service
public class TubeGateway {

    private final RestTemplate restTemplate;
    private final ToStationConverter converter;
    private final ToResponseConverter responseConverter;

    @Autowired
    public TubeGateway(RestTemplate restTemplate, ToStationConverter converter, ToResponseConverter responseConverter) {
        this.restTemplate = restTemplate;
        this.converter = converter;
        this.responseConverter = responseConverter;
    }


    public String getAllStations() {

        ResponseEntity<String> response
                = restTemplate.getForEntity(TM_DB_URL + "/tube/stations/", String.class);

        log.info(response.getStatusCode().toString());

        return response.getBody();

    }

    public List<String> getAllStationsNames() {
        final var allStations = getAllStations();
        return converter.fromStationsAsJson(allStations).getStations().stream().map(Station::getName).collect(Collectors.toList());
    }

    public Response getStation(String stationName) {
        log.info("Getting Station data from TubeGateway for " + stationName);
        try {
            ResponseEntity<String> response
                    = restTemplate.getForEntity(TM_DB_URL + "/tube/station/" + stationName, String.class);
            log.info("Got response with status: " + response.getStatusCode());
            try {
                final Station station = converter.fromStationAsJson(response.getBody());
                System.out.println("STATION: " + station);
                if (station.isNotAStation()) {
                    System.out.println("NOT FOUND");
                    return Response.notFound(stationName);
                }
                return Response.ok(station);
            } catch (SomethingWentWrongException somethingWentWrongException) {
                return Response.error(somethingWentWrongException.getMessage());
            }
        } catch (HttpStatusCodeException exception) {
            if (exception.getStatusCode().series() == HttpStatus.Series.SERVER_ERROR) {
                return Response.error("Unable to get station due to server error: " + exception.getStatusCode().getReasonPhrase());
            } else if (exception.getStatusCode()
                    .series() == HttpStatus.Series.CLIENT_ERROR) {
                if (exception.getStatusCode() == HttpStatus.NOT_FOUND) {
                    return Response.notFound(stationName);
                } else {
                    return Response.error("Unable to get station due to server error: " + exception.getStatusCode().getReasonPhrase());
                }
            }
        }  catch (ResourceAccessException resourceAccessException){
            log.error("Database is offline : " + resourceAccessException.getMessage());
            return Response.error("Database is offline : " + resourceAccessException.getMessage());
        }
        catch (Exception exception)        {
            log.error("Database is offline : " + exception.getMessage());
        }
        return Response.error("shouldn't get here");
    }


    public boolean updateToPassed(String stationName) {
        ResponseEntity<String> response
                = restTemplate.getForEntity(TM_DB_URL + "/tube/station/passed/" + stationName + "/" + LocalDate.now(), String.class);
        return response.getStatusCode().is2xxSuccessful();
    }

    public void updateStatusFor(Station station) {
        log.info(format("Updating status to {0} for {1}", station.getStatus(), station.getName()));
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        final String stationAsJson = converter.toStationAsJson(station);
        HttpEntity<?> entity = new HttpEntity<Object>(stationAsJson, headers);
        try {
            final ResponseEntity<String> response = restTemplate.exchange(TM_DB_URL + "/tube/update", HttpMethod.POST, entity, String.class);
            log.info(response.getBody());
        } catch (HttpStatusCodeException exception) {
            log.error("Unable to update station as response back with code " + exception.getStatusCode()+ exception.getMessage());
            if (exception.getStatusCode().series() == HttpStatus.Series.SERVER_ERROR) {
                throw new SomethingWentWrongException("Unable to get station due to server error: " + exception.getStatusCode().getReasonPhrase());
            } else if (exception.getStatusCode()
                    .series() == HttpStatus.Series.CLIENT_ERROR) {
                if (exception.getStatusCode() == HttpStatus.NOT_FOUND) {
                    throw new NotFoundException("Station " + station.getName());
                } else {
                    throw new SomethingWentWrongException("Unable to get station due to server error: " + exception.getStatusCode().getReasonPhrase());
                }
            }
        }


    }
}
