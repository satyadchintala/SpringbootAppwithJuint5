package com.avatar.bank.Avatar_Bank.model;

public class TransferForm {
    private int fromAccountId;
    private int toAccountId;
    private double amountToTransfer;

    public int getFromAccountId() {
        return fromAccountId;
    }

    public void setFromAccountId(int fromAccountId) {
        this.fromAccountId = fromAccountId;
    }

    public int getToAccountId() {
        return toAccountId;
    }

    public void setToAccountId(int toAccountId) {
        this.toAccountId = toAccountId;
    }

    public double getAmountToTransfer() {
        return amountToTransfer;
    }

    public void setAmountToTransfer(double amountToTransfer) {
        this.amountToTransfer = amountToTransfer;
    }
}
