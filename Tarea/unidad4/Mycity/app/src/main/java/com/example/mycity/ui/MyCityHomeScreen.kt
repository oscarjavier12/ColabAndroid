package com.example.mycity.ui

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.mycity.model.Category
import com.example.mycity.ui.utils.MyCityContentType

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyCityHomeScreen(
    contentType: MyCityContentType,
    uiState: MyCityUiState,
    onCategorySelected: (com.example.mycity.model.Category) -> Unit,
    onRecommendationSelected: (com.example.mycity.model.Recommendation) -> Unit,
    onBackPressed: () -> Unit,
    modifier: Modifier = Modifier
) {
    // En móvil: si no estamos en homepage, mostramos detalle solo
    if (contentType == MyCityContentType.ListOnly && !uiState.isShowingHomepage) {
        RecommendationDetailScreen(
            recommendation = uiState.selectedRecommendation!!,
            onBackPressed = onBackPressed
        )
        return
    }

    Row(modifier = modifier.fillMaxSize()) {

        // NavigationRail para pantallas medianas/expandidas
        if (contentType == MyCityContentType.ListAndDetail) {
            MyCityNavigationRail(
                categories = uiState.categories,
                selectedCategory = uiState.selectedCategory,
                onCategorySelected = onCategorySelected
            )
        }

        // Panel izquierdo: lista de recomendaciones
        Column(modifier = Modifier.weight(1f)) {
            // TopAppBar
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = stringResource(uiState.selectedCategory.nameRes),
                        style = MaterialTheme.typography.titleLarge
                    )
                }
            )
            RecommendationListScreen(
                recommendations = uiState.recommendations,
                onRecommendationSelected = onRecommendationSelected,
                selectedRecommendation = uiState.selectedRecommendation
            )
        }

        // Panel derecho: detalle (solo en ListAndDetail)
        if (contentType == MyCityContentType.ListAndDetail) {
            val detail = uiState.selectedRecommendation
                ?: uiState.recommendations.firstOrNull()
            detail?.let {
                RecommendationDetailScreen(
                    recommendation = it,
                    onBackPressed = {},
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }

    // NavigationBar en móvil (parte inferior)
    if (contentType == MyCityContentType.ListOnly) {
        // Se envuelve en Scaffold en MainActivity
    }
}

@Composable
fun MyCityNavigationRail(
    categories: List<Category>,
    selectedCategory: Category,
    onCategorySelected: (Category) -> Unit,
    modifier: Modifier = Modifier
) {
    NavigationRail(modifier = modifier) {
        categories.forEach { category ->
            NavigationRailItem(
                selected = category.id == selectedCategory.id,
                onClick = { onCategorySelected(category) },
                icon = {
                    Icon(
                        painter = painterResource(id = category.iconRes),
                        contentDescription = stringResource(category.nameRes)
                    )
                },
                label = { Text(stringResource(category.nameRes)) }
            )
        }
    }
}