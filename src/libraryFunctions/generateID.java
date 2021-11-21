package libraryFunctions;

import java.util.UUID;

public class generateID {

    public static String uniqueId() {
        String uniqueID = UUID.randomUUID().toString();
        return uniqueID;
    }
}
