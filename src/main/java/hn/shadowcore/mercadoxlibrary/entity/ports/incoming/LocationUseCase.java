package hn.shadowcore.mercadoxlibrary.entity.ports.incoming;

import hn.shadowcore.mercadoxlibrary.entity.model.core.Location;
import hn.shadowcore.mercadoxlibrary.entity.response.dto.LocationDto;

public interface LocationUseCase {

    Location findById(String locationId);

    LocationDto saveLocation(Location location);

    void deleteLocationById(String locationId);

}
