
public abstract class NumeralSystem implements Cloneable{
    String binary;
    String decimal;
    String hexdecimal;

    public String getBinary() {
        return binary;
    }

    public void setBinary(String binary) {
        if (binary.isEmpty()) {
            throw new IllegalArgumentException("Значение не должно быть пустым!");
        }
        if (binary.matches("[01]+")) {
            this.binary = binary;
        } else {
            throw new IllegalArgumentException("Двоичное число состоит только из 0 и 1");
        }
    }

    public String getDecimal() {
        return decimal;
    }

    public void setDecimal(String decimal) {
        if (decimal.isEmpty()){
            throw new IllegalArgumentException("Значение не должно быть пустым!");
        }
        if (decimal.matches("\\d+")) {
            this.decimal = decimal;
        }else {
            throw new IllegalArgumentException("Десятичное число состоит только из цифр от 0 до 9");
        }
    }

    public String getHexdecimal() {
        return hexdecimal;
    }

    public void setHexdecimal(String hexdecimal) {
        if (hexdecimal.isEmpty()){
            throw new IllegalArgumentException("Значение не должно быть пустым!");
        }
        if (hexdecimal.matches("^[0-9A-F]+$")) {
            this.hexdecimal = hexdecimal;
        }else {
            throw new IllegalArgumentException("Шестнадцатеричное число состоит из цифр от 0 до 9 и букв латинского алфавита (A-F)");
        }
    }

    public void setValue(String value){

    }

    public String getAdditionResult(NumeralSystem system){
        return "0";
    }

    public String getSubtractionResult(NumeralSystem system){
        return "0";
    }

    @Override
    public NumeralSystem clone() {
        try {
            return (NumeralSystem) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
