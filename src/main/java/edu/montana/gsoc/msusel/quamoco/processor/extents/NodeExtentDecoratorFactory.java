package edu.montana.gsoc.msusel.quamoco.processor.extents;

import edu.montana.gsoc.msusel.codetree.node.AbstractNode;
import edu.montana.gsoc.msusel.codetree.node.member.FieldNode;
import edu.montana.gsoc.msusel.codetree.node.member.MethodNode;
import edu.montana.gsoc.msusel.codetree.node.structural.FileNode;
import edu.montana.gsoc.msusel.codetree.node.structural.ModuleNode;
import edu.montana.gsoc.msusel.codetree.node.structural.NamespaceNode;
import edu.montana.gsoc.msusel.codetree.node.structural.ProjectNode;
import edu.montana.gsoc.msusel.codetree.node.type.TypeNode;

/**
 * @author Isaac Griffith
 * @version 1.2.0
 */
public class NodeExtentDecoratorFactory {

    private NodeExtentDecoratorFactory() {

    }

    public static NodeExtentDecoratorFactory getInstance() {
        return Holder.INSTANCE;
    }

    public AbstractNodeExtentDecorator getDecorator(AbstractNode node) {
        if (node instanceof TypeNode) {
            return new TypeNodeExtentDecorator(node);
        } else if (node instanceof MethodNode) {
            return new MethodNodeExtentDecorator(node);
        } else if (node instanceof FileNode) {
            return new FileNodeExtentDecorator(node);
        } else if (node instanceof FieldNode) {
            return new FieldNodeExtentDecorator(node);
        } else if (node instanceof ModuleNode) {
            return new ModuleNodeExtentDecorator(node);
        } else if (node instanceof NamespaceNode) {
            return new NamespaceNodeExtentDecorator(node);
        } else if (node instanceof ProjectNode) {
            return new ProjectNodeExtentDecorator(node);
        } else {
            return new FileNodeExtentDecorator(node);
        }
    }

    private static final class Holder {
        private static final NodeExtentDecoratorFactory INSTANCE = new NodeExtentDecoratorFactory();
    }
}