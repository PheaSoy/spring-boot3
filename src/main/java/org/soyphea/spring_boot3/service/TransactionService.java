package org.soyphea.spring_boot3.service;

import org.soyphea.spring_boot3.repository.TransactionRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepositoryCustom transactionRepositoryCustom;

    public List<Object[]> getAggregatedData(String[] groupByFields, Date from, Date to) {
        return transactionRepositoryCustom.getAggregatedDataByGroup(groupByFields,from,to);
    }
}
