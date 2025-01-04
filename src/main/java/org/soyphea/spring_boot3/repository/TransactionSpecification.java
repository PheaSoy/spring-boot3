package org.soyphea.spring_boot3.repository;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import org.soyphea.spring_boot3.domain.entity.Txn;
import jakarta.persistence.criteria.*;
import org.springframework.data.jpa.domain.Specification;

import java.util.Calendar;
import java.util.Date;

public class TransactionSpecification implements Specification<Txn> {

    private Date fromDate;
    private Date toDate;

    public TransactionSpecification(Date fromDate, Date toDate) {
        // Set default values for fromDate and toDate if they are not provided
        if (fromDate == null || toDate == null) {
            Calendar cal = Calendar.getInstance();
            if (fromDate == null) {
                // Set fromDate to today (start of the day)
                cal.set(Calendar.HOUR_OF_DAY, 0);
                cal.set(Calendar.MINUTE, 0);
                cal.set(Calendar.SECOND, 0);
                cal.set(Calendar.MILLISECOND, 0);
                this.fromDate = cal.getTime();
            }
            if (toDate == null) {
                // Set toDate to today (end of the day)
                cal.set(Calendar.HOUR_OF_DAY, 23);
                cal.set(Calendar.MINUTE, 59);
                cal.set(Calendar.SECOND, 59);
                cal.set(Calendar.MILLISECOND, 999);
                this.toDate = cal.getTime();
            }
        } else {
            this.fromDate = fromDate;
            this.toDate = toDate;
        }
    }

    @Override
    public Predicate toPredicate(Root<Txn> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        Predicate datePredicate = cb.between(root.get("createdAt"), fromDate, toDate);
        return datePredicate;
    }


}
