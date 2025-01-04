package org.soyphea.spring_boot3.repository;

import org.soyphea.spring_boot3.domain.entity.Txn;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;

@RestResource(path = "transactions")
public interface TxnRepository extends CrudRepository<Txn, String> {
}
