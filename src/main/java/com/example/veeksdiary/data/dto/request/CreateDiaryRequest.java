package com.example.veeksdiary.data.dto.request;
import jakarta.validation.constraints.NotBlank;
import lombok.*;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CreateDiaryRequest {
    @NotBlank(message = "Name cannot be blank")
    private String name;
    private String email;
    @NotBlank(message = "Password cannot be blank")
    private String password;
}
