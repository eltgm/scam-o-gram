package ru.sultanyarov.authserver.enums;

import com.google.common.collect.ImmutableMap;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Getter
@RequiredArgsConstructor
public enum SexEnum {
    MALE("male"),

    FEMALE("female");

    private final String value;


    private static final Map<String, SexEnum> defectStatusCodeImmutableMap =
            ImmutableMap.<String, SexEnum>builder()
                    .putAll(
                            Arrays.stream(SexEnum.values())
                                    .collect(Collectors.toMap(SexEnum::getValue, Function.identity()))
                    )
                    .build();

    public static SexEnum of(String name) {
        return Optional.ofNullable(defectStatusCodeImmutableMap.get(name))
                .orElseThrow(() -> new RuntimeException("Not found sex for code=" + name));
    }
}
