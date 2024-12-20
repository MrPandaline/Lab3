import myEnums.Daytime;
import myEnums.Location;
import myExceptions.LogicalContradiction;
import myExceptions.WrongAmountException;
import myObjects.*;
import states.AliveObjectState;
import states.InanimateObjectState;
import states.WorldState;

public class Script {
    final byte COUNT_OF_NIGHTS;
    final boolean RANDOMIZED;

    public Script(byte countOfNights){
        COUNT_OF_NIGHTS = countOfNights;
        RANDOMIZED = false;
    }

    public Script(){
        COUNT_OF_NIGHTS = (byte) (Math.random() * 20);
        RANDOMIZED = true;
    }

    public void playScript() throws WrongAmountException {
        boolean scenatioCompleted = false;

        while (!scenatioCompleted) {
            try {
                World world = World.getInstance();

                if (RANDOMIZED) {
                    world.addWorldState(new WorldState("время", Daytime.values()
                            [(int) (Math.random() * (Daytime.values().length))].toString()));
                }
                else {
                    world.addWorldState(new WorldState("время", Daytime.NIGHT.toString()));
                }
                Person archbishop = new Person("Архиепископ");
                Person king = new Person("Король");
                Person queen;
                if (RANDOMIZED && Math.random() < 0.5) {
                    queen = new Person("Элиза", 1, "Королева");
                } else {
                    queen = new Witch("Элиза", 1, "Королева");
                }
                Person nation = new Person("человек", Integer.MAX_VALUE);


                ImaginableThinkingObject saints = new ImaginableThinkingObject("святой", 10);
                AbstractObject evilWords = new AbstractObject("слова", "злые");
                Image image = new Image("образ", 1, "резное");
                Droplet tears = new Droplet("слеза", 2, "крупная");

                AbstractObject doubt = new AbstractObject("сомнение");
                AbstractObject despair = new AbstractObject("отчаяние");
                AbstractObject dream = new AbstractObject("сон");

                if (RANDOMIZED) {
                    saints = new ImaginableThinkingObject("святой", (int) (Math.random() * 100) + 1);
                    tears = new Droplet("слеза", (int) (Math.random() * 100) + 1, "крупная");
                }

                image.addObjectParts(saints);
                saints.addObjectParts(new BodyPart("голова"));

                archbishop.addState(new AliveObjectState("спит"));

                nation.sleep();
                archbishop.sleep();
                archbishop.see(queen);
                archbishop.ensure("он прав");
                archbishop.suspect(queen);
                if (queen instanceof Witch) { //на будущее для вариативности
                    System.out.println(queen + " действительно ведьма");
                    ((Witch) queen).charm(king);
                    ((Witch) queen).charm(nation);
                }
                world.addWorldState(new WorldState("время", Daytime.NOON.toString()));
                archbishop.setLocation(Location.CONFESSIONAL);
                king.walk(archbishop);
                archbishop.say("что видел и подозревал", king);
                evilWords.iFallFrom(king.getObjectParts().get(king.
                        getObjectParts().indexOf(new BodyPart("щёки"))));
                System.out.println(image.getName() + ": " + image.getDescription());
                saints.ishake("голова");
                saints.iSay("Неправда, элиза невинна!");
                archbishop.rethink("это");

                archbishop.say("святые сведетельствуют против неё, неодобрительно качая головами");
                tears.moveAt(king.getObjectParts().get(king.
                        getObjectParts().indexOf(new BodyPart("щёки"))));
                doubt.iReown(king.getObjectParts().get(king.
                        getObjectParts().indexOf(new BodyPart("сердце"))), king);
                despair.iReown(king.getObjectParts().get(king.
                        getObjectParts().indexOf(new BodyPart("сердце"))), king);

                king.walk(Location.SLEEPING_ROOM);

                byte iterable = 0;
                while (iterable < COUNT_OF_NIGHTS) {
                    System.out.println("\n" + (iterable + 1) + " ночь");
                    world.addWorldState(new WorldState("время", Daytime.NIGHT.toString()));
                    queen.setLocation(Location.SLEEPING_ROOM);
                    queen.sleep();

                    king.simulate(new InanimateObjectState("спит"));
                    dream.iRunFrom(king);

                    if (queen instanceof Witch) {
                        king.see(queen);
                        queen.sleep();
                    }
                    if (iterable == COUNT_OF_NIGHTS - 1) {
                        break;
                    }
                    if (queen instanceof Witch) {
                        queen.disappear();
                    }
                    world.addWorldState(new WorldState("время", Daytime.NOON.toString()));
                    iterable += 1;
                }
                if (queen instanceof Witch) {
                    king.see(queen);
                    queen.walk(Location.SECRET_ROOM);
                }
                scenatioCompleted = true;
            } catch (LogicalContradiction e){
                System.out.println(e.getMessage());
                System.out.println("Новая итерация сценария");
            }
        }
    }
}
