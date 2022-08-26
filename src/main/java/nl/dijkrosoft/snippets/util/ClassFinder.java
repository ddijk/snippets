package nl.dijkrosoft.snippets.util;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.jar.JarFile;
import java.util.zip.ZipFile;

public class ClassFinder {

    public static void main(String[] args) throws IOException {

        if (args == null || args.length < 2) {
            System.out.println("Usage: java -jar classfinder.jar <dir> <class-name>");
            return;
        }

        String dir = args[0];
        String classname = args[1];

        System.out.println("dir=" + dir + ", en class=" + classname);

        Files.walkFileTree(Paths.get(dir), new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                if (attrs.isRegularFile() && file.toString().endsWith(".jar")) {
                    System.out.println("\nJAR file " + file);
                    processjar(file, classname);
                }
                return FileVisitResult.CONTINUE;
            }
        });
    }

    private static void processjar(Path file, String classname) throws IOException {

        JarFile jarFile = new JarFile(file.toFile(), false, ZipFile.OPEN_READ);
        jarFile.stream().filter(e->!e.isDirectory() && e.getName().indexOf(classname) != -1 ).forEach(System.out::println);
    }
}



