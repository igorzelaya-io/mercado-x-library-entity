package hn.alturaforge.mercadox.library.entity.ports.incoming;

import hn.alturaforge.mercadox.library.entity.request.ClientLeadRequest;

public interface ClientLeadUseCase {

    void generateLead(ClientLeadRequest leadRequest, String orgId);

}
