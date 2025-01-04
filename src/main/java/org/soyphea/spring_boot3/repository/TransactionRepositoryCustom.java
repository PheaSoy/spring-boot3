package org.soyphea.spring_boot3.repository;

import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TransactionRepositoryCustom {

    List<Object[]> getAggregatedDataByGroup(String[] groupByFields, Date fromDate, Date toDate);
}
