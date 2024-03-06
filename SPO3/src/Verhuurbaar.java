interface Verhuurbaar {
    public boolean isVerhuurbaar();

    String getNaam();

    Klant getHuurder();

    void verhuurAan(Klant klant);

    void reserveerVoor(Klant klant);

    void retourneer();
}
