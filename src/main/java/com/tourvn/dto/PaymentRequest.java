package com.tourvn.dto;

public class PaymentRequest {
    private long bookingId;
    private Double amount;
    private String paymentMethod;


    public long getBookingId() {
        return bookingId;
    }
    public void setBookingId(long bookingId) {
        this.bookingId = bookingId;
    }
    public Double getAmount() {
        return amount;
    }
    public void setAmount(Double amuont) {
        this.amount = amuont;
    }
    public String getPaymentMethod() {
        return paymentMethod;
    }
    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
