package ra.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v4/test")
public class AdminController {
    @GetMapping("/admin")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<String> admin (){
        return ResponseEntity.ok("Welcome Admin come back App");
    }
    @GetMapping("/pm")
    @PreAuthorize("hasAuthority('PM')")
    public ResponseEntity<String> pm (){
        return ResponseEntity.ok("Welcome PM come back App");
    }
    @GetMapping("/user")
    @PreAuthorize("hasAuthority('USER')")
    public ResponseEntity<String> User (){
        return ResponseEntity.ok("Welcome User come back App");
    }
}
