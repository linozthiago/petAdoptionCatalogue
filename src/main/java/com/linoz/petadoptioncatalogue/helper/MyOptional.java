package com.linoz.petadoptioncatalogue.helper;

import java.util.Optional;
import java.util.function.Consumer;

/**
 * Created by linoz on 11/30/21
 */
public class MyOptional {

    private boolean isPresent;

    public MyOptional(boolean isPresent) {
        this.isPresent = isPresent;
    }

    public void orElse(Runnable runner) {
        if (! isPresent) {
            runner.run();
        }
    }

    public static <T> MyOptional ifPresent(Optional<T> opt, Consumer<? super T> consumer) {
        if (opt.isPresent()) {
            consumer.accept(opt.get());
            return new MyOptional(true);
        }
        return new MyOptional(false);
    }
}
