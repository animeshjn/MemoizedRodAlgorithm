public class HuffmanNode implements Comparable<HuffmanNode> {
	char character;
	int frequency;
	HuffmanNode left,center,right;
	boolean isRoot = false;

	HuffmanNode() {
super();
	}
	HuffmanNode(int frequency, char character) {
		this.character = character;
		this.frequency = frequency;
		left = null;
		center = null;
		right = null;
	}
	@Override
	public int compareTo(HuffmanNode other) {
			return this.frequency-other.frequency;
	}
}
