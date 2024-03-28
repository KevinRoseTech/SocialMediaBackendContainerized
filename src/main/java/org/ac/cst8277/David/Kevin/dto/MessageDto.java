package org.ac.cst8277.David.Kevin.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageDto {
    private Long messageId;
    private String messageContent;
    private Long userId;
}
