package com.ramilnagimov.mimimimetr.util;

import java.util.Base64;

public class ImageEncoder {
    public ImageEncoder imageEncoder;

    public ImageEncoder(ImageEncoder imageEncoder) {
        this.imageEncoder = imageEncoder;
    }

    public static String encodeImageToBase64 (byte[] array) {
        return new String(Base64.getMimeEncoder().encode(array));
    }
}
