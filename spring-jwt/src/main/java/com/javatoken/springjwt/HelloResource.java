package com.javatoken.springjwt;

import com.javatoken.springjwt.Services.MyUserDetailsService;
import com.javatoken.springjwt.models.AuthenticationRequest;
import com.javatoken.springjwt.models.AuthenticationResponse;
import com.javatoken.springjwt.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloResource {

    // auto wired is a way to inject dependency. This is call annotation injection which eliminates getter and setters
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private MyUserDetailsService userDetailsService;

    @Autowired
    private JwtUtil jwtTokenUtil;

    @RequestMapping({ "/hello" })
    public String hello(){
        return "Hello Universe";
    }

    @RequestMapping("/helloworld")
    public String helloworld() {
        return "Hello world";
    }

    // taking the POST request
    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    // takes in the authentication request parsing the request, payload that has username and password
    public ResponseEntity<?> createAuthenticateionToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        try {
            // if the authentication fails then it will go catch block
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
            );
        } catch(BadCredentialsException e) {
            throw new Exception("Incorrect authentication", e);
            }

        // this detail will be gather through the service and generate the token
        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());

        // if the user was able to authenticate through, they are able to get a token
        final String jwt = jwtTokenUtil.generateToken(userDetails);

        // send ok reponse to the request
        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }
}
