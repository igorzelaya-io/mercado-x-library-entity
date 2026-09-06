package hn.shadowcore.mercadox.library.entity.request.appointments;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record StartGoogleCalendarConnectionRequest(
        @NotBlank
        @Size(max = 512)
        @Pattern(regexp = "^/[A-Za-z0-9/_?&=.%~-]*$")
        String returnPath
) {
}
