package com.example.mycity.data

import com.example.mycity.R
import com.example.mycity.model.Category
import com.example.mycity.model.Recommendation

object DataSource {

    val categories = listOf(
        Category(id = 1, nameRes = R.string.category_coffee,     iconRes = R.drawable.ic_coffee),
        Category(id = 2, nameRes = R.string.category_restaurants, iconRes = R.drawable.ic_restaurant),
        Category(id = 3, nameRes = R.string.category_parks,       iconRes = R.drawable.ic_park),
        Category(id = 4, nameRes = R.string.category_museums,     iconRes = R.drawable.ic_museum),
        Category(id = 5, nameRes = R.string.category_shopping,    iconRes = R.drawable.ic_shopping),
    )

    val recommendations = listOf(
        // Coffee Shops
        Recommendation(1, 1, R.string.place1_name, R.string.place1_address, R.string.place1_desc, R.drawable.place1),
        Recommendation(2, 1, R.string.place2_name, R.string.place2_address, R.string.place2_desc, R.drawable.place2),
        Recommendation(3, 1, R.string.place3_name, R.string.place3_address, R.string.place3_desc, R.drawable.place3),
        Recommendation(4, 1, R.string.place4_name, R.string.place4_address, R.string.place4_desc, R.drawable.place4),

        // Restaurants
        Recommendation(5,  2, R.string.place5_name,  R.string.place5_address,  R.string.place5_desc,  R.drawable.place5),
        Recommendation(6,  2, R.string.place6_name,  R.string.place6_address,  R.string.place6_desc,  R.drawable.place6),
        Recommendation(7,  2, R.string.place7_name,  R.string.place7_address,  R.string.place7_desc,  R.drawable.place7),
        Recommendation(8,  2, R.string.place8_name,  R.string.place8_address,  R.string.place8_desc,  R.drawable.place8),

        // Parks
        Recommendation(9,  3, R.string.place9_name,  R.string.place9_address,  R.string.place9_desc,  R.drawable.place9),
        Recommendation(10, 3, R.string.place10_name, R.string.place10_address, R.string.place10_desc, R.drawable.place10),
        Recommendation(11, 3, R.string.place11_name, R.string.place11_address, R.string.place11_desc, R.drawable.place11),

        // Museums
        Recommendation(12, 4, R.string.place12_name, R.string.place12_address, R.string.place12_desc, R.drawable.place12),
        Recommendation(13, 4, R.string.place13_name, R.string.place13_address, R.string.place13_desc, R.drawable.place13),
        Recommendation(14, 4, R.string.place14_name, R.string.place14_address, R.string.place14_desc, R.drawable.place14),

        // Shopping
        Recommendation(15, 5, R.string.place15_name, R.string.place15_address, R.string.place15_desc, R.drawable.place15),
        Recommendation(16, 5, R.string.place16_name, R.string.place16_address, R.string.place16_desc, R.drawable.place16),
        Recommendation(17, 5, R.string.place17_name, R.string.place17_address, R.string.place17_desc, R.drawable.place17),
    )

    fun getRecommendationsByCategory(categoryId: Int) =
        recommendations.filter { it.categoryId == categoryId }
}