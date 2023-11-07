public class Main
{
    public static void main(String[] args)
    {
        ProductSet knife = new ProductSet("Ніж", "Виделка&Ложка",
                                            100, 83.50, 179.99, "1 рік");

        knife.printInfo();

        ProductSet fork = new ProductSet("Виделка", "Виделка&Ложка",
                                            120, 35.80, 59.99, "1 рік");

        ProductSet.printSet();

        ProductSet.findRetailLower(100);

        System.out.println("Найдорожчий товар це " + ProductSet.getMostExpensiveName());
        fork.setAmount(1000);
        System.out.println("Тепер найдорожчий товар це " + ProductSet.getMostExpensiveName());

        ProductSet spoon = new ProductSet("Ложка", "Виделка&Ложка",
                                            -100, 35.80, 59.99, "1 рік");
    }
}