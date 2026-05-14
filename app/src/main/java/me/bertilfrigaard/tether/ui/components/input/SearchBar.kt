package me.bertilfrigaard.tether.ui.components.input

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import me.bertilfrigaard.tether.R
import me.bertilfrigaard.tether.ui.theme.TetherTheme

@Composable
fun SearchBar(query: String, onQueryChange: (String) -> Unit){
    TextField(
        value = query,
        onValueChange = onQueryChange,
        modifier = Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        singleLine = true,
        placeholder = {
            Text(
                "Search apps...",
                color = TetherTheme.colors.ink2
            )
        },
        leadingIcon = {
            Icon(
                painter = painterResource(R.drawable.search_24px),
                contentDescription = null,
                tint = TetherTheme.colors.ink2
            )
        },
        colors = TextFieldDefaults.colors(
            focusedContainerColor = TetherTheme.colors.surface2,
            unfocusedContainerColor = TetherTheme.colors.surface2,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            cursorColor = TetherTheme.colors.accent,
            focusedLeadingIconColor = TetherTheme.colors.accent,
        )
    )
}