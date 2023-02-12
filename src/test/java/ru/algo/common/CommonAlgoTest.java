package ru.algo.common;

import com.google.common.io.Resources;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.String.format;
import static java.lang.System.currentTimeMillis;

@Slf4j
public abstract class CommonAlgoTest {

    protected abstract CommonAlgo init();

    protected abstract String inPath();

    @Test
    void findTickets() {
        startTest();
    }

    protected void startTest() {
        System.out.println("********************* [" + name() + "]");

        prepareCases().forEach((file) -> {

            final String[] input = loadFileFromResources(file + ".in");
            final String[] output = loadFileFromResources(file + ".out");

            long elapsed = currentTimeMillis();
            var result = executeTest(input);
            elapsed = currentTimeMillis() - elapsed;

            for (int i = 0; i < output.length; i++) {
                var inputCurrent = input[i].trim();
                var resultCurrent = result[i].trim();
                var outputCurrent = output[i].trim();

                boolean ok = resultCurrent.equals(outputCurrent);

                String res = ok ? format("Время, мсек: [%d]", elapsed) : format("Ожидалось: [%s]. Ошибка", outputCurrent);

                System.out.printf("[%s]: Вход: [%s] Результат: [%s]. [%s]\n",
                        file,
                        inputCurrent,
                        resultCurrent,
                        res
                        );
            }
        });

        System.out.println("\n");
    }

    private String name() {
        return init().name();
    }

    private String[] executeTest(String[] input) {
        return init().exec(input);
    }

    @SneakyThrows
    protected Set<String> prepareCases() {
        URL url = CommonAlgoTest.class.getClassLoader().getResource(inPath());

        assert url != null;

        Path dirPath = Paths.get(url.toURI());
        try (Stream<Path> paths = Files.list(dirPath)) {
            return paths
                    .map(p -> p.getFileName().toString())
                    .filter(p -> p.contains(".in"))
                    .map(p -> p.replace(".in", ""))
                    .collect(Collectors.toCollection(TreeSet::new));
        }
    }

    @SneakyThrows
    private String[] loadFileFromResources(String file) {
        URL url = Resources.getResource(inPath() + "/" + file);
        return Resources.toString(url, StandardCharsets.UTF_8).split("\\r?\\n");
    }
}
