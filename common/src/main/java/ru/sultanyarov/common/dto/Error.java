package ru.sultanyarov.common.dto;

public record Error(String applicationErrorCode, String debug, String message) {
}
