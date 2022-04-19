package com.mjs.skillassure.DomainLayer.Repositories

import com.mjs.skillassure.DataLayer.CategoryItems
import com.mjs.skillassure.R

class CategoryDataRepository {
    companion object {
        fun setCategoryItem(): List<CategoryItems> {
            val items = ArrayList<CategoryItems>()
            items.add(CategoryItems(R.drawable.ic_youtube, "Videos"))
            items.add(CategoryItems(R.drawable.ic_briefcase, "Jobs"))
            items.add(CategoryItems(R.drawable.ic_tv, "News"))
            items.add(CategoryItems(R.drawable.ic_book_open, "Blogs"))
            items.add(CategoryItems(R.drawable.ic_gift, "Tips"))
            items.add(CategoryItems(R.drawable.ic_grid, "More"))
            return items
        }
    }
}