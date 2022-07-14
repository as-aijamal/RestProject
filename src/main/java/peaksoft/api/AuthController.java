package peaksoft.api;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import peaksoft.dto.request.AuthRequest;
import peaksoft.dto.response.AuthResponse;
import peaksoft.service.AuthService;

import javax.annotation.security.PermitAll;

@RestController
@RequestMapping("/api/authentication")
@AllArgsConstructor
public class AuthController {

        private final AuthService authService;

        @PostMapping
        @PermitAll
        public AuthResponse authenticate(@RequestBody AuthRequest authRequest) {
            return authService.authenticate(authRequest);
        }
}
