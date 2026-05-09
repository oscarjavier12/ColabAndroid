package com.example.mycity.ui

import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.*
import com.example.mycity.data.DataSource
import com.example.mycity.model.Category
import com.example.mycity.model.Recommendation
import com.example.mycity.ui.utils.MyCityContentType

data class MyCityUiState(
    val categories: List<Category> = DataSource.categories,
    val selectedCategory: Category = DataSource.categories[0],
    val selectedRecommendation: Recommendation? = null,
    val recommendations: List<Recommendation> =
        DataSource.getRecommendationsByCategory(DataSource.categories[0].id),
    val isShowingHomepage: Boolean = true
)

@Composable
fun MyCityApp(windowSize: WindowWidthSizeClass) {
    val contentType: MyCityContentType = when (windowSize) {
        WindowWidthSizeClass.Compact  -> MyCityContentType.ListOnly
        WindowWidthSizeClass.Medium   -> MyCityContentType.ListOnly
        WindowWidthSizeClass.Expanded -> MyCityContentType.ListAndDetail
        else                          -> MyCityContentType.ListOnly
    }

    var uiState by remember { mutableStateOf(MyCityUiState()) }

    MyCityHomeScreen(
        contentType = contentType,
        uiState = uiState,
        onCategorySelected = { category ->
            uiState = uiState.copy(
                selectedCategory = category,
                recommendations = DataSource.getRecommendationsByCategory(category.id),
                selectedRecommendation = null,
                isShowingHomepage = true
            )
        },
        onRecommendationSelected = { recommendation ->
            uiState = uiState.copy(
                selectedRecommendation = recommendation,
                isShowingHomepage = false
            )
        },
        onBackPressed = {
            uiState = uiState.copy(isShowingHomepage = true)
        }
    )
}