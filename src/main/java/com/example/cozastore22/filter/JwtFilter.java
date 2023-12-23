package com.example.cozastore22.filter;

import com.example.cozastore22.utils.JwtHelper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Service
public class JwtFilter extends OncePerRequestFilter {
@Autowired
private JwtHelper jwtHelper;
private Gson gson = new Gson();
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authen = request.getHeader("Authorization");

        // TODO: Fix here
        authen = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJbe1wicm9sZVwiOlwiUk9MRV9BRE1JTlwifV0iLCJleHAiOjE3MDMzNTMxMDF9.ESvr6WzQXW-W53NGsExWHoNRuPydL4iYVPvfhInftbw";

        if(authen != null && authen.startsWith("Bearer ")){
            String token = authen.substring(7);
            if(!token.isEmpty()){
                try {
                    String data = jwtHelper.validayToken(token);
                    System.out.println("kiemtra 1" + data);
                    Type listType = new TypeToken<ArrayList<SimpleGrantedAuthority>>(){}.getType();
                    List<SimpleGrantedAuthority> roles = gson.fromJson(data,listType);

//                   List<GrantedAuthority> roles = new ArrayList<>();
//                   SimpleGrantedAuthority authority = new SimpleGrantedAuthority("ROLE_ADMIN");
//                   roles.add(authority);
                   UsernamePasswordAuthenticationToken tokenAuthen = new UsernamePasswordAuthenticationToken("","",roles);

                    SecurityContext context = SecurityContextHolder.getContext();
                    context.setAuthentication(tokenAuthen);

                    System.out.println("kiemtra 2" + data);
                }catch (Exception e){
                    System.out.println("Lỗi giải mã token " + e.getLocalizedMessage());
                }
            }
        }
       // System.out.println("kiemtra authen " + authen);
        filterChain.doFilter(request,response);
    }
}
