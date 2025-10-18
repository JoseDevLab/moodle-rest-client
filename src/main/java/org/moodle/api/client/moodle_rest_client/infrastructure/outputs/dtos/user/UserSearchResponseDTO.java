
package org.moodle.api.client.moodle_rest_client.infrastructure.outputs.dtos.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.moodle.api.client.moodle_rest_client.infrastructure.outputs.dtos.WarningDTO;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserSearchResponseDTO {
    @JsonProperty("users")
    private List<UserDTO> users;
    @JsonProperty("warnings")
    private List<WarningDTO> warnings;
}