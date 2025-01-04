package org.soyphea.spring_boot3.controller;

import org.soyphea.spring_boot3.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping("/aggregated")
    public List<Object[]> getAggregatedData(@RequestParam String[] groupByFields,  @RequestParam(value = "fromDate", defaultValue = "#{T(java.util.Calendar).getInstance().getTime()}") Date fromDate,
                                            @RequestParam(value = "toDate", defaultValue = "#{T(java.util.Calendar).getInstance().getTime()}") Date toDate) {
        System.out.printf("date: %s", toDate);
        System.out.printf("date: %s", fromDate);
        return transactionService.getAggregatedData(groupByFields,fromDate,toDate);
    }
}
