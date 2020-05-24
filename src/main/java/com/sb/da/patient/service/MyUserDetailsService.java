package com.sb.da.patient.service;

import com.sb.da.patient.entity.MyUserDetails;
import com.sb.da.patient.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.concurrent.ExecutionException;
@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    FirebaseService firebaseService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<User> user = null;
        try {
            user = Optional.ofNullable(firebaseService.getUserDetails(s));

        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        user.orElseThrow(() -> new UsernameNotFoundException("User Not found:" +
                " " + s));

        return user.map(MyUserDetails::new).get();
    }
}
