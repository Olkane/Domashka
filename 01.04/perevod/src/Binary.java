import static java.lang.Math.pow;

public class Binary extends NumeralSystem{
    public Binary(String binary){
        setBinary(binary);
    }

    @Override
    public String getDecimal(){
        int result = 0;

        if (!binary.isEmpty()) {
            int len = binary.length() - 1;
            char[] chars = binary.toCharArray();


            for (int i = 0; i <= len; i++) {
                result += (int) (Integer.parseInt(String.valueOf(chars[len - i])) * pow(2, i));
            }
        }
        setDecimal(String.valueOf(result));
        return decimal;
    }

    @Override
    public String getHexdecimal(){
        String result = "";
        if (binary.equals("0")){
            result = "0";
        }
        else {
            int round = (4 - binary.length() % 4) % 4;
            String currentBinary = "0".repeat(round) + binary;
            int decimal;
            for (int i = 0; i < currentBinary.length(); i += 4) {
                String group = currentBinary.substring(i, i + 4);
                decimal = 0;

                for (int j = 0; j < 4; j++) {
                    decimal = decimal * 2 + (group.charAt(j) - '0');
                }

                result += Util.hexDigits[decimal];
            }
        }
        setHexdecimal(result);
        return hexdecimal;
    }
    @Override
    public void setValue(String binary){
        setBinary(binary);
    }

    @Override
    public String getAdditionResult(NumeralSystem system) {
        return new Decimal(String.valueOf(Integer.parseInt(this.getDecimal()) + Integer.parseInt(system.getDecimal()))).getBinary();
    }

    @Override
    public String getSubtractionResult(NumeralSystem system) {
        return new Decimal(String.valueOf(Integer.parseInt(this.getDecimal()) - Integer.parseInt(system.getDecimal()))).getBinary();
    }

    @Override
    public String toString() {
        return "Двоичная";
    }


}
