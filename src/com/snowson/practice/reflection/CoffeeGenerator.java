package practice.src.reflection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * author: snows
 * created on: 2018/3/31 21:52
 * description:
 */

public class CoffeeGenerator implements Generator<Coffee>, Iterable<Coffee> {

    private Class[] types = new Class[]{Latte.class, Mocha.class,
            Cappuccino.class, Americano.class, Breve.class};
    private Random random = new Random(System.currentTimeMillis());
    private long size = 0;
    private static List<Integer> indexs = new ArrayList<>();

    public Coffee next() {
        try {
            int index = random.nextInt(types.length);
            indexs.add(index);
            return (Coffee) types[index].newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public CoffeeGenerator() {
    }

    public CoffeeGenerator(int size) {
        this.size = size;
    }

    @Override
    public Iterator<Coffee> iterator() {
        return new CoffeeIterator();
    }

    class CoffeeIterator implements Iterator<Coffee> {
        long count = size;


        @Override
        public boolean hasNext() {
            return count > 0;
        }

        @Override
        public Coffee next() {
            count--;
            return CoffeeGenerator.this.next();
        }
    }

    public static void main(String[] args) {
        CoffeeGenerator cg = new CoffeeGenerator();
        for (int i = 0; i < 5; i++) {
            System.out.println(cg.next());
        }
        for (Coffee c : new CoffeeGenerator(5)) {
            System.out.println(c);
        }
        System.out.print(indexs.toString());
    }
}
