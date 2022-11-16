package calculator;

import java.util.Objects;

public class Positive {
    private int number;

    public static Positive from(String target) {
        try {
            return new Positive(Integer.parseInt(target));
        } catch (NumberFormatException e) {
            throw new RuntimeException("숫자 형태의 문자만 인자로 받을 수 있습니다.");
        }
    }

    public Positive(int number) {
        this.number = validateNumber(number);
    }

    private int validateNumber(int number) {
        if(number < 0) {
            throw new RuntimeException("양수만 가능합니다.");
        }
        return number;
    }

    public int getNumber() {
        return this.number;
    }

    @Override
    public boolean equals(Object o) {
        if(!(o instanceof Positive)) {
            return false;
        }
        Positive target = (Positive) o;
        return this.number == target.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.number);
    }

    public int plus(int i) {
        return this.number + i;
    }

    public int plus(Positive positive) {
        this.number = getNumber() + positive.getNumber();
        return this.getNumber();
    }
}