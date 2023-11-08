package konsalting.t1.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import konsalting.t1.service.Service;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    private final Service service;

    public Controller(Service service) {
        this.service = service;
    }

    @Operation(summary = "возвращает символ и его количество в строке",
            responses = @ApiResponse(
                    responseCode = "200",
                    description = "результат"
            ))
    @PostMapping("/str")
    public ResponseEntity<String> controller(@RequestParam String s) {
        return ResponseEntity.ok(service.helpMetod(s));
    }

}
