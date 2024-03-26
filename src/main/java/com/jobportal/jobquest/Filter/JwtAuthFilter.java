package com.jobportal.jobquest.Filter;

// package com.admission.eduadmit_connect.Filter;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import com.jobportal.jobquest.Service.*;
import com.jobportal.jobquest.config.UserInfoUserDetailsService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;

@Component
public class JwtAuthFilter extends OncePerRequestFilter {
    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserInfoUserDetailsService userDetailsService;
    
    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
    throws ServletException, IOException
    {
        String authHeader = request.getHeader("Authorization");
        String token = null;
        String usermail = null;

        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            token = authHeader.substring(7);
            usermail = jwtService.extractUserMail(token);
        }

        if (usermail != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = userDetailsService.loadUserByUsername(usermail);
            if (jwtService.validateToken(token, userDetails)) {
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userDetails,
                        null, userDetails.getAuthorities());
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }
        filterChain.doFilter(request, response);
    }
}