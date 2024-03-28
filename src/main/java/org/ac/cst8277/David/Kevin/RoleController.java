package org.ac.cst8277.David.Kevin;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/roles")
public class RoleController {

    @GetMapping
    public ResponseEntity<Map<String, String>> getRoles() {
        Map<String, String> roles = new HashMap<>();
        roles.put("producer", "User can produce content");
        roles.put("subscriber", "User can subscribe to producers");
        return ResponseEntity.ok(roles);
    }
}
