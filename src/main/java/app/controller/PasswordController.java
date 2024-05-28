package app.controller;

import app.dto.BodyRequest;
import app.dto.FailResponse;
import app.service.PasswordService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/validate-password")
public class PasswordController {

    private final PasswordService service;

    public PasswordController(PasswordService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<FailResponse> validatePassword(@RequestBody BodyRequest request) {

        List<String> fails = service.validatePass(request.password());

        if(fails.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.badRequest().body(new FailResponse(fails));
    }
}
