package com.example.veeksdiary.data.dto.response;

import lombok.*;

import java.time.LocalDateTime;

@Builder
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateDiaryResponse {
    private String name;
    private String email;
    private Long id;
    private LocalDateTime creationDate;
}
