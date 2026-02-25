package hn.shadowcore.mercadoxlibrary.entity.ports.incoming;

import hn.shadowcore.mercadoxlibrary.entity.request.ClientLeadRequest;

public interface ClientLeadUseCase {

    void generateLead(ClientLeadRequest leadRequest);

}
