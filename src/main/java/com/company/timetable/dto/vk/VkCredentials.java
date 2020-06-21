package com.company.timetable.dto.vk;

import com.vk.api.sdk.actions.Database;
import com.vk.api.sdk.client.actors.ServiceActor;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class VkCredentials {

    private Database vkDatabase;
    private ServiceActor actor;
}
