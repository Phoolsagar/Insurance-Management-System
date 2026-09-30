package com.insurance.security;
import com.insurance.repository.UserRepository; import jakarta.servlet.*; import jakarta.servlet.http.*; import org.springframework.security.authentication.UsernamePasswordAuthenticationToken; import org.springframework.security.core.authority.SimpleGrantedAuthority; import org.springframework.security.core.context.SecurityContextHolder; import org.springframework.stereotype.Component; import org.springframework.web.filter.OncePerRequestFilter; import java.util.List;
@Component public class JwtFilter extends OncePerRequestFilter {
 private final JwtService jwt; private final UserRepository users;
 public JwtFilter(JwtService j,UserRepository u){jwt=j;users=u;}
 protected void doFilterInternal(HttpServletRequest req,HttpServletResponse res,FilterChain chain)throws ServletException,java.io.IOException{
  String h=req.getHeader("Authorization");
    if(h!=null&&h.startsWith("Bearer ")){String t=h.substring(7);try{String email=jwt.email(t);var u=users.findByEmail(email).orElse(null);if(u!=null&&jwt.valid(t)){var a=new UsernamePasswordAuthenticationToken(email,null,List.of(new SimpleGrantedAuthority("ROLE_"+u.getRole().name())));SecurityContextHolder.getContext().setAuthentication(a);}}catch(Exception ignored){}}
  chain.doFilter(req,res);
 }
}
