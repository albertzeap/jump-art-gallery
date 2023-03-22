package com.cognixia.jump.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.cognixia.jump.service.MyUserDetailsService;
import com.cognixia.jump.util.JwtUtil;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {

    @Autowired
    private MyUserDetailsService userDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        // the header that contains our jwt info from the request
        final String authorizationHeader = request.getHeader("Authorization");

        String jwt = null;
        String username = null;

        // if the header was null, no jwt was sent
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            
            // token exists, grab the actual part of the string
            jwt = authorizationHeader.substring(7);

            //grab the username 
            username = jwtUtil.extractUsername(jwt);
        }

        // if we found the user and not already in the security context...
        if(username != null && SecurityContextHolder.getContext().getAuthentication() == null){

            // load in the user details
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);

            // check if token is valid based on the given user and as long as token is not expired 
            if (jwtUtil.validateToken(jwt, userDetails)) {
                
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
						new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
				
				usernamePasswordAuthenticationToken.setDetails(
						new WebAuthenticationDetailsSource().buildDetails(request) );
				
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }
        }

        filterChain.doFilter(request, response);



    }
    
}
