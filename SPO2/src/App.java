class App {
    public static void main(String[] args) {
        Kat katObj = new Kat("gelaarsde kat");
        Hond hondObj = new Hond("goofy");
        katObj.geluidMaken();
        hondObj.geluidMaken();
        katObj.bewegen();
        hondObj.bewegen();
        katObj.sleep();
        hondObj.sleep();
    }
}