package hn.shadowcore.mercadox.library.entity.model.enums.kafka.event;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@JsonSerialize
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class LeadCreatedEvent extends DomainEvent {

        @JsonProperty
        private String orgName;
        @JsonProperty
        private String userName;
        @JsonProperty
        private String email;
        @JsonProperty
        private String phoneNumber;
}
