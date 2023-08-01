package cinema.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record SeatDto(
        @JsonProperty("row") int row,
        @JsonProperty("column") int column
) {
}