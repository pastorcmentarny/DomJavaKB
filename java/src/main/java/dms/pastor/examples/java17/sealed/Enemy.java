package dms.pastor.examples.java17.sealed;

public record Enemy(EnemyType enemyType) implements Unit {
    @Override
    public String name() {
        return "Enemy";
    }
}
