package hn.shadowcore.mercadoxlibrary.entity.ports.incoming;


import hn.shadowcore.mercadoxlibrary.entity.model.auth.Organization;
import hn.shadowcore.mercadoxlibrary.entity.request.OrgCreationRequest;

public interface OrganizationUseCase {
    Organization create(OrgCreationRequest request);

}
