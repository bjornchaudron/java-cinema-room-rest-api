package cinema.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "cinema-room")
public record CinemaRoomProperties(
        int rows,
        int columns
) {
}
