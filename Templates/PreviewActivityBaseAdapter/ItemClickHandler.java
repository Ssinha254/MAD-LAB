package com.example.template;

/**
 * Usage:
 * Implement this in Activity/Fragment if you want adapter callbacks.
 */
public interface ItemClickHandler {
    void onItemClicked(PreviewItem item, int position);
}
