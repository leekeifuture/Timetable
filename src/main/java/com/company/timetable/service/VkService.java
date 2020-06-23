package com.company.timetable.service;

import com.company.timetable.dto.education.City;
import com.company.timetable.dto.education.Country;
import com.company.timetable.dto.education.Education;
import com.company.timetable.dto.vk.VkCredentials;
import com.google.gson.Gson;
import com.vk.api.sdk.actions.Database;
import com.vk.api.sdk.client.Lang;
import com.vk.api.sdk.client.TransportClient;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.ServiceActor;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.httpclient.HttpTransportClient;
import com.vk.api.sdk.objects.database.responses.GetCitiesResponse;
import com.vk.api.sdk.objects.database.responses.GetCountriesResponse;
import com.vk.api.sdk.objects.database.responses.GetSchoolsResponse;
import com.vk.api.sdk.objects.database.responses.GetUniversitiesResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VkService {

    private final Lang LANG = Lang.RU;

    @Value("${vk.app_id}")
    private Integer appId;
    @Value("${vk.client_secret}")
    private String clientSecret;
    @Value("${vk.access_token}")
    private String accessToken;

    private VkCredentials getVkCredentials() {
        TransportClient transportClient = HttpTransportClient.getInstance();
        VkApiClient vk = new VkApiClient(transportClient, new Gson(), 3);

        Database vkDatabase = vk.database();
        ServiceActor actor = new ServiceActor(appId, clientSecret, accessToken);

        return new VkCredentials(vkDatabase, actor);
    }

    public void updateDatabaseFromVk() {
        List<Country> countries = getCountries();
        List<City> cities = getCities(3);
        List<Education> educations = getEducations(281);
    }

    public List<Country> getCountries() {
        VkCredentials vkCredentials = getVkCredentials();
        List<Country> countries = new ArrayList<>();

        try {
            int offset = 0;
            final Integer MAX_COUNT = 1000;
            Integer countriesSize;
            do {
                GetCountriesResponse countriesResponse = vkCredentials.getVkDatabase()
                        .getCountries(vkCredentials.getActor())
                        .lang(LANG)
                        .needAll(true)
                        .count(MAX_COUNT)
                        .offset(offset)
                        .execute();
                countriesResponse.getItems().forEach(country ->
                        countries.add(
                                new Country(country.getId(), country.getTitle())
                        ));
                countriesSize = countriesResponse.getItems().size();
                offset += MAX_COUNT;
            } while (countriesSize > 0);
        } catch (ApiException | ClientException e) {
            e.printStackTrace();
        }

        return countries;
    }

    public List<City> getCities(Integer countryId) {
        VkCredentials vkCredentials = getVkCredentials();
        List<City> cities = new ArrayList<>();

        try {
            int offset = 0;
            final Integer MAX_COUNT = 1000;
            Integer citiesSize;
            do {
                GetCitiesResponse citiesResponse = vkCredentials.getVkDatabase()
                        .getCities(vkCredentials.getActor(), countryId)
                        .lang(LANG)
                        .needAll(true)
                        .count(MAX_COUNT)
                        .offset(offset)
                        .execute();
                citiesResponse.getItems().forEach(city ->
                        cities.add(
                                new City(city.getId(), city.getTitle())
                        ));
                citiesSize = citiesResponse.getItems().size();
                offset += MAX_COUNT;
            } while (citiesSize > 0);
        } catch (ApiException | ClientException e) {
            e.printStackTrace();
        }

        return cities;
    }

    public List<Education> getEducations(Integer cityId) {
        VkCredentials vkCredentials = getVkCredentials();
        List<Education> educations = new ArrayList<>();

        try {
            int offset = 0;
            final Integer MAX_COUNT = 10000;
            Integer schoolsSize;
            Integer universitiesSize;
            do {
                // Schools
                GetSchoolsResponse schoolsResponse = vkCredentials.getVkDatabase()
                        .getSchools(vkCredentials.getActor(), cityId)
                        .lang(LANG)
                        .count(MAX_COUNT)
                        .offset(offset)
                        .execute();
                schoolsResponse.getItems().forEach(city ->
                        educations.add(
                                new Education(city.getId(), city.getTitle())
                        ));
                schoolsSize = schoolsResponse.getItems().size();
                // Universities
                GetUniversitiesResponse universitiesResponse = vkCredentials.getVkDatabase()
                        .getUniversities(vkCredentials.getActor())
                        .lang(LANG)
                        .count(MAX_COUNT)
                        .offset(offset)
                        .cityId(cityId)
                        .execute();
                universitiesResponse.getItems().forEach(city ->
                        educations.add(
                                new Education(city.getId(), city.getTitle())
                        ));
                universitiesSize = universitiesResponse.getItems().size();
                // Educations
                offset += MAX_COUNT;
            } while (schoolsSize > 0 || universitiesSize > 0);
        } catch (ApiException | ClientException e) {
            e.printStackTrace();
        }

        return educations;
    }
}
