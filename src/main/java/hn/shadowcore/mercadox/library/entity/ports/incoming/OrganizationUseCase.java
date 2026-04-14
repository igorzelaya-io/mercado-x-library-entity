package hn.shadowcore.mercadox.library.entity.ports.incoming;


import hn.shadowcore.mercadox.library.entity.request.OrgCreationRequest;
import hn.shadowcore.mercadox.library.entity.model.auth.Organization;

public interface OrganizationUseCase {
    Organization create(OrgCreationRequest request);

}
