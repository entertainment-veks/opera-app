package hibernate.model.dto;

import hibernate.lib.annotation.EmailValidator;
import jakarta.validation.constraints.NotNull;

public class UserResponseDto {
    @NotNull
    private Long id;
    @EmailValidator
    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
