package hn.shadowcore.mercadoxlibrary.entity.response.dto;

import hn.shadowcore.mercadoxlibrary.entity.response.EventDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmailEventDto<T> implements EventDto {

    private UUID eventId;

    private String eventSubject;

    private List<EmailRecipientDto> recipients;

    private T payload;

    private Instant timestamp;

}