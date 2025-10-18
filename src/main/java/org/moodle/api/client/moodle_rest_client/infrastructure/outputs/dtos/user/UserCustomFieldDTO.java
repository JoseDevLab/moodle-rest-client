package org.moodle.api.client.moodle_rest_client.infrastructure.outputs.dtos.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserCustomFieldDTO {
    private String type;
    private String value;
    private String displayvalue;
    private String name;
    private String shortname;
}