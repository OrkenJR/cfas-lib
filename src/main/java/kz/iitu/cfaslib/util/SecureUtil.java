package kz.iitu.cfaslib.util;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SecureUtil {

    private static final int FILLER = -1;
    private static final int BEFORE = -2;

    public static String decode(List<Integer> encoded) {

        if (encoded == null || encoded.isEmpty()) {
            throw new RuntimeException("Cannot decode empty list");
        }

        return decodeFirstRound(decodeSecondRound(decodeThirdRound(encoded))).stream()
                .map(x -> (char) ((int) x))
                .map(Object::toString)
                .collect(Collectors.joining());
    }

    private static List<Integer> decodeThirdRound(List<Integer> encoded) {
        List<Integer> decoded = new ArrayList<>();
        int size = encoded.size();

        int currentIndex = 0;

        for (int i = 0; i < size; ++i) {
            final int number = encoded.get(i);

            if (number == BEFORE) {
                i++;

                if (i >= size) {
                    throw new RuntimeException("Incorrect encoded message");
                }

                decoded.add(encoded.get(i) / 2 - currentIndex);
            } else {
                decoded.add(number - (2 * currentIndex));
            }

            currentIndex++;

        }

        return decoded;
    }

    private static List<Integer> decodeSecondRound(List<Integer> encoded) {
        List<Integer> decoded = new ArrayList<>();
        int size = encoded.size();

        if (size % 2 != 0) {
            throw new RuntimeException("Incorrect encoded message");
        }

        int middle = size / 2;

        for (int i = middle; i < size; ++i) {
            decoded.add(encoded.get(i));
        }

        for (int i = 0; i < middle; ++i) {
            decoded.add(encoded.get(i));
        }

        return decoded;
    }

    private static List<Integer> decodeFirstRound(List<Integer> encoded) {
        int size = encoded.size();

        if (size == 0) {
            throw new RuntimeException("Encoded message is empty");
        }

        int lastCharIndex = size - 1;
        int lastChar = encoded.get(lastCharIndex);

        if (lastChar == FILLER) {
            encoded.remove(lastCharIndex);
        }

        return encoded;
    }

}
