package com.company.timetable.service;

import com.company.timetable.dao.education.ICityDao;
import com.company.timetable.dao.education.ICountryDao;
import com.company.timetable.dao.education.IEducationDao;
import com.company.timetable.dao.education.IEducationTypeDao;
import com.company.timetable.dao.education.IFacultyDao;
import com.company.timetable.dto.education.City;
import com.company.timetable.dto.education.Country;
import com.company.timetable.dto.education.Education;
import com.company.timetable.dto.education.EducationType;
import com.company.timetable.dto.education.Faculty;
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
import com.vk.api.sdk.objects.database.responses.GetFacultiesResponse;
import com.vk.api.sdk.objects.database.responses.GetSchoolsResponse;
import com.vk.api.sdk.objects.database.responses.GetUniversitiesResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VkService {

    private final Lang LANG = Lang.RU;
    private final Integer BELARUS_ID = 3;

    @Autowired
    private ICountryDao iCountryDao;
    @Autowired
    private ICityDao iCityDao;
    @Autowired
    private IEducationDao iEducationDao;
    @Autowired
    private IEducationTypeDao iEducationTypeDao;
    @Autowired
    private IFacultyDao iFacultyDao;

    @Value("${vk.app_id}")
    private Integer appId;
    @Value("${vk.client_secret}")
    private String clientSecret;
    @Value("${vk.access_token}")
    private String accessToken;

    public void updateEducationInfoFromVk() {
        VkCredentials vkCredentials = getVkCredentials();

        // Countries (allowed only Belarus)
        List<Country> newCountries =
                getCountries(vkCredentials)
                        .stream().filter(country -> country.getId().equals(BELARUS_ID))
                        .collect(Collectors.toList());

        // Cities for country
        newCountries.forEach(country -> {
            iCountryDao.save(country);

            List<City> newCities =
                    getCities(country.getId(), vkCredentials);
            iCityDao.saveAll(newCities);

            // Educations for city
            newCities.forEach(city -> {
                List<Education> newEducations =
                        getEducations(city.getId(), vkCredentials);
                iEducationDao.saveAll(newEducations);

                // Faculties for education
                newEducations.forEach(education -> {
                    List<Faculty> newFaculties =
                            getFaculties(education.getId(), vkCredentials);
                    iFacultyDao.saveAll(newFaculties);
                });
            });
        });
    }

    private VkCredentials getVkCredentials() {
        TransportClient transportClient = HttpTransportClient.getInstance();
        VkApiClient vk = new VkApiClient(transportClient, new Gson(), 10);

        Database vkDatabase = vk.database();
        ServiceActor actor = new ServiceActor(appId, clientSecret, accessToken);

        return new VkCredentials(vkDatabase, actor);
    }

    public List<Country> getCountries(VkCredentials vkCredentials) {
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
                                new Country(
                                        country.getId(),
                                        country.getTitle(),
                                        true
                                )
                        ));
                countriesSize = countriesResponse.getItems().size();
                offset += MAX_COUNT;
            } while (countriesSize > 0);
        } catch (ApiException | ClientException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }

        return countries;
    }

    public List<City> getCities(Integer countryId, VkCredentials vkCredentials) {
        List<City> cities = new ArrayList<>();

        try {
            int offset = 0;
            final Integer MAX_COUNT = 1000;
            Integer citiesSize;
            do {
                Country country = iCountryDao.getOne(countryId);
                GetCitiesResponse citiesResponse = vkCredentials.getVkDatabase()
                        .getCities(vkCredentials.getActor(), countryId)
                        .lang(LANG)
                        .needAll(true)
                        .count(MAX_COUNT)
                        .offset(offset)
                        .execute();
                citiesResponse.getItems().forEach(city ->
                        cities.add(
                                new City(
                                        city.getId(),
                                        city.getTitle(),
                                        true,
                                        country
                                )
                        ));
                citiesSize = citiesResponse.getItems().size();
                offset += MAX_COUNT;
            } while (citiesSize > 0);
        } catch (ApiException | ClientException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }

        return cities;
    }

    public List<Education> getEducations(Integer cityId, VkCredentials vkCredentials) {
        List<Education> educations = new ArrayList<>();

        try {
            int offset = 0;
            final Integer MAX_COUNT = 10000;
            Integer schoolsSize;
            Integer universitiesSize;
            do {
                City city = iCityDao.getOne(cityId);
                // Schools
                EducationType schoolEducationType =
                        iEducationTypeDao.findByTitle("school");

                GetSchoolsResponse schoolsResponse = vkCredentials.getVkDatabase()
                        .getSchools(vkCredentials.getActor(), cityId)
                        .lang(LANG)
                        .count(MAX_COUNT)
                        .offset(offset)
                        .execute();
                schoolsResponse.getItems().forEach(school ->
                        educations.add(
                                new Education(
                                        school.getId(),
                                        school.getTitle(),
                                        true,
                                        city,
                                        schoolEducationType
                                )
                        ));
                schoolsSize = schoolsResponse.getItems().size();

                // Universities
                EducationType universityEducationType =
                        iEducationTypeDao.findByTitle("university");

                GetUniversitiesResponse universitiesResponse = vkCredentials.getVkDatabase()
                        .getUniversities(vkCredentials.getActor())
                        .lang(LANG)
                        .count(MAX_COUNT)
                        .offset(offset)
                        .cityId(cityId)
                        .execute();
                universitiesResponse.getItems().forEach(university ->
                        educations.add(
                                new Education(
                                        university.getId(),
                                        university.getTitle(),
                                        true,
                                        city,
                                        universityEducationType
                                )
                        ));
                universitiesSize = universitiesResponse.getItems().size();
                // Educations
                offset += MAX_COUNT;
            } while (schoolsSize > 0 || universitiesSize > 0);
        } catch (ApiException | ClientException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }

        return educations;
    }

    public List<Faculty> getFaculties(Integer universityId, VkCredentials vkCredentials) {
        List<Faculty> faculties = new ArrayList<>();

        try {
            int offset = 0;
            final Integer MAX_COUNT = 10000;
            Integer facultiesSize;
            do {
                Education university = iEducationDao.getOne(universityId);
                GetFacultiesResponse
                        facultiesResponse = vkCredentials.getVkDatabase()
                        .getFaculties(vkCredentials.getActor(), universityId)
                        .lang(LANG)
                        .count(MAX_COUNT)
                        .offset(offset)
                        .execute();
                facultiesResponse.getItems().forEach(country ->
                        faculties.add(
                                new Faculty(
                                        country.getId(),
                                        country.getTitle(),
                                        true,
                                        university
                                )
                        ));
                facultiesSize = facultiesResponse.getItems().size();
                offset += MAX_COUNT;
            } while (facultiesSize > 0);
        } catch (ApiException | ClientException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }

        return faculties;
    }
}
