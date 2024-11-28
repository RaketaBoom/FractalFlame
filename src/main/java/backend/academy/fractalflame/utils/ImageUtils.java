package backend.academy.fractalflame.utils;

import backend.academy.fractalflame.enums.ImageFormat;
import backend.academy.fractalflame.exception.ImageSaveException;
import backend.academy.fractalflame.model.FractalImage;
import lombok.experimental.UtilityClass;
import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Path;

@UtilityClass
public final class ImageUtils {

    public void save(FractalImage image, Path filename, ImageFormat format) {
        Color[][] colors = image.getColorsOfImage();
        int width = image.width();
        int height = image.height();

        // Создаем BufferedImage
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        // Заполняем BufferedImage цветами из массива
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Color color = colors[y][x];

                bufferedImage.setRGB(x, y, color.getRGB());

            }
        }



        try {
            ImageIO.write(bufferedImage, format.name(), nameWithFormat(filename, format).toFile());
        } catch (IOException e) {
            throw new ImageSaveException();
        }
    }

    Path nameWithFormat(Path filename, ImageFormat format){
        return filename.resolveSibling(filename.getFileName() + "." + format.name().toLowerCase());
    }
}
