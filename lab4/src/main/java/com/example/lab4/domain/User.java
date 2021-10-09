package com.example.lab4.domain;

import lombok.*;

import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "id")
public class User {
    @NotNull(message = "Id cannot be null")
    @Min(value = 0, message = "id cannot be less then 0")
    private Long id;

    @NonNull
    @NotBlank(message = "This field cannot be blank")
    private String username;

    @NonNull
    @NotBlank(message = "This field cannot be blank")
    @Size(min = 6, message = "Password should be at least 6 characters")
    private String password;

    @Pattern(regexp = "^(.+)@(.+)$", message = "Email should matches *@.* pattern")
    private String email;

    private String roles;

    private String authorities;

    public User(String username, String password, String roles, String authorities) {
        this.username = username;
        this.password = password;
        this.roles = roles;
        this.authorities = authorities;
    }

    public List<String> getRoles() {
        if (roles.length() > 0) {
            return Arrays.asList(roles.split(","));
        }
        return new ArrayList<>();
    }

    public List<String> getAuthorities() {
        if (authorities.length() > 0) {
            return Arrays.asList(authorities.split(","));
        }
        return new ArrayList<>();
    }
}
