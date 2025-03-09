package com.escom.cerraduras.model;

import java.util.Set;

public class StringClosure {
    private Set<String> strings;

    public StringClosure() {
    }

    public StringClosure(Set<String> strings) {
        this.strings = strings;
    }

    public Set<String> getStrings() {
        return strings;
    }

    public void setStrings(Set<String> strings) {
        this.strings = strings;
    }
}