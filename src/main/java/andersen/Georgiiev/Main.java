package andersen.Georgiiev;

public class Main {

    public static void main(String[] args) {
        CustomLoader cl = new CustomLoader(ClassLoader.getSystemClassLoader());
        Class customClass = null;
        try {
            System.out.println("Попытка загрузить класс CustomCollection:");
            customClass = cl.loadClass("CustomCollection");
        } catch (ClassNotFoundException e) {
            System.out.println("Класс не найден");
        }
        System.out.println(customClass);
        if (customClass != null) {
            System.out.println("Вывод загрузчика класса CustomCollection:");
            System.out.println(customClass.getClassLoader());
        }
    }
}