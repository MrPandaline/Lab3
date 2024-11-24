package myEnums;

public enum Amounts {
    ONE("один"),
    COUPLE("пара"),
    FEW("несколько"),
    LOT("много");

    private final String amountTitle;

    Amounts(String title) {
        amountTitle = title;
    }

    public static Amounts getAmountFromInt(int amount){
        amount = Math.abs(amount);
        if (amount == 1){
            return Amounts.ONE;
        } else if (amount == 2) {
            return Amounts.COUPLE;
        } else if (3 <= amount && amount <= 10){
            return Amounts.FEW;
        } else { return Amounts.LOT;}
    }

    @Override
    public String toString(){ return amountTitle;}
}
