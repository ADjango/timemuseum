package com.example.myazureapp.controller;

import java.io.IOException;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.myazureapp.entity.Role;
import com.example.myazureapp.entity.UploadFile;
import com.example.myazureapp.entity.User;
import com.example.myazureapp.entity.UserRole;
// import com.example.myazureapp.payload.response.JwtResponse;
// import com.example.myazureapp.payload.response.MessageResponse;
import com.example.myazureapp.repository.RoleRepository;
import com.example.myazureapp.repository.UserRepository;
import com.example.myazureapp.security.services.UserDetailsImpl;
// import com.example.myazureapp.utils.JWTUtils;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
// @CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/auth")
public class UserController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    // @Autowired
    // private JWTUtils jwtUtils;

    @Autowired
    private MongoTemplate mongoTemplate;

    // @PostMapping("/login")
    // public ResponseEntity<?> login(@RequestBody User user) {
    //     Authentication authentication = null;
    //     try {
    //         authentication = authenticationManager
    //                 .authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
    //     } catch (AuthenticationException e) {
    //         return new ResponseEntity<>("user not found", HttpStatus.UNAUTHORIZED);
    //     }

    //     SecurityContextHolder.getContext().setAuthentication(authentication);
    //     UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

    //     String jwtToken = jwtUtils.generateJwtToken(userDetails);

    //     List<String> roles = userDetails.getAuthorities().stream()
    //             .map(item -> item.getAuthority())
    //             .collect(Collectors.toList());

    //     return ResponseEntity.ok(new JwtResponse(jwtToken,
    //             userDetails.getId(),
    //             userDetails.getUsername(),
    //             userDetails.getEmail(),
    //             userDetails.getAvatarUrl(),
    //             roles));
    // }

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody User user) {
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());

        if (userRepository.existsByUsername(user.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body("Error: Username is already taken!");

        }

        User newUser = new User();
        newUser.setUsername(user.getUsername());
        newUser.setPassword(passwordEncoder.encode(user.getPassword()));

        Role defaultUserRole = roleRepository.findByName(UserRole.USER)
                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
        HashSet<Role> userRoles = new HashSet<>();
        userRoles.add(defaultUserRole);
        newUser.setRoles(userRoles);
        newUser.setCreateTime(new Date());

        userRepository.save(newUser);
        return ResponseEntity.ok("User registered successfully!");
    }

    @GetMapping(value = "/user/{userId}")
    public User getMethodName(@PathVariable String userId) {
        return userRepository.findById(userId).orElseThrow();
    }

    // @PostMapping(value="/user/update")
    // public ResponseEntity<?> postMethodName(@RequestParam String avatarFileId, @RequestHeader HttpHeaders headers) {
    //     String token = headers.get("authentication").get(0);
    //     String userId = jwtUtils.getUserIdFromToken(token);
    //     User user = userRepository.findById(userId).orElseThrow();
    //     user.setAvatarUrl(avatarFileId);
    //     userRepository.save(user);
    //     return ResponseEntity.ok(user.getAvatarUrl());
    // }

    @PostMapping(value = "/public/file/uploadFile")
    public ResponseEntity<?> postMethodName(@RequestParam("file") MultipartFile file) {
        UploadFile uploadFile = new UploadFile();
        UploadFile savedFile = new UploadFile();
        try {
            String originalFilename = file.getOriginalFilename();
            if (!StringUtils.hasText(originalFilename)) {
                return ResponseEntity.badRequest().body("参数错误");
            }
            uploadFile.setName(originalFilename);
            uploadFile.setCreatedTime(new Date());
            uploadFile.setContent(new Binary(file.getBytes()));
            uploadFile.setContentType(file.getContentType());
            uploadFile.setSize(file.getSize());
            savedFile = mongoTemplate.save(uploadFile);
        } catch (Exception e) {
            ResponseEntity.badRequest().body("文件上传异常");
        }
        return ResponseEntity.ok(String.valueOf(savedFile.getId()));
    }

    @GetMapping(value = "/public/file/image/{id}", produces = { MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE })
    public byte[] getImage(@PathVariable String id) throws IOException {
        byte[] data = null;
        UploadFile file = mongoTemplate.findById(id, UploadFile.class);
        if(file!=null){
            data = file.getContent().getData();
        }
        return data;
    }

}
