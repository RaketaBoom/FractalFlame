package backend.academy.fractalflame;

import backend.academy.fractalflame.constant.Constants;
import backend.academy.fractalflame.core.FractalImageGenerator;
import backend.academy.fractalflame.core.MultiThreadingFractalImageGenerator;
import backend.academy.fractalflame.core.SingleThreadFractalImageGenerator;
import backend.academy.fractalflame.dto.ConfigDto;
import backend.academy.fractalflame.dto.HistogramRequest;
import backend.academy.fractalflame.enums.ImageFormat;
import backend.academy.fractalflame.factory.HistogramRequestFactory;
import backend.academy.fractalflame.loader.JsonConfigLoader;
import backend.academy.fractalflame.model.FractalImage;
import backend.academy.fractalflame.service.FractalFlameService;
import backend.academy.fractalflame.utils.FileNameGenerator;
import backend.academy.fractalflame.utils.ImageUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.nio.file.Path;

public class FractalFlameApi {
    private final JsonConfigLoader configLoader = new JsonConfigLoader(new ObjectMapper());

    public void start() {

        ConfigDto configDto = configLoader.loadConfig(Path.of(Constants.CONFIG_PATH));

        HistogramRequest histogramRequest = HistogramRequestFactory.createFromConfig(configDto);
        ImageFormat format = ImageFormat.valueOfLabel(configDto.format());
        FractalFlameService service = new FractalFlameService(fractalGenerator(configDto.threads()));

        FractalImage fractalImage = service.createFlameHistogram(histogramRequest);
        fractalImage = service.postProcessing(fractalImage);

        saveImage(fractalImage, Constants.OUTPUT_DIRECTORY, format);
    }

    private FractalImageGenerator fractalGenerator(int threads) {
        return threads == 1
            ? new SingleThreadFractalImageGenerator()
            : new MultiThreadingFractalImageGenerator(threads);
    }

    private void saveImage(FractalImage fractalImage, String outputDirectory, ImageFormat format) {
        ImageUtils.save(fractalImage, Path.of(outputDirectory, FileNameGenerator.dataTimeName()), format);
    }
}
