package hn.shadowcore.mercadoxlibrary.entity.response.dto;

import hn.shadowcore.mercadoxlibrary.entity.model.enums.NotificationTemplateName;
import hn.shadowcore.mercadoxlibrary.entity.response.EventDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class EmailEventDto<T> extends EventDto {

    private String eventSubject;

    private NotificationTemplateName emailTemplate;

    private List<EmailRecipientDto> recipients;

    private T payload;

    private Instant timestamp;

}