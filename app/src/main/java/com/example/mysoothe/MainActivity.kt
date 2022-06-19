package com.example.mysoothe

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mysoothe.ui.theme.MySootheTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MySootheTheme {
                MySoothe()
            }
        }
    }
}

@Composable
fun SearchBar(modifier: Modifier = Modifier) {
    TextField(
        value = "",
        onValueChange = {},
        leadingIcon = {
            Icon(Icons.Default.Search, contentDescription = null)
        },
        placeholder = {
            Text(text = "Search")
        },
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = MaterialTheme.colors.surface
        ),
        modifier = modifier
            .heightIn(56.dp)
            .fillMaxWidth()
    )

}

@Preview(showBackground = true , backgroundColor = 0xFFF0EAE2)
@Composable
fun SearchBarPrev() {
    MySootheTheme {
        SearchBar(Modifier.padding(8.dp))
    }
}

@Composable
fun AlignYourBodyElement() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.background(color = Color(0XFFffffff))
    ) {
        Image(
            painterResource(id = R.drawable.cds),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(88.dp)
                .clip(CircleShape)
        )
        Text(
            text = "Action 1",
            style = MaterialTheme.typography.h5,
            modifier = Modifier.paddingFromBaseline(top = 24.dp, bottom = 8.dp)
        )

    }
}

@Preview(showBackground = true , backgroundColor = 0xFFF0EAE2)
@Composable
fun AlignYourBodyElementPrev() {
    MySootheTheme {
        AlignYourBodyElement()
    }
}

@Composable
fun FavoriteCollectionCard() {
    Surface(
        shape = MaterialTheme.shapes.small
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.width(192.dp)
        ) {
            Image(
                painterResource(id = R.drawable.cf),
                contentDescription = null,
                modifier = Modifier.size(56.dp),
                contentScale = ContentScale.Crop
            )
            Text(
                text = "FavAction",
                style = MaterialTheme.typography.h6,
                modifier = Modifier.padding(horizontal = 16.dp)
            )

        }

    }

}

@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun FavoriteCollectionCardPrev() {
    MySootheTheme {
        FavoriteCollectionCard()
    }

}

@Composable
fun AlignBodyRow() {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) {
        items(10) {
            AlignYourBodyElement()
        }
    }

}

@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun AlignBodyRowPrev() {
    MySootheTheme {
        AlignBodyRow()

    }

}

@Composable
fun FavoriteCollectionsGrid() {
    LazyHorizontalGrid(
        rows = GridCells.Fixed(2),
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.height(120.dp)

    ) {
        items(8) {
            FavoriteCollectionCard()
        }
    }

}

@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun FavoriteCollectionsGridPrev() {
    MySootheTheme {
        FavoriteCollectionsGrid()

    }
}

@Composable
fun HomeSection(
    title: String,
    content: @Composable () -> Unit
) {
    Column {
        Text(
            title.uppercase(),
            modifier = Modifier
                .paddingFromBaseline(top = 40.dp, bottom = 8.dp)
                .padding(horizontal = 16.dp),
            style = MaterialTheme.typography.h6
        )
        content()

    }

}

@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun HomeSectionPrev() {
    MySootheTheme {
        HomeSection(title = "Align Your Body") {
            AlignBodyRow()
        }

    }
}

@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .padding(vertical = 16.dp)
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        SearchBar(Modifier.padding(horizontal = 16.dp))
        HomeSection(title = "Align Your Body") {
            AlignBodyRow()
        }
        HomeSection(title = "Favorite Collection") {
            FavoriteCollectionsGrid()

        }
        Spacer(modifier = Modifier.height(16.dp))

    }

}

@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2, heightDp = 180)
@Composable
fun HomeScreenPrev() {
    MySootheTheme {
        HomeScreen()

    }
}

@Composable
private fun SootheBottomNavigation(modifier: Modifier = Modifier) {
    BottomNavigation(
        backgroundColor = MaterialTheme.colors.background,
        modifier = modifier
    ) {
        BottomNavigationItem(
            selected = true,
            onClick = { /*TODO*/ },
            icon = {
                Icon(Icons.Default.Home, contentDescription = null)
            },
            label = {
                Text(text = "Home")
            }
        )
        BottomNavigationItem(
            selected = false,
            onClick = { /*TODO*/ },
            icon = {
                Icon(Icons.Default.AccountCircle, contentDescription = null)
            },
            label = {
                Text(text = "Home")
            }
        )

    }

}

@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun SootheBottomNavigationPrev() {
    MySootheTheme {
        SootheBottomNavigation()

    }
}

@Composable
fun MySoothe() {
        Scaffold(
            bottomBar = { SootheBottomNavigation() }
        ) { padding ->
            HomeScreen()
        }
    }


@Preview(widthDp = 360, heightDp = 640)
@Composable
fun MySootheAppPrev() {
    MySootheTheme {
        MySoothe()

    }
}

