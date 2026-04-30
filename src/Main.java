public class Main {
    public static void main(String[] args) {
        BST<Integer, String> tree = new BST<>();

        System.out.println("--- Тестирование BST (put и get) ---");

        tree.put(5, "Муха");
        tree.put(2, "Арс");
        tree.put(7, "Артем");
        tree.put(1, "Стас");
        tree.put(9, "Данат");

        System.out.println("Размер дерева (size): " + tree.size());

        System.out.println("Поиск ключа 2: " + tree.get(2));
        System.out.println("Поиск ключа 9: " + tree.get(9));
        System.out.println("Поиск ключа 5: " + tree.get(5));
        System.out.println("Поиск ключа 10: " + tree.get(10));


        tree.put(2, "Арс");
        System.out.println("Обновленный ключ 2: " + tree.get(2));
        System.out.println("Новый размер дерева: " + tree.size());
    }
    
}