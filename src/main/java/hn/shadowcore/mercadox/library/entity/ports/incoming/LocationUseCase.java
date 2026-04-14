package hn.shadowcore.mercadox.library.entity.ports.incoming;

import hn.shadowcore.mercadox.library.entity.response.dto.LocationDto;
import hn.shadowcore.mercadox.library.entity.model.core.Location;

public interface LocationUseCase {

    Location findById(String locationId);

    LocationDto saveLocation(Location location);

    void deleteLocationById(String locationId);

}
