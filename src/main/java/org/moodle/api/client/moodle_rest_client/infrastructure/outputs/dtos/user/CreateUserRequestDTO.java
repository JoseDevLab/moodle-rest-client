package org.moodle.api.client.moodle_rest_client.infrastructure.outputs.dtos.user;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import org.moodle.api.client.moodle_rest_client.infrastructure.outputs.dtos.TypeValueRequestDTO;

import java.util.List;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateUserRequestDTO {
    private Integer createpassword;
    private String username;
    private String auth;
    private String password;
    private String firstname;
    private String lastname;
    private String email;
    private Integer maildisplay;
    private String city;
    private String country;
    private String timezone;
    private String description;
    private String firstnamephonetic;
    private String lastnamephonetic;
    private String middlename;
    private String alternatename;
    private String interests;
    private String idnumber;
    private String institution;
    private String department;
    private String phone1;
    private String phone2;
    private String address;
    private String lang;
    private String calendartype;
    private String theme;
    private Integer mailformat;
    /**
     * Type: The name of the custom field
     * Value: The value of the custom field
     */
    private List<TypeValueRequestDTO> customfields;
    /**
     * Type: The name of the preference
     * Value: The value of the preference
     */
    private List<TypeValueRequestDTO> preferences;
}
