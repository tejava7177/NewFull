package org.example.service;

import org.example.model.ApplicationUser;
import org.example.repository.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private ApplicationUserRepository applicationUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        ApplicationUser applicationUser = applicationUserRepository.findByUsername(username);

        if(applicationUser == null){
            throw new UsernameNotFoundException("No user with " + username + " exists in the system");

        }

        return User.builder()
                .username(applicationUser.getUsername())
                .password(applicationUser.getPassword())
                .disabled(!applicationUser.isVerified())
                .accountExpired(applicationUser.isAccountCredentialsExpired())
                .accountLocked(applicationUser.isLocked())
                .roles("USER")
                .build();
    }
}
