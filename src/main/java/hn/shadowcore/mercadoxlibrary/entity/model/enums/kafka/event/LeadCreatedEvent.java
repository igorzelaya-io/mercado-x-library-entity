package hn.shadowcore.mercadoxlibrary.entity.model.enums.kafka.event;

import hn.shadowcore.mercadoxlibrary.entity.response.EventDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LeadCreatedEvent extends EventDto {
        private String orgId;
        private String orgName;
        private String userName;
        private String email;
        private String phoneNumber;
}
