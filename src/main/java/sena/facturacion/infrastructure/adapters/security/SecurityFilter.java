package sena.facturacion.infrastructure.adapters.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import sena.facturacion.application.service.AuthenticationService;
import sena.facturacion.application.service.TokenService;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    private TokenService tokenService;
    @Autowired
    private AuthenticationService authService;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
            var authHeader =request.getHeader("Authorization");
            if(authHeader != null){
                var token = authHeader.replace("Bearer","").trim();
                var userName = tokenService.getSubject(token);
                if(userName != null){
                    var user = authService.loadUserByUsername(userName);
                    var authentication = new UsernamePasswordAuthenticationToken(
                            user,null,user.getAuthorities());
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            }
            filterChain.doFilter(request, response);
    }
}
