package com.kroll;


class Item {
    private final String title;
    private final String identifier;

    public Item(String title, String identifier) {
        this.title = title;
        this.identifier = identifier;
    }

    public String getTitle() {
        return title;
    }

    public String getIdentifier() {
        return identifier;
    }


    public String getType() {
        return "Предмет";
    }

    @Override
    public String toString() {
        return getType() + ": " + title + " (Ідентифікатор: " + identifier + ")";
    }
}
