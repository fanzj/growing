package com.jary.daily.grows;

import java.util.List;

/**
 * @author fanzhengjie
 * @version 1.0
 * @create 2017/8/19 上午9:45
 */
public class Transaction {

    public static class Output {
        String address;
        long amount;

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public long getAmount() {
            return amount;
        }

        public void setAmount(long amount) {
            this.amount = amount;
        }

        @Override
        public String toString() {
            return "Output{" +
                    "address=" + address + '\'' +
                    ", amount=" + amount +
                    '}';
        }
    }

    private String txid;
    private String action;
    private long amount;
    private long fees;
    private long time;
    private int confirmations;
    private List<Output> outputs;

    public String getTxid() {
        return txid;
    }

    public void setTxid(String txid) {
        this.txid = txid;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public long getFees() {
        return fees;
    }

    public void setFees(long fees) {
        this.fees = fees;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public int getConfirmations() {
        return confirmations;
    }

    public void setConfirmations(int confirmations) {
        this.confirmations = confirmations;
    }

    public List<Output> getOutputs() {
        return outputs;
    }

    public void setOutputs(List<Output> outputs) {
        this.outputs = outputs;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "txid='" + txid + '\'' +
                ", action='" + action + '\'' +
                ", amount=" + amount +
                ", fees=" + fees +
                ", time=" + time +
                ", confirmations=" + confirmations +
                ", outputs=" + outputs +
                '}';
    }

}
