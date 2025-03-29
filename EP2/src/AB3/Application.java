package AB3;

import AB3.Provided.BrailleEncoder;
import AB3.Provided.BrailleFont;

import java.util.Arrays;

/**
 * The Application class serves as the entry point to the program.
 * <p>This class is used to test and demonstrate the functionality of printing text in Braille format
 * using the AdvancedLinePrinter, configured with a BrailleLineBuffer, a BrailleFont and a BrailleEncoder.</p>
 * <p>Any implementation is not subject to examination and assessment by the EP2-Team, but serves as
 * free test hub for students.</p>
 */
public class Application {
    public static void main(String[] args) {

        // create a font
        BrailleFont font = new BrailleFont(3, 2, 'o', '.', new BrailleEncoder());

        // create a linked list
        BrailleLinkedList list = new BrailleLinkedList();

        // create a list buffer
        BrailleListBuffer brailleListBuffer = new BrailleListBuffer(list);

        // write a message to the buffer
        String message = "Hello World";
        for (char c : message.toCharArray()) {
            brailleListBuffer.push(font.getBitmap(Character.toLowerCase(c)));   // we do not care for any other symbols due to specification
        }

        // get Braille text scanlines
        String[] lines = brailleListBuffer.renderScanlines(4);

        // write them to screen (just for fun)
        if (lines.length > 0) {
            Arrays.asList(lines).forEach(System.out::println);
        }

        // create a Braille Decoder
        BrailleDecoder decoder = new BrailleDecoder(new BrailleEncoder());

        // create a Braille reader
        BrailleReader reader = new BrailleReader(decoder);

        // translate the braille line back to ASCII
        String asciiText = reader.translate(lines, 'o', 4);

        // and write it to screen :)
        System.out.println(asciiText);

        // TODO: implementation of any developer specific tests (optional)

/*        BrailleEncoder testEncoder = new BrailleEncoder();
        BrailleFont testFont = new BrailleFont(3, 2, 'o', '.', testEncoder);
        BrailleDecoder testDecoder = new BrailleDecoder(testEncoder);
        BrailleLinkedList testLinkedList = new BrailleLinkedList();

        BrailleSymbolTree testTree = new BrailleSymbolTree(testEncoder);
        for (char i = 'a'; i <= 'z'; i++) {
            byte currentByte = testEncoder.toBinary(i);
            TreeNode target = testTree.getNode(currentByte);
            System.out.println(target.getSymbol());
        }


        for (char i = 'a'; i <= 'z'; i++) {
            char[][] currentBitMap = testFont.getBitmap(i);
            char decodedTestChar = testDecoder.decodeBitmap(currentBitMap, 'o');
            System.out.println(decodedTestChar);
        }

        testLinkedList.remove(0);
        testLinkedList.remove(-1);
        testLinkedList.remove(10);
        testLinkedList.removeFirst();
        testLinkedList.removeLast();
        ListNode first = new ListNode(testFont.getBitmap('a'));
        ListNode second = new ListNode(testFont.getBitmap('b'));
        ListNode third = new ListNode(testFont.getBitmap('c'));
        ListNode fourth = new ListNode(testFont.getBitmap('d'));
        ListNode fifth = new ListNode(testFont.getBitmap('a'));
        ListNode sixth = new ListNode(testFont.getBitmap('e'));
        testLinkedList.addFirst(first); // a
        testLinkedList.addFirst(second); // b -> a
        testLinkedList.addLast(third); // b -> a -> c
        testLinkedList.insert(fourth, 1); // b -> d -> a -> c
        testLinkedList.insert(fifth, -1); // a -> b -> d -> a -> c
        testLinkedList.insert(sixth, 10); // a -> b -> d -> a -> c -> e

        System.out.println(Arrays.deepToString(testLinkedList.removeFirst().getBitmap())); // (removed: a) b -> d -> a -> c -> e
        System.out.println(Arrays.deepToString(testLinkedList.removeLast().getBitmap())); // b -> d -> a -> c (removed: e)
        System.out.println(Arrays.deepToString(testLinkedList.remove(1).getBitmap())); // b -> (removed: d) a -> c
        System.out.println(Arrays.deepToString(testLinkedList.remove(-1).getBitmap())); // (removed: b) a -> c
        System.out.println(Arrays.deepToString(testLinkedList.remove(10).getBitmap())); // a (removed: c)
        System.out.println(Arrays.deepToString(testLinkedList.removeLast().getBitmap())); // (removed: a)*/
    }
}