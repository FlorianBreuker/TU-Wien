package AB4;

import AB4.Interfaces.AbstractTreeNode;
import AB4.Interfaces.Dinosaur;

import java.util.Objects;

/**
 * Represents a non-empty node in a binary tree structure.
 *
 * <p>This class implements the {@code AbstractTreeNode} interface and encapsulates the functionality
 * of storing and retrieving a {@code Dinosaur} within a binary tree.</p>
 * <p>Each {@code NonEmptyTreeNode} instance represents a node for a specific DNA (key) and may contain a {@code Dinosaur}
 * as its value. The node also contains references to its left and right child nodes, where the left child's key is
 * smaller than the node's key and the right child's key is larger than the node's key. Child nodes are always non-null.</p>
 */
public class NonEmptyTreeNode implements AbstractTreeNode {
    // TODO: variable declarations
    AbstractTreeNode left;
    AbstractTreeNode right;
    Dinosaur dinosaur;
    int key;

    /**
     * Constructs a {@code NonEmptyTreeNode} that containing a given Dinosaur object.
     * <p>The node initializes its key and value attributes using the provided Dinosaur and initializes its left and right
     * children of type {@code AbstractTreeNode} to indicate that it initially has no child nodes.</p>
     *
     * @param animal the Dinosaur object to be stored in the tree node.
     *               The DNA of this Dinosaur is used as the key, and the Dinosaur itself is the value of the node.
     */
    NonEmptyTreeNode(Dinosaur animal) {
        // TODO: implementation
        left = new EmptyTreeNode();
        right = new EmptyTreeNode();
        key = animal.getDNA();
        dinosaur = animal;
    }

    /**
     * Stores a given Dinosaur within the tree.
     *
     * <p>The method uses the dinosaur's DNA as the key to determine the correct position
     * within the tree. If the DNA matches the current node's key, the existing value is updated.
     * If the DNA is less than the current node's key, the Dinosaur is stored in the left subtree.
     * Otherwise, the Dinosaur is stored in the right subtree.</p>
     *
     * @param animal the Dinosaur object to be stored in the tree. The dinosaur's DNA is used to determine the storage location.
     * @return the current tree node (the node where the parent node should point to) after the dinosaur has been stored.
     */
    @Override
    public AbstractTreeNode store(Dinosaur animal) {
        // TODO: implementation
        if (key == animal.getDNA()) {
            dinosaur = animal;
        } else if (animal.getDNA() < key) {
            left = left.store(animal);
        } else {
            right = right.store(animal);
        }
        return this;
    }

    /**
     * Removes the dinosaur identified by the given DNA from the tree.
     *
     * <p>The method clears the value (payload) of the node (set value to null) if the DNA matches the key of the current node.
     * If the current node does not have any child nodes after removal, it transitions into an empty node (NIL).</p>
     *
     * <p>If the DNA does not match the key, the operation is delegated to the left or right child node
     * based on whether the DNA is less than or greater than the key of the current node.</p>
     *
     * @param dna the unique integer encoded DNA of the dinosaur to be removed.
     * @return the current tree node after the removal operation or {@code EmptyTreeNode.NIL} after transitioning to an empty node.
     */
    @Override
    public AbstractTreeNode remove(int dna) {
        // TODO: implementation
        if (key == dna) {
            dinosaur = null;
            if (left instanceof EmptyTreeNode && right instanceof EmptyTreeNode) {
                return right.remove(dna);
            }
        } else if (dna < key) {
            left = left.remove(dna);
        } else {
            right = right.remove(dna);
        }
        return this;
    }

    /**
     * Finds and returns a Dinosaur object in the tree based on its unique DNA identifier.
     *
     * <p>The method recursively traverses the tree, comparing the provided DNA with the node's key.
     * If the DNA matches the key, the corresponding Dinosaur is returned. If the DNA is less than
     * the key, the method continues its search in the left subtree. Otherwise, the search proceeds
     * in the right subtree.</p>
     *
     * @param dna the unique DNA, encoded as an {@code int}, of the dinosaur to be found.
     * @return the Dinosaur object with the specified DNA, or {@code null} if no such dinosaur is found in the tree.
     */
    @Override
    public Dinosaur find(int dna) {
        // TODO: implementation
        if (key == dna) {
            return this.dinosaur;
        } else if (dna < key) {
            return left.find(dna);
        } else {
            return right.find(dna);
        }
    }

    /**
     * Finds a dinosaur within the tree by its name.
     *
     * <p>The method searches the current tree node and recursively checks
     * its left and right children to locate a dinosaur with the specified name.</p>
     *
     * @param name the name of the dinosaur to locate
     * @return the dinosaur object with the specified name, or {@code null} if no such dinosaur is found
     */
    @Override
    public Dinosaur findByName(String name) {
        // TODO: implementation
        Dinosaur result = null;
        if (dinosaur != null && Objects.equals(dinosaur.getName(), name)) {
            result = dinosaur;
        }

        if (left instanceof NonEmptyTreeNode) result = result == null ? left.findByName(name) : result;
        if (right instanceof NonEmptyTreeNode) result = result == null ? right.findByName(name) : result;
        return result;
    }

    /**
     * Flattens the tree into an array of Dinosaur objects using an in-order traversal.
     *
     * <p>This method iterates through the tree's structure by performing:<br>
     * 1. A recursive flattening of the left subtree.<br>
     * 2. Adding the current node's value if it exists, so it is not equal to {@code null}.<br>
     * 3. A recursive flattening of the right subtree.</p>
     *
     * @return an array of {@code Dinosaur} objects representing all dinosaurs in the tree,
     * sorted by their DNA in ascending order.
     */
    @Override
    public Dinosaur[] flatten() {
        // TODO: implementation
        Dinosaur[] dinos = new Dinosaur[countDino()];
        flattenRec(0, dinos);
        return dinos;
    }

    private int flattenRec(int i, Dinosaur[] dinos) {
        if (left instanceof NonEmptyTreeNode) i = ((NonEmptyTreeNode) left).flattenRec(i, dinos);
        if (dinosaur != null) dinos[i++] = dinosaur;
        if (right instanceof NonEmptyTreeNode) i = ((NonEmptyTreeNode) right).flattenRec(i, dinos);
        return i;
    }

    private int countDino() {
        int count = 0;
        if (dinosaur != null) {
            count = 1;
        }
        if (left instanceof NonEmptyTreeNode) count += ((NonEmptyTreeNode) left).countDino();
        if (right instanceof NonEmptyTreeNode) count += ((NonEmptyTreeNode) right).countDino();
        return count;
    }

    // GETTERS AND SETTERS

    /**
     * Retrieves the key of the current tree node.
     *
     * @return the key of the current tree node, represented as an {@code int}.
     */
    public int getKey() {
        // TODO: implementation
        return key;
    }

    /**
     * Retrieves the left child node of the current tree node.
     *
     * @return the left child node represented as an {@code AbstractTreeNode}.
     */
    public AbstractTreeNode getLeft() {
        // TODO: implementation
        return left;
    }

    /**
     * Retrieves the right child node of the current tree node.
     *
     * @return the right child node represented as an {@code AbstractTreeNode}.
     */
    public AbstractTreeNode getRight() {
        // TODO: implementation
        return right;
    }

    /**
     * Sets the left child node of the current tree node.
     *
     * <p>Precondition: (left != null) </p>
     *
     * @param left the left child node to be assigned, represented as an {@code AbstractTreeNode}.
     */
    public void setLeft(AbstractTreeNode left) {
        // TODO: implementation
        if (left == null) return;
        this.left = left;
    }

    /**
     * Sets the right child node of the current tree node.
     *
     * <p>Precondition: (right != null) </p>
     *
     * @param right the right child node to be assigned, represented as an {@code AbstractTreeNode}.
     */
    public void setRight(AbstractTreeNode right) {
        // TODO: implementation
        if (right == null) return;
        this.right = right;
    }

}
