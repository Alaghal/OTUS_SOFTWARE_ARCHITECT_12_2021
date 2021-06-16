package otus.seryakov.myapp.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import otus.seryakov.myapp.domain.User;
import otus.seryakov.myapp.repository.UserRepository;
import otus.seryakov.myapp.service.UserService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    @Override
    public boolean addUser(User user) {
        var userFromRep = userRepository.findById(user.getId());
        var sb = new StringBuilder("Added User ");
        if (userFromRep.isPresent()) {
            sb.append(userFromRep.get());
            sb.append(" Current user is exist in DB");
            sb.append(" ");
            sb.append(LocalDate.now());
            log.info(sb.toString());
            return false;
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.saveAndFlush(user);
        sb.append(user);
        sb.append(" ");
        sb.append(LocalDate.now());
        log.info(sb.toString());
        return true;
    }

    @Override
    public boolean deleteUser(long id) {
        var userFromRep = userRepository.findById(id);

        if (!userFromRep.isPresent()) {
            log.info("User don't delete. Because user not exist in Db " + LocalDate.now());
            return false;
        }

        userRepository.deleteById(id);

        log.info("Delete " + userFromRep.get().toString() + " " + LocalDate.now());

        return true;
    }

    @Override
    public boolean updateUsers(User user) {
        var userFromRep = userRepository.findById(user.getId());

        if (!userFromRep.isPresent()) {
            return false;
        }

        userRepository.saveAndFlush(user);

        log.info("Edit  old version = " + userFromRep.get().toString() + ", new version =" + user.toString() + " " + LocalDate.now());

        return true;
    }

    @Override
    public User getUserById(long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public List<User> getAllUsers() {
        return Optional.of(userRepository.findAll()).orElse(new ArrayList<>());
    }


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(s);

        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return user;
    }
}
