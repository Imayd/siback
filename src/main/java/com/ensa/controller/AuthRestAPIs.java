package com.ensa.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ensa.entities.Role;
import com.ensa.entities.RoleName;
import com.ensa.entities.User;
import com.ensa.jwtAuthentication.message.request.LoginForm;
import com.ensa.jwtAuthentication.message.request.SignUpForm;
import com.ensa.jwtAuthentication.message.response.JwtResponse;
import com.ensa.jwtAuthentication.message.response.MessageResponse;
import com.ensa.jwtAuthentication.repository.RoleRepository;
import com.ensa.jwtAuthentication.repository.UserRepository;
import com.ensa.jwtAuthentication.security.jwt.JwtProvider;
import com.ensa.jwtAuthentication.security.services.UserPrinciple;

//@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthRestAPIs {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtProvider jwtProvider;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginForm loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtProvider.generateJwtToken(authentication);
        UserPrinciple userDetails = (UserPrinciple) authentication.getPrincipal();		
		List<String> roles = userDetails.getAuthorities().stream()
				.map(item -> item.getAuthority())
				.collect(Collectors.toList());

		return ResponseEntity.ok(new JwtResponse(jwt, 
												 userDetails.getId(), 
												 userDetails.getUsername(), 
												 userDetails.getEmail(), 
												 roles));
    }

    @SuppressWarnings("unchecked")
	@PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpForm signUpRequest) {
        if(userRepository.existsByUsername(signUpRequest.getUsername())) {
            return new ResponseEntity("Fail -> Username is already taken!",
                    HttpStatus.BAD_REQUEST);
        }

        if(userRepository.existsByEmail(signUpRequest.getEmail())) {
            return new ResponseEntity("Fail -> Email is already in use!",
                    HttpStatus.BAD_REQUEST);
        }

        // Creating user's account
        User user = new User(signUpRequest.getName(), signUpRequest.getUsername(),
                signUpRequest.getEmail(), encoder.encode(signUpRequest.getPassword()));

        
        Set<String> strRoles = new HashSet<String>();
        strRoles.add(signUpRequest.getRole());
        Set<Role> roles = new HashSet<Role>();
        System.out.println(roles);

        strRoles.forEach(role -> {
        	
        	
        	/*
	    		if(role == "admin") {
	    			Role adminRole = null;
					try {
						adminRole = (Role) roleRepository.findByName(RoleName.ROLE_ADMIN)
						.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
					} catch (Throwable e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	    			roles.add(adminRole);
	    		}else if(role == "etudiant") {
	    				Role etudiantRole = null;
						try {
							etudiantRole = (Role) roleRepository.findByName(RoleName.ROLE_ETUDIANT)
							    .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
						} catch (Throwable e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
	    	            	roles.add(etudiantRole);
	    		}else if(role== "enseignant") {
	    			Role enseigantRole = null;
					try {
						enseigantRole = (Role) roleRepository.findByName(RoleName.ROLE_ENSEIGNANT)
						        .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
					} catch (Throwable e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	    	            	roles.add(enseigantRole);
	    		}else {
	    			
	        		Role internauteRole = null;
					try {
						internauteRole = (Role) roleRepository.findByName(RoleName.ROLE_INTERNAUTE)
						.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
					} catch (Throwable e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	        		roles.add(internauteRole); 
	    		}*/
        	System.out.println(role);
        	
        	switch(role) {
    		case "admin":
    			Role adminRole = roleRepository.findByName(RoleName.ROLE_ADMIN)
                .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not found."));
    			roles.add(adminRole);
    			
    			break;
    		case "etudiant":
            	Role etudiantRole = roleRepository.findByName(RoleName.ROLE_ETUDIANT)
                .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not found."));
            	roles.add(etudiantRole);
            	
    			break;
    		case "enseignant":
            	Role enseignantRole = roleRepository.findByName(RoleName.ROLE_ENSEIGNANT)
                .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not found."));
            	roles.add(enseignantRole);
            	
    			break;
    			
    		default:
        		Role userRole = roleRepository.findByName(RoleName.ROLE_INTERNAUTE)
                .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not found."));
        		roles.add(userRole);        			
    	}
        	}
        );
        
        user.setRoles(roles);
        userRepository.save(user);

        System.out.println(user);
        //return ResponseEntity.ok().body("User registered successfully!");
        //return ResponseEntity.ok().body(user);
        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
        
    }
}