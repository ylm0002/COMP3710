package com.example.spendingmanagerv2;

public interface IDataAccess {
    public Balance loadBalance(double bal);
    public double saveBalance(Balance balance);
}