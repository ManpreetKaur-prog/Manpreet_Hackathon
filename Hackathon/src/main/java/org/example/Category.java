package org.example;

class Category {
    private int typeId;
    private String typeName;
    private double interest;

    public Category(int typeId, String typeName, double interest) {
        this.typeId = typeId;
        this.typeName = typeName;
        this.interest = interest;
    }
    public int getTypeId() {
        return typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public double getInterest() {
        return interest;
    }
    public String toString() {
        return "Type: " + typeName + ", Interest: " + interest + "%";
    }
}