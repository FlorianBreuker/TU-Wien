package AB5;
import AB5.Interfaces.Dinosaur;

public class Application {
    public static void main(String[] args) {

        Dinosaur dino;

        // check dino DNA
        System.out.println(new DinosaurDNA(5));
        System.out.println();

        // add some dinosaurs to the hashmap
        System.out.println("Storing some dinosaurs in the hashmap...");
        DinosaurHashMap map = new DinosaurHashMap(4, 4);
        for (int i = 0; i < 10; i++) {
            dino = map.put(new TyrannosaurusRex(new DinosaurDNA(i), "TRex_" + i));
            System.out.println((dino != null) ? "Error: store should return null for new nodes" : "dino TRex_" + i + " was stored.");
            dino = map.put(new Edmontosaurus(new DinosaurDNA(i + 16), "Edmont_" + i));
            System.out.println((dino != null) ? "Error: store should return null for new nodes" : "dino Edmont_" + i + " was stored.");
        }
        System.out.println();

        // check the size of the hashmap
        System.out.println("Checking hashmap size...");
        System.out.println("Size: " + map.size());
        System.out.println();

        // find dinosaurs in the hashmap
        System.out.println("Finding some dinosaurs in the hashmap...");
        dino = map.get(new DinosaurDNA(1));
        System.out.println((dino != null) ? dino + " was found." : "Error: find returned null");
        dino = map.get(new DinosaurDNA(3));
        System.out.println((dino != null) ? dino + " was found." : "Error: find returned null");
        dino = map.get(new DinosaurDNA(33));
        System.out.println((dino != null) ? dino + "Error: an unknown dino was found." : "OK: find for unknown dino returned null");
        System.out.println();

        // now remove dinosaurs from the hashmap
        System.out.println("Removing some dinosaurs from the hashmap...");
        dino = map.remove(new DinosaurDNA(1));
        System.out.println((dino != null) ? "removed dino, length=" + map.size() : "Error: removed dino should not be null after removing a dinosaur.");
        dino = map.remove(new DinosaurDNA(3));
        System.out.println((dino != null) ? "removed dino, length=" + map.size() : "Error: removed dino should not be null after removing a dinosaur.");
        dino = map.remove(new DinosaurDNA(666));
        System.out.println((dino == null) ? "OK: unknown dino can not be removed, length=" + map.size() : "Error: dino should be unknown...");
        System.out.println();

        // test the hashmap iterator
        System.out.println("Test hashmap iterator...");
        System.out.println("Order of dinos may vary here, as this iterator's order is implementation specific.");
        DinosaurHashMapIterator mapIterator = map.iterator();
        while (mapIterator.hasNext()) {
            System.out.println(mapIterator.next());
        }
        System.out.println();

        // now clear the hashmap
        System.out.println("Clearing the hashmap...");
        map.clear();
        System.out.println("Size: " + map.size());
        System.out.println();

        // test find and remove on an empty map
        System.out.println("Test find and remove on empty map...");
        dino = map.get(new DinosaurDNA(33));
        System.out.println((dino != null) ? dino + "Error: a dino was found in an empty map!" : "OK: find in empty map returned null");
        dino = map.remove(new DinosaurDNA(1));
        System.out.println((dino == null) ? "OK: remove dino from empty map returned null, length=" + map.size() : "Error: remove from empty map returned a dino!");
        System.out.println();

        // test the hashmap iterator on an empty map
        System.out.println("Test hashmap iterator... (should not produce any output)");
        mapIterator = map.iterator();
        while (mapIterator.hasNext()) {
            System.out.println(mapIterator.next());
        }
        System.out.println();

        // TODO: implementation of any developer specific tests

/*        Dinosaur dino1 = new Edmontosaurus(new DinosaurDNA(1), "horst");
        Dinosaur dino2 = new Edmontosaurus(new DinosaurDNA(2), "günther");
        Dinosaur dino3 = new Edmontosaurus(new DinosaurDNA(3), "peter");
        Dinosaur dino4 = new Edmontosaurus(new DinosaurDNA(4), "martin");
        Dinosaur dino5 = new Edmontosaurus(new DinosaurDNA(5), "sepp");
        Dinosaur dino6 = new Edmontosaurus(new DinosaurDNA(6), "jörg");
        Dinosaur dino7 = new Edmontosaurus(new DinosaurDNA(7), "andi");
        Dinosaur dino8 = new Edmontosaurus(new DinosaurDNA(8), "bar");
        Dinosaur dino9 = new Edmontosaurus(new DinosaurDNA(9), "sam");
        Dinosaur dino10 = new Edmontosaurus(new DinosaurDNA(10), "rob");
        Dinosaur dino11 = new Edmontosaurus(new DinosaurDNA(11), "flo");
        Dinosaur dino12 = new Edmontosaurus(new DinosaurDNA(12), "mam");
        Dinosaur dino13 = new Edmontosaurus(new DinosaurDNA(13), "nad");*/


/*        System.out.println("Test remove, size, isEmpty from BucketList");
        DinosaurBucketList bucketList = new DinosaurBucketList();
        System.out.println(bucketList.store(new Edmontosaurus(new DinosaurDNA(123), "horst")));
        System.out.println(bucketList.store(new Edmontosaurus(new DinosaurDNA(104), "günther")));
        System.out.println(bucketList.store(new Edmontosaurus(new DinosaurDNA(107), "peter")));
        System.out.println(bucketList.store(new Edmontosaurus(new DinosaurDNA(104), "sepp")));
        System.out.println(bucketList.store(new Edmontosaurus(new DinosaurDNA(104), "martin")));
        System.out.println(bucketList.size());
        System.out.println(bucketList.remove(new DinosaurDNA(107)));
        System.out.println(bucketList.size());
        System.out.println(bucketList.isEmpty());
        System.out.println(bucketList.remove(new DinosaurDNA(104)));
        System.out.println(bucketList.size());
        System.out.println(bucketList.isEmpty());
        System.out.println(bucketList.remove(new DinosaurDNA(123)));
        System.out.println(bucketList.size());
        System.out.println(bucketList.isEmpty());*/

/*        System.out.println("Test hasNext, next from DinosaurListIterator");
        DinosaurListIterator iterator = bucketList.iterator();
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());*/

/*        System.out.println("Test DinosaurHashMap");
        DinosaurHashMap hashMap = new DinosaurHashMap();
        hashMap.put(dino1);
        hashMap.put(dino2);
        hashMap.put(dino3);
        hashMap.put(dino4);
        hashMap.put(dino5);
        hashMap.put(dino6);
        hashMap.put(dino7);
        hashMap.put(dino8);
        hashMap.put(dino9);
        hashMap.put(dino10);
        hashMap.put(dino11);
        hashMap.put(dino12);
        hashMap.put(dino13);*/
    }
}
