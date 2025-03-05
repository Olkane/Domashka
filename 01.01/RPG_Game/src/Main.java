import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

class Character {
    private String name;
    private int health, damage, armor, speed, attackRange, skillChance;
    private boolean skill = false;

    public Character(String name, int health, int damage, int armor, int speed, int attackRange, int skillChance) {
        this.name = name;
        this.health = health;
        this.damage = damage;
        this.armor = armor;
        this.speed = speed;
        this.attackRange = attackRange;
        this.skillChance = skillChance;
    }


    public void defaultAttack(Character target, int distance) {
        if (distance <= attackRange) {
            int currentDamage;
            if (skill){
                currentDamage = (int) (((double)(100 - target.armor) / 100) * damage * 1.15);
                skill = false;
            }
            else {
                currentDamage = (int) (((double)(100 - target.armor) / 100) * damage);
            }
            target.health -= currentDamage;
            System.out.println(name + " атаковал " + target.name + " на " + currentDamage + " урона.");
        } else {
            System.out.println(name + " не может атаковать " + target.name + " из-за расстояния.");
        }
    }

    public void skill(){
        skill = true;
    }

    public boolean isAlive() {
        return health > 0;
    }

    public void status() {
        System.out.println(name + " имеет " + health + " здоровья.");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getAttackRange() {
        return attackRange;
    }

    public void setAttackRange(int attackRange) {
        this.attackRange = attackRange;
    }

    public boolean isSkill() {
        return skill;
    }

    public void setSkill(boolean skill) {
        this.skill = skill;
    }

    public int getSkillChance() {
        return skillChance;
    }

    public void setSkillChance(int skillChance) {
        this.skillChance = skillChance;
    }
}

class Berserk extends Character {
    public Berserk() {
        super("Берсерк", 120, 30, 50, 10, 5, 10);
    }
    @Override
    public void skill(){
        super.skill();
        Main.distance /= 2;
        System.out.println("Берсерк сократил расстояние до цели в 2 раза");
    }
}

class Mage extends Character {
    public Mage() {
        super("Маг", 80, 20, 20, 40, 100, 7);
    }

    @Override
    public void skill(){
        super.skill();
        setArmor(getArmor() + 5);
        System.out.println("Маг увеличил показатель своей брони на 5");
    }
}

class Archer extends Character {
    public Archer() {
        super("Лучник", 100, 10, 10, 60, 80, 3);
    }

    @Override
    public void skill(){
        super.skill();
        setDamage(getDamage() + 3);
        System.out.println("Лучник увеличил показатель своего урона на 3");
    }
}

class Goblin extends Character{
    public Goblin() {
        super("Гоблин", 40, 5, 5, 80, 5, 2);
    }

    @Override
    public void skill(){
        super.skill();
        if (getHealth() < 25) {
            setHealth(getHealth() + 3);
            System.out.println("Гоблин вылечился на 3 единицы здоровья");
        }
    }
}

public class Main {
    public static int distance;

    public static void main(String[] args) {
        Random random = new Random();


        Character berserk = new Berserk();
        Character archer = new Archer();
        Character mage = new Mage();
        Character goblin = new Goblin();

        ArrayList<Character> characters = new ArrayList<>(Arrays.asList(berserk, archer, mage, goblin));
        Character character1 = characters.get(random.nextInt(characters.size()));
        characters.remove(character1);
        Character character2 = characters.get(random.nextInt(characters.size()));


        distance = random.nextInt(200);

        System.out.println("Начало боя: \n" + character1.getName() + " против " + character2.getName());
        System.out.println("Расстояние между персонажами: " + distance + "\n");

        while (character1.isAlive() && character2.isAlive()){
            if (random.nextBoolean()){
                if (distance > character1.getAttackRange()){
                    distance -= character1.getSpeed();
                }else {
                    if (random.nextInt(character1.getSkillChance()) == 1){
                        character1.skill();
                    }
                    character1.defaultAttack(character2, distance);
                }
            }else {
                if (distance > character2.getAttackRange()){
                    distance -= character2.getSpeed();
                }else {
                    if (random.nextInt(character2.getSkillChance()) == 1){
                        character2.skill();
                    }
                    character2.defaultAttack(character1, distance);
                }
            }
        }
        System.out.println();
        if (character1.isAlive()){
            System.out.println(character1.getName() + " - победитель");
        }
        else {
            System.out.println(character2.getName() + " - победитель");
        }

    }
}

