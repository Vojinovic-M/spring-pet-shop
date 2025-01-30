package com.example.backend.configuration;

import com.example.backend.repositories.IUserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
public class ApplicationConfiguration {
    private final IUserRepository userRepository;

    public ApplicationConfiguration(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Bean
    UserDetailsService userDetailsService() {
        return username -> userRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
    }


    @Bean
    BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }
}
////    public static class PasswordHasher {
////        public static void main(String[] args) {
////            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
////
////            // Plain-text passwords
////            String[] passwords = {
////                    "matejmatej", "markomarko", "lukaluka", "jovanjovan",
////                    "darkodarko", "aksentije", "bogdanbogdan",
////                    "cvetolik", "dragoslav", "radasin", "petarpetar"
////            };
////
////            // Hash each password
////            for (String password : passwords) {
////                System.out.println("Plain: " + password + " -> Hashed: " + encoder.encode(password));
////            }
////        }
//    }
