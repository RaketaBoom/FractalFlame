package backend.academy;

import backend.academy.fractalflame.FractalFlameApi;
import backend.academy.fractalflame.core.FlameHistogramGenerator;
import backend.academy.fractalflame.loader.JsonConfigLoader;
import backend.academy.fractalflame.service.FractalFlameService;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Random;
import lombok.experimental.UtilityClass;

@UtilityClass
public class Main {
    //TODO продумать бизнесовку с учетом в дальнейшем выбора многопоточки и однопоточки
    public static void main(String[] args) {
        Random random = new Random();

        FractalFlameApi fractalFlameApi = new FractalFlameApi(new JsonConfigLoader(new ObjectMapper()),
            new FractalFlameService(new FlameHistogramGenerator(random)));

        fractalFlameApi.start();
    }
}
