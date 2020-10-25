package com.company.timetable.service;

import com.company.timetable.dto.education.City;
import com.company.timetable.dto.education.Country;
import com.company.timetable.dto.education.Education;
import com.company.timetable.dto.education.Faculty;
import com.company.timetable.dto.vk.VkCredentials;

import java.util.List;

public interface IVkService {

    VkCredentials getVkCredentials();

    void updateEducationInfoFromVk();

    List<Country> getCountries(VkCredentials vkCredentials);

    List<City> getCities(Integer countryId, VkCredentials vkCredentials);

    List<Education> getEducations(Integer cityId, VkCredentials vkCredentials);

    List<Faculty> getFaculties(Integer universityId, VkCredentials vkCredentials);
}
