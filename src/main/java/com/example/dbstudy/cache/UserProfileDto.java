package com.example.dbstudy.cache;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class UserProfileDto {
    @JsonProperty
    private String name;
    @JsonProperty
    private int age;

    public static UserProfileDto of(String name, int age) {
        UserProfileDto dto = new UserProfileDto();
        dto.name = name;
        dto.age = age;
        return dto;
    }
}
