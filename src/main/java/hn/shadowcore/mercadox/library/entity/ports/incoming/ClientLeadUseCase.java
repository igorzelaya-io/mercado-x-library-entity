package hn.shadowcore.mercadox.library.entity.ports.incoming;

import hn.shadowcore.mercadox.library.entity.request.ClientLeadRequest;

public interface ClientLeadUseCase {

    void generateLead(ClientLeadRequest leadRequest, String orgId);

}
