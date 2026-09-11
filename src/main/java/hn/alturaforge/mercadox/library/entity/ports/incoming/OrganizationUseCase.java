package hn.alturaforge.mercadox.library.entity.ports.incoming;


import hn.alturaforge.mercadox.library.entity.request.OrgCreationRequest;
import hn.alturaforge.mercadox.library.entity.model.auth.Organization;

public interface OrganizationUseCase {
    Organization create(OrgCreationRequest request);

}
