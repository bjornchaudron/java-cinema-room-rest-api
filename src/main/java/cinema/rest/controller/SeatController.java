package cinema.rest.controller;

import cinema.domain.CinemaRoom;
import cinema.rest.dto.GetAvailableSeatsResponseDto;
import cinema.rest.dto.SeatDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SeatController {

    private final CinemaRoom cinemaRoom;

    public SeatController(CinemaRoom cinemaRoom) {
        this.cinemaRoom = cinemaRoom;
    }

    @GetMapping("/seats")
    public ResponseEntity<GetAvailableSeatsResponseDto> getAvailableSeats() {
        var response = new GetAvailableSeatsResponseDto(
                cinemaRoom.rows(),
                cinemaRoom.columns(),
                cinemaRoom.seats().stream().map(s -> new SeatDto(s.row(), s.column())).toList()
        );
        return ResponseEntity.ok(response);
    }
}
