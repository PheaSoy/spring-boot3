package org.soyphea.spring_boot3.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import org.soyphea.spring_boot3.domain.entity.Txn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class TransactionRepositoryCustomImpl implements TransactionRepositoryCustom {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Object[]> getAggregatedDataByGroup(String[] groupByFields,Date fromDate, Date toDate) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Object[]> query = cb.createQuery(Object[].class);
        Root<Txn> root = query.from(Txn.class);
        // Date range filter
        Predicate datePredicate = cb.between(root.get("createdAt"), fromDate, toDate);

        // Create a list for the selected fields (grouping fields + aggregation)
        List<Expression<?>> selections = new ArrayList<>();

        // Loop through the groupByFields array and dynamically add to the selections
        for (String field : groupByFields) {
            Path<Object> path = root.get(field);  // Get path for the dynamic field
            selections.add(path);  // Add to selections for GROUP BY
        }

        // Add the aggregation functions: COUNT and SUM
        selections.add(cb.count(root));  // Count of transactions
        selections.add(cb.sum(root.get("amount")));  // Sum of amounts

        // Apply selections dynamically
        query.multiselect(selections.toArray(new Expression[0]));  // Use array of expressions

        // Add the GROUP BY clause dynamically based on the fields
        List<Expression<?>> groupByExpressions = new ArrayList<>();
        for (String field : groupByFields) {
            groupByExpressions.add(root.get(field));
        }
        query.where(datePredicate);
        query.groupBy(groupByExpressions);  // Apply GROUP BY

        // Execute the query
        TypedQuery<Object[]> typedQuery = entityManager.createQuery(query);
        return typedQuery.getResultList();
    }
}
