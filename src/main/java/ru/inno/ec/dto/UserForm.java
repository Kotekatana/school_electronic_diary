package ru.inno.ec.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.inno.ec.models.User;

import javax.persistence.Basic;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserForm {


    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Integer age;
    private User.Role role;
    private Long groupId;
    private String dateOfBirth;


}
