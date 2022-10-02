package kz.iitu.cfaslib.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private String id;

    private String username;

    private String password;

    private String firstName;

    private String lastName;

    private UserDto parent;

    private Set<UserDto> children;

    private List<RoleDto> roles;
}
