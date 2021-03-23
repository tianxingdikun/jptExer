package designPattarn.example;

public class FoodServiceImpl72 implements FoodService71 {
    @Override
    public Food73 makeChicken() {
        Food73 f = new Chicken74();
        f.setChicken("");
        f.setSpicy("");
        f.setSalt("");
        return f;
    }

    @Override
    public Food73 makeNoodle() {
        Food73 f = new Noodle75();
        f.setSalt("");
        f.setNoodle("");
        return f;
    }
}
