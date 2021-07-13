package geek.homework2;

abstract class Car {

    /* Для начала, создать не достающий класс Engine, вынети в него значения,
    затем вынести  методы start() и open() в интерфейс(т.к. все ТС могут стартовать)
    и объеденить новый интерфейс с двумя другими (Moveable, Stopable) в один,
    возможно метод open() стоит вынести в отдельный интерфейс,
    так как не все транспортные средства надо открывать, не которым не требуется открытие,
    далее унаследовать класс Car от интерфейсов,
    Добавить в класс Lorry не достающий метод open(),
    так же унаследовать интрефейсы через implements, а не через extends.
    Так же разнести по пакетам классы авто в один пакет и сам класс car(), engine() и интрерфейс/ы к нему в другой.
    */

    public Engine engine;
    private String color;
    private String name;

    protected void start() {
        System.out.println("Car starting");
    }

    abstract void open();

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
