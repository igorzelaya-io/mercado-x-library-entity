package hn.shadowcore.mercadox.library.entity.response.dto;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Setter
@Getter
@Builder
@JsonSerialize
@NoArgsConstructor
@AllArgsConstructor
public class NotificationRequest {

    private String orgId;

    private String templateKey;

    private String phoneNumber;

    private Map<String, String> variables;

}
