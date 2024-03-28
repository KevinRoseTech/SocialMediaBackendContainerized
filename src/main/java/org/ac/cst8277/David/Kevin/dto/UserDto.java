package org.ac.cst8277.David.Kevin.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long userId;
    private boolean producer;
    private boolean subscriber;
    //reminder:ask if I need to have a username field despite not doing so for assignment1
}

