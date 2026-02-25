package hn.shadowcore.mercadoxlibrary.entity.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EventDto<T> {
    private String eventId;
    private T eventPayload;
}
