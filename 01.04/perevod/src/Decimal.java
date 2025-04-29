

public class Decimal extends NumeralSystem{
    public Decimal(String decimal){
        setDecimal(decimal);
    }

    @Override
    public String getBinary(){
        String result = "";
        long number = Long.parseLong(decimal);

        if (number == 0) {
            result = "0";
        }
        else {
            while (number > 0){
                result = number % 2 + result;
                number /= 2;
            }
        }
        setBinary(result);
        return binary;
    }

    @Override
    public String getHexdecimal(){
        String result = "";
        long number = Long.parseLong(decimal);

        if (number == 0){
            result = "0";
        }
        else {
            while (number > 0) {
                int index = (int) (number % 16);
                result = Util.hexDigits[index] + result;
                number = number / 16;
            }
        }
        setHexdecimal(result);
        return hexdecimal;
    }

    @Override
    public void setValue(String decimal){
        setDecimal(decimal);
    }

    @Override
    public String getAdditionResult(NumeralSystem system) {
        return String.valueOf(Integer.parseInt(this.getDecimal()) + Integer.parseInt(system.getDecimal()));
    }

    @Override
    public String getSubtractionResult(NumeralSystem system) {
        return String.valueOf(Integer.parseInt(this.getDecimal()) - Integer.parseInt(system.getDecimal()));
    }

    @Override
    public String toString() {
        return "Десятичная";
    }
}
