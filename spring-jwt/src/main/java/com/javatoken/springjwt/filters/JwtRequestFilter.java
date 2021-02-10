package com.javatoken.springjwt.filters;

import com.javatoken.springjwt.Services.MyUserDetailsService;
import com.javatoken.springjwt.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOError;
import java.io.IOException;
import java.rmi.ServerException;

// filter to intercept the request
@Component
public class JwtRequestFilter extends OncePerRequestFilter {

    @Autowired
    private MyUserDetailsService userDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    // it has opiton of passing the chain, examines the http request and see if the JWT is valid
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServerException, IOException, ServletException {
        // header should have authorization property
        final String authorizationHeader = request.getHeader("Authorization");
        String username = null;
        String jwt = null;

        // if the incoming header is not null and starts with Bearer then this if logic hits
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            // cetting the jwt from the header through substring method
            jwt = authorizationHeader.substring(7);
            // injecting the jwtUtil method in the class and extracting the username
            username = jwtUtil.extractionUserName(jwt);
        }
        // if the user name is found and is in the list then load the user by its detail
        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
            // if its not expired
            if (jwtUtil.validateToken(jwt, userDetails)) {

                // create the default token using the username and password
                // if its valid then authentication process takes place
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities());
                usernamePasswordAuthenticationToken
                        .setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);

            }
        }
        chain.doFilter(request, response);



    }
}
