package Sabra_Talkies.controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import Sabra_Talkies.models.*;
import Sabra_Talkies.payload.request.UpdateProfileRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import Sabra_Talkies.payload.request.LoginRequest;
import Sabra_Talkies.payload.request.SignupRequest;
import Sabra_Talkies.payload.response.JwtResponse;
import Sabra_Talkies.payload.response.MessageResponse;
import Sabra_Talkies.repository.RoleRepository;
import Sabra_Talkies.repository.UserRepository;
import Sabra_Talkies.security.jwt.JwtUtils;
import Sabra_Talkies.security.services.UserDetailsImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

		//Reject Login if admin rejected user
		Optional<User> existingUser = userRepository.findByUsername(loginRequest.getUsername());
			if (existingUser.get().getRejectedByAdmin() == true) {
				return ResponseEntity
						.badRequest()
						.body(new MessageResponse("Error:User Rejected By Admin!Register Again"));
			}
		//Reject Login if admin didnt accept user
		if (existingUser.get().getAcceptedByAdmin() == false) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error:User not accepted By Admin!Wait some time !!"));
		}

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);
		
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();		
		List<String> roles = userDetails.getAuthorities().stream()
				.map(item -> item.getAuthority())
				.collect(Collectors.toList());

		return ResponseEntity.ok(new JwtResponse(jwt, 
												 userDetails.getId(),
												 userDetails.getFirstname(),
												 userDetails.getLastname(),
												 userDetails.getGender(),
												 userDetails.getBirthOfDate(),
												 userDetails.getDistrict(),
												 userDetails.getUsername(), 
												 userDetails.getEmail(),
												 userDetails.getAcademicYear(),
												 userDetails.getFacultyName(),
												 userDetails.getDepartmentName(),
												 userDetails.getAcceptedByAdmin(),
												 userDetails.getRejectedByAdmin(),
												 roles));
	}

	@PostMapping("/adduser")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Username is already taken!"));
		}

		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Email is already in use!"));
		}

		// Create new user's account
		User user = new User(
				signUpRequest.getFirstname(),
				signUpRequest.getLastname(),
				signUpRequest.getGender(),
				signUpRequest.getBirthOfDate(),
				signUpRequest.getDistrict(),
				signUpRequest.getUsername(),
				signUpRequest.getEmail(),
				encoder.encode(signUpRequest.getPassword()),
				signUpRequest.getAcademicYear(),
				signUpRequest.getFacultyName(),
				signUpRequest.getDepartmentName(),
				signUpRequest.getAcceptedByAdmin(),
				signUpRequest.getRejectedByAdmin(),
				signUpRequest.getResetPasswordToken());

		Set<String> strRoles = signUpRequest.getRole();
		Set<Role> roles = new HashSet<>();

			strRoles.forEach(role -> {
				switch (role) {

				case "student":
					Role studentRole = roleRepository.findByName(ERole.ROLE_STUDENT)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(studentRole);
					break;

				case "admin":
					Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(adminRole);
					break;
				}
			});

		user.setRoles(roles);
		userRepository.save(user);
		return ResponseEntity.ok(new MessageResponse("User Added successfully!"));
	}

	@GetMapping("/allusers")
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}


	@PutMapping("/updateprofile")
	ResponseEntity<?> UpdateUserProfile(@Valid @RequestBody UpdateProfileRequest updateProfileRequest){

		User existingUser = userRepository.findByEmail(updateProfileRequest.getEmail());

		existingUser.setFirstname(updateProfileRequest.getFirstname());
		existingUser.setLastname(updateProfileRequest.getLastname());
		existingUser.setGender(updateProfileRequest.getGender());
		existingUser.setBirthOfDate(updateProfileRequest.getBirthOfDate());
		existingUser.setDistrict(updateProfileRequest.getDistrict());
		existingUser.setEmail(updateProfileRequest.getEmail());
		existingUser.setPassword(encoder.encode(updateProfileRequest.getPassword()));
		existingUser.setAcademicYear(updateProfileRequest.getAcademicYear());
		existingUser.setFacultyName(updateProfileRequest.getFacultyName());
		existingUser.setDepartmentName(updateProfileRequest.getDepartmentName());

		User result = userRepository.save(existingUser);

		return ResponseEntity.ok(new MessageResponse("User Updated successfully!"));
	}

	//UserAcceptedByAdmin
	@PutMapping("/acceptedByAdmin/{id}")
	ResponseEntity<?> userAcceptedByAdmin( @RequestParam("acceptedByAdmin") Boolean acceptedByAdmin , @PathVariable Long id) {
		Optional<User> existingUser = userRepository.findById(id);
		existingUser.ifPresent((User user) -> {
			user.setAcceptedByAdmin(acceptedByAdmin);
			userRepository.save(user);
		});
		return ResponseEntity.ok().build();
	}

	//UserRejectedByAdmin
	@PutMapping("/rejectedByAdmin/{id}")
	ResponseEntity<?> userDeletedByAdmin( @RequestParam("rejectedByAdmin") Boolean rejectedByAdmin , @PathVariable Long id) {
		Optional<User> existingUser = userRepository.findById(id);
		existingUser.ifPresent((User user) -> {
			user.setRejectedByAdmin(rejectedByAdmin);
			userRepository.save(user);
		});
		return ResponseEntity.ok().build();
	}
}
