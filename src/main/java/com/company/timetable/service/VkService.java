package com.company.timetable.service;

import com.company.timetable.dto.education.Country;
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
import com.vk.api.sdk.objects.ServiceClientCredentialsFlowResponse;
import com.vk.api.sdk.objects.database.responses.GetCountriesResponse;

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

    private VkCredentials getVkCredentials() {
        try {
            TransportClient transportClient = HttpTransportClient.getInstance();
            VkApiClient vk = new VkApiClient(transportClient, new Gson(), 3);

            ServiceClientCredentialsFlowResponse authResponse = vk.oauth()
                    .serviceClientCredentialsFlow(appId, clientSecret)
                    .execute();

            Database vkDatabase = vk.database();
            ServiceActor actor = new ServiceActor(appId, authResponse.getAccessToken());

            return new VkCredentials(vkDatabase, actor);
        } catch (ApiException | ClientException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void updateDatabaseFromVk() {
        List<Country> countries = getCountries();
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
                countriesSize = countriesResponse.getItems().size();
                offset += MAX_COUNT;
                countriesResponse.getItems().forEach(country ->
                        countries.add(
                                new Country(country.getId(), country.getTitle())
                        ));
            } while (countriesSize > 0);
        } catch (ApiException | ClientException e) {
            e.printStackTrace();
        }

        return countries;
    }
}
