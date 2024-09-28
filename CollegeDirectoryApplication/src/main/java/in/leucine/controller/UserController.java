package in.leucine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.leucine.dto.LoginRequest;
import in.leucine.dto.UserDTO;
import in.leucine.entity.User;
import in.leucine.service.UserService;
import in.leucine.utils.JwtUtil;

@RestController
@RequestMapping("/api/auth")
public class UserController {
	
	@Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil; 

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody UserDTO userDTO) {
        User user = userService.createUser(userDTO);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

//    @PostMapping("/login")
//    public ResponseEntity<String> loginUser(@RequestBody LoginRequest loginRequest) throws Exception {
//        User user = userService.authenticateUser(loginRequest.getUsername(), loginRequest.getPassword());
//        String jwtToken = generateJWT(user);  
//        return ResponseEntity.ok(jwtToken);
//    }

    private String generateJWT(User user) {
        return jwtUtil.generateToken(user); 
    }
}