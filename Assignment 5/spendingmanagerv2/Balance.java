package com.example.spendingmanagerv2;

public class Balance {

    public double bal;

    public String toSQL() {
        StringBuilder sb = new StringBuilder("(");
        sb.append(bal).append(",");
        return sb.toString();
    }

}