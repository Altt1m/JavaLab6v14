import java.text.MessageFormat;
import java.util.ArrayList;

public class ProductSet
{
    private String name;
    private String manufacturer;
    private int amount;
    private double wholesalePrice;
    private double retailPrice;
    private String guarantee;

    private static ArrayList<ProductSet> products = new ArrayList<>();

    // 14 1,2,16,37
    // Додавання товару.
    // Виведення множини товарів на екран.
    // Знайти усі товари з роздрібною ціною більше Х.
    // Знайти товар, який може принести найбільший прибуток (найменування).

    public ProductSet(String name, String manufacturer, int amount, double wP, double rP, String guarantee)
    {
        try
        {
            if (amount < 0)
            {
                throw new IllegalArgumentException("Від'ємна кількість товару.");
            }
            if (wP <= 0 || rP <= 0)
            {
                throw new IllegalArgumentException("Ціна менше нуля або йому дорівнює.");
            }
            if (name.length() < 3)
            {
                throw new IllegalArgumentException("Найменування товару містить менше 3 символів.");
            }
            if (manufacturer.length() < 5)
            {
                throw new IllegalArgumentException("Найменування виробника містить менше 5 символів.");
            }
            if (wP >= rP)
            {
                throw new IllegalArgumentException("Оптова ціна вища за роздрібну або рівна їй.");
            }
            if (guarantee.isEmpty())
            {
                throw new IllegalArgumentException("Гарантійний термін не вказаний належним чином.");
            }

            this.name = name;
            this.manufacturer = manufacturer;
            this.amount = amount;
            wholesalePrice = wP;
            retailPrice = rP;
            this.guarantee = guarantee;

            products.add(this);
        }
        catch (IllegalArgumentException e)
        {
            System.err.println("\nПомилка: " + e.getMessage());
        }
    }

    public static void printSet() // Вивести множину
    {
        System.out.println("Список товарів:\n");
        for (ProductSet product : products)
        {
            product.printInfo();
        }
    }

    public static void findRetailLower(double x) // Вивести список товарів з роздрібною ціною нижче х
    {
        System.out.println("Товари з роздрібною ціною нижчою за " + x + ":\n");
        for (ProductSet product : products)
        {
            if (product.retailPrice < x)
                product.printInfo();
        }
    }

    public static String getMostExpensiveName() // Отримати назву найприбутковішого товару
    {
        double cost = 0;
        String name = "N/A";
        for (ProductSet product : products)
        {
            if (product.retailPrice * product.amount > cost)
            {
                name = product.name;
                cost = product.retailPrice * product.amount;
            }

        }
        return name;
    }

    public void printInfo() // Вивести інформацію про об'єкт
    {
        System.out.println(MessageFormat.format("Назва: {0}\n" +
                "Виробник: {1}\n" +
                "Кількість: {2}\n" +
                "Оптова ціна: {3}\n" +
                "Роздрібна ціна: {4}\n" +
                "Гарантійний строк: {5}\n", name, manufacturer, amount, wholesalePrice, retailPrice, guarantee));
    }

    public void setAmount(int amount) { this.amount = amount; }
    public void setWholesalePrice(double wP) { wholesalePrice = wP; }
    public void setRetailPrice(double rP) { retailPrice = rP; }
    public void setGuarantee(String g) { guarantee = g; }
}
