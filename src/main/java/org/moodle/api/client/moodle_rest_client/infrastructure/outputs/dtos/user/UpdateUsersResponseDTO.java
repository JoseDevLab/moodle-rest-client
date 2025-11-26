package org.moodle.api.client.moodle_rest_client.infrastructure.outputs.dtos.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.moodle.api.client.moodle_rest_client.infrastructure.outputs.dtos.WarningDTO;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UpdateUsersResponseDTO {
    List<WarningDTO> warnings;
}
