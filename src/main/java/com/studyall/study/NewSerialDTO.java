package com.studyall.study;

public class NewSerialDTO {
    static final long serialVersionUID = 1L;
    private String bookType = "IT";
    private String bookName;
    private int bookOrder;
    private boolean bestSeller;
    private long soldPerDay;

    public NewSerialDTO(String bookName, int bookOrder, boolean bestSeller, long soldPerDay) {
        this.bookName = bookName;
        this.bookOrder = bookOrder;
        this.bestSeller = bestSeller;
        this.soldPerDay = soldPerDay;
    }

    @Override
    public String toString() {
        return "NewSerialDTO{" +
                "bookType='" + bookType + '\'' +
                ", bookName='" + bookName + '\'' +
                ", bookOrder=" + bookOrder +
                ", bestSeller=" + bestSeller +
                ", soldPerDay=" + soldPerDay +
                '}';
    }
}
