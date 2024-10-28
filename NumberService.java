package Lab2;

import java.io.Serializable;

public class NumberService implements Serializable {
    public int number;

    public NumberService() {

    }

    public NumberService(int number) {
        this.number = number;
    }
}

