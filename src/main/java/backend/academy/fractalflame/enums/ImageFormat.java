package backend.academy.fractalflame.enums;

import backend.academy.fractalflame.exception.UnknownImageFormatException;
import java.util.HashMap;
import java.util.Map;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum ImageFormat {
    JPEG("jpg"),
    BMP("bmp"),
    PNG("png");

    private final String label;

    private static final Map<String, ImageFormat> BY_LABEL = new HashMap<>();

    static {
        for (var value : values()) {
            BY_LABEL.put(value.label(), value);
        }
    }

    public static ImageFormat valueOfLabel(String label) {
        ImageFormat imageFormat = BY_LABEL.get(label);
        if (imageFormat == null) {
            throw new UnknownImageFormatException();
        }
        return imageFormat;
    }
}
