package com.example.veeksdiary.data.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;


@Builder
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateEntryRequest {
    @NotBlank(message = "Title cannot be blank")
    private String title;
    @NotBlank(message = "Body cannot be blank")
    private String body;
}
