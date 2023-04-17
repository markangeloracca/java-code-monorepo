package ph.oron.working.sample.resttemplate.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ToDo {
    String userId;
    String id;
    String title;
    boolean completed;
}