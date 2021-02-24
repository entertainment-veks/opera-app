package opera.app.model.dto;

import opera.app.lib.annotation.EmailValidator;
import opera.app.lib.annotation.PasswordValidator;

@PasswordValidator.List({
        @PasswordValidator(
                field = "password",
                fieldMatch = "repeatPassword",
                message = "Password do not match"
        )
})
public class UserRequestDto {
    @EmailValidator
    private String email;
    private String password;
    private String repeatPassword;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepeatPassword() {
        return repeatPassword;
    }

    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }
}
