package backend.academy.fractalflame.enums;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum ImageFormat {
    JPEG("jpg"),
    BMP("bmp"),
    PNG("png");

    private final String name;

    public static ImageFormat fromString(String name) {
        for (ImageFormat format : values()) {
            if (format.name.equalsIgnoreCase(name)) {
                return format;
            }
        }
        // TODO заменить эксепшн на кастомный
        throw new IllegalArgumentException("Unknown image format: " + name);
    }
}
