package mini_rpg.Utilitaire;

public abstract class Model {
    public int id = 0;

    public abstract boolean get(int id);
    public abstract boolean save();
}
