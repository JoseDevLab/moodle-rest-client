package org.moodle.api.client.moodle_rest_client.infrastructure.outputs.dtos.enrol;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.moodle.api.client.moodle_rest_client.infrastructure.outputs.dtos.user.UserCustomFieldDTO;
import org.moodle.api.client.moodle_rest_client.infrastructure.outputs.dtos.user.UserPreferenceDTO;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class EnrolledUserDTO {
    private Long id;
    private String username;
    private String firstname;
    private String lastname;
    private String fullname;
    private String email;
    private String address;
    private String phone1;
    private String phone2;
    private String department;
    private String institution;
    private String idnumber;
    private String interests;
    private Long firstaccess;
    private Long lastaccess;
    private Long lastcourseaccess;
    private String description;
    private Integer descriptionformat;
    private String city;
    private String country;
    private String profileimageurlsmall;
    private String profileimageurl;
    private List<UserCustomFieldDTO> customfields;
    private List<GroupDTO> groups;
    private List<RoleDTO> roles;
    private List<UserPreferenceDTO> preferences;
    private List<EnrolledCourseDTO> enrolledcourses;
}
