/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.sql.Timestamp;


/**
 *
 * @author Eunar B. Dayangco
 */
public class StudentTransaction {
    
    private int transID;
    private Timestamp transDate;
    private String officialReceipt;
    private GeneralPayment paymentFor;
    private double paymentAmount;
    private String schoolYear;
    private Student student;
    private User user;
    private String remarks;
    private double remainingBalance;
    private boolean reported;

    public StudentTransaction() {
    }

    public int getTransID() {
        return transID;
    }

    public void setTransID(int transID) {
        this.transID = transID;
    }

    public Timestamp getTransDate() {
        return transDate;
    }

    public void setTransDate(Timestamp transDate) {
        this.transDate = transDate;
    }

   

    public String getOfficialReceipt() {
        return officialReceipt;
    }

    public void setOfficialReceipt(String officialReceipt) {
        this.officialReceipt = officialReceipt;
    }

    public GeneralPayment getPaymentFor() {
        return paymentFor;
    }

    public void setPaymentFor(GeneralPayment paymentFor) {
        this.paymentFor = paymentFor;
    }

   

    public double getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public String getSchoolYear() {
        return schoolYear;
    }

    public void setSchoolYear(String schoolYear) {
        this.schoolYear = schoolYear;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public double getRemainingBalance() {
        return remainingBalance;
    }

    public void setRemainingBalance(double remainingBalance) {
        this.remainingBalance = remainingBalance;
    }

    public boolean isReported() {
        return reported;
    }

    public void setReported(boolean reported) {
        this.reported = reported;
    }
    
    
    
}
