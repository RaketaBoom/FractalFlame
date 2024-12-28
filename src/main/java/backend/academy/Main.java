package backend.academy;

import backend.academy.fractalflame.FractalFlameApi;
import lombok.experimental.UtilityClass;

@UtilityClass
public class Main {
    public static void main(String[] args) {
        FractalFlameApi fractalFlameApi = new FractalFlameApi();

        fractalFlameApi.start();
    }
}
