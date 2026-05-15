package me.bertilfrigaard.tether.ui.screens.app.viewblocks

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import me.bertilfrigaard.tether.data.model.Block
import me.bertilfrigaard.tether.ui.theme.TetherTheme

@Composable
fun ViewBlocksContent(state: ViewBlocksUiState, deleteBlock: (Block) -> Unit) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        LazyColumn {
            items(state.blocks) { block ->
                Column(
                    modifier = Modifier
                        .padding(10.dp)
                        .background(TetherTheme.colors.surface)
                        .padding(10.dp)
                ) {
                    Text(
                        text = block.name,
                        style = TetherTheme.typography.bodyEmphasis,
                        color = TetherTheme.colors.ink
                    )
                    Text(
                        text = block.toString(),
                        style = TetherTheme.typography.body,
                        color = TetherTheme.colors.ink2
                    )
                    Button(
                        onClick = { deleteBlock(block) }
                    ) {
                        Text(text = "Delete")
                    }
                }
            }
        }
    }
}