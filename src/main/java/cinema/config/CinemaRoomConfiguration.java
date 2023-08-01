package cinema.config;

import cinema.config.properties.CinemaRoomProperties;
import cinema.domain.CinemaRoom;
import cinema.domain.Seat;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableConfigurationProperties(CinemaRoomProperties.class)
public class CinemaRoomConfiguration {

    @Bean
    public CinemaRoom cinemaRoom(CinemaRoomProperties properties) {
        List<Seat> seats = new ArrayList<>();
        for (int r = 0; r < properties.rows(); r++) {
            for (int c = 0; c < properties.columns(); c++) {
                seats.add(new Seat(r + 1, c + 1));
            }
        }
        return new CinemaRoom(properties.rows(), properties.columns(), seats);
    }
}
