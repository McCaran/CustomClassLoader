package andersen.Georgiiev;

import java.io.*;

/**
 * Класс, реализующий свой загрузчик классов
 * В данном случае будет использован для загрузки класса из другого, не связанного с этим, проекта
 */

public class CustomLoader extends ClassLoader {
    private static final String path = "loadedClasses/";

    public CustomLoader(ClassLoader parent) {
        super(parent);
    }

    @Override
    public Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            byte b[] = getClassBytes(path + name + ".class");
            return defineClass(name, b, 0, b.length);
        }  catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
            return super.findClass(name);
        } catch (IOException ex) {
            System.out.println("Ошибка чтения файла");
            return super.findClass(name);
        }
    }

    private byte[] getClassBytes(String path) throws IOException {
        File classFile = new File(path);
        InputStream is = new FileInputStream(classFile);
        byte[] bytes = new byte[(int)classFile.length()];
        int offset = 0;
        int numRead;
        while (offset < bytes.length
                && (numRead=is.read(bytes, offset, bytes.length-offset)) >= 0) {
            offset += numRead;
        }
        is.close();
        return bytes;
    }
}
