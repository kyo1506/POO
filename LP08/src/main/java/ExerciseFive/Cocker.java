package ExerciseFive;

public class Cocker extends Cachorro{
    private boolean tosa;

    public Cocker(){}
    public Cocker(boolean tosa){
        this.tosa = tosa;
    }

    public String getTosa() {
        if (tosa)
            return "Precisa de tosa!";
        else
            return "Não precisa de tosa!";
    }
    public void setTosa(boolean tosa) {
        this.tosa = tosa;
    }
}
