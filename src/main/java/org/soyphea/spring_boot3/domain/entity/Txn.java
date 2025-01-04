package org.soyphea.spring_boot3.domain.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "transactions")

public class Txn {

    public void setId(String id) {
        this.id = id;
    }

    public void setStatus(TxnStatus status) {
        this.status = status;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    @Id
    String id;
    TxnStatus status;
    Double amount;
    Date createdAt;
    Channel channel;

    public String getId() {
        return id;
    }

    public TxnStatus getStatus() {
        return status;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Channel getChannel() {
        return channel;
    }

    public Double getAmount() {
        return amount;
    }
}


