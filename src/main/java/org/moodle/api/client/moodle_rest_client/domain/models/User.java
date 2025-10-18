
package org.moodle.api.client.moodle_rest_client.domain.models;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class User {
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
    private String auth;
    private Boolean suspended;
    private Boolean confirmed;
    private String lang;
    private String calendartype;
    private String theme;
    private String timezone;
    private Integer mailformat;
    private Integer trackforums;
    private String description;
    private Integer descriptionformat;
    private String city;
    private String country;
    private String profileimageurlsmall;
    private String profileimageurl;
    private List<UserCustomField> customfields;
    private List<UserPreference> preferences;
}
