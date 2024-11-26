import myEnums.BodyPartEnum;
import myEnums.Daytime;
import myEnums.Locations;
import myObjects.*;
import states.AliveObjectState;
import states.InanimateObjectState;
import states.WorldState;

// TODO: пере
public class Main {
    public static void main(String[] args){
        final byte COUNT_OF_NIGHTS = 5;

        WorldCondition world = WorldCondition.getInstance();
        world.addWorldState(new WorldState("время",Daytime.NIGHT.toString()));

        Person archbishop = new Person("Архиепископ");
        Person king = new Person("Король");
        Witch queen = new Witch("Элиза", 1, "Королева");
        Person nation = new Person("человек", Integer.MAX_VALUE);
        ImaginableThinkingObject saints = new ImaginableThinkingObject("святой", 10);
        AbstractObject evilWords = new AbstractObject("слова", "злые");
        Image image = new Image("образ", 1, "резное");
        Droplet tears = new Droplet("слеза", 2, "крупная");
        AbstractObject doubt = new AbstractObject("сомнение");
        AbstractObject despair = new AbstractObject("отчаяние");
        AbstractObject dream = new AbstractObject("сон");


        image.addObjectParts(saints);
        saints.addObjectParts(new BodyPart(BodyPartEnum.HEAD));

        archbishop.addState(new AliveObjectState("спит"));

        nation.sleep();
        archbishop.sleep();
        archbishop.see(queen);
        archbishop.ensure("он прав");
        archbishop.suspect(queen);
        if (queen instanceof Witch){ //на будущее для вариативности
            System.out.println(queen + " действительно ведьма");
            queen.charm(king);
            queen.charm(nation);
        }
        world.addWorldState(new WorldState("время", Daytime.NOON.toString()));
        archbishop.setLocation(Locations.CONFESSIONAL);
        king.walk(archbishop);
        archbishop.say("что видел и подозревал", king);
        evilWords.iFallFrom(king.getObjectParts().get(king.
                getObjectParts().indexOf(new BodyPart(BodyPartEnum.CHEEKS))));
        System.out.println(image.getName() + ": " + image.getDescription());
        saints.ishake(BodyPartEnum.HEAD);
        saints.iSay("Неправда, элиза невинна!");
        archbishop.rethink("это");
        //сделать метод свидетельствовать, который возвращает String
        archbishop.say("святые свядетельствуют против неё, неодобрительно качая головами");
        tears.moveAt(Locations.KING_CHEEKS);
        doubt.iReown(king.getObjectParts().get(king.
                getObjectParts().indexOf(new BodyPart(BodyPartEnum.HEART))), king);
        despair.iReown(king.getObjectParts().get(king.
                getObjectParts().indexOf(new BodyPart(BodyPartEnum.HEART))), king);

        king.walk(Locations.SLEEPING_ROOM);

        byte iterable = 0;
        while (iterable < COUNT_OF_NIGHTS){
            System.out.println("\n" + (iterable+1) + " ночь");
            world.addWorldState(new WorldState("время", Daytime.NIGHT.toString()));
            queen.setLocation(Locations.SLEEPING_ROOM);
            queen.sleep();

            king.simulate(new InanimateObjectState("спит"));
            dream.iRunFrom(king);
            king.see(queen);
            queen.sleep();
            queen.disappear();
            if (iterable == COUNT_OF_NIGHTS - 1){
                break;
            }
            world.addWorldState(new WorldState("время", Daytime.NOON.toString()));
            iterable += 1;
        }
        king.see(queen);
        queen.walk(Locations.SECRET_ROOM);
    }
}
