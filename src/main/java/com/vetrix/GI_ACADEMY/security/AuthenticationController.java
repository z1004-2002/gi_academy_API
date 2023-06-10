package com.vetrix.GI_ACADEMY.security;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/authentication")
@CrossOrigin("*")
@Tag(name = "Authentication")
public class AuthenticationController {
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping(path = "/enseignant")
    public AuthResponse generateToken(@RequestBody AuthRequest authRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword())
            );
        } catch (Exception ex) {
            throw new Exception("inavalid email/password");
        }
        return new AuthResponse(jwtUtil.generateToken(authRequest.getEmail()),"Welcome Teacher");
    }

    /*@PostMapping(path = "/admin")
    public AuthResponse getTokenAdmin(@RequestBody AuthRequest authRequest) throws Exception {
        try{
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getEmail(),authRequest.getPassword())
            );
        }catch (Exception ex) {
            throw new Exception("inavalid email/password");
        }
        return new AuthResponse(jwtUtil.generateToken(authRequest.getEmail()),"Welcome Admin" );
    }*/
}
