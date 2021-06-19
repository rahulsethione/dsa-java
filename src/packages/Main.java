package packages;

/**
 * 1. Package is a group of related classes
 * 2. Similar to a folder in file directory
 * 3. Helps in avoiding naming conflicts for classes
 * 4. Helps in keeping code organized and maintainable
 */
public class Main {
    public static void main(String[] args) {
        String[] accessLevel = new String[] {
                "Within Class",
                "Extended Class within Same Package",
                "Anywhere Within Package",
                "Extended Class in Different Package",
                "Globally"
        };

        String[] accessModifier = new String[] {
                "Public",
                "Protected",
                "Default",
                "Private"
        };
    }
}
