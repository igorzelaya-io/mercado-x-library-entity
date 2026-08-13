package hn.shadowcore.mercadox.library.entity.model.enums.kafka.event;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LeadCreatedEvent extends DomainEvent{
        private String orgName;
        private String userName;
        private String email;
        private String phoneNumber;
}
