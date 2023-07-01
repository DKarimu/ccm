package com.dari.ccm.entitys;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Payment {
    private int id;
    private int userId;
    private int creditCardId;
    private BigDecimal amount;
    private LocalDate date;
    private String status;
    private String description;

    public Payment(int id, int userId, int creditCardId, BigDecimal amount, LocalDate date, String status, String description) {
        this.id = id;
        this.userId = userId;
        this.creditCardId = creditCardId;
        this.amount = amount;
        this.date = date;
        this.status = status;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getCreditCardId() {
        return creditCardId;
    }

    public void setCreditCardId(int creditCardId) {
        this.creditCardId = creditCardId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", userId=" + userId +
                ", creditCardId=" + creditCardId +
                ", amount=" + amount +
                ", date=" + date +
                ", status='" + status + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
