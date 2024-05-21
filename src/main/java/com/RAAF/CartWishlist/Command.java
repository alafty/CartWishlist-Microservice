package com.RAAF.CartWishlist;

import java.util.Set;
import java.util.UUID;

public interface Command {
    void execute(UUID uuid);
    void execute(UUID userID, String itemID);
    Set<String> executeGet();
}
