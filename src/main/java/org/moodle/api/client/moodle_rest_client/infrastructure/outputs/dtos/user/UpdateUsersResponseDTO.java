package org.moodle.api.client.moodle_rest_client.infrastructure.outputs.dtos.user;

import lombok.Builder;
import lombok.Data;
import org.moodle.api.client.moodle_rest_client.infrastructure.outputs.dtos.WarningDTO;

import java.util.List;

@Data
@Builder
public class UpdateUsersResponseDTO {
    List<WarningDTO> warnings;
}
