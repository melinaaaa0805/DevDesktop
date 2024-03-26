package com.example.financemanager.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Income {
    private final LocalDate date;
    private final float total;
    private final float income;
    private final float help;
    private final float autoentreprise;
    private final float passifIncome;
    private final float other;

    private final static String PRICE_FORMAT = "%.2f €";

    private final static DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("MMMM yyyy");

    public Income(LocalDate date, float income, float help, float autoentreprise, float passifIncome, float other) {
        this.date = date;
        this.total = income + help + autoentreprise + passifIncome + other;
        this.income = income;
        this.help = help;
        this.autoentreprise = autoentreprise;
        this.passifIncome = passifIncome;
        this.other = other;
    }

    public StringProperty dateProperty() {
        return new SimpleStringProperty(date.format(DATE_FORMAT));
    }

    public StringProperty totalProperty() {
        return formatAmount(total);
    }

    private SimpleStringProperty formatAmount(float amount) {
        return new SimpleStringProperty(String.format(PRICE_FORMAT, amount));
    }

    public StringProperty incomeProperty() {
        return formatAmount(income);
    }

    public StringProperty helpProperty() {
        return formatAmount(help);
    }

    public StringProperty autoentrepriseProperty() {
        return formatAmount(autoentreprise);
    }


    public StringProperty passifIncomeProperty() {
        return formatAmount(passifIncome);
    }

    public StringProperty otherProperty() {
        return formatAmount(other);
    }

    public LocalDate getDate() {
        return date;
    }

    public float getTotal() {
        return total;
    }

    public float getIncome() {
        return income;
    }

    public float getHelp() {
        return help;
    }

    public float getAutoentreprise() {
        return autoentreprise;
    }

    public float getPassifIncome() {
        return passifIncome;
    }

    public float getOther() {
        return other;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "date=" + date +
                ", total=" + total +
                ", income=" + income +
                ", help=" + help +
                ", autoentreprise=" + autoentreprise +
                ", passifIncome=" + passifIncome +
                ", other=" + other +
                '}';
    }

    public int compareTo(Income income) {
        return -this.date.compareTo(income.date);
    }
}
