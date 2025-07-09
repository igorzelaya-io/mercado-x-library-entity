package hn.shadowcore.mercadoxlibrary.entity.response.dto;

import hn.shadowcore.mercadoxlibrary.entity.response.EventDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EmailEventDto<T> implements EventDto {

    private String eventType;

    private String userEmail;

    private String userName;

    private T payload;

}