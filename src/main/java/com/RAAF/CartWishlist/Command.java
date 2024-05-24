package com.RAAF.CartWishlist;

import java.util.Set;

public interface Command {
    void execute(String uuid);
    Set<String> executeGet();
}
