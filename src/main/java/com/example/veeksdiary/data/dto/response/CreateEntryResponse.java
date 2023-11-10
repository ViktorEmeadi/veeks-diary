package com.example.veeksdiary.data.dto.response;


import lombok.*;

import java.time.LocalDateTime;

@Builder
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateEntryResponse {
    private String title;
    private String body;
    private LocalDateTime creationDate;
}
