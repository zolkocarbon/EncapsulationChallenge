package com.chrisz;

public class Printer {
    private double tonerLevel = 100;
    private int numberOfPagesPrinted = 0;
    private boolean duplexCapable = false;

    public Printer(int tonerLevel, boolean duplexCapable) {
        if(tonerLevel <= 100 && tonerLevel >= 0) {
            this.tonerLevel = tonerLevel;
        }
        this.duplexCapable = duplexCapable;
    }

    public Printer(boolean duplexCapable) {
        this.duplexCapable = duplexCapable;
    }

    public void changeToner() {
        this.tonerLevel = 100;
        System.out.println("Toner changed, toner level is " + this.tonerLevel);
    }

    public void printPage(int printXpages, boolean doubleSided) {
        if(printXpages <= 0 ) {
            System.out.println("Number of pages printed needs to be greater than 0");
        } else if(doubleSided && !this.duplexCapable) {
            System.out.println("This printer can't print on both sides");
        } else if(doubleSided) {
            this.numberOfPagesPrinted += (printXpages / 2 + printXpages % 2);
            this.tonerLevel -= printXpages*0.2;
        } else {
            this.numberOfPagesPrinted += printXpages;
            this.tonerLevel -= printXpages*0.1;
        }
    }

    public double getTonerLevel() {
        return tonerLevel;
    }

    public int getNumberOfPagesPrinted() {
        return numberOfPagesPrinted;
    }

    public boolean isDuplexCapable() {
        return duplexCapable;
    }
}
