package org.moodle.api.client.moodle_rest_client.domain.requests.user;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import org.moodle.api.client.moodle_rest_client.domain.requests.TypeValueRequest;

@Data
@Builder
public class UpdateUserRequest {
    Long id;
    String username;
    String auth;
    Integer suspended;
    String password;
    String firstname;
    String lastname;
    String email;
    Integer maildisplay;
    String city;
    String country;
    String timezone;
    String description;
    Integer userpicture;
    String firstnamephonetic;
    String lastnamephonetic;
    String middlename;
    String alternatename;
    String interests;
    String idnumber;
    String institution;
    String department;
    String phone1;
    String phone2;
    String address;
    String lang;
    String calendartype;
    String theme;
    Integer mailformat;
    /**
     * type: The name of the custom field
     * value: The value of the custom field
     */
    List<TypeValueRequest> customfields;
    /**
     * type: The name of the preference
     * value: The value of the preference
     */
    List<TypeValueRequest> preferences;
}
