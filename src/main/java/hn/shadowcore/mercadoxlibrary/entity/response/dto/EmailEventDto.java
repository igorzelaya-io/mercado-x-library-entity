package hn.shadowcore.mercadoxlibrary.entity.response.dto;

import hn.shadowcore.mercadoxlibrary.entity.response.EventDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailEventDto<T> implements EventDto {

    private String eventType;

    private List<EmailRecipientDto> recipients;

    private T payload;

}